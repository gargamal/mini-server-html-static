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
public class PageActualites extends AbstractPageArticles
{

    public PageActualites(Path xmlPath)
    {
        super(xmlPath);
    }

    @Override
    protected Head generateHead()
    {
        final Head head = new Head();
        head.setTitle("Actualités");
        head.getMeta().add(Meta.newMetaName("description", "Suivre les actualités, les forums, et les inscriptions aux formations proposées par l'hypnothérapeute Maud BARRAULT."));
        head.getMeta().add(Meta.newMetaName("keywords", "actualités,formations, inscriptions,hypnose,hypnothérapeute,Maud,BARRAULT,45,orléans"));
        head.getMeta().add(Meta.newMetaProperty("og:title", "Actualités"));
        head.getMeta().add(Meta.newMetaProperty("og:type", "website"));
        head.getMeta().add(Meta.newMetaProperty("og:url", "http://orleanshypnose.fr/actualites-formations"));
        head.getMeta().add(Meta.newMetaProperty("og:image", "http://orleanshypnose.fr/images/logo.png"));
        head.getMeta().add(Meta.newMetaProperty("og:description", "Suivre les actualités, les forums, et les inscriptions aux formations proposées par l'hypnothérapeute Maud BARRAULT."));
        return head;
    }

    @Override
    protected Body generateBody()
    {
        final Body body = Body.factory(PageMenu.ATELIERS_ACTUALITES, "Actualités");

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
