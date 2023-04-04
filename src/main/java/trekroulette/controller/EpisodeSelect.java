package trekroulette.controller;

import com.cezarykluczynski.stapi.client.api.rest.Episode;
import com.cezarykluczynski.stapi.client.v1.rest.model.EpisodeFullResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EpisodeSelect", urlPatterns = "/selector")
public class EpisodeSelect extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Episode episode = (Episode)session.getAttribute("Episodes");
        StapiParse parser = new StapiParse(episode);
        EpisodeFullResponse selection = parser.recommendEpisode();
        session.setAttribute("selection", selection);
        String url = "/recommend.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
