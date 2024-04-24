package com.example.cc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.cc1.model.Orderss;
import com.example.cc1.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    //post one by one
    public Orderss saveOrder(Orderss orders)
    {
        return orderRepository.save(orders);
    }

    //post as list
    public List<Orderss> saveOrderList(List<Orderss> orders)
    {
        return orderRepository.saveAll(orders);
    }
    
    //find one obj value by id
    public Orderss getOrder(int id)
    {
        return orderRepository.findById(id).orElse(null);
    }

    //getting all table values or objs
    public List<Orderss> getallOrderList()
    {
        return orderRepository.findAll();
    }

   //deleting by id
    public void deleteOrder(int id)
    {
        orderRepository.deleteById(id);
    }
    
    //find list of items by price
    public List<Orderss> gettotalpricegreater(double tp) 
    {
        return orderRepository.findByTotalPriceGreaterThan(tp);
    }
    

   //pagenation all details
   public  Page<Orderss> pagenateList(int pn,int s)
   { 
    return orderRepository.findAll(PageRequest.of(pn, s));
   }
    
   //pagenation only content
   public List<Orderss> pagenateListcon(int pn,int s)
   {
       return orderRepository.findAll(PageRequest.of(pn, s)).getContent();
   }

   //pagenation and sort
   public Page<Orderss> pageListsort(int pn,int s,String st)
   {
     return orderRepository.findAll(PageRequest.of(pn,s,Sort.by(Direction.ASC, st )));
   }
   
   //get user list
   public List<Orderss> getuserIddd(int u)
   {
    return orderRepository.findByUse(u);
   }
   
   //update using put
   public Orderss getupdate(int i)
   {
    return orderRepository.findById(i).orElse(null);
   }
   
   //update using query
   @Transactional
   public void update(int a,int b){
    orderRepository.updateuse(a, b);
   }
}

