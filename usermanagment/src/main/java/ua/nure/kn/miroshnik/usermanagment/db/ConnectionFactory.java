package ua.nure.kn.miroshnik.usermanagment.db;

import ua.nure.kn.miroshnik.usermanagment.db.exception.DataBaseException;

import java.sql.Connection;

/**
 * Interface to create connection with DB
 */
public interface ConnectionFactory {
    Connection createConnection () throws DataBaseException;
}
