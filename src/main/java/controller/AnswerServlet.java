package controller;

import model.GameGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "answerServlet", value = "/answer")
public class AnswerServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AnswerServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String result = req.getParameter("choose");
        int option = Integer.parseInt(result);

        GameGraph graph = (GameGraph) getServletContext().getAttribute(AppGraph.ATTR_GLOBAL_GRAPH);

        HttpSession session = req.getSession(false);
        int oldLevel = (int) session.getAttribute("level");
        int oldGamesPlayed = (int) session.getAttribute("gamesPlayed");

        logger.info("{} reached quest {}", session.getId(), oldLevel + 1);

        if (graph.isAnswerRight(oldLevel, option)) {
            session.setAttribute("level", oldLevel + 1);

            if (graph.hasNext(oldLevel)) {
                req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
            } else {
                logger.info("{} won the game", session.getId());
                session.setAttribute("gamesPlayed", oldGamesPlayed + 1);
                req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
            }

        } else {
            logger.info("{} lost the game", session.getId());
            session.setAttribute("gamesPlayed", oldGamesPlayed + 1);
            req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
        }
    }
}
