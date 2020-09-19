package com.video.model;

public class video {
	private int id;
	private String name;
	private String category;
	private String description;
	private byte[] videofile;
	
	public video() {
		
	}
	
	
	



	
	public video(int id, String name, String category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
	}







	public video(int id, String name, String category, String description, byte[] videofile) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.videofile = videofile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getVideofile() {
		return videofile;
	}
	public void setVideofile(byte[] videofile) {
		this.videofile = videofile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
