package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties{

	@JsonProperty("directors")
	private Directors directors;

	@JsonProperty("title")
	private Title title;

	@JsonProperty("episodeNumber")
	private EpisodeNumber episodeNumber;

	@JsonProperty("storyAuthors")
	private StoryAuthors storyAuthors;

	@JsonProperty("uid")
	private Uid uid;

	@JsonProperty("stardateTo")
	private StardateTo stardateTo;

	@JsonProperty("characters")
	private Characters characters;

	@JsonProperty("teleplayAuthors")
	private TeleplayAuthors teleplayAuthors;

	@JsonProperty("season")
	private Season season;

	@JsonProperty("stardateFrom")
	private StardateFrom stardateFrom;

	@JsonProperty("titleItalian")
	private TitleItalian titleItalian;

	@JsonProperty("performers")
	private Performers performers;

	@JsonProperty("standInPerformers")
	private StandInPerformers standInPerformers;

	@JsonProperty("seasonNumber")
	private SeasonNumber seasonNumber;

	@JsonProperty("writers")
	private Writers writers;

	@JsonProperty("usAirDate")
	private UsAirDate usAirDate;

	@JsonProperty("yearTo")
	private YearTo yearTo;

	@JsonProperty("featureLength")
	private FeatureLength featureLength;

	@JsonProperty("series")
	private Series series;

	@JsonProperty("yearFrom")
	private YearFrom yearFrom;

	@JsonProperty("finalScriptDate")
	private FinalScriptDate finalScriptDate;

	@JsonProperty("productionSerialNumber")
	private ProductionSerialNumber productionSerialNumber;

	@JsonProperty("titleGerman")
	private TitleGerman titleGerman;

	@JsonProperty("titleJapanese")
	private TitleJapanese titleJapanese;

	@JsonProperty("stuntPerformers")
	private StuntPerformers stuntPerformers;

	public void setDirectors(Directors directors){
		this.directors = directors;
	}

	public Directors getDirectors(){
		return directors;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setEpisodeNumber(EpisodeNumber episodeNumber){
		this.episodeNumber = episodeNumber;
	}

	public EpisodeNumber getEpisodeNumber(){
		return episodeNumber;
	}

	public void setStoryAuthors(StoryAuthors storyAuthors){
		this.storyAuthors = storyAuthors;
	}

	public StoryAuthors getStoryAuthors(){
		return storyAuthors;
	}

	public void setUid(Uid uid){
		this.uid = uid;
	}

	public Uid getUid(){
		return uid;
	}

	public void setStardateTo(StardateTo stardateTo){
		this.stardateTo = stardateTo;
	}

	public StardateTo getStardateTo(){
		return stardateTo;
	}

	public void setCharacters(Characters characters){
		this.characters = characters;
	}

	public Characters getCharacters(){
		return characters;
	}

	public void setTeleplayAuthors(TeleplayAuthors teleplayAuthors){
		this.teleplayAuthors = teleplayAuthors;
	}

	public TeleplayAuthors getTeleplayAuthors(){
		return teleplayAuthors;
	}

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setStardateFrom(StardateFrom stardateFrom){
		this.stardateFrom = stardateFrom;
	}

	public StardateFrom getStardateFrom(){
		return stardateFrom;
	}

	public void setTitleItalian(TitleItalian titleItalian){
		this.titleItalian = titleItalian;
	}

	public TitleItalian getTitleItalian(){
		return titleItalian;
	}

	public void setPerformers(Performers performers){
		this.performers = performers;
	}

	public Performers getPerformers(){
		return performers;
	}

	public void setStandInPerformers(StandInPerformers standInPerformers){
		this.standInPerformers = standInPerformers;
	}

	public StandInPerformers getStandInPerformers(){
		return standInPerformers;
	}

	public void setSeasonNumber(SeasonNumber seasonNumber){
		this.seasonNumber = seasonNumber;
	}

	public SeasonNumber getSeasonNumber(){
		return seasonNumber;
	}

	public void setWriters(Writers writers){
		this.writers = writers;
	}

	public Writers getWriters(){
		return writers;
	}

	public void setUsAirDate(UsAirDate usAirDate){
		this.usAirDate = usAirDate;
	}

	public UsAirDate getUsAirDate(){
		return usAirDate;
	}

	public void setYearTo(YearTo yearTo){
		this.yearTo = yearTo;
	}

	public YearTo getYearTo(){
		return yearTo;
	}

	public void setFeatureLength(FeatureLength featureLength){
		this.featureLength = featureLength;
	}

	public FeatureLength getFeatureLength(){
		return featureLength;
	}

	public void setSeries(Series series){
		this.series = series;
	}

	public Series getSeries(){
		return series;
	}

	public void setYearFrom(YearFrom yearFrom){
		this.yearFrom = yearFrom;
	}

	public YearFrom getYearFrom(){
		return yearFrom;
	}

	public void setFinalScriptDate(FinalScriptDate finalScriptDate){
		this.finalScriptDate = finalScriptDate;
	}

	public FinalScriptDate getFinalScriptDate(){
		return finalScriptDate;
	}

	public void setProductionSerialNumber(ProductionSerialNumber productionSerialNumber){
		this.productionSerialNumber = productionSerialNumber;
	}

	public ProductionSerialNumber getProductionSerialNumber(){
		return productionSerialNumber;
	}

	public void setTitleGerman(TitleGerman titleGerman){
		this.titleGerman = titleGerman;
	}

	public TitleGerman getTitleGerman(){
		return titleGerman;
	}

	public void setTitleJapanese(TitleJapanese titleJapanese){
		this.titleJapanese = titleJapanese;
	}

	public TitleJapanese getTitleJapanese(){
		return titleJapanese;
	}

	public void setStuntPerformers(StuntPerformers stuntPerformers){
		this.stuntPerformers = stuntPerformers;
	}

	public StuntPerformers getStuntPerformers(){
		return stuntPerformers;
	}

	@Override
 	public String toString(){
		return 
			"Properties{" + 
			"directors = '" + directors + '\'' + 
			",title = '" + title + '\'' + 
			",episodeNumber = '" + episodeNumber + '\'' + 
			",storyAuthors = '" + storyAuthors + '\'' + 
			",uid = '" + uid + '\'' + 
			",stardateTo = '" + stardateTo + '\'' + 
			",characters = '" + characters + '\'' + 
			",teleplayAuthors = '" + teleplayAuthors + '\'' + 
			",season = '" + season + '\'' + 
			",stardateFrom = '" + stardateFrom + '\'' + 
			",titleItalian = '" + titleItalian + '\'' + 
			",performers = '" + performers + '\'' + 
			",standInPerformers = '" + standInPerformers + '\'' + 
			",seasonNumber = '" + seasonNumber + '\'' + 
			",writers = '" + writers + '\'' + 
			",usAirDate = '" + usAirDate + '\'' + 
			",yearTo = '" + yearTo + '\'' + 
			",featureLength = '" + featureLength + '\'' + 
			",series = '" + series + '\'' + 
			",yearFrom = '" + yearFrom + '\'' + 
			",finalScriptDate = '" + finalScriptDate + '\'' + 
			",productionSerialNumber = '" + productionSerialNumber + '\'' + 
			",titleGerman = '" + titleGerman + '\'' + 
			",titleJapanese = '" + titleJapanese + '\'' + 
			",stuntPerformers = '" + stuntPerformers + '\'' + 
			"}";
		}
}