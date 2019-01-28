package com.zykj.springboot_example.datasource2.service;

import com.zykj.springboot_example.model.Student;

public interface MyBatisTestService2 {
    Student getStudentByStudentNumber(String studentNumber);
}
