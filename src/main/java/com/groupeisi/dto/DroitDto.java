package com.groupeisi.dto;

import java.util.ArrayList;
import java.util.List;


public class DroitDto {

	private int id;
	private String name;
	private List<String> comptes = new ArrayList<String>();
	
	
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
	public List<String> getComptes() {
		return comptes;
	}
	public void setComptes(List<String> comptes) {
		this.comptes = comptes;
	}

	public DroitDto() {
	}

	public DroitDto(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
