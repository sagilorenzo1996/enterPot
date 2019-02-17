package com.finalYearProject.enterPot.repo;

import com.finalYearProject.enterPot.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
}
