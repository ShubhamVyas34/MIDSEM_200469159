package com.example.w22comp1011gctest1;

import java.sql.*;
import java.util.ArrayList;

public class StudentDBUtility {
    private static String user = DBCred.getUser();
    private static String pass = DBCred.getPass();
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Shubham200469159";

    public static ArrayList<Student> getLocalCodeFromDB(String province,String grade) {
        ArrayList<Student> student1 = new ArrayList<>();
        ResultSet resultSet=null;
        String sql = "SELECT * FROM students";
        if(province.equals("All")&&grade.equals("All")){
            sql="SELECT * FROM students ";
        }
        else if(province.equals("ON")){
            sql="SELECT * FROM students WHERE province='ON'";
        }
        else if(grade.equals("Honor")){
            sql="SELECT * FROM students WHERE avgGrade>=80 ";

        }
        else if(province.equals("ON")&&grade.equals("Honor")){
            sql="SELECT * FROM students WHERE province='ON' AND avgGrade>=80";

        }
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                PreparedStatement statement = conn.prepareStatement(sql);
        )
        {

            resultSet=statement.executeQuery();
            {
                while (resultSet.next()) {
                    int studentNum = resultSet.getInt("studentNum");
                    int avgGrade = resultSet.getInt("avgGrade");
                    String phone = resultSet.getString("telephone");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String address = resultSet.getString("homeAddress");
                    String pro = resultSet.getString("province");
                    String major = resultSet.getString("major");


                    Student newStudent = new Student(phone, studentNum, firstName, lastName, address, pro, avgGrade, major);
                    student1.add(newStudent);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return student1;
    }
}

