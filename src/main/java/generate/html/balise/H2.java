package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class H2 implements Element
{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlValue
    private String text;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
