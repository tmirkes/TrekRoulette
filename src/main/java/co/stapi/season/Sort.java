package co.stapi.season;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sort{

	@JsonProperty("clauses")
	private List<Object> clauses;

	public void setClauses(List<Object> clauses){
		this.clauses = clauses;
	}

	public List<Object> getClauses(){
		return clauses;
	}

	@Override
 	public String toString(){
		return 
			"Sort{" + 
			"clauses = '" + clauses + '\'' + 
			"}";
		}
}