package co.stapi.performer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PerformersItem{

	@JsonProperty("entPerformer")
	private boolean entPerformer;

	@JsonProperty("standInPerformer")
	private boolean standInPerformer;

	@JsonProperty("videoGamePerformer")
	private boolean videoGamePerformer;

	@JsonProperty("placeOfBirth")
	private Object placeOfBirth;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("dateOfDeath")
	private Object dateOfDeath;

	@JsonProperty("animalPerformer")
	private boolean animalPerformer;

	@JsonProperty("stuntPerformer")
	private boolean stuntPerformer;

	@JsonProperty("dateOfBirth")
	private Object dateOfBirth;

	@JsonProperty("placeOfDeath")
	private Object placeOfDeath;

	@JsonProperty("tasPerformer")
	private boolean tasPerformer;

	@JsonProperty("birthName")
	private Object birthName;

	@JsonProperty("voicePerformer")
	private boolean voicePerformer;

	@JsonProperty("disPerformer")
	private boolean disPerformer;

	@JsonProperty("voyPerformer")
	private boolean voyPerformer;

	@JsonProperty("tosPerformer")
	private boolean tosPerformer;

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("tngPerformer")
	private boolean tngPerformer;

	@JsonProperty("name")
	private String name;

	@JsonProperty("filmPerformer")
	private boolean filmPerformer;

	@JsonProperty("ds9Performer")
	private boolean ds9Performer;

	public void setEntPerformer(boolean entPerformer){
		this.entPerformer = entPerformer;
	}

	public boolean isEntPerformer(){
		return entPerformer;
	}

	public void setStandInPerformer(boolean standInPerformer){
		this.standInPerformer = standInPerformer;
	}

	public boolean isStandInPerformer(){
		return standInPerformer;
	}

	public void setVideoGamePerformer(boolean videoGamePerformer){
		this.videoGamePerformer = videoGamePerformer;
	}

	public boolean isVideoGamePerformer(){
		return videoGamePerformer;
	}

	public void setPlaceOfBirth(Object placeOfBirth){
		this.placeOfBirth = placeOfBirth;
	}

	public Object getPlaceOfBirth(){
		return placeOfBirth;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setDateOfDeath(Object dateOfDeath){
		this.dateOfDeath = dateOfDeath;
	}

	public Object getDateOfDeath(){
		return dateOfDeath;
	}

	public void setAnimalPerformer(boolean animalPerformer){
		this.animalPerformer = animalPerformer;
	}

	public boolean isAnimalPerformer(){
		return animalPerformer;
	}

	public void setStuntPerformer(boolean stuntPerformer){
		this.stuntPerformer = stuntPerformer;
	}

	public boolean isStuntPerformer(){
		return stuntPerformer;
	}

	public void setDateOfBirth(Object dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public Object getDateOfBirth(){
		return dateOfBirth;
	}

	public void setPlaceOfDeath(Object placeOfDeath){
		this.placeOfDeath = placeOfDeath;
	}

	public Object getPlaceOfDeath(){
		return placeOfDeath;
	}

	public void setTasPerformer(boolean tasPerformer){
		this.tasPerformer = tasPerformer;
	}

	public boolean isTasPerformer(){
		return tasPerformer;
	}

	public void setBirthName(Object birthName){
		this.birthName = birthName;
	}

	public Object getBirthName(){
		return birthName;
	}

	public void setVoicePerformer(boolean voicePerformer){
		this.voicePerformer = voicePerformer;
	}

	public boolean isVoicePerformer(){
		return voicePerformer;
	}

	public void setDisPerformer(boolean disPerformer){
		this.disPerformer = disPerformer;
	}

	public boolean isDisPerformer(){
		return disPerformer;
	}

	public void setVoyPerformer(boolean voyPerformer){
		this.voyPerformer = voyPerformer;
	}

	public boolean isVoyPerformer(){
		return voyPerformer;
	}

	public void setTosPerformer(boolean tosPerformer){
		this.tosPerformer = tosPerformer;
	}

	public boolean isTosPerformer(){
		return tosPerformer;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setTngPerformer(boolean tngPerformer){
		this.tngPerformer = tngPerformer;
	}

	public boolean isTngPerformer(){
		return tngPerformer;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFilmPerformer(boolean filmPerformer){
		this.filmPerformer = filmPerformer;
	}

	public boolean isFilmPerformer(){
		return filmPerformer;
	}

	public void setDs9Performer(boolean ds9Performer){
		this.ds9Performer = ds9Performer;
	}

	public boolean isDs9Performer(){
		return ds9Performer;
	}

	@Override
 	public String toString(){
		return 
			"PerformersItem{" + 
			"entPerformer = '" + entPerformer + '\'' + 
			",standInPerformer = '" + standInPerformer + '\'' + 
			",videoGamePerformer = '" + videoGamePerformer + '\'' + 
			",placeOfBirth = '" + placeOfBirth + '\'' + 
			",gender = '" + gender + '\'' + 
			",dateOfDeath = '" + dateOfDeath + '\'' + 
			",animalPerformer = '" + animalPerformer + '\'' + 
			",stuntPerformer = '" + stuntPerformer + '\'' + 
			",dateOfBirth = '" + dateOfBirth + '\'' + 
			",placeOfDeath = '" + placeOfDeath + '\'' + 
			",tasPerformer = '" + tasPerformer + '\'' + 
			",birthName = '" + birthName + '\'' + 
			",voicePerformer = '" + voicePerformer + '\'' + 
			",disPerformer = '" + disPerformer + '\'' + 
			",voyPerformer = '" + voyPerformer + '\'' + 
			",tosPerformer = '" + tosPerformer + '\'' + 
			",uid = '" + uid + '\'' + 
			",tngPerformer = '" + tngPerformer + '\'' + 
			",name = '" + name + '\'' + 
			",filmPerformer = '" + filmPerformer + '\'' + 
			",ds9Performer = '" + ds9Performer + '\'' + 
			"}";
		}
}