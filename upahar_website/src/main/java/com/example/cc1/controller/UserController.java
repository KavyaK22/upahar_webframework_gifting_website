package com.example.cc1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.cc1.model.Products;
import com.example.cc1.model.User;
import com.example.cc1.repository.ProductRepository;
import com.example.cc1.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("/post")
    public String postMethodName(@RequestBody User user) {

       // Products products=user.getProducts();
       //Products p= productRepository.findByProductNameEndsWith(products.getProductName());
     //  user.setProducts(p);

        userService.saveUser(user);

        
        return "saved user details successfully";
    }

   @GetMapping("/user/{id}")
    public User getMethodName(@PathVariable("id") int a) {
        return userService.getUser(a);
    }

    @DeleteMapping("/us/{id}")
    public String animaldel(@PathVariable("id") int id)
    {
        User existOrder = userService.getUser(id);
        if(existOrder != null)
        {
            userService.deleteUser(id);
            return "deleted";
        }
        else{
        return " not deleted";}
    } 
    
    
}
