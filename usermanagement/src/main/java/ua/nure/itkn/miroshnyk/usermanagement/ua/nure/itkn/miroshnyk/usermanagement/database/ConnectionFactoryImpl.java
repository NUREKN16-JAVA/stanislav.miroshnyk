package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImpl implements ConnectionFactory {
    private String user;
    private String password;
    private String url;
    private String driver;

    public ConnectionFactoryImpl() {}

    ConnectionFactoryImpl(String user, String password, String url, String driver) {
        this.user = user;
        this.password = password;
        this.url =  url;
        this.driver = driver;
    }

    @Override
    public Connection createConnection() throws DataBaseException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DataBaseException(e.toString());
        }
    }
}
