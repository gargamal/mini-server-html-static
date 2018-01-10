package generate.html.balise;

/**
 *
 * @author gargamal
 */
public enum PageMenu
{
    ACCUEIL("Page.ACCUEIL"),
    HYPNOSE("Page.HYPNOSE"),
    APPLICATIONS("Page.APPLICATIONS"),
    INFOS_PRATIQUES("Page.INFOS_PRATIQUES"),
    ATELIERS_ACTUALITES("Page.ATELIERS_ACTUALITES"),
    QUISUISJE("Page.QUISUISJE"),
    CONTACT("Page.CONTACT"),
    PARTENAIRES("Page.PARTENAIRES");

    private final String codeJs;

    PageMenu(String codeJs)
    {
        this.codeJs = codeJs;
    }

    public String getCodeJs()
    {
        return codeJs;
    }
}
