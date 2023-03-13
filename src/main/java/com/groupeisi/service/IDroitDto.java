package com.groupeisi.service;

import com.groupeisi.dto.DroitDto;

import java.util.List;

public interface IDroitDto {

	public int add(DroitDto droitDto);
	public int delete(int id);
	public int update(DroitDto droitDto);
	public List<DroitDto> list();
	public DroitDto get(int id);
}
