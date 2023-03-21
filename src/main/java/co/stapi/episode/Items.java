package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items{

	@JsonProperty("$ref")
	private String ref;

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}

	@Override
 	public String toString(){
		return 
			"Items{" + 
			"$ref = '" + ref + '\'' + 
			"}";
		}
}