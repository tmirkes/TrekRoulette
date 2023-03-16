package co.stapi.staff;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffItem{

	@JsonProperty("exhibitAndAttractionStaff")
	private boolean exhibitAndAttractionStaff;

	@JsonProperty("publicationStaff")
	private boolean publicationStaff;

	@JsonProperty("referenceAuthor")
	private boolean referenceAuthor;

	@JsonProperty("musicDepartment")
	private boolean musicDepartment;

	@JsonProperty("calendarArtist")
	private boolean calendarArtist;

	@JsonProperty("videoGameProductionStaff")
	private boolean videoGameProductionStaff;

	@JsonProperty("comicPencilArtist")
	private boolean comicPencilArtist;

	@JsonProperty("castingDepartment")
	private boolean castingDepartment;

	@JsonProperty("placeOfDeath")
	private Object placeOfDeath;

	@JsonProperty("cinematographer")
	private boolean cinematographer;

	@JsonProperty("comicLetterArtist")
	private boolean comicLetterArtist;

	@JsonProperty("birthName")
	private Object birthName;

	@JsonProperty("cameraAndElectricalDepartment")
	private boolean cameraAndElectricalDepartment;

	@JsonProperty("makeupStaff")
	private boolean makeupStaff;

	@JsonProperty("comicInteriorArtist")
	private boolean comicInteriorArtist;

	@JsonProperty("productionDesigner")
	private boolean productionDesigner;

	@JsonProperty("publicationDesigner")
	private boolean publicationDesigner;

	@JsonProperty("comicColorArtist")
	private boolean comicColorArtist;

	@JsonProperty("ilmProductionStaff")
	private boolean ilmProductionStaff;

	@JsonProperty("comicAuthor")
	private boolean comicAuthor;

	@JsonProperty("novelArtist")
	private boolean novelArtist;

	@JsonProperty("stuntDepartment")
	private boolean stuntDepartment;

	@JsonProperty("director")
	private boolean director;

	@JsonProperty("author")
	private boolean author;

	@JsonProperty("transportationDepartment")
	private boolean transportationDepartment;

	@JsonProperty("cbsDigitalStaff")
	private boolean cbsDigitalStaff;

	@JsonProperty("scienceConsultant")
	private boolean scienceConsultant;

	@JsonProperty("specialFeaturesStaff")
	private boolean specialFeaturesStaff;

	@JsonProperty("publicityArtist")
	private boolean publicityArtist;

	@JsonProperty("audioAuthor")
	private boolean audioAuthor;

	@JsonProperty("productionStaff")
	private boolean productionStaff;

	@JsonProperty("name")
	private String name;

	@JsonProperty("producer")
	private boolean producer;

	@JsonProperty("comicArtist")
	private boolean comicArtist;

	@JsonProperty("productionAssociate")
	private boolean productionAssociate;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("assistantOrSecondUnitDirector")
	private boolean assistantOrSecondUnitDirector;

	@JsonProperty("publicationEditor")
	private boolean publicationEditor;

	@JsonProperty("dateOfDeath")
	private String dateOfDeath;

	@JsonProperty("gameArtist")
	private boolean gameArtist;

	@JsonProperty("uid")
	private String uid;

	@JsonProperty("specialAndVisualEffectsStaff")
	private boolean specialAndVisualEffectsStaff;

	@JsonProperty("studioExecutive")
	private boolean studioExecutive;

	@JsonProperty("personalAssistant")
	private boolean personalAssistant;

	@JsonProperty("novelAuthor")
	private boolean novelAuthor;

	@JsonProperty("artDepartment")
	private boolean artDepartment;

	@JsonProperty("filmEditor")
	private boolean filmEditor;

	@JsonProperty("gameAuthor")
	private boolean gameAuthor;

	@JsonProperty("comicInkArtist")
	private boolean comicInkArtist;

	@JsonProperty("placeOfBirth")
	private Object placeOfBirth;

	@JsonProperty("composer")
	private boolean composer;

	@JsonProperty("publicationArtist")
	private boolean publicationArtist;

	@JsonProperty("soundDepartment")
	private boolean soundDepartment;

	@JsonProperty("dateOfBirth")
	private String dateOfBirth;

	@JsonProperty("locationStaff")
	private boolean locationStaff;

	@JsonProperty("comicStripArtist")
	private boolean comicStripArtist;

	@JsonProperty("artDirector")
	private boolean artDirector;

	@JsonProperty("costumeDesigner")
	private boolean costumeDesigner;

	@JsonProperty("linguist")
	private boolean linguist;

	@JsonProperty("costumeDepartment")
	private boolean costumeDepartment;

	@JsonProperty("referenceArtist")
	private boolean referenceArtist;

	@JsonProperty("storyEditor")
	private boolean storyEditor;

	@JsonProperty("writer")
	private boolean writer;

	public void setExhibitAndAttractionStaff(boolean exhibitAndAttractionStaff){
		this.exhibitAndAttractionStaff = exhibitAndAttractionStaff;
	}

	public boolean isExhibitAndAttractionStaff(){
		return exhibitAndAttractionStaff;
	}

	public void setPublicationStaff(boolean publicationStaff){
		this.publicationStaff = publicationStaff;
	}

	public boolean isPublicationStaff(){
		return publicationStaff;
	}

	public void setReferenceAuthor(boolean referenceAuthor){
		this.referenceAuthor = referenceAuthor;
	}

	public boolean isReferenceAuthor(){
		return referenceAuthor;
	}

	public void setMusicDepartment(boolean musicDepartment){
		this.musicDepartment = musicDepartment;
	}

	public boolean isMusicDepartment(){
		return musicDepartment;
	}

	public void setCalendarArtist(boolean calendarArtist){
		this.calendarArtist = calendarArtist;
	}

	public boolean isCalendarArtist(){
		return calendarArtist;
	}

	public void setVideoGameProductionStaff(boolean videoGameProductionStaff){
		this.videoGameProductionStaff = videoGameProductionStaff;
	}

	public boolean isVideoGameProductionStaff(){
		return videoGameProductionStaff;
	}

	public void setComicPencilArtist(boolean comicPencilArtist){
		this.comicPencilArtist = comicPencilArtist;
	}

	public boolean isComicPencilArtist(){
		return comicPencilArtist;
	}

	public void setCastingDepartment(boolean castingDepartment){
		this.castingDepartment = castingDepartment;
	}

	public boolean isCastingDepartment(){
		return castingDepartment;
	}

	public void setPlaceOfDeath(Object placeOfDeath){
		this.placeOfDeath = placeOfDeath;
	}

	public Object getPlaceOfDeath(){
		return placeOfDeath;
	}

	public void setCinematographer(boolean cinematographer){
		this.cinematographer = cinematographer;
	}

	public boolean isCinematographer(){
		return cinematographer;
	}

	public void setComicLetterArtist(boolean comicLetterArtist){
		this.comicLetterArtist = comicLetterArtist;
	}

	public boolean isComicLetterArtist(){
		return comicLetterArtist;
	}

	public void setBirthName(Object birthName){
		this.birthName = birthName;
	}

	public Object getBirthName(){
		return birthName;
	}

	public void setCameraAndElectricalDepartment(boolean cameraAndElectricalDepartment){
		this.cameraAndElectricalDepartment = cameraAndElectricalDepartment;
	}

	public boolean isCameraAndElectricalDepartment(){
		return cameraAndElectricalDepartment;
	}

	public void setMakeupStaff(boolean makeupStaff){
		this.makeupStaff = makeupStaff;
	}

	public boolean isMakeupStaff(){
		return makeupStaff;
	}

	public void setComicInteriorArtist(boolean comicInteriorArtist){
		this.comicInteriorArtist = comicInteriorArtist;
	}

	public boolean isComicInteriorArtist(){
		return comicInteriorArtist;
	}

	public void setProductionDesigner(boolean productionDesigner){
		this.productionDesigner = productionDesigner;
	}

	public boolean isProductionDesigner(){
		return productionDesigner;
	}

	public void setPublicationDesigner(boolean publicationDesigner){
		this.publicationDesigner = publicationDesigner;
	}

	public boolean isPublicationDesigner(){
		return publicationDesigner;
	}

	public void setComicColorArtist(boolean comicColorArtist){
		this.comicColorArtist = comicColorArtist;
	}

	public boolean isComicColorArtist(){
		return comicColorArtist;
	}

	public void setIlmProductionStaff(boolean ilmProductionStaff){
		this.ilmProductionStaff = ilmProductionStaff;
	}

	public boolean isIlmProductionStaff(){
		return ilmProductionStaff;
	}

	public void setComicAuthor(boolean comicAuthor){
		this.comicAuthor = comicAuthor;
	}

	public boolean isComicAuthor(){
		return comicAuthor;
	}

	public void setNovelArtist(boolean novelArtist){
		this.novelArtist = novelArtist;
	}

	public boolean isNovelArtist(){
		return novelArtist;
	}

	public void setStuntDepartment(boolean stuntDepartment){
		this.stuntDepartment = stuntDepartment;
	}

	public boolean isStuntDepartment(){
		return stuntDepartment;
	}

	public void setDirector(boolean director){
		this.director = director;
	}

	public boolean isDirector(){
		return director;
	}

	public void setAuthor(boolean author){
		this.author = author;
	}

	public boolean isAuthor(){
		return author;
	}

	public void setTransportationDepartment(boolean transportationDepartment){
		this.transportationDepartment = transportationDepartment;
	}

	public boolean isTransportationDepartment(){
		return transportationDepartment;
	}

	public void setCbsDigitalStaff(boolean cbsDigitalStaff){
		this.cbsDigitalStaff = cbsDigitalStaff;
	}

	public boolean isCbsDigitalStaff(){
		return cbsDigitalStaff;
	}

	public void setScienceConsultant(boolean scienceConsultant){
		this.scienceConsultant = scienceConsultant;
	}

	public boolean isScienceConsultant(){
		return scienceConsultant;
	}

	public void setSpecialFeaturesStaff(boolean specialFeaturesStaff){
		this.specialFeaturesStaff = specialFeaturesStaff;
	}

	public boolean isSpecialFeaturesStaff(){
		return specialFeaturesStaff;
	}

	public void setPublicityArtist(boolean publicityArtist){
		this.publicityArtist = publicityArtist;
	}

	public boolean isPublicityArtist(){
		return publicityArtist;
	}

	public void setAudioAuthor(boolean audioAuthor){
		this.audioAuthor = audioAuthor;
	}

	public boolean isAudioAuthor(){
		return audioAuthor;
	}

	public void setProductionStaff(boolean productionStaff){
		this.productionStaff = productionStaff;
	}

	public boolean isProductionStaff(){
		return productionStaff;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProducer(boolean producer){
		this.producer = producer;
	}

	public boolean isProducer(){
		return producer;
	}

	public void setComicArtist(boolean comicArtist){
		this.comicArtist = comicArtist;
	}

	public boolean isComicArtist(){
		return comicArtist;
	}

	public void setProductionAssociate(boolean productionAssociate){
		this.productionAssociate = productionAssociate;
	}

	public boolean isProductionAssociate(){
		return productionAssociate;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setAssistantOrSecondUnitDirector(boolean assistantOrSecondUnitDirector){
		this.assistantOrSecondUnitDirector = assistantOrSecondUnitDirector;
	}

	public boolean isAssistantOrSecondUnitDirector(){
		return assistantOrSecondUnitDirector;
	}

	public void setPublicationEditor(boolean publicationEditor){
		this.publicationEditor = publicationEditor;
	}

	public boolean isPublicationEditor(){
		return publicationEditor;
	}

	public void setDateOfDeath(String dateOfDeath){
		this.dateOfDeath = dateOfDeath;
	}

	public String getDateOfDeath(){
		return dateOfDeath;
	}

	public void setGameArtist(boolean gameArtist){
		this.gameArtist = gameArtist;
	}

	public boolean isGameArtist(){
		return gameArtist;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setSpecialAndVisualEffectsStaff(boolean specialAndVisualEffectsStaff){
		this.specialAndVisualEffectsStaff = specialAndVisualEffectsStaff;
	}

	public boolean isSpecialAndVisualEffectsStaff(){
		return specialAndVisualEffectsStaff;
	}

	public void setStudioExecutive(boolean studioExecutive){
		this.studioExecutive = studioExecutive;
	}

	public boolean isStudioExecutive(){
		return studioExecutive;
	}

	public void setPersonalAssistant(boolean personalAssistant){
		this.personalAssistant = personalAssistant;
	}

	public boolean isPersonalAssistant(){
		return personalAssistant;
	}

	public void setNovelAuthor(boolean novelAuthor){
		this.novelAuthor = novelAuthor;
	}

	public boolean isNovelAuthor(){
		return novelAuthor;
	}

	public void setArtDepartment(boolean artDepartment){
		this.artDepartment = artDepartment;
	}

	public boolean isArtDepartment(){
		return artDepartment;
	}

	public void setFilmEditor(boolean filmEditor){
		this.filmEditor = filmEditor;
	}

	public boolean isFilmEditor(){
		return filmEditor;
	}

	public void setGameAuthor(boolean gameAuthor){
		this.gameAuthor = gameAuthor;
	}

	public boolean isGameAuthor(){
		return gameAuthor;
	}

	public void setComicInkArtist(boolean comicInkArtist){
		this.comicInkArtist = comicInkArtist;
	}

	public boolean isComicInkArtist(){
		return comicInkArtist;
	}

	public void setPlaceOfBirth(Object placeOfBirth){
		this.placeOfBirth = placeOfBirth;
	}

	public Object getPlaceOfBirth(){
		return placeOfBirth;
	}

	public void setComposer(boolean composer){
		this.composer = composer;
	}

	public boolean isComposer(){
		return composer;
	}

	public void setPublicationArtist(boolean publicationArtist){
		this.publicationArtist = publicationArtist;
	}

	public boolean isPublicationArtist(){
		return publicationArtist;
	}

	public void setSoundDepartment(boolean soundDepartment){
		this.soundDepartment = soundDepartment;
	}

	public boolean isSoundDepartment(){
		return soundDepartment;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setLocationStaff(boolean locationStaff){
		this.locationStaff = locationStaff;
	}

	public boolean isLocationStaff(){
		return locationStaff;
	}

	public void setComicStripArtist(boolean comicStripArtist){
		this.comicStripArtist = comicStripArtist;
	}

	public boolean isComicStripArtist(){
		return comicStripArtist;
	}

	public void setArtDirector(boolean artDirector){
		this.artDirector = artDirector;
	}

	public boolean isArtDirector(){
		return artDirector;
	}

	public void setCostumeDesigner(boolean costumeDesigner){
		this.costumeDesigner = costumeDesigner;
	}

	public boolean isCostumeDesigner(){
		return costumeDesigner;
	}

	public void setLinguist(boolean linguist){
		this.linguist = linguist;
	}

	public boolean isLinguist(){
		return linguist;
	}

	public void setCostumeDepartment(boolean costumeDepartment){
		this.costumeDepartment = costumeDepartment;
	}

	public boolean isCostumeDepartment(){
		return costumeDepartment;
	}

	public void setReferenceArtist(boolean referenceArtist){
		this.referenceArtist = referenceArtist;
	}

	public boolean isReferenceArtist(){
		return referenceArtist;
	}

	public void setStoryEditor(boolean storyEditor){
		this.storyEditor = storyEditor;
	}

	public boolean isStoryEditor(){
		return storyEditor;
	}

	public void setWriter(boolean writer){
		this.writer = writer;
	}

	public boolean isWriter(){
		return writer;
	}

	@Override
 	public String toString(){
		return 
			"StaffItem{" + 
			"exhibitAndAttractionStaff = '" + exhibitAndAttractionStaff + '\'' + 
			",publicationStaff = '" + publicationStaff + '\'' + 
			",referenceAuthor = '" + referenceAuthor + '\'' + 
			",musicDepartment = '" + musicDepartment + '\'' + 
			",calendarArtist = '" + calendarArtist + '\'' + 
			",videoGameProductionStaff = '" + videoGameProductionStaff + '\'' + 
			",comicPencilArtist = '" + comicPencilArtist + '\'' + 
			",castingDepartment = '" + castingDepartment + '\'' + 
			",placeOfDeath = '" + placeOfDeath + '\'' + 
			",cinematographer = '" + cinematographer + '\'' + 
			",comicLetterArtist = '" + comicLetterArtist + '\'' + 
			",birthName = '" + birthName + '\'' + 
			",cameraAndElectricalDepartment = '" + cameraAndElectricalDepartment + '\'' + 
			",makeupStaff = '" + makeupStaff + '\'' + 
			",comicInteriorArtist = '" + comicInteriorArtist + '\'' + 
			",productionDesigner = '" + productionDesigner + '\'' + 
			",publicationDesigner = '" + publicationDesigner + '\'' + 
			",comicColorArtist = '" + comicColorArtist + '\'' + 
			",ilmProductionStaff = '" + ilmProductionStaff + '\'' + 
			",comicAuthor = '" + comicAuthor + '\'' + 
			",novelArtist = '" + novelArtist + '\'' + 
			",stuntDepartment = '" + stuntDepartment + '\'' + 
			",director = '" + director + '\'' + 
			",author = '" + author + '\'' + 
			",transportationDepartment = '" + transportationDepartment + '\'' + 
			",cbsDigitalStaff = '" + cbsDigitalStaff + '\'' + 
			",scienceConsultant = '" + scienceConsultant + '\'' + 
			",specialFeaturesStaff = '" + specialFeaturesStaff + '\'' + 
			",publicityArtist = '" + publicityArtist + '\'' + 
			",audioAuthor = '" + audioAuthor + '\'' + 
			",productionStaff = '" + productionStaff + '\'' + 
			",name = '" + name + '\'' + 
			",producer = '" + producer + '\'' + 
			",comicArtist = '" + comicArtist + '\'' + 
			",productionAssociate = '" + productionAssociate + '\'' + 
			",gender = '" + gender + '\'' + 
			",assistantOrSecondUnitDirector = '" + assistantOrSecondUnitDirector + '\'' + 
			",publicationEditor = '" + publicationEditor + '\'' + 
			",dateOfDeath = '" + dateOfDeath + '\'' + 
			",gameArtist = '" + gameArtist + '\'' + 
			",uid = '" + uid + '\'' + 
			",specialAndVisualEffectsStaff = '" + specialAndVisualEffectsStaff + '\'' + 
			",studioExecutive = '" + studioExecutive + '\'' + 
			",personalAssistant = '" + personalAssistant + '\'' + 
			",novelAuthor = '" + novelAuthor + '\'' + 
			",artDepartment = '" + artDepartment + '\'' + 
			",filmEditor = '" + filmEditor + '\'' + 
			",gameAuthor = '" + gameAuthor + '\'' + 
			",comicInkArtist = '" + comicInkArtist + '\'' + 
			",placeOfBirth = '" + placeOfBirth + '\'' + 
			",composer = '" + composer + '\'' + 
			",publicationArtist = '" + publicationArtist + '\'' + 
			",soundDepartment = '" + soundDepartment + '\'' + 
			",dateOfBirth = '" + dateOfBirth + '\'' + 
			",locationStaff = '" + locationStaff + '\'' + 
			",comicStripArtist = '" + comicStripArtist + '\'' + 
			",artDirector = '" + artDirector + '\'' + 
			",costumeDesigner = '" + costumeDesigner + '\'' + 
			",linguist = '" + linguist + '\'' + 
			",costumeDepartment = '" + costumeDepartment + '\'' + 
			",referenceArtist = '" + referenceArtist + '\'' + 
			",storyEditor = '" + storyEditor + '\'' + 
			",writer = '" + writer + '\'' + 
			"}";
		}
}