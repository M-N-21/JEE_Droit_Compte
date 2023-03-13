package com.groupeisi.service;

import com.groupeisi.dao.DroitImpl;
import com.groupeisi.dto.DroitDto;
import com.groupeisi.entities.Droit;
import java.util.ArrayList;
import java.util.List;
public class DroitDtoImpl implements IDroitDto {
	private DroitImpl ddao = new DroitImpl();
	@Override
	public int add(DroitDto droitDto) {

		return ddao.add(ddao.DroitDtoToDroitEntity(droitDto));
	}
	@Override
	public int delete(int id) {

		return ddao.delete(id, new Droit());
	}
	@Override
	public int update(DroitDto droitDto) {

		return ddao.update(ddao.DroitDtoToDroitEntity(droitDto));
	}

	@Override
	public List<DroitDto> list() {
		List<DroitDto> droitDtos = new ArrayList<>();
		List<Droit> droits = ddao.list(new Droit());
		for (Droit r: droits) {
			if (droitDtos.isEmpty()){
				droitDtos.add(ddao.DroitEntityToDroitDto(r));
			}else{
				boolean trouve = false;
				for (DroitDto rdto: droitDtos) {
					if (r.getName().equals(rdto.getName())){
						trouve = true;
						break;
					}
				}
				if (!trouve)
					droitDtos.add(ddao.DroitEntityToDroitDto(r));
			}
		}

		return droitDtos;
	}

	@Override
	public DroitDto get(int id) {

		return ddao.DroitEntityToDroitDto(ddao.get(id, new Droit()));
	}

}