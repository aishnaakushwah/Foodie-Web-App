package com.example.order.repository;

import com.example.order.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends MongoRepository<Order,Integer> {
    @Query("{'customerId': ?0}")
    List<Order> findByCustomerId(String email);
}
