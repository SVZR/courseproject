package by.itacademy.servlet;

import by.itacademy.entity.Role;
import by.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> searchFilter = new HashMap<>();
        if (req.getParameter("firstName") != null && !req.getParameter("firstName").isEmpty()) {
            searchFilter.put("firstName", req.getParameter("firstName"));
        }
        if (req.getParameter("role") != null && !req.getParameter("role").isEmpty() && !req.getParameter("role").equals("ALL")) {
            searchFilter.put("role", req.getParameter("role"));

        }
        if (req.getParameter("haveCollection") != null && !req.getParameter("haveCollection").isEmpty()) {
            searchFilter.put("haveCollection", req.getParameter("haveCollection"));

        }
        if (req.getParameter("amountUsersOnPage") != null && !req.getParameter("amountUsersOnPage").isEmpty()) {
            searchFilter.put("amountUsersOnPage", req.getParameter("amountUsersOnPage"));

        }

        req.setAttribute("searchFilter", searchFilter);
        req.setAttribute("amount", Arrays.asList("2", "4", "6", "8"));

        int page = req.getParameterMap()
                .containsKey("page") ? Integer.valueOf(req.getParameter("page")) : 1;
        int amountUsersOnPage = req.getParameterMap()
                .containsKey("amountUsersOnPage") ? Integer.valueOf(req.getParameter("amountUsersOnPage")) : 2;
        req.setAttribute("roles", Role.values());
        req.setAttribute("users", UserService.getInstance().getFilteredUsersOnPage(searchFilter, page, amountUsersOnPage));
        req.setAttribute("pages", UserService.getInstance().getFilteredUsersAmount(searchFilter, amountUsersOnPage).keySet());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/users.jsp")
                .forward(req, resp);
    }
}
