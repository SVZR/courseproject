package by.itacademy.servlet;

import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/country", name = "CountryServlet")
public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long countryId = Long.valueOf(req.getParameter("id"));
        Country countryById = CountryService.getInstance().getCountryById(countryId);
        req.setAttribute("country", countryById);
//        req.setAttribute("themes", ThemeService.getInstance().getAllThemesByCountryId(countryId));
//        req.setAttribute("series", SeriesService.getInstance().getAllSeriesByCountryId(countryId));
//        req.setAttribute("coins", CoinService.getInstance().getAllCoinsByCountryId(countryId));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/country.jsp")
                .forward(req, resp);
    }
}
