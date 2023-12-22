import Book.Librairie;
import Book.Book;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersSteps {

    private Librairie librairie = new Librairie();
    private Book livre = new Book();

    @ParameterType(".*")
    public String librairie(String librairie) {
        return librairie;
    }

    @ParameterType(".*")
    public String titre(String titre) {
        return titre;
    }

    @ParameterType(".*")
    public String auteur(String auteur) {
        return auteur;
    }

    @ParameterType(".*")
    public String livre(String livre) {
        return livre;
    }

    @Given("la librairie {librairie}")
    public void createLibrairie(String librairie) {
        this.librairie = new Librairie();
        this.librairie.setNom(librairie);
    }

    @When("le bibliothécaire ajoute le livre {titre} de l'auteur {auteur}")
    public void addBook(String titre, String auteur) {
        livre = new Book();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setLibrairie(librairie);
        librairie.addBook(livre);
    }

    @Then("le livre de l {auteur} doit être ajouté à la liste des livres de la librairie")
    public void checkBook(String auteur) {
        assertEquals(true, librairie.checkAuteur(auteur));
    }

    @Given("la librairie contient le livre de l'auteur ")
    public void initLibrairie(String librairie, String titre, String auteur) {
        this.librairie.addBook(livre);
    }

    @When("le bibliothécaire supprime le livre de la librairie")
    public void deleteBook() {
        this.librairie.removeBook(livre);
    }

    @Then("le livre {auteur} ne doit plus apparaître dans la liste des livres de la librairie")
    public void checkDelete(String auteur) {
        assertEquals(false, this.librairie.checkAuteur(auteur));
    }

    @Given("le livre {titre} de l'auteur {auteur} est disponible")
    public void initLivre(String titre, String auteur) {
        livre.setTitre(titre);
        livre.setAuteur(auteur);
    }

    @When("le client consulte les informations du livre")
    public void afficheLivre() {
        // Dans un vrai système, vous pouvez appeler une fonction qui récupère les informations du livre
        // Ici, pour l'exemple, nous allons simplement afficher les informations du livre dans la console.
        System.out.println(livre.bookInfo(livre.getTitre(), livre.getAuteur()));
    }

    @Then("les informations affichées doivent être Le livre : {titre} écrit par : {auteur}")
    public void checkInfo(String titre, String auteur) {
        String expectedInfo = "Le livre : " + titre + " écrit par : " + auteur;
        String actualInfo = livre.bookInfo(livre.getTitre(), livre.getAuteur());
        assertEquals(expectedInfo, actualInfo);
    }
}
