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
    
}
