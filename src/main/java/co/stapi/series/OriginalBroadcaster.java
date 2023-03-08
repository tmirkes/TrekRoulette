package co.stapi.series;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalBroadcaster{

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("name")
	private String name;

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
			"OriginalBroadcaster{" + 
			"uid = '" + uid + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}