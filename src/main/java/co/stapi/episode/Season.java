package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("description")
	private String description;

	@JsonProperty("$ref")
	private String ref;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}

	@Override
 	public String toString(){
		return 
			"Season{" + 
			"description = '" + description + '\'' + 
			",$ref = '" + ref + '\'' + 
			"}";
		}
}