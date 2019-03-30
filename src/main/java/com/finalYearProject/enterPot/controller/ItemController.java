package com.finalYearProject.enterPot.controller;

import com.finalYearProject.enterPot.domain.Item;
import com.finalYearProject.enterPot.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    private String AVAILABLE = "available";
    private String UNAVAILABLE = "unavailable";

    @PostMapping("/")
    public Long createItem(@RequestBody Item item){
        return itemRepository.save(item).getId();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Item> getItem(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Item> item = itemRepository.findById(id);
        if(!item.isPresent()){
            throw new ResourceNotFoundException("Item not found");
        }
        return item;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Item> item = itemRepository.findById(id);
        if(!item.isPresent()){
            throw new ResourceNotFoundException("Item not found");
        }
        itemRepository.delete(item.get());
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Long updateItem(@PathVariable Long id, @RequestBody Item updatedItem) throws ResourceNotFoundException {
        Optional<Item> item = itemRepository.findById(id);
        if (!item.isPresent()) {
            throw new ResourceNotFoundException("Item not found");
        }
        item.get().setCategory(updatedItem.getCategory());
        item.get().setStatus(updatedItem.getStatus());
        item.get().setDescription(updatedItem.getDescription());
        item.get().setName(updatedItem.getName());
        item.get().setModels(updatedItem.getModels());
        item.get().setPrice(updatedItem.getPrice());
        return itemRepository.save(item.get()).getId();
    }

    @CrossOrigin
    @PutMapping("/status/{id}")
    public Long updateItemStatus(@PathVariable Long id, @RequestParam String status) throws ResourceNotFoundException{
        Optional<Item> item = itemRepository.findById(id);
        if (!item.isPresent()) {
            throw new ResourceNotFoundException("Item not found");
        }
        item.get().setStatus(status);
        return itemRepository.save(item.get()).getId();
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getAll(){
        return itemRepository.findAll();
    }

}
