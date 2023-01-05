package com.example.demo.controller;

import com.example.demo.DAO.StudentDao;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.mysql.cj.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List <Student> students = StudentService.students;
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        LocalDate dateOfbirth = LocalDate.parse(req.getParameter("dateofbirth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String classRoom = req.getParameter("classroom");
        Student student = new Student(name, dateOfbirth, address, phone, email, classRoom);
        StudentService.insert(student);
        resp.sendRedirect("/home");
    }
}
