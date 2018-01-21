package by.itacademy.servlet;

import by.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/username")
public class UsernameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", new UserService().getUsername());
        req.getRequestDispatcher("/WEB-INF/jsp/username.jsp")
                .forward(req, resp);
    }
}
