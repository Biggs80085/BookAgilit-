package Book;

public class Book {
    // variables d'instance
    private String titre;
    private String auteur;
    private Librairie librairie;


    // Infos du livre
    public String bookInfo(String titre, String auteur) {
        return "Le livre : " + titre + " écrit par : " + auteur;
    }

    public String bookInLibrary(String titre, String auteur){
        return this.bookInfo(titre, auteur) + " dans la librairie " + librairie.getNom();
    }

    // Getters & Setters

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setLibrairie(Librairie librairie){
        this.librairie = librairie;
    }
}