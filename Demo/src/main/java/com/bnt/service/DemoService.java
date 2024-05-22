package com.bnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.bnt.model.Demo;
import com.bnt.repository.DemoRepository;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public Demo create(Demo demo){
        return demoRepository.save(demo);
    }

    public List<Demo> getAll(){
        return demoRepository.findAll();
    }

    public void delete(Long id){
    demoRepository.deleteById(id);
    }

    public Demo updateDemo(Demo demo) {
        return demoRepository.save(demo);
    }

    public Demo patchName(Long id, String name) {
        Demo existingDemo = demoRepository.findById(id).orElse(null);
        if (existingDemo == null) {
            return null;
        }
        existingDemo.setName(name);
        return demoRepository.save(existingDemo);
    }
    
}
