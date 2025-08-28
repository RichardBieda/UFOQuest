package controller;

import model.AppGraph;
import model.GameGraph;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "answerServlet", value = "/answer")
public class AnswerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String result = req.getParameter("choose");
        int option = Integer.parseInt(result);

        GameGraph graph = (GameGraph) getServletContext().getAttribute(AppGraph.ATTR_GLOBAL_GRAPH);

        HttpSession session = req.getSession(false);

        int level = (int) session.getAttribute("level");

        if (graph.isAnswerRight(level,option)) {
            session.setAttribute("level", level + 1);

            if (!graph.hasNext(level)) {
                req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
                return;
            }

            req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/finish.jsp").forward(req, resp);
        }
    }
}
