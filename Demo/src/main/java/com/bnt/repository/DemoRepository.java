package com.bnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.model.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long>{

    
}