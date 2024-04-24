package com.example.cc1.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1.model.Orderss;
import com.example.cc1.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;
    
    //constructor injection
    public OrderController(OrderService orderService)
    {
        this.orderService=orderService;
    }
    
    //posting one by one
    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @PostMapping("/orders")
    public String postMethodName(@RequestBody Orderss orders) {
        
        orderService.saveOrder(orders);
        
        return "saved user details successfully";
    }

    // posting as list
    @PostMapping("/orderss")
    public String postMethodNameList(@RequestBody List<Orderss> orders) {
       
        orderService.saveOrderList(orders);
        
        return "saved user details successfully";
        
   
    }

    // get row by id
    @GetMapping("/ord/{id}")
    public Orderss getMethodName(@PathVariable("id") int a) {
        return orderService.getOrder(a);
    }

    // delete by id ,check for existence then delete
    @DeleteMapping("/od/{id}")
    public String animaldel(@PathVariable("id") int id)
    {
        Orderss existOrder = orderService.getOrder(id);
        if(existOrder != null)
        {
            orderService.deleteOrder(id);
            return "deleted";
        }
        else{
        return " not deleted";}
    } 

    // update row ,check for existence and update,validation and updation
    @PutMapping("/put/ordr/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable int id, 
                            @RequestBody Orderss updateOrderss) {
        Orderss existOrderss= orderService.getOrder(id);
        if(existOrderss != null)
        {
            existOrderss.setTotalPrice(updateOrderss.getTotalPrice());
            existOrderss.setProductId(updateOrderss.getProductId());
            orderService.saveOrder(existOrderss);
            return new ResponseEntity<>(" data found and updated",HttpStatus.ACCEPTED);
        }
        else 
        {
            return new ResponseEntity<>("no data found ",HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
    //get rows in list based on price 
    @GetMapping("/greater/{tp}")
    public List<Orderss> getgreater(@PathVariable double tp) {
        return orderService.gettotalpricegreater(tp);
    }

    //pagenation all details without sort
    @GetMapping("/page/{pn}/{s}")//should use requestparamss instead
    public Page<Orderss> pagenatedisplay(@PathVariable("pn") int pn, @PathVariable("s") int s)
    {
      return orderService.pagenateList(pn, s);
    }

    //pagenation with only contents
    @GetMapping("/pages/{pn}/{s}")//should use requestparamss instead
    public List<Orderss> pagenatedisplaycon(@PathVariable("pn") int pn, @PathVariable("s") int s)
    {
         return orderService.pagenateListcon(pn, s);
    }

    // pagenation with sort and all details
    @GetMapping("/pagess/{pn}/{s}/{st}")//should use requestparamss instead
    public Page<Orderss> pagenatedisplaycon(@PathVariable("pn") int pn, @PathVariable("s") int s,@PathVariable("st") String st)
    {
         return orderService.pageListsort(pn, s,st);
    }

    //get userrow by id using jpql
    @GetMapping("/guser/{u}")
    public List<Orderss> getg(@PathVariable int u) {
        return orderService.getuserIddd(u);
    }

    /*  
    @PutMapping("/put/ordr/{id}")
    public ResponseEntity<String> putMethoName(@PathVariable int id, @RequestBody Orderss updateOrderss) {
        Orderss existOrderss= orderService.getOrder(id);
        if(existOrderss != null)
        {
            existOrderss.setTotalPrice(updateOrderss.getTotalPrice());
            existOrderss.setProductId(updateOrderss.getProductId());
            orderService.saveOrder(existOrderss);
            return new ResponseEntity<>(" data found and updated",HttpStatus.ACCEPTED);
        }
        else 
        {
            return new ResponseEntity<>("no data found ",HttpStatus.NOT_ACCEPTABLE);
        }
        }
    */
    
    //updation using jpql
    @PutMapping("putuse/od/{i}/{y}")
    public String putuse(@PathVariable int i,@PathVariable int y) {
      orderService.update(i,y);
      return "updated";
    }
}


  /*   public String postMethodName(@RequestBody List<Orderss> orders) {
        for(Orderss i:orders)
        orderService.saveOrder(i);
        
        return "saved user details successfully";
    }*/

