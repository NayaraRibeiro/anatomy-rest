package db;

import javax.naming.NamingException;
import java.sql.*;

public class JdbcConnection {

    public static String getMessage() throws NamingException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_anatomy", "root",
                "solnascente");
        Statement stm = connection.createStatement();
        ResultSet res = stm.executeQuery("SELECT * FROM app_anatomy.answer");
        while (res.next()) {
            System.out.println(res.getString("answer"));
        }
        connection.close();

        return "Hello World Nayara!!!!!";
    }
}
