package generate.html.page;

import generate.html.balise.Body;
import generate.html.balise.Head;
import generate.html.balise.Meta;
import generate.html.balise.PageMenu;
import generate.html.xml.articles.ArticleFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gargamal
 */
public class PageAteliers extends AbstractPageArticles
{

    public PageAteliers(Path xmlPath)
    {
        super(xmlPath);
    }

    @Override
    protected Head generateHead()
    {
        final Head head = new Head();
        final String title = "Ateliers et formations en hypnose";
        head.setTitle(title);
        final String description = "Voir les ateliers et formations pour les particuliers et professionnels proposées par l'hypnothérapeute Maud BARRAULT.";
        head.getMeta().add(Meta.newMetaName("description", description));
        head.getMeta().add(Meta.newMetaName("keywords", "ateliers,formations,hypnose,hypnothérapeute,Maud,BARRAULT,45,orléans"));
        head.getMeta().add(Meta.newMetaProperty("og:title", title));
        head.getMeta().add(Meta.newMetaProperty("og:type", "website"));
        head.getMeta().add(Meta.newMetaProperty("og:url", "http://orleanshypnose.fr/ateliers-hypnose"));
        head.getMeta().add(Meta.newMetaProperty("og:image", "http://orleanshypnose.fr/images/logo.png"));
        head.getMeta().add(Meta.newMetaProperty("og:description", description));
        return head;
    }

    @Override
    protected Body generateBody()
    {
        final Body body = Body.factory(PageMenu.ATELIERS_ACTUALITES, "Ateliers et formations en hypnose");

        try
        {
            build(ArticleFactory.get(getXmlPath()), body);
        }
        catch (JAXBException | IOException ex)
        {
            Logger.getLogger(PageActualites.class.getName()).log(Level.SEVERE, null, ex);
        }

        return body;
    }
}
