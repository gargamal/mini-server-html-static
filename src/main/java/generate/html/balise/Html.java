package generate.html.balise;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Html
{

    @XmlAttribute
    private final String lang = "fr-FR";

    @XmlElement
    private Head head;

    @XmlElement
    private Body body;

    public void setHead(Head head)
    {
        this.head = head;
    }

    public void setBody(Body body)
    {
        this.body = body;
    }
}
