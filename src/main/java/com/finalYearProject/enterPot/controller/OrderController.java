package com.finalYearProject.enterPot.controller;

import com.finalYearProject.enterPot.domain.Customer;
import com.finalYearProject.enterPot.domain.Item;
import com.finalYearProject.enterPot.domain.Order;
import com.finalYearProject.enterPot.repo.CustomerRepository;
import com.finalYearProject.enterPot.repo.ItemRepository;
import com.finalYearProject.enterPot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    private String ORDERPLACED = "placed";

    @CrossOrigin
    @Transactional
    @PostMapping("/")
    public Long createOrder(@RequestParam Long customer, @RequestParam Long item, @RequestParam int quantity, @RequestBody BigDecimal total)throws ResourceNotFoundException {
        Optional<Customer> customer1= customerRepository.findById(customer);
        Optional<Item> item1= itemRepository.findById(item);
        if(!customer1.isPresent() || !item1.isPresent()){
            throw new ResourceNotFoundException("Can't Process Order");
        }
        Order order = new Order();
        if(quantity>0 && total.signum()>0){
            order.setCustomerId(customer1.get().getId());
            order.setItemId(item1.get().getId());
            order.setQuantity(quantity);
            order.setTotal(total);
            order.setLocation(customer1.get().getAddressLineOne()+","+customer1.get().getAddressLineTwo()+","+customer1.get().getCity()+","+customer1.get().getCountry()+","+customer1.get().getPostalCode());
            order.setOrderedDate(new Date());
            order.setShippingMode("ship");
            order.setStatus(this.ORDERPLACED);
        }
        return orderRepository.save(order).getId();
    }
}
