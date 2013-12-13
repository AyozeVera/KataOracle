package kataoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class KataOracle {
    private static final String URL ="jdbc:oracle:thin:@10.22.146.238:1521:orcl";
    private static final String USER ="system";
    private static final String PASSWORD ="orcl";
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        while(resultSet.next()){
            System.out.println(resultSet.getString("DIVISA")+ " ");
            System.out.println(resultSet.getString("CAMBIO"));
        }
        connection.close();
    }
}
