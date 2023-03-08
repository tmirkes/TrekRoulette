package co.stapi.episode;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode{

	@JsonProperty("episodes")
	private List<EpisodesItem> episodes;

	public void setEpisodes(List<EpisodesItem> episodes){
		this.episodes = episodes;
	}

	public List<EpisodesItem> getEpisodes(){
		return episodes;
	}

	@Override
 	public String toString(){
		return 
			"Episode{" + 
			"episodes = '" + episodes + '\'' + 
			"}";
		}
}