package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Uid{

	@JsonProperty("description")
	private String description;

	@JsonProperty("type")
	private String type;

	@JsonProperty("required")
	private boolean required;

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

	public void setRequired(boolean required){
		this.required = required;
	}

	public boolean isRequired(){
		return required;
	}

	@Override
 	public String toString(){
		return 
			"Uid{" + 
			"description = '" + description + '\'' + 
			",type = '" + type + '\'' + 
			",required = '" + required + '\'' + 
			"}";
		}
}