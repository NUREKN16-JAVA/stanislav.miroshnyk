package ua.nure.kn.miroshnik.usermanagment.web;

import ua.nure.kn.miroshnik.usermanagment.User;
import ua.nure.kn.miroshnik.usermanagment.db.DAOFactory;
import ua.nure.kn.miroshnik.usermanagment.db.DataBaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends EditServlet {
    private static final String ADD_JSP = "/add,jsp";

    @Override
    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(ADD_JSP).forward(req, resp);
    }

    @Override
    protected void processUser(User user) throws ReflectiveOperationException, DataBaseException {
        DAOFactory.getInstance().getUserDAO().create(user);
    }
}
