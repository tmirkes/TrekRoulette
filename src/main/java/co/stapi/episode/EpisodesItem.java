package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodesItem{

	@JsonProperty("titleItalian")
	private Object titleItalian;

	@JsonProperty("seasonNumber")
	private int seasonNumber;

	@JsonProperty("title")
	private String title;

	@JsonProperty("usAirDate")
	private String usAirDate;

	@JsonProperty("episodeNumber")
	private int episodeNumber;

	@JsonProperty("yearTo")
	private int yearTo;

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("stardateTo")
	private Object stardateTo;

	@JsonProperty("featureLength")
	private boolean featureLength;

	@JsonProperty("series")
	private Series series;

	@JsonProperty("yearFrom")
	private int yearFrom;

	@JsonProperty("finalScriptDate")
	private Object finalScriptDate;

	@JsonProperty("productionSerialNumber")
	private String productionSerialNumber;

	@JsonProperty("season")
	private Season season;

	@JsonProperty("stardateFrom")
	private Object stardateFrom;

	@JsonProperty("titleGerman")
	private String titleGerman;

	@JsonProperty("titleJapanese")
	private Object titleJapanese;

	public void setTitleItalian(Object titleItalian){
		this.titleItalian = titleItalian;
	}

	public Object getTitleItalian(){
		return titleItalian;
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

	public void setUsAirDate(String usAirDate){
		this.usAirDate = usAirDate;
	}

	public String getUsAirDate(){
		return usAirDate;
	}

	public void setEpisodeNumber(int episodeNumber){
		this.episodeNumber = episodeNumber;
	}

	public int getEpisodeNumber(){
		return episodeNumber;
	}

	public void setYearTo(int yearTo){
		this.yearTo = yearTo;
	}

	public int getYearTo(){
		return yearTo;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setStardateTo(Object stardateTo){
		this.stardateTo = stardateTo;
	}

	public Object getStardateTo(){
		return stardateTo;
	}

	public void setFeatureLength(boolean featureLength){
		this.featureLength = featureLength;
	}

	public boolean isFeatureLength(){
		return featureLength;
	}

	public void setSeries(Series series){
		this.series = series;
	}

	public Series getSeries(){
		return series;
	}

	public void setYearFrom(int yearFrom){
		this.yearFrom = yearFrom;
	}

	public int getYearFrom(){
		return yearFrom;
	}

	public void setFinalScriptDate(Object finalScriptDate){
		this.finalScriptDate = finalScriptDate;
	}

	public Object getFinalScriptDate(){
		return finalScriptDate;
	}

	public void setProductionSerialNumber(String productionSerialNumber){
		this.productionSerialNumber = productionSerialNumber;
	}

	public String getProductionSerialNumber(){
		return productionSerialNumber;
	}

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setStardateFrom(Object stardateFrom){
		this.stardateFrom = stardateFrom;
	}

	public Object getStardateFrom(){
		return stardateFrom;
	}

	public void setTitleGerman(String titleGerman){
		this.titleGerman = titleGerman;
	}

	public String getTitleGerman(){
		return titleGerman;
	}

	public void setTitleJapanese(Object titleJapanese){
		this.titleJapanese = titleJapanese;
	}

	public Object getTitleJapanese(){
		return titleJapanese;
	}

	@Override
 	public String toString(){
		return 
			"EpisodesItem{" + 
			"titleItalian = '" + titleItalian + '\'' + 
			",seasonNumber = '" + seasonNumber + '\'' + 
			",title = '" + title + '\'' + 
			",usAirDate = '" + usAirDate + '\'' + 
			",episodeNumber = '" + episodeNumber + '\'' + 
			",yearTo = '" + yearTo + '\'' + 
			",uid = '" + uid + '\'' + 
			",stardateTo = '" + stardateTo + '\'' + 
			",featureLength = '" + featureLength + '\'' + 
			",series = '" + series + '\'' + 
			",yearFrom = '" + yearFrom + '\'' + 
			",finalScriptDate = '" + finalScriptDate + '\'' + 
			",productionSerialNumber = '" + productionSerialNumber + '\'' + 
			",season = '" + season + '\'' + 
			",stardateFrom = '" + stardateFrom + '\'' + 
			",titleGerman = '" + titleGerman + '\'' + 
			",titleJapanese = '" + titleJapanese + '\'' + 
			"}";
		}
}