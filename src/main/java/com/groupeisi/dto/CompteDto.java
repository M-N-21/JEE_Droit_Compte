package com.groupeisi.dto;

import java.util.ArrayList; 
import java.util.List;

public class CompteDto {

	private int id;
	private String username;
	private String password;
	private List<DroitDto> droits = new ArrayList<DroitDto>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String email) {
		this.username = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DroitDto> getDroits() {
		return droits;
	}
	public void setDroits(List<DroitDto> droits) {
		this.droits = droits;
	}
}
