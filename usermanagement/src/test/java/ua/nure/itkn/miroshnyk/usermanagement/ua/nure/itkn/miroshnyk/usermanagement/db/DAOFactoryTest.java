package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.db;

import org.junit.Assert;
import org.junit.Test;
import ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database.DAOFactory;
import ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database.UserDAO;

public class DAOFactoryTest {
    @Test
    public void getUserDAOTest () {
        DAOFactory daoFactory = DAOFactory.getInstance();
        Assert.assertNotNull(daoFactory);
        UserDAO userDAO;
        try {
            userDAO = daoFactory.getUserDAO();
            Assert.assertNotNull(userDAO);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
