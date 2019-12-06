package com.ncse.demo.controller;

import com.ncse.demo.Student;
import com.ncse.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @Autowired
    private StudentRepository studentRepository;
    @RequestMapping("/login")
    public String Login(@RequestParam("name") String name, @RequestParam("passwd") String passwd ){
        Student student =new Student();
        student.setName(name);
        student.setPassword(passwd);
        if(student.getPassword().equals(studentRepository.findByName(student.getName()).getPassword()))
        return "main";
        return "test_show";
    }
}
