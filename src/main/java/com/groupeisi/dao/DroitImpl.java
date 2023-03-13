package com.groupeisi.dao;


import com.groupeisi.dto.DroitDto;
import com.groupeisi.entities.Compte;
import com.groupeisi.entities.Droit;

import java.util.ArrayList;
import java.util.List;

public class DroitImpl extends RepositoryImpl<Droit> implements IDroit {
    @Override
    public Droit getByNom(String name) {

        return (Droit) session.createQuery("FROM Droit droit WHERE droit.name = :droit_name")
                .setParameter("droit_name", name).uniqueResult();
    }

    public Droit DroitDtoToDroitEntity (DroitDto droitDto) {
        Droit droit = new Droit();
        droit.setId(droitDto.getId());
        droit.setName(droitDto.getName());
        if (droitDto.getComptes() != null) {
            List<Compte> comptes = new ArrayList<Compte>();
            droitDto.getComptes().forEach(comptename->{
                Compte compte = new CompteImpl().getByUsername(comptename);
                comptes.add(compte);
            });
            droit.setComptes(comptes);
        }
        return droit;
    }
    public DroitDto DroitEntityToDroitDto (Droit droit) {
        DroitDto droitDto = new DroitDto();
        droitDto.setId(droit.getId());
        droitDto.setName(droit.getName());
        if (droit.getComptes() != null) {
            List<String> comptenameComptes = new ArrayList<String>();
            droit.getComptes().forEach(compte->{
                comptenameComptes.add(compte.getUsername());
            });
            droitDto.setComptes(comptenameComptes);
        }
        return droitDto;
    }
}
