package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureLength{

	@JsonProperty("description")
	private String description;

	@JsonProperty("type")
	private String type;

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

	@Override
 	public String toString(){
		return 
			"FeatureLength{" + 
			"description = '" + description + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}