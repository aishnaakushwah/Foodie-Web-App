package com.example.order.service;

import com.example.order.domain.Item;
import com.example.order.domain.Order;

import java.util.List;

public interface IOrderService {
    public Order insertOrder(Order order);
    public List<Item> getItems(String status,String email);
    public boolean removeItem(String email, Item item);
    public boolean addItem(String email,Item item);
    public boolean cancelOrder(String email,List<Item> items);
    public boolean placeOrder(String email, List<Item> items);

}
