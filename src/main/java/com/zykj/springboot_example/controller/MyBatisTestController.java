package com.zykj.springboot_example.controller;

import com.zykj.springboot_example.datasource2.service.MyBatisTestService2;
import com.zykj.springboot_example.datasource3.service.MyBatisTestService3;
import com.zykj.springboot_example.model.Student;
import com.zykj.springboot_example.datasource1.service.MyBatisTestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MyBatisTest")
public class MyBatisTestController {
    @Autowired
    MyBatisTestService1 myBatisTestService1;

    @Autowired
    MyBatisTestService2 myBatisTestService2;

    @Autowired
    MyBatisTestService3 myBatisTestService3;


    @RequestMapping("/getStudentByStudentNumber1")
    public Student getStudentByStudentNumber1(@RequestParam("studentNumber") String studentNumber) {
        return myBatisTestService1.getStudentByStudentNumber(studentNumber);
    }

    @RequestMapping("/getStudentByStudentNumber2")
    public Student getStudentByStudentNumber2(@RequestParam("studentNumber") String studentNumber) {
        return myBatisTestService2.getStudentByStudentNumber(studentNumber);
    }

    @RequestMapping("/getStudentByStudentNumber3")
    public Student getStudentByStudentNumber3(@RequestParam("studentNumber") String studentNumber) {
        return myBatisTestService3.getStudentByStudentNumber(studentNumber);
    }

}
