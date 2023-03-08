package co.stapi.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series{

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("title")
	private String title;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Series{" + 
			"uid = '" + uid + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}