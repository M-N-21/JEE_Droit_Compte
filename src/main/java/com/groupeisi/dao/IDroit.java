package com.groupeisi.dao;


import com.groupeisi.entities.Droit;

public interface IDroit extends IRepository<Droit> {
    public Droit getByNom(String name);
}
