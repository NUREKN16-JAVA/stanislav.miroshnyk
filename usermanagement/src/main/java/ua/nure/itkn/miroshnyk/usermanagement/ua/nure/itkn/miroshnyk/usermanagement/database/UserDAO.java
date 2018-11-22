package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database;

import ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.User;

import java.util.Collection;

public interface UserDAO {
    User create (User user) throws DataBaseException;
    void update (User user) throws DataBaseException;
    void delete (User user) throws DataBaseException;
    User find (Long id) throws DataBaseException;
    Collection findAll () throws DataBaseException;
    void setConnectionFactory(ConnectionFactory connectionFactory);
}
