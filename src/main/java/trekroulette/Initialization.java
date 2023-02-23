package trekroulette;

import trekroulette.controller.RouletteController;
import trekroulette.entity.Episode;
import trekroulette.persistence.GenericDao;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;

@WebServlet(name = "Initialization", value = "/startup", loadOnStartup = 1)
public class Initialization extends HttpServlet {
    public void init() {
        RouletteController controller = new RouletteController();
        getServletContext().setAttribute("controller", controller);
        GenericDao<Episode> getEpisodes = new GenericDao(Episode.class);
        List<Episode> allEpisodes = getEpisodes.getAll();
        getServletContext().setAttribute("episodes", allEpisodes);
    }
}