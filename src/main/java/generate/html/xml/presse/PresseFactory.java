package generate.html.xml.presse;

import generate.html.balise.*;
import generate.html.xml.XmlTools;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

/**
 *
 * @author gargamal
 */
public class PresseFactory
{

    public static Presse get(final Path xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Presse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Presse) unmarshaller.unmarshal(xmlPath.toFile());
    }

    public static void buildImage(final Article article, final Li nodeParent)
    {
        final A newA = new A();
        newA.setHref(XmlTools.cleanSpaceAndLine(article.getLink()));
        newA.setTarget("_blank");
        nodeParent.getOther().add(newA);

        final Figure newFigure = new Figure();
        newA.setOther(newFigure);

        final Img newImg = new Img();
        newImg.setSrc(article.getImage());
        newImg.setAlt("image presse");
        newFigure.setImg(newImg);

        final FigCaption newFigcaption = new FigCaption();
        newFigcaption.setText(article.getDateofpost());
        newFigure.setFigcaption(newFigcaption);
    }
}
