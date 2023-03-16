package co.stapi.episode;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("page")
	private Page page;

	@JsonProperty("sort")
	private Sort sort;

	@JsonProperty("episodes")
	private List<EpisodesItem> episodes;

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("title")
	private String title;

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

	public void setEpisodes(List<EpisodesItem> episodes){
		this.episodes = episodes;
	}

	public List<EpisodesItem> getEpisodes(){
		return episodes;
	}

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
			"Season{" + 
			"page = '" + page + '\'' + 
			",sort = '" + sort + '\'' + 
			",episodes = '" + episodes + '\'' + 
			",uid = '" + uid + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}