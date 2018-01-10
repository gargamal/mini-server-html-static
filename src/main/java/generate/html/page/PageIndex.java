package generate.html.page;

import generate.html.balise.*;
import generate.html.xml.XmlTools;
import generate.html.xml.presse.Article;
import generate.html.xml.presse.Presse;
import generate.html.xml.presse.PresseFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gargamal
 */
public class PageIndex extends AbstractPageHtml
{

    public PageIndex(Path xmlPath)
    {
        super(xmlPath);
    }

    @Override
    protected Head generateHead()
    {
        final Head head = new Head();
        final String title = "Maud BARRAULT Hypnothérapeute et Formation - Orléans";
        head.setTitle(title);
        final String metaPhrase
                = "Hypnothérapeute sur Orléans, je vous aide à atteindre vos objectifs pour vivre mieux : "
                + "arrêter de fumer, phobies, angoisses, stress, dépression, sommeil, confiance en soi, "
                + "douleurs chroniques, migraines, chocs et traumatismes... Cabinet d'hypnose sur Orléans "
                + "(Loiret 45) \"Hypn'Ose&GO\". Je suis certifiée en hypnose thérapeutique Ericksonienne.";

        head.getMeta().add(Meta.newMetaName("description", metaPhrase));
        head.getMeta().add(Meta.newMetaName("keywords", "hypnothérapeute,hypnose,45,orléans"));
        head.getMeta().add(Meta.newMetaProperty("og:title", title));
        head.getMeta().add(Meta.newMetaProperty("og:type", "website"));
        head.getMeta().add(Meta.newMetaProperty("og:url", "http://orleanshypnose.fr/"));
        head.getMeta().add(Meta.newMetaProperty("og:image", "http://orleanshypnose.fr/images/logo.png"));
        head.getMeta().add(Meta.newMetaProperty("og:description", metaPhrase));

        head.getLink().add(new Link("stylesheet", "css/carrousel.css"));

        return head;
    }

    @Override
    protected Body generateBody()
    {
        final Body body = Body.factory(PageMenu.ACCUEIL, "Hypnothérapeute Orléans");

        try
        {
            build(PresseFactory.get(getXmlPath()), body);
        }
        catch (JAXBException | IOException ex)
        {
            Logger.getLogger(PageActualites.class.getName()).log(Level.SEVERE, null, ex);
        }

        return body;
    }

    private Hr buildHr()
    {
        final Hr hr = new Hr();
        hr.setClassName("hrCarroussel");
        return hr;
    }

    private Script buildScript(final String src)
    {
        final Script script = new Script();
        script.setSrc(src);
        return script;
    }

    private void build(final Presse presse, final Body body)
    {
        final Div divContainer = (Div) body.getDiv().getOthers().get(2);

        final H2 h2 = new H2();
        h2.setId("sentence");
        h2.setClassName("introSiteH2");
        h2.setText("\"Nous sommes infinis, accueillons nos possibilités.\"");
        divContainer.getOthers().add(h2);

        final Figure figure = new Figure();
        final Img img = new Img();
        img.setClassName("imgPageIndex");
        img.setSrc("images/accueil.png");
        img.setAlt("Hypnose et Coaching");
        figure.setImg(img);
        divContainer.getOthers().add(figure);

        divContainer.getOthers().add(buildHr());

        final Div divCarrousel = new Div();
        divCarrousel.setId("carrousel");
        divContainer.getOthers().add(divCarrousel);
        divCarrousel.getOthers().add(buildHr());
        final Ul ul = new Ul();
        ul.setId("ulCarrousel");
        divCarrousel.getOthers().add(ul);

        for (Article article : presse.getArticle())
        {
            final Li li = new Li();

            if (article.getImage() != null && !article.getImage().isEmpty())
            {
                PresseFactory.buildImage(article, li);
            }

            final P newP = new P();
            newP.setText(XmlTools.cleanSpaceAndLine(article.getText()));
            li.getOther().add(newP);

            ul.getLi().add(li);
        }

        final Footer footer = new Footer();
        divContainer.getOthers().add(footer);

        body.getOthers().add(buildScript("https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"));
        body.getOthers().add(buildScript("js/carrousel.js"));
    }
}
