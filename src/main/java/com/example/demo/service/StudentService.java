package com.example.demo.service;

import com.example.demo.DAO.StudentDao;
import com.example.demo.model.Student;

import java.util.List;

public class StudentService {
public static List<Student> students = StudentDao.selectAll();
public static void insert(Student student){
     StudentDao.insert(student);
     students = StudentDao.selectAll();
}
public static void update(Student student){
    StudentDao.update(student);
    students = StudentDao.selectAll();
}
public static void delete(int id){
    StudentDao.delete(id);
    students = StudentDao.selectAll();
}
public static List<Student> search(String name){

    return StudentDao.search(name);

}
}
