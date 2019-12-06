package com.ncse.demo.controller;

import com.ncse.demo.Student;
import com.ncse.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class studentController {
    @Autowired
    private StudentRepository studentRepository;
    private static int cnt = 0;
    @RequestMapping("show")
    @ResponseBody
    public List<Student> show(){
        List<Student> studentList;
        studentList = studentRepository.findAll();
//        JSONObject json = new JSONObject();
//        json.put("data",studentList);
         return studentList;
    }


    @RequestMapping("add")
    @ResponseBody
    public boolean add(@RequestParam("name") String name, @RequestParam("age") String age,@RequestParam("password") String password)
    {
        Student user = new Student();
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setPassword(password);
        System.out.println(user);
        studentRepository.save(user);
        System.out.println(studentRepository.existsByName(name));
        if(studentRepository.existsByName(name)){
            return true;
        }
        return false;
    }

    @RequestMapping("update")
    public boolean update(@RequestParam("name") String name, @RequestParam("age") String age,@RequestParam("id") String id){
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        int Id= Integer.parseInt(id);
        Student user = studentRepository.findById(Id);
        System.out.println(user);
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        studentRepository.save(user);
        if(studentRepository.existsByName(user.getName())){
            return true;
        }
        return false;
    }
    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(@RequestParam("id") String id){
        System.out.println(id);
        Student user = studentRepository.findById(Integer.parseInt(id));
        System.out.println(user);
        studentRepository.delete(user);
        System.out.println(studentRepository.existsById(user.getId()));
        if(!studentRepository.existsById(user.getId())) {
            return true;
        }
        return false;

    }

}
