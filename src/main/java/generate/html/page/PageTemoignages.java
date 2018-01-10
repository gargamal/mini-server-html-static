package generate.html.page;

import generate.html.balise.*;
import generate.html.xml.XmlTools;
import generate.html.xml.temoignages.Temoignage;
import generate.html.xml.temoignages.TemoignageFactory;
import generate.html.xml.temoignages.Temoignages;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gargamal
 */
public class PageTemoignages extends AbstractPageHtml
{

    public PageTemoignages(Path xmlPath)
    {
        super(xmlPath);
    }

    @Override
    protected Head generateHead()
    {
        final Head head = new Head();
        head.setTitle("Témoignages");
        head.getMeta().add(Meta.newMetaName("description", "Lire tous les témoignages laissés par les différentes personnes soignées et suivis par l'hypnothérapeute Maud BARRAULT."));
        head.getMeta().add(Meta.newMetaName("keywords", "témoignages,hypnose,hypnothérapeute,Maud,BARRAULT,45,orléans"));
        head.getMeta().add(Meta.newMetaProperty("og:title", "Témoignages"));
        head.getMeta().add(Meta.newMetaProperty("og:type", "website"));
        head.getMeta().add(Meta.newMetaProperty("og:url", "http://orleanshypnose.fr/temoignages"));
        head.getMeta().add(Meta.newMetaProperty("og:image", "http://orleanshypnose.fr/images/logo.png"));
        head.getMeta().add(Meta.newMetaProperty("og:description", "Lire tous les témoignages laissés par les différentes personnes soignées et suivis par l'hypnothérapeute Maud BARRAULT."));
        
        final List<Link> link = new ArrayList<>(
            Arrays.asList(
                    new Link("icon", "images/favicon.png"),
                    new Link("canonical", "http://orleanshypnose.fr/temoignages"),
                    new Link("alternate", "http://orleanshypnose.fr/temoignages", "x-default"),
                    new Link("stylesheet", "css/main.css"),
                    new Link("stylesheet", "css/footer.css"),
                    new Link("stylesheet", "css/header.css"),
                    new Link("stylesheet", "css/image.css")
            )
    );
        head.setLink(link);
        
        head.getLink().add(new Link("stylesheet", "css/temoignage.css"));

        return head;
    }

    @Override
    protected Body generateBody()
    {
        final Body body = Body.factory(PageMenu.APPLICATIONS, "Témoignages");

        try
        {
            build(TemoignageFactory.get(getXmlPath()), body);
        }
        catch (JAXBException | IOException ex)
        {
            Logger.getLogger(PageActualites.class.getName()).log(Level.SEVERE, null, ex);
        }

        return body;
    }

    private void build(final Temoignages temoignages, final Body body)
    {
        final Ul ul = new Ul();

        int i = 0;
        for (Temoignage temoignage : temoignages.getTemoignage())
        {
            final Li li = new Li();
            ul.getLi().add(li);
            XmlTools.buildTitle(temoignage.getTitle(), li);
            TemoignageFactory.buildMessageTemoignage(temoignage, li, i++);

            if (temoignage.getName() != null && !temoignage.getName().isEmpty())
            {
                final P p = new P();
                p.setText(XmlTools.cleanSpaceAndLine(temoignage.getName()));
                li.getOther().add(p);
            }
        }

        final Div div = ((Div) body.getDiv().getOthers().get(2));
        div.getOthers().add(ul);

        final Footer footer = new Footer();
        div.getOthers().add(footer);
    }
}
