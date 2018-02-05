package by.itacademy.servlet;

import by.itacademy.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/catalog", name = "CatalogServlet")
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countrynames", CountryService.getInstance().getAllCountries());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/catalog.jsp")
                .forward(req, resp);
    }
}
