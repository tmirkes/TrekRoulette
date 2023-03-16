package co.stapi.occupation;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Occupation{

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	@JsonProperty("occupations")
	private List<OccupationsItem> occupations;

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

	public void setOccupations(List<OccupationsItem> occupations){
		this.occupations = occupations;
	}

	public List<OccupationsItem> getOccupations(){
		return occupations;
	}

	@Override
 	public String toString(){
		return 
			"Occupation{" + 
			"page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			",occupations = '" + occupations + '\'' + 
			"}";
		}
}