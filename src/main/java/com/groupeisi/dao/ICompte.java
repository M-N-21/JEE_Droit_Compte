package com.groupeisi.dao;

import com.groupeisi.dto.CompteDto;
import com.groupeisi.entities.Compte;

public interface ICompte extends IRepository<Compte> {
    public Compte login(String username, String password);
    public Compte getByUsername(String username);
    public CompteDto CompteEntityToCompteDto (Compte compte);
    public Compte CompteDtoToCompteEntity (CompteDto compteDto);
}
