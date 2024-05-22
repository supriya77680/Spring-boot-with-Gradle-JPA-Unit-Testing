package com.bnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/update/{id}")
    public Demo updateDemo(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("company") String company) {
     Demo updateDemo = new Demo(id, name, city, company);
      return demoService.updateDemo(updateDemo);
        
    }

    @PatchMapping("/patch-name/{id}")
     public ResponseEntity<Demo> patchName(@PathVariable Long id, @RequestParam("name") String name) {
        Demo patchName = demoService.patchName(id, name);
        return new ResponseEntity<>(patchName, HttpStatus.OK);
    }
}
