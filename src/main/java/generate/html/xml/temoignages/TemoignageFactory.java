package generate.html.xml.temoignages;

import generate.html.balise.Li;
import generate.html.balise.P;
import generate.html.balise.Script;
import generate.html.xml.XmlTools;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

/**
 *
 * @author gargamal
 */
public class TemoignageFactory
{

    public static Temoignages get(final Path xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Temoignages.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Temoignages) unmarshaller.unmarshal(xmlPath.toFile());
    }

    private static final int SHORT_MESSAGE_LENGHT = 450;

    private static String getShortMessage(final String message)
    {
        return message.length() > SHORT_MESSAGE_LENGHT
                ? message.substring(0, SHORT_MESSAGE_LENGHT)
                : message;
    }

    public static void buildMessageTemoignage(Temoignage temoignage, final Li nodeParent, final int index)
    {
        final String shortMessage = getShortMessage(temoignage.getMessage());
        final String ipP = "idPTemoignage" + index;
        final String idSpan = "idSpanTemoignage" + index;

        boolean isMoreGreater = temoignage.getMessage().length() > shortMessage.length();

        final P p = new P();
        p.setId(ipP);
        p.setText(XmlTools.cleanWord(shortMessage + (isMoreGreater ? "..." : "")));
        nodeParent.getOther().add(p);

        if (isMoreGreater)
        {
            final P pSpan = new P();
            nodeParent.getOther().add(pSpan);
            pSpan.setClassName("readAll");
            pSpan.setId(idSpan);
            pSpan.setText("[Pour lire la suite du témoignage]");

            final Script script = new Script();
            script.setCodeJs(
                    "var span = document.getElementById('" + idSpan + "');"
                    + "span.addEventListener('click', function()"
                    + "{"
                    + "    var p = document.getElementById('" + ipP + "');"
                    + "    p.innerHTML = \"" + XmlTools.cleanWord(temoignage.getMessage()).replace("\"", "\\\"") + "\";"
                    + "    var span = document.getElementById('" + idSpan + "');"
                    + "    span.innerHTML = '';"
                    + "});"
            );
            nodeParent.getOther().add(script);
        }
    }
}
