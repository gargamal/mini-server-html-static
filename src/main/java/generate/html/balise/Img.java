package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Img implements Element
{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlAttribute
    private String src;
    @XmlAttribute
    private String alt;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public void setAlt(String alt)
    {
        this.alt = alt;
    }
}
