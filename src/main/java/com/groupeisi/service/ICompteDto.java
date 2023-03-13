package com.groupeisi.service;

import com.groupeisi.dto.CompteDto;

import java.util.List;

public interface ICompteDto {

	public int add(CompteDto compteDto);
	public int delete(int id);
	public int update(CompteDto compteDto);
	public List<CompteDto> list();
	public CompteDto get(int id);
}
