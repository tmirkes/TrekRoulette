package co.stapi.performer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Performer{

	@JsonProperty("performers")
	private List<PerformersItem> performers;

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	public void setPerformers(List<PerformersItem> performers){
		this.performers = performers;
	}

	public List<PerformersItem> getPerformers(){
		return performers;
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
			"Performer{" + 
			"performers = '" + performers + '\'' + 
			",page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			"}";
		}
}