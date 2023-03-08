package co.stapi.season;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeasonsItem{

	@JsonProperty("numberOfEpisodes")
	private int numberOfEpisodes;

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("series")
	private Series series;

	@JsonProperty("seasonNumber")
	private int seasonNumber;

	@JsonProperty("title")
	private String title;

	public void setNumberOfEpisodes(int numberOfEpisodes){
		this.numberOfEpisodes = numberOfEpisodes;
	}

	public int getNumberOfEpisodes(){
		return numberOfEpisodes;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setSeries(Series series){
		this.series = series;
	}

	public Series getSeries(){
		return series;
	}

	public void setSeasonNumber(int seasonNumber){
		this.seasonNumber = seasonNumber;
	}

	public int getSeasonNumber(){
		return seasonNumber;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"SeasonsItem{" + 
			"numberOfEpisodes = '" + numberOfEpisodes + '\'' + 
			",uid = '" + uid + '\'' + 
			",series = '" + series + '\'' + 
			",seasonNumber = '" + seasonNumber + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}