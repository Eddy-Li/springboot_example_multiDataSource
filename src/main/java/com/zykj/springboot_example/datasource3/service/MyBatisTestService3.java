package com.zykj.springboot_example.datasource3.service;

import com.zykj.springboot_example.model.Student;

public interface MyBatisTestService3 {
    Student getStudentByStudentNumber(String studentNumber);
}
