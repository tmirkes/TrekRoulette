package co.stapi.series;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Series{

	@JsonProperty("series")
	private ArrayList<SeriesItem> series;

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	@JsonCreator
	public Series() {}

	public void setSeries(ArrayList<SeriesItem> series){
		this.series = series;
	}

	public ArrayList<SeriesItem> getSeries(){
		return series;
	}

	public void setPage(Page page){
		this.page = page;
	}

	public Page getPage(){
		return page;
	}

	public void setSort(Sort sort){
		this.sort = sort;
	}

	public Sort getSort(){
		return sort;
	}

	@Override
 	public String toString(){
		return 
			"Series{" + 
			"series = '" + series + '\'' + 
			",page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			"}";
		}
}