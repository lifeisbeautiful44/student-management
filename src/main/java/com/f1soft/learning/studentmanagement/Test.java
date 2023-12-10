package com.f1soft.learning.studentmanagement;

import com.f1soft.learning.studentmanagement.platform.dbconnection.DataBaseConnection;

public class Test {
    public static void main(String[] args) {
       DataBaseConnection a =  DataBaseConnection.getInstance();
        DataBaseConnection b =  DataBaseConnection.getInstance();
        System.out.println(a);
        System.out.println(b);
    }
}
