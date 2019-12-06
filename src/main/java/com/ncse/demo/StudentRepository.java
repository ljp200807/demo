package com.ncse.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    void deleteByName(String name);
    boolean existsByName(String name);
    Student findById(int id);
}
