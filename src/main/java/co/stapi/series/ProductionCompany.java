package co.stapi.series;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCompany{

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("name")
	private String name;

	public ProductionCompany() {
	}

	public ProductionCompany(String uid, String name) {
		this.uid = uid;
		this.name = name;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ProductionCompany{" + 
			"uid = '" + uid + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}