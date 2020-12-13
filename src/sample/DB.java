package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect()  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("non");
        }
        Connection con = null;
        try {
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","arbi","torjmen2020");
            System.out.println("sss");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("eeee");
        }
        return con;
    }
}
