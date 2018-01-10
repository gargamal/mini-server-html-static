package generate.html.xml;

import generate.html.balise.*;

/**
 *
 * @author gargamal
 */
public final class XmlTools
{

    private XmlTools()
    {
    }

    public static void buildParagraphe(final String paragraphe, final Li nodeParent)
    {
        final P p = new P();
        p.setText(cleanWord(paragraphe));
        nodeParent.getOther().add(p);
    }

    public static void buildTitle(final String title, final Li nodeParent)
    {
        final H2 h2 = new H2();
        h2.setClassName("leftH2");
        h2.setText(cleanSpaceAndLine(title));
        nodeParent.getOther().add(h2);
    }

    public static void buildIntroduction(final String introduction, final Li nodeParent)
    {
        if (introduction != null && !introduction.isEmpty())
        {
            buildParagraphe(introduction, nodeParent);
        }
    }

    public static void buildImage(final String urlImage, final String title, final String caption, final Li nodeParent)
    {
        final Figure figure = new Figure();
        nodeParent.getOther().add(figure);

        final FigCaption figcaption = new FigCaption();
        figcaption.setClassName("ActualiteAteliersH3");
        figcaption.setText(cleanWord(caption));
        figure.setFigcaption(figcaption);

        final Img img = new Img();
        img.setClassName("imgActualitesAteliers");
        img.setSrc(cleanSpaceAndLine(urlImage));
        img.setAlt(cleanSpaceAndLine(title));
        figure.setImg(img);
    }

    private static final String BR = "#br#";

    public static String cleanSpaceAndLine(final String url)
    {
        return url.replace("\r\n", "").replace("\n\r", "").replace("\r", "").replace("\n", "").trim();
    }

    public static String cleanWord(final String message)
    {
        String returnString = message.trim();

        returnString = returnString.replace("\r\n", BR).replace("\n\r", BR).replace("\r", BR).replace("\n", BR);
        /**
         * Pour retirer le premier retour charriot
         */
        if (returnString.indexOf(BR) == 0)
        {
            returnString = returnString.substring(BR.length(), returnString.length());
        }

        return returnString;//.replace("#\"", "<strong>").replace("\"#", "</strong>");
    }

    public static String convertToHtmlText(final String stream)
    {
        return stream.replace("#\"", "<strong>").replace("\"#", "</strong>").replace(BR, "<br>");
    }
}
