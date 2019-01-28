package com.zykj.springboot_example.datasource3.service;

import com.zykj.springboot_example.datasource1.dao.StudentDao1;
import com.zykj.springboot_example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/*
 * springboot默认集成了事务管理，只需要加 @Transactional即可，不需要其他配置
 * @Transactional:加此注解的方法不能有try
 *
 *
 */

@Service
public class MyBatisTestServiceImpl3 implements MyBatisTestService3 {
    @Autowired
    StudentDao1 studentDao3;

    @Override
    public Student getStudentByStudentNumber(String studentNumber) {
        return studentDao3.getStudentByStudentNumber(studentNumber);
    }
}
