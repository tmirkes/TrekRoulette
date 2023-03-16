package co.stapi.performer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page{

	@JsonProperty("pageNumber")
	private int pageNumber;

	@JsonProperty("numberOfElements")
	private int numberOfElements;

	@JsonProperty("firstPage")
	private boolean firstPage;

	@JsonProperty("lastPage")
	private boolean lastPage;

	@JsonProperty("totalPages")
	private int totalPages;

	@JsonProperty("pageSize")
	private int pageSize;

	@JsonProperty("totalElements")
	private int totalElements;

	public void setPageNumber(int pageNumber){
		this.pageNumber = pageNumber;
	}

	public int getPageNumber(){
		return pageNumber;
	}

	public void setNumberOfElements(int numberOfElements){
		this.numberOfElements = numberOfElements;
	}

	public int getNumberOfElements(){
		return numberOfElements;
	}

	public void setFirstPage(boolean firstPage){
		this.firstPage = firstPage;
	}

	public boolean isFirstPage(){
		return firstPage;
	}

	public void setLastPage(boolean lastPage){
		this.lastPage = lastPage;
	}

	public boolean isLastPage(){
		return lastPage;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setTotalElements(int totalElements){
		this.totalElements = totalElements;
	}

	public int getTotalElements(){
		return totalElements;
	}

	@Override
 	public String toString(){
		return 
			"Page{" + 
			"pageNumber = '" + pageNumber + '\'' + 
			",numberOfElements = '" + numberOfElements + '\'' + 
			",firstPage = '" + firstPage + '\'' + 
			",lastPage = '" + lastPage + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",totalElements = '" + totalElements + '\'' + 
			"}";
		}
}