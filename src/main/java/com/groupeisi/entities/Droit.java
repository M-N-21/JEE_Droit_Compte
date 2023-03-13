package com.groupeisi.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Droit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "droits", fetch = FetchType.EAGER)
    private List<Compte> comptes = new ArrayList<Compte>();

    public Droit(int id, String name, List<Compte> comptes) {
        this.id = id;
        this.name = name;
        this.comptes = comptes;
    }

    public Droit() {
    }

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

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
