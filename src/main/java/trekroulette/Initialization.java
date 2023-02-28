package trekroulette;

import trekroulette.controller.RouletteController;
import trekroulette.entity.Episode;
import trekroulette.persistence.GenericDao;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;

@WebServlet(name = "Initialization", value = "/startup", loadOnStartup = 1)
/**
 * Initialization servlet sets up the servlet context in advance of requests being sent to the servlet.  A RouletteController
 * object is instantiated and added to the ServletContext.  A GenericDao is instantiated to handle Episode objects, and
 * populates a List object with the contents of the Episode database table at the time of initialization, adding it to
 * the ServletContext as an attribute.  The ServletContext is assigned the attribute <code>preload</code> to manage initial
 * page loading operations.
 */
public class Initialization extends HttpServlet {
    public void init() {
        RouletteController controller = new RouletteController();
        getServletContext().setAttribute("controller", controller);
        GenericDao<Episode> getEpisodes = new GenericDao(Episode.class);
        List<Episode> allEpisodes = getEpisodes.getAll();
        getServletContext().setAttribute("episodes", allEpisodes);
        getServletContext().setAttribute("preload", true);
    }
}