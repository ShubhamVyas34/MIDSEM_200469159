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


}
