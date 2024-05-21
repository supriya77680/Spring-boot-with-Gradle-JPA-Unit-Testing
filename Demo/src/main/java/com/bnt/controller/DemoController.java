package com.bnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.bnt.model.Demo;
import com.bnt.service.DemoService;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/hello")
    public String check(){
    return "Hello";
   }

   @PostMapping("/save")
   public Demo create(@RequestBody Demo demo){
    return demoService.create(demo);
   }

   @GetMapping("/getAll")
   public List<Demo> getAll(){
    return demoService.getAll();
   }

   @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable Long id){
    demoService.delete(id);
    return "Deleted the user with id " + id;
   }

}
