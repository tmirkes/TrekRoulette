package trekroulette;

import trekroulette.controller.RouletteController;
import trekroulette.entity.Episode;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Generate", value = "/generate")
public class Generate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RouletteController controller = (RouletteController) getServletContext().getAttribute("controller");
        List<Episode> episodeLibrary = (List<Episode>)getServletContext().getAttribute("episodes");
        Episode recommendedEpisode = episodeLibrary.get(controller.getRecommendation(episodeLibrary));
        HttpSession session = request.getSession();
        session.setAttribute("recommendedEpisode", recommendedEpisode);
        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
