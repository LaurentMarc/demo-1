package com.example.demo.model;

public class Car {
	private int id;
    private String nom;
    private String couleur;

    //constructeur par défaut
    public Car() {
    }

    //constructeur pour nos tests

    public Car(int id, String nom, String couleur) {
        this.id=id;
        this.nom=nom;
        this.couleur=couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom=nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur=couleur;
    }
    
    @Override
    public String toString(){  
        return "Product{"+
        "id=" + id + 
        ", nom='"+ nom + '\'' + 
        ", couleur=" + couleur+ '}';
    }
}

