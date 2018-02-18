package by.itacademy.servlet;

import by.itacademy.entity.Coin;
import by.itacademy.service.CoinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/coin", name = "Coin")
public class CoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long coinId = Long.valueOf(req.getParameter("id"));
        System.out.println(coinId);
        Coin coin = CoinService.getInstance().getCoinById(coinId);
        System.out.println(coin.getName());
        req.setAttribute("coin", coin);
        req.setAttribute("coinDescription", coin.getCoinDescriptions());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/coin.jsp")
                .forward(req, resp);
    }
}
