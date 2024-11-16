/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_akhir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/kebudayaan";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("terkoneksi");
        } catch (SQLException e) {
            System.out.println("error : " + e.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args) {
        getConnection();
        
        login lg = new login();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
    }
}
