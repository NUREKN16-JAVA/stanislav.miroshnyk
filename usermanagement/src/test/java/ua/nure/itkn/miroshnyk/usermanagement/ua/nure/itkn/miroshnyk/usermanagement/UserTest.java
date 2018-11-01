package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private static final long ID = 1L;
    private static final String FIRSTNAME = "Anzhelika";
    private static final String LASTNAME = "Kosheva";

    @Before
    public void setUp() throws Exception {
        user = new User(ID, FIRSTNAME, LASTNAME, null);
    }

    @Test
    public void testGetFullName() {
        User user = new User(ID, FIRSTNAME, LASTNAME, LocalDate.of(1998,11, 12));
        assertEquals("Anzhelika, Kosheva", user.testGetFullName());
    }

    @Test
    public void testGetBeforeAge() {
        LocalDate date = LocalDate.of(1998, 8, 21);
        User user = new User(ID, FIRSTNAME, LASTNAME, date);
        assertEquals(20, user.getAge());
    }

    @Test
    public void testGetAfterAge() {
        LocalDate date = LocalDate.of(1998, 12, 14);
        User user = new User(ID, FIRSTNAME, LASTNAME, date);
        assertEquals(19, user.getAge());
    }

    @Test
    public void testGetAgeAfterSameMonth() {
        LocalDate date = LocalDate.of(1998, 11, 26);
        User user = new User(ID, FIRSTNAME, LASTNAME, date);
        assertEquals(19, user.getAge());
    }

    @Test
    public void testGetAgeBeforeSameMonth() {
        LocalDate date = LocalDate.of(1998, 11, 4);
        User user = new User(ID, FIRSTNAME, LASTNAME, date);
        assertEquals(20, user.getAge());
    }

    @Test
    public void testGetAgeToday() {
        LocalDate date = LocalDate.now();
        date = date.withYear(1998);
        User user = new User(ID, FIRSTNAME, LASTNAME, date);
        assertEquals(20, user.getAge());
    }

}