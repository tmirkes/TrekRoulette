package co.stapi.season;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("seasons")
	private List<SeasonsItem> seasons;

	public void setSeasons(List<SeasonsItem> seasons){
		this.seasons = seasons;
	}

	public List<SeasonsItem> getSeasons(){
		return seasons;
	}

	@Override
 	public String toString(){
		return 
			"Season{" + 
			"seasons = '" + seasons + '\'' + 
			"}";
		}
}