package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.db;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.*;
import ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database.*;

import java.time.LocalDate;
import java.util.Collection;

public class HsqlDBUserDAOTest extends DatabaseTestCase {
    private User user;
    private ConnectionFactory connectionFactory;
    private UserDAO dao;
    private final Long ID = 1L;
    private final String FIRSTNAME = "Anzhelika";
    private final String LASTNAME = "Kosheva";
    private final LocalDate DATEOFBIRTH = LocalDate.of(1998, 11, 12);

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl();
        return  new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
        return dataSet;
    }

    @Before
    public void setUp() throws Exception {
        dao = DAOFactory.getInstance().getUserDAO();
        user = new User(null, FIRSTNAME, LASTNAME, DATEOFBIRTH);
    }

    @Test
    public void testCreate() throws DataBaseException {
        Assert.assertNull(user.getId());
        User ResulUser = dao.create(user);
        Assert.assertNotNull(ResulUser);
        Assert.assertNotNull(ResulUser.getId());
        Assert.assertEquals(user.getFirstName(), ResulUser.getFirstName());
        Assert.assertEquals(user.getLastName(), ResulUser.getLastName());
        Assert.assertEquals(user.getDateOfBirth(), ResulUser.getDateOfBirth());
    }

    @Test
    public void testFind () throws DataBaseException {
        User testUser = dao.find(ID);
        Assert.assertNotNull(testUser);
        Assert.assertEquals(testUser.getFirstName(), user.getFirstName());
        Assert.assertEquals(testUser.getLastName(), user.getLastName());
        Assert.assertEquals(testUser.getDateOfBirth(), user.getDateOfBirth());
    }

    @Test
    public void testFindAll() throws DataBaseException {
        User testUser = dao.create(user);
        int ExpectedCollectionSize = 3;
        Collection AllUsers = dao.findAll();
        Assert.assertNotNull("Collection is null", AllUsers);
        Assert.assertEquals("Collection size.", ExpectedCollectionSize, AllUsers.size());
    }

    @Test
    public void testUpdate () throws DataBaseException {
        String testFirstName = "Sam";
        String testLastName = "Smith";
        LocalDate testDateOfBirth = LocalDate.now();
        User testUser = new User(ID, testFirstName, testLastName, testDateOfBirth);
        dao.update(testUser);
        User updatedUser = dao.find(testUser.getId());
        Assert.assertNotNull(updatedUser);
        Assert.assertEquals(testUser.getFirstName(), updatedUser.getFirstName());
        Assert.assertEquals(testUser.getLastName(), updatedUser.getLastName());
        Assert.assertEquals(testUser.getDateOfBirth(), updatedUser.getDateOfBirth());
    }

    @Test
    public void testDelete () throws DataBaseException {
        User testUser = new User(ID, FIRSTNAME, LASTNAME, DATEOFBIRTH);
        dao.delete(testUser);
        Assert.assertNull(dao.find(ID));
    }
}
