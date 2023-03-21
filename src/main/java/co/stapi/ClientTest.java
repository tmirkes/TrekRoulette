package co.stapi;

import co.stapi.episode.EpisodeData;
import com.cezarykluczynski.stapi.client.api.StapiRestClient;
import com.cezarykluczynski.stapi.client.api.dto.EpisodeSearchCriteria;
import com.cezarykluczynski.stapi.client.api.rest.Episode;
import com.cezarykluczynski.stapi.client.v1.rest.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private StapiRestClient stapiRestClient;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        stapiRestClient = new StapiRestClient();
    }

    @Test
    void getSinglePageEpisodeResults() throws Exception {
        // Get episode list
        Episode episode = stapiRestClient.getEpisode();
        logger.info("Episode instantiated.");
        assertTrue(episode != null);
        // Get search criteria, default page 0 (1)
        EpisodeSearchCriteria episodeSearchCriteria = new EpisodeSearchCriteria();
        // Set search criteria for lowest season number to 1
        episodeSearchCriteria.setSeasonNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberFrom());
        // Set search criteria for highest season number to 1
        episodeSearchCriteria.setSeasonNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberTo());
        // Set search criteria for lowest episode number to 1
        episodeSearchCriteria.setEpisodeNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberFrom());
        // Set search criteria for highest episode number to 1
        episodeSearchCriteria.setEpisodeNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberTo());
        logger.info("episodeSeachCriteria set.");
        // Output search criteria settings for debugging
        logger.info("page " + episodeSearchCriteria.getPageNumber() + ", seasons " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo() + ", episodes " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo());
        // Search the episode list for all results marked as page 0 (1), season 1 and episode 1-3
        EpisodeBaseResponse episodeBaseResponse = episode.search(episodeSearchCriteria);
        logger.info("episodeBaseResponse data returned.");
        // Output selected search details for debugging
        int resultCount = 0;
        while (resultCount < episodeBaseResponse.getPage().getNumberOfElements()) {
            logger.info("EpisodeBaseResponse element " + resultCount + ": " + episodeBaseResponse.getEpisodes().get(resultCount).getTitle());
            resultCount++;
        }
        // Create list of page 0 (1) episodes matching search criteria for handling later
        // !! Could also append new entries to previous list for single object to pass to other classes !!
        List<EpisodeBase> episodes = episodeBaseResponse.getEpisodes();
        logger.info("Episode list length: " + episodes.size());
        // Output selected search result details for debugging
        int i = 0;
        while (i < episodes.size()) {
            logger.info(episodes.get(i).getTitle() + " (" + episodes.get(i).getUid() + ")" + ", episode " + episodes.get(i).getEpisodeNumber() + " of " + episodes.get(i).getSeries().getTitle() + " season " + episodes.get(i).getSeasonNumber());
            i++;
        }
        logger.info(episodes);
        // Retrieve the response page object for page 0 (1)
        ResponsePage page = episodeBaseResponse.getPage();
        assertEquals(11, page.getTotalElements());
        assertEquals(1, page.getTotalPages());
        assertTrue(page.getFirstPage());
        assertTrue(page.getLastPage());
        // Output page details for debugging
        logger.info("ResponsePage data:\n");
        logger.info(page);
    }

    @Test
    void getMultiPageEpisodeResults() throws Exception {
        // Get episode list
        Episode episode = stapiRestClient.getEpisode();
        logger.info("Episode instantiated.");
        assertTrue(episode != null);
        // Get search criteria, default page 0 (1)
        EpisodeSearchCriteria episodeSearchCriteria = new EpisodeSearchCriteria();
        // Set search criteria for lowest season number to 1
        episodeSearchCriteria.setSeasonNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberFrom());
        // Set search criteria for highest season number to 2
        episodeSearchCriteria.setSeasonNumberTo(2);
        assertEquals(2, episodeSearchCriteria.getSeasonNumberTo());
        // Set search criteria for lowest episode number to 1
        episodeSearchCriteria.setEpisodeNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberFrom());
        // Set search criteria for highest episode number to 3
        episodeSearchCriteria.setEpisodeNumberTo(3);
        assertEquals(3, episodeSearchCriteria.getEpisodeNumberTo());
        logger.info("episodeSeachCriteria set.");
        // Output search criteria settings for debugging
        logger.info("page " + episodeSearchCriteria.getPageNumber() + ", seasons " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo() + ", episodes " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo());
        // Search the episode list for all results marked as page 0 (1), season 1 and episode 1-3
        EpisodeBaseResponse episodeBaseResponse = episode.search(episodeSearchCriteria);
        logger.info("episodeBaseResponse data returned.");
        // Output selected search details for debugging
        int resultCount = 0;
        while (resultCount < episodeBaseResponse.getPage().getNumberOfElements()) {
            logger.info("EpisodeBaseResponse element " + resultCount + ": " + episodeBaseResponse.getEpisodes().get(resultCount).getTitle());
            resultCount++;
        }
        // Create list of page 0 (1) episodes matching search criteria for handling later
        // !! Could also append new entries to previous list for single object to pass to other classes !!
        List<EpisodeBase> episodes = episodeBaseResponse.getEpisodes();
        logger.info("Episode list length: " + episodes.size());
        // Output selected search result details for debugging
        int i = 0;
        while (i < episodes.size()) {
            logger.info(episodes.get(i).getTitle() + " (" + episodes.get(i).getUid() + ")" + ", episode " + episodes.get(i).getEpisodeNumber() + " of " + episodes.get(i).getSeries().getTitle() + " season " + episodes.get(i).getSeasonNumber());
            i++;
        }
        logger.info(episodes);
        // Retrieve the response page object for page 0 (1)
        ResponsePage page = episodeBaseResponse.getPage();
        assertEquals(0, page.getPageNumber());
        assertEquals(55, page.getTotalElements());
        assertEquals(2, page.getTotalPages());
        assertTrue(page.getFirstPage());
        assertFalse(page.getLastPage());
        logger.info("ResponsePage data:\n");
        logger.info(page);
        // Alter search criteria to look for page 2 (1)
        episodeSearchCriteria.setPageNumber(1);
        assertEquals(1, episodeSearchCriteria.getPageNumber());
        logger.info("episodeSeachCriteria set.");
        // Output search criteria settings for debugging
        logger.info("page " + episodeSearchCriteria.getPageNumber() + ", seasons " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo() + ", episodes " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo());
        // Search the episode list for all results marked as page 0 (1), season 1 and episode 1-3
        EpisodeBaseResponse episodeBaseResponse2 = episode.search(episodeSearchCriteria);
        logger.info("episodeBaseResponse data returned.");
        int resultCount2 = 0;
        while (resultCount2 < episodeBaseResponse2.getPage().getNumberOfElements()) {
            logger.info("EpisodeBaseResponse element " + resultCount2 + ": " + episodeBaseResponse2.getEpisodes().get(resultCount2).getTitle());
            resultCount2++;
        }
        // Create list of page 1 (2) episodes matching search criteria for handling later
        List<EpisodeBase> episodes2 = episodeBaseResponse2.getEpisodes();
        logger.info("Episode list length: " + episodes2.size());
        // Output selected search result details for debugging
        i = 0;
        while (i < episodes2.size()) {
            logger.info(episodes2.get(i).getTitle() + " (" + episodes2.get(i).getUid() + ")" + ", episode " + episodes2.get(i).getEpisodeNumber() + " of " + episodes2.get(i).getSeries().getTitle() + " season " + episodes2.get(i).getSeasonNumber());
            i++;
        }
        logger.info(episodes2);
        // Retrieve the response page object for page 1 (2)
        ResponsePage page2 = episodeBaseResponse2.getPage();
        assertEquals(1, page2.getPageNumber());
        assertEquals(55, page2.getTotalElements());
        assertEquals(2, page2.getTotalPages());
        assertFalse(page2.getFirstPage());
        assertTrue(page2.getLastPage());
        // Output page details for debugging
        logger.info("ResponsePage data:\n");
        logger.info(page);
        logger.info(page2);
    }

    @Test
    void multiPageEpisodeResultRetrievalTesting() throws Exception {
        // Get episode list
        Episode episode = stapiRestClient.getEpisode();
        // Get search criteria, default page 0 (1)
        EpisodeSearchCriteria episodeSearchCriteria = new EpisodeSearchCriteria();
        // Search the episode list for all results marked as page 0 (1)
        EpisodeBaseResponse episodeBaseResponse = episode.search(episodeSearchCriteria);
        // Create list of page 0 (1) episodes for handling later
        List<EpisodeBase> episodes1 = episodeBaseResponse.getEpisodes();
        // Retrieve the response page object for page 0 (1)
        ResponsePage page = episodeBaseResponse.getPage();
        // Alter search criteria to look for page 2 (1)
        episodeSearchCriteria.setPageNumber(1);
        // Search the episode list for all results marked as page 1 (2)
        EpisodeBaseResponse episodeBaseResponse1 = episode.search(episodeSearchCriteria);
        // Create list of page 1 (2) episodes for handling later
        // !! Could also append new entries to previous list for single object to pass to other classes !!
        List<EpisodeBase> episodes2 = episodeBaseResponse.getEpisodes();
        // Retrieve the response page object for page 1 (2)
        ResponsePage page2 = episodeBaseResponse1.getPage();
        // Output page details for debugging
        logger.info("ResponsePage data:\n");
        logger.info(page);
        assertEquals(0, page.getPageNumber());
        assertEquals(855, page.getTotalElements());
        assertEquals(18, page.getTotalPages());
        assertTrue(page.getFirstPage());
        assertFalse(page.getLastPage());
        logger.info(page2);
        assertEquals(1, page2.getPageNumber());
        assertEquals(855, page2.getTotalElements());
        assertEquals(18, page2.getTotalPages());
        assertFalse(page2.getFirstPage());
        assertFalse(page2.getLastPage());
    }

    @Test
    void getSingleEpisodeWithCredits() throws Exception {
        // Get episode list
        Episode episode = stapiRestClient.getEpisode();
        logger.info("Episode instantiated.");
        assertTrue(episode != null);
        // Get search criteria, default page 0 (1)
        EpisodeSearchCriteria episodeSearchCriteria = new EpisodeSearchCriteria();
        // Set search criteria for lowest season number to 1
        episodeSearchCriteria.setSeasonNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberFrom());
        // Set search criteria for highest season number to 1
        episodeSearchCriteria.setSeasonNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberTo());
        // Set search criteria for lowest episode number to 1
        episodeSearchCriteria.setEpisodeNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberFrom());
        // Set search criteria for highest episode number to 1
        episodeSearchCriteria.setEpisodeNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberTo());
        logger.info("episodeSeachCriteria set.");
        // Output search criteria settings for debugging
        logger.info("page " + episodeSearchCriteria.getPageNumber() + ", seasons " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo() + ", episodes " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo());
        // Search the episode list for all results marked as page 0 (1), season 1 and episode 1
        EpisodeBaseResponse episodeBaseResponse = episode.search(episodeSearchCriteria);
        logger.info("episodeBaseResponse data returned.");
        // Output selected search details for debugging and populate search UID
        int resultCount = 0;
        String queryUid = null;
        while (resultCount < episodeBaseResponse.getPage().getNumberOfElements()) {
            int position = resultCount;
            logger.info("EpisodeBaseResponse element " + resultCount + ": " + episodeBaseResponse.getEpisodes().get(resultCount).getTitle());
            logger.info("Element title: " + episodeBaseResponse.getEpisodes().get(resultCount).getSeries().getTitle());
            if (episodeBaseResponse.getEpisodes().get(resultCount).getSeries().getTitle().compareTo("Star Trek: Deep Space Nine") == 0) {
                queryUid = (String) episodeBaseResponse.getEpisodes().get(position).getUid();
            }
            resultCount++;
        }
        logger.info(queryUid);
        logger.info(queryUid.getClass().getName());
        // Get the episode list for the episode with the UID matching the extracted value
        EpisodeFullResponse episodeFullResponse = episode.get(queryUid);
        logger.info("episodeFullResponse data returned.");
        // Output selected search details for debugging
        //logger.info("EpisodeFullResponse: " + episodeFullResponse.getEpisode().toString());
        logger.info(episodeFullResponse.getEpisode());
    }

    @Test
    void extractSingleEpisodeFullObjectFromResponse() throws Exception {
        // Get episode list
        Episode episode = stapiRestClient.getEpisode();
        logger.info("Episode instantiated.");
        assertTrue(episode != null);
        // Get search criteria, default page 0 (1)
        EpisodeSearchCriteria episodeSearchCriteria = new EpisodeSearchCriteria();
        // Set search criteria for lowest season number to 1
        episodeSearchCriteria.setSeasonNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberFrom());
        // Set search criteria for highest season number to 1
        episodeSearchCriteria.setSeasonNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getSeasonNumberTo());
        // Set search criteria for lowest episode number to 1
        episodeSearchCriteria.setEpisodeNumberFrom(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberFrom());
        // Set search criteria for highest episode number to 1
        episodeSearchCriteria.setEpisodeNumberTo(1);
        assertEquals(1, episodeSearchCriteria.getEpisodeNumberTo());
        logger.info("episodeSeachCriteria set.");
        // Output search criteria settings for debugging
        logger.info("page " + episodeSearchCriteria.getPageNumber() + ", seasons " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo() + ", episodes " + episodeSearchCriteria.getSeasonNumberFrom() + "-" + episodeSearchCriteria.getSeasonNumberTo());
        // Search the episode list for all results marked as page 0 (1), season 1 and episode 1
        EpisodeBaseResponse episodeBaseResponse = episode.search(episodeSearchCriteria);
        logger.info("episodeBaseResponse data returned.");
        // Output selected search details for debugging and populate search UID
        int resultCount = 0;
        String queryUid = null;
        while (resultCount < episodeBaseResponse.getPage().getNumberOfElements()) {
            int position = resultCount;
            logger.info("EpisodeBaseResponse element " + resultCount + ": " + episodeBaseResponse.getEpisodes().get(resultCount).getTitle());
            logger.info("Element title: " + episodeBaseResponse.getEpisodes().get(resultCount).getSeries().getTitle());
            if (episodeBaseResponse.getEpisodes().get(resultCount).getSeries().getTitle().compareTo("Star Trek: Deep Space Nine") == 0) {
                queryUid = (String) episodeBaseResponse.getEpisodes().get(position).getUid();
            }
            resultCount++;
        }
        logger.info(queryUid);
        logger.info(queryUid.getClass().getName());
        // Get the episode list for the episode with the UID matching the extracted value
        EpisodeFullResponse episodeFullResponse = episode.get(queryUid);
        logger.info("episodeFullResponse data returned.");
        // Output selected search details for debugging
        logger.info("EpisodeFullResponse: " + episodeFullResponse.getEpisode().toString());
        EpisodeFull episodeFull = episodeFullResponse.getEpisode();
        logger.info("Episode result: " + episodeFull.toString());
    }

    @Test
    public void swapiJSONResponseTesting() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/people/19");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{\"name\":\"Jek Tono Porkins\",\"height\":\"180\",\"mass\":\"110\",\"hair_color\":\"brown\",\"skin_color\":\"fair\",\"eye_color\":\"blue\",\"birth_year\":\"unknown\",\"gender\":\"male\",\"homeworld\":\"https://swapi.dev/api/planets/26/\",\"films\":[\"https://swapi.dev/api/films/1/\"],\"species\":[],\"vehicles\":[],\"starships\":[\"https://swapi.dev/api/starships/12/\"],\"created\":\"2014-12-12T11:16:56.569000Z\",\"edited\":\"2014-12-20T21:17:50.343000Z\",\"url\":\"https://swapi.dev/api/people/19/\"}", response);
    }

    @Test
    public void swapiJSONResponseMappingTest() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/people/19");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{\"name\":\"Jek Tono Porkins\",\"height\":\"180\",\"mass\":\"110\",\"hair_color\":\"brown\",\"skin_color\":\"fair\",\"eye_color\":\"blue\",\"birth_year\":\"unknown\",\"gender\":\"male\",\"homeworld\":\"https://swapi.dev/api/planets/26/\",\"films\":[\"https://swapi.dev/api/films/1/\"],\"species\":[],\"vehicles\":[],\"starships\":[\"https://swapi.dev/api/starships/12/\"],\"created\":\"2014-12-12T11:16:56.569000Z\",\"edited\":\"2014-12-20T21:17:50.343000Z\",\"url\":\"https://swapi.dev/api/people/19/\"}", response);

        ObjectMapper responseMapper = new ObjectMapper();
        ResultsItem itsJustPorkins = responseMapper.readValue(response, ResultsItem.class);
        String jeksFullName = "Jek Tono Porkins";
        assertEquals(jeksFullName, itsJustPorkins.getName());
    }
}