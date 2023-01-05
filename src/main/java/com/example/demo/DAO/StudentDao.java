package com.example.demo.DAO;

import com.example.demo.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    static Connection connection = ConnectionSql.getConnection();

    public static List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        String sql = "Select * from classroom ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dateOfbirth = resultSet.getDate("dateofbirth").toLocalDate();
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classRoom = resultSet.getString("classroom");
                students.add(new Student(id, name, dateOfbirth, address, phone, email, classRoom));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void insert(Student student) {
        String sql = "INSERT INTO `classroom`.`classroom` (`name`, `dateofbirth`, `adress`, `phone`, `email`, `classroom`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "name");
            prepareStatement.setDate(2, Date.valueOf("dateofbirth"));
            prepareStatement.setString(3, "address");
            prepareStatement.setString(4, "phone");
            prepareStatement.setString(5, "email");
            prepareStatement.setString(6, "classroom");
            prepareStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean update(Student student) {
        String sql = "UPDATE `classroom`.`classroom` SET `name` = ?, `dateofbirth` = ?, `address` = ?, `phone` = ?, `email` = ?, `classroom` = ? " +
                "WHERE (`id` = ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfbirth()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassRoom());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void delete(int id) {
        String delete = "Delete from classroom where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> search(String searchname) {
        String search = "select * from classroom where name like '%'+?+'%'";
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            preparedStatement.setString(1, searchname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dateOfbirth = resultSet.getDate("dateofbirth").toLocalDate();
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classRoom = resultSet.getString("classroom");
                students.add(new Student(id, name, dateOfbirth, address, phone, email, classRoom));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
