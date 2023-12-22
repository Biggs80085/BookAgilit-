import static org.junit.jupiter.api.Assertions.*;

import Book.Book;
import Book.Librairie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe-test BookTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class BookTest
{
    private Book miserable;
    private Librairie fontaine;




    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).



    /**
     * Constructeur de la classe-test BookTest
     */
    public BookTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        miserable = new Book();
        fontaine = new Librairie();
        miserable.setTitre("Miserable");
        miserable.setAuteur("Victor Hugo");
        miserable.setLibrairie(fontaine);
        fontaine.setNom("chantelivre");
        miserable.bookInLibrary("Miserable", "Victor Hugo");
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void bookInfoTest()
    {
        assertEquals("Le livre : Miserable écrit par : Victor Hugo", miserable.bookInfo("Miserable", "Victor Hugo"));
    }

    @Test
    public void bookInLibraryTest()
    {
        assertEquals("Le livre : Miserable écrit par : Victor Hugo dans la librairie chantelivre", miserable.bookInLibrary("Miserable", "Victor Hugo"));
    }
    @Test
    public void addRemoveBookTest()
    {
        fontaine.addBook(miserable);
        assertEquals(1, fontaine.getLivres().size());
        fontaine.removeBook(miserable);
        assertEquals(0, fontaine.getLivres().size());
    }

    @Test
    public void checkAuteurTest() {
        fontaine.addBook(miserable);
        assertEquals(true, fontaine.checkAuteur("victor hugo"));
    }
}




