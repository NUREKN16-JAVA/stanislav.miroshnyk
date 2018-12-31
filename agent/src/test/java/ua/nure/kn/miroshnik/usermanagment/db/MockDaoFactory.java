package ua.nure.kn.miroshnik.usermanagment.db;

import com.mockobjects.dynamic.Mock;

public class MockDaoFactory extends DAOFactory {
    private Mock mockUserDao;

    MockDaoFactory() {
        mockUserDao = new Mock(UserDAO.class);
    }

    public Mock getMockUserDao() {
        return mockUserDao;
    }

    @Override
    public UserDAO getUserDAO() throws ReflectiveOperationException {
        return (UserDAO) mockUserDao.proxy();
    }
}
