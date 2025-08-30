package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(StartServlet.class);

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

        logger.info("{} start a game", session.getId());
//        System.out.println("catalina.base=" + System.getProperty("catalina.base"));
//        System.out.println("user.dir=" + System.getProperty("user.dir"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/quest.jsp");
        dispatcher.forward(req, resp);
    }
}
