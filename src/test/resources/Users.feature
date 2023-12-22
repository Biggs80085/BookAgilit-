Feature: Gestion des livres dans la librairie

  En tant que bibliothécaire
  Afin de maintenir un inventaire à jour
  Je veux pouvoir ajouter un livre à la librairie

  En tant que bibliothécaire
  Afin de retirer les livres obsolètes ou indisponibles
  Je veux pouvoir supprimer un livre de la librairie

  En tant que client
  Afin de connaître le titre et l'auteur d'un livre
  Je veux pouvoir consulter les informations d'un livre

  En tant que client
  Afin de découvrir d'autres œuvres d'un auteur
  Je veux pouvoir vérifier si un auteur a des livres disponibles dans la librairie

  Scenario Outline: Ajout d'un livre à la librairie
    Given la librairie <librairie>
    When le bibliothécaire ajoute le livre <titre> de l'auteur <auteur>
    Then le livre de l <auteur> doit être ajouté à la liste des livres de la librairie

    Examples:
      | librairie       | titre             | auteur       |
      | Chante livre    | Les Misérables    | Victor Hugo  |
      | Autre librairie | Autre Livre       | Autre Auteur |

  Scenario Outline: Suppression d'un livre de la librairie
    Given la librairie contient le livre de l'auteur
    When le bibliothécaire supprime le livre de la librairie
    Then le livre d <titre> ne doit plus apparaître dans la liste des livres de la librairie

    Examples:
      | titre             |
      | Les Misérables    |
      | Autre Livre       |


  Scenario Outline: Consultation des informations d'un livre
    Given le livre <titre> de l'auteur <auteur> est disponible
    When le client consulte les informations du livre
    Then les informations affichées doivent être Le livre : <titre> écrit par : <auteur>

    Examples:
      | titre             | auteur        |
      | Les Misérables    | Victor Hugo   |
      | Autre Livre       | Autre Auteur  |