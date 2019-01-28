package com.zykj.springboot_example.datasource2.dao;

import com.zykj.springboot_example.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDao2 {
    Student getStudentByStudentNumber(@Param("studentNumber") String studentNumber);
}
