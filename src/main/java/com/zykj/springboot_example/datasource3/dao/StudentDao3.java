package com.zykj.springboot_example.datasource3.dao;

import com.zykj.springboot_example.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDao3 {
    Student getStudentByStudentNumber(@Param("studentNumber") String studentNumber);
}
