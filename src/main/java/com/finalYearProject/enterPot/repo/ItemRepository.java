package com.finalYearProject.enterPot.repo;

import com.finalYearProject.enterPot.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
    Iterable<Item> findAllByCategory(String category);
    Iterable<Item> findAllByName(String name);

    @Query("Select i from Item i where i.name like %:name%")
    Iterable<Item> findByNameContaining(String name);
}
