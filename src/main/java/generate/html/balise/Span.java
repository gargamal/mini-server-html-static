package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Span implements Element
{

    @XmlAttribute
    private String id;

    @XmlAttribute(name = "class")
    private String className;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

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
                @XmlElement(name = "header", type = Header.class),
                @XmlElement(name = "footer", type = Footer.class),
                @XmlElement(name = "div", type = Div.class)
            }
    )
    private List<Element> others = new ArrayList<>();

    public List<Element> getOthers()
    {
        return others;
    }
}
