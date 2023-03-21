package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StardateTo{

	@JsonProperty("format")
	private String format;

	@JsonProperty("description")
	private String description;

	@JsonProperty("type")
	private String type;

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

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
			"StardateTo{" + 
			"format = '" + format + '\'' + 
			",description = '" + description + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}