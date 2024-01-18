package karmaka.v1;

/**
 * Enumeration de description des cartes
 */
public enum Description {

	TRANSMIGRATION("Placez dand votre main n'importe quelle carte de votre vie future."),
    DESTINEE("Regardez les 3 premières cartes de la source; ajoutez-en jusqu'à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité."),
    OEIL("Regardez la Main d'un rival. Vous pouvez ensuite jouer une autre carte"),
    REVES("Placez la première carte de la Vie Future d'un rival sur la vôtre"),
    DUPERIE("Regardez 3 cartes de la Main d'un rival; ajoutez-en une à votre Main"),
    DENI("Défaussez une carte de votre Main. Copiez le pouvoir de cette carte"),
    VOL("Placez dans votre Main l'Oeuvre Exposée d'un rival."),
    LENDEMAIN("Puisez une caerte à la Source. Vous pouvez ensuite jouer une autre carte."),
    RECYCLAGE("Ajoutez à votre Vue Future une des 3 dernières cartes de la Fosse."),
    SAUVETAGE("Ajoutez à votre Main une des 3 dernières cartes de la Fosse."),
    LONGEVITE("Placez 2 cartes puisés à la Source sur la Pile d'un joueur."),
    SEMIS("Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main."),
    VOYAGE("Puisez 3 cartes à la SOurce. Vous pouvez ensuite jouer une autre carte"),
    JUBILE("Placez jusqu'à 2 cartes de votre Main sur vos Oeuvres."),
    PANIQUE("Défaussez la première carte de la Pile dun joueur. Vous pouvez ensuite jouer une autre carte."),
    SOUFFLE("Le joueur de votre choux défausse une carte de sa Main"),
    ROULETTE("Défaussez jusqu'à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1"),
    CRISE("Le rival de votre choix défausse une de ses Oeuvres."),
    FOURNAISE("Défaussez les 2 premières cartes de la Vie Future d'un rival"),
    VENGEANCE("Défaussez l'Oeuvre Exposée d'un rival."),
    BASSESSE("Défaussez au hasard 2 cartes de la Main d'un rival"),
    INCARNATION("Choisissez une de vos Oeuvres. Copier son pouvoir"),
    MIMETISME("Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée.");
	

    // Attribut pour stocker la description de chaque élément
    private final String description;

    /**
     * Constructeur privé pour initialiser la description
     * @param description
     */
    private Description(String description) {
        this.description = description;
    }

    // Méthode pour obtenir la description
    public String getDescription() {
        return description;
    }
}