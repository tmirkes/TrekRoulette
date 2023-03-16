package co.stapi.series;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeriesItem{

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("productionEndYear")
	private Object productionEndYear;

	@JsonProperty("seasonsCount")
	private int seasonsCount;

	@JsonProperty("featureLengthEpisodesCount")
	private int featureLengthEpisodesCount;

	@JsonProperty("originalRunStartDate")
	private String originalRunStartDate;

	@JsonProperty("originalBroadcaster")
	private OriginalBroadcaster originalBroadcaster;

	@JsonProperty("episodesCount")
	private int episodesCount;

	@JsonProperty("productionCompany")
	private ProductionCompany productionCompany;

	@JsonProperty("productionStartYear")
	private int productionStartYear;

	@JsonProperty("originalRunEndDate")
	private String originalRunEndDate;

	@JsonProperty("title")
	private String title;

	@JsonProperty("abbreviation")
	private String abbreviation;

	public SeriesItem() {}

	public SeriesItem(String uid, Object productionEndYear, int seasonsCount, int featureLengthEpisodesCount, String originalRunStartDate, OriginalBroadcaster originalBroadcaster, int episodesCount, ProductionCompany productionCompany, int productionStartYear, String originalRunEndDate, String title, String abbreviation) {
		this.uid = uid;
		this.productionEndYear = productionEndYear;
		this.seasonsCount = seasonsCount;
		this.featureLengthEpisodesCount = featureLengthEpisodesCount;
		this.originalRunStartDate = originalRunStartDate;
		this.originalBroadcaster = originalBroadcaster;
		this.episodesCount = episodesCount;
		this.productionCompany = productionCompany;
		this.productionStartYear = productionStartYear;
		this.originalRunEndDate = originalRunEndDate;
		this.title = title;
		this.abbreviation = abbreviation;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setProductionEndYear(Object productionEndYear){
		this.productionEndYear = productionEndYear;
	}

	public Object getProductionEndYear(){
		return productionEndYear;
	}

	public void setSeasonsCount(int seasonsCount){
		this.seasonsCount = seasonsCount;
	}

	public int getSeasonsCount(){
		return seasonsCount;
	}

	public void setFeatureLengthEpisodesCount(int featureLengthEpisodesCount){
		this.featureLengthEpisodesCount = featureLengthEpisodesCount;
	}

	public int getFeatureLengthEpisodesCount(){
		return featureLengthEpisodesCount;
	}

	public void setOriginalRunStartDate(String originalRunStartDate){
		this.originalRunStartDate = originalRunStartDate;
	}

	public String getOriginalRunStartDate(){
		return originalRunStartDate;
	}

	public void setOriginalBroadcaster(OriginalBroadcaster originalBroadcaster){
		this.originalBroadcaster = originalBroadcaster;
	}

	public OriginalBroadcaster getOriginalBroadcaster(){
		return originalBroadcaster;
	}

	public void setEpisodesCount(int episodesCount){
		this.episodesCount = episodesCount;
	}

	public int getEpisodesCount(){
		return episodesCount;
	}

	public void setProductionCompany(ProductionCompany productionCompany){
		this.productionCompany = productionCompany;
	}

	public ProductionCompany getProductionCompany(){
		return productionCompany;
	}

	public void setProductionStartYear(int productionStartYear){
		this.productionStartYear = productionStartYear;
	}

	public int getProductionStartYear(){
		return productionStartYear;
	}

	public void setOriginalRunEndDate(String originalRunEndDate){
		this.originalRunEndDate = originalRunEndDate;
	}

	public String getOriginalRunEndDate(){
		return originalRunEndDate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation(){
		return abbreviation;
	}

	@Override
 	public String toString(){
		return 
			"SeriesItem{" + 
			"uid = '" + uid + '\'' + 
			",productionEndYear = '" + productionEndYear + '\'' + 
			",seasonsCount = '" + seasonsCount + '\'' + 
			",featureLengthEpisodesCount = '" + featureLengthEpisodesCount + '\'' + 
			",originalRunStartDate = '" + originalRunStartDate + '\'' + 
			",originalBroadcaster = '" + originalBroadcaster + '\'' + 
			",episodesCount = '" + episodesCount + '\'' + 
			",productionCompany = '" + productionCompany + '\'' + 
			",productionStartYear = '" + productionStartYear + '\'' + 
			",originalRunEndDate = '" + originalRunEndDate + '\'' + 
			",title = '" + title + '\'' + 
			",abbreviation = '" + abbreviation + '\'' + 
			"}";
		}
}