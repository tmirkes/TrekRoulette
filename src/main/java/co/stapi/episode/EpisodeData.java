package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeData{

	@JsonProperty("description")
	private String description;

	@JsonProperty("type")
	private String type;

	@JsonProperty("properties")
	private Properties properties;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setProperties(Properties properties){
		this.properties = properties;
	}

	public Properties getProperties(){
		return properties;
	}

	@Override
 	public String toString(){
		return 
			"EpisodeData{" + 
			"description = '" + description + '\'' + 
			",type = '" + type + '\'' + 
			",properties = '" + properties + '\'' + 
			"}";
		}
}