package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "startServlet", value = "/start")
public class StartServlet extends HttpServlet {

    private final static int START_LEVEL = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        session.setAttribute("level", START_LEVEL);

        Integer gamesCount = (Integer) session.getAttribute("gamesPlayed");
        if (gamesCount == null) {
            session.setAttribute("gamesPlayed", START_LEVEL);
        } else {
            session.setAttribute("gamesPlayed", gamesCount + 1);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/quest.jsp");
        dispatcher.forward(req, resp);
    }
}
