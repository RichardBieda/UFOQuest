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

        int level = (int) session.getAttribute("level");

        logger.info("{} reached quest {}", session.getId(), level + 1);

        if (graph.isAnswerRight(level,option)) {
            session.setAttribute("level", level + 1);

            if (!graph.hasNext(level)) {
                req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
                logger.info("{} won the game", session.getId());
                return;
            }

            req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
            logger.info("{} lost the game", session.getId());
        }
    }
}
