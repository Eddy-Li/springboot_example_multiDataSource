package com.zykj.springboot_example.datasource1.service;

import com.zykj.springboot_example.model.Student;

public interface MyBatisTestService1 {
    Student getStudentByStudentNumber(String studentNumber);
}
