package co.stapi.series;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sort{

	@JsonProperty("clauses")
	private ArrayList<Object> clauses;

	public Sort() {
	}

	public Sort(ArrayList<Object> clauses) {
		this.clauses = clauses;
	}

	public void setClauses(ArrayList<Object> clauses){
		this.clauses = clauses;
	}

	public ArrayList<Object> getClauses(){
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