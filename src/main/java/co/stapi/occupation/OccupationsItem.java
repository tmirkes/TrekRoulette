package co.stapi.occupation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OccupationsItem{

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("medicalOccupation")
	private boolean medicalOccupation;

	@JsonProperty("name")
	private String name;

	@JsonProperty("legalOccupation")
	private boolean legalOccupation;

	@JsonProperty("scientificOccupation")
	private boolean scientificOccupation;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setMedicalOccupation(boolean medicalOccupation){
		this.medicalOccupation = medicalOccupation;
	}

	public boolean isMedicalOccupation(){
		return medicalOccupation;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLegalOccupation(boolean legalOccupation){
		this.legalOccupation = legalOccupation;
	}

	public boolean isLegalOccupation(){
		return legalOccupation;
	}

	public void setScientificOccupation(boolean scientificOccupation){
		this.scientificOccupation = scientificOccupation;
	}

	public boolean isScientificOccupation(){
		return scientificOccupation;
	}

	@Override
 	public String toString(){
		return 
			"OccupationsItem{" + 
			"uid = '" + uid + '\'' + 
			",medicalOccupation = '" + medicalOccupation + '\'' + 
			",name = '" + name + '\'' + 
			",legalOccupation = '" + legalOccupation + '\'' + 
			",scientificOccupation = '" + scientificOccupation + '\'' + 
			"}";
		}
}