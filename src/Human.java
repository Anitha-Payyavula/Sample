package com.anitha.demorest;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Human {
	int id;
	String name;
	int points;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

}
