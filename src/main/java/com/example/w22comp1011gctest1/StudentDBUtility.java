package com.example.w22comp1011gctest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDBUtility {
    private static String user = DBCred.getUser();
    private static String pass = DBCred.getPass();
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Shubham200469159";

    public static ArrayList<Student> getLocalCodeFromDB() {
        ArrayList<Student> student1 = new ArrayList<>();
        String sql = "SELECT * FROM students ";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()){
                int studentNum=resultSet.getInt("studentNum");
                int avgGrade=resultSet.getInt("avgGrade");
                String phone=resultSet.getString("telephone");
                String firstName=resultSet.getString("firstName");
                String lastName=resultSet.getString("lastName");
                String address=resultSet.getString("homeAddress");
                String province=resultSet.getString("province");
                String major=resultSet.getString("major");


                Student newStudent=new Student(phone,studentNum,firstName,lastName,address,province,avgGrade,major);
                student1.add(newStudent);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student1;
    }
}
