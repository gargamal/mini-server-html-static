package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 *
 * @author gargamal
 */
public class A implements Element
{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlAttribute
    private String href;
    @XmlAttribute
    private String target;

    @XmlElements(
            {
                @XmlElement(name = "h1", type = H1.class),
                @XmlElement(name = "h2", type = H2.class),
                @XmlElement(name = "h3", type = H3.class),
                @XmlElement(name = "p", type = P.class),
                @XmlElement(name = "figure", type = Figure.class),
                @XmlElement(name = "ul", type = Ul.class),
                @XmlElement(name = "span", type = Span.class),
                @XmlElement(name = "script", type = Script.class),
                @XmlElement(name = "hr", type = Hr.class),
                @XmlElement(name = "a", type = A.class),
                @XmlElement(name = "div", type = Div.class)
            }
    )
    private Element other;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    public void setOther(Element other)
    {
        this.other = other;
    }
}
