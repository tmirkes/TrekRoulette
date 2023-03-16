package co.stapi.staff;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff{

	@JsonProperty("staff")
	private List<StaffItem> staff;

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	public void setStaff(List<StaffItem> staff){
		this.staff = staff;
	}

	public List<StaffItem> getStaff(){
		return staff;
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
			"Staff{" + 
			"staff = '" + staff + '\'' + 
			",page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			"}";
		}
}