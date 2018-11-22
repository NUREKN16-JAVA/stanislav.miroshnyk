package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection createConnection () throws DataBaseException;
}
