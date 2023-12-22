package Book;

import Book.Book;

import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private String nom;
    private ArrayList<Book> livres = new ArrayList<Book>();

    public void addBook(Book livre) {
        livres.add(livre);
    }

    public void removeBook(Book livre) {
        livres.remove(livre);
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public ArrayList<Book> getLivres() {
        return this.livres;
    }
    public boolean checkAuteur(String auteur)
    {
        for (Book livre : livres) {
            if(livre.getAuteur().equalsIgnoreCase(auteur))
                return true;
        }
        return false;
    }
}