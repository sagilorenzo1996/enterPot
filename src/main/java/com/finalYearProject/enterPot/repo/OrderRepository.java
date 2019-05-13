package com.finalYearProject.enterPot.repo;

import com.finalYearProject.enterPot.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    Iterable<Order> findAllByCustomerId(Long id);
}
