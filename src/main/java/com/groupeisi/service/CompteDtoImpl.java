package com.groupeisi.service;

import com.groupeisi.dao.CompteImpl;
import com.groupeisi.dto.CompteDto;
import com.groupeisi.entities.Compte;

import java.util.ArrayList;
import java.util.List;

public class CompteDtoImpl implements ICompteDto {

	private CompteImpl cdao = new CompteImpl();
	@Override
	public int add(CompteDto compteDto) {

		return cdao.add(cdao.CompteDtoToCompteEntity(compteDto));
	}

	@Override
	public int delete(int id) {

		return cdao.delete(id, new Compte());
	}

	@Override
	public int update(CompteDto compteDto) {

		return cdao.update(cdao.CompteDtoToCompteEntity(compteDto));
	}

	@Override
	public List<CompteDto> list() {
		List<CompteDto> compteDtos = new ArrayList<CompteDto>();
		cdao.list(new Compte()).forEach(droit -> {
			compteDtos.add(cdao.CompteEntityToCompteDto(droit));
		});
		return compteDtos;
	}

	@Override
	public CompteDto get(int id) {

		return cdao.CompteEntityToCompteDto(cdao.get(id, new Compte()));
	}

}
