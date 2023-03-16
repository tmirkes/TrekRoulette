package co.stapi.season;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("seasons")
	private List<SeasonsItem> seasons;

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	public void setSeasons(List<SeasonsItem> seasons){
		this.seasons = seasons;
	}

	public List<SeasonsItem> getSeasons(){
		return seasons;
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
			"Season{" + 
			"seasons = '" + seasons + '\'' + 
			",page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			"}";
		}
}