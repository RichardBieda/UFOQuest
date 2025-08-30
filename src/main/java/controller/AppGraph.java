package controller;

import model.GameGraph;
import model.QGraph;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppGraph implements ServletContextListener {
    public static final String ATTR_GLOBAL_GRAPH = "model.appGraph";

    @Override
    public void contextInitialized(ServletContextEvent e) {
        GameGraph graph = new QGraph();
        e.getServletContext().setAttribute(ATTR_GLOBAL_GRAPH, graph);
    }

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        e.getServletContext().removeAttribute(AppGraph.ATTR_GLOBAL_GRAPH);
    }
}
