package co.stapi.series;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("series")
	private List<SeriesItem> series;

	public void setSeries(List<SeriesItem> series){
		this.series = series;
	}

	public List<SeriesItem> getSeries(){
		return series;
	}

	@Override
 	public String toString(){
		return 
			"Season{" + 
			"series = '" + series + '\'' + 
			"}";
		}
}