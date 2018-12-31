package ua.nure.kn.miroshnik.usermanagment.db;

import ua.nure.kn.miroshnik.usermanagment.User;
import ua.nure.kn.miroshnik.usermanagment.db.exception.DataBaseException;

import java.util.Collection;

/**
 * Realize main logic for DAO
 */
public interface UserDAO {
    User create (User user) throws DataBaseException;
    void update (User user) throws DataBaseException;
    void delete (User user) throws DataBaseException;
    User find (Long id) throws DataBaseException;
    Collection find (String firstName, String lastName) throws DataBaseException;
    Collection findAll () throws DataBaseException;
    void setConnectionFactory(ConnectionFactory connectionFactory);
}
