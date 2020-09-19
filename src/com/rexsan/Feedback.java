package com.rexsan;

public class Feedback {
private int id;
private String name,email,system,rating,comments;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getsystem(){
	return system;
}
public void setsystem(String system) {
	this.system=system;
}
public String getrating() {
	return rating;
}
public void setrating(String rating) {
	this.rating = rating;
}
public String getcomments() {
	return comments;
}
public void setcomments(String comments) {
	this.comments=comments;
}

}
