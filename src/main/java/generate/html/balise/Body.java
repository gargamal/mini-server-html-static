package generate.html.balise;

import javax.xml.bind.Element;
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
public class Body
{

    @XmlElement
    private final Div div = new Div();

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

    public Body()
    {
    }

    public Body(final PageMenu menu)
    {
        div.setClassName("sectionBody");
        div.setId("idSectionBody");

        final Script scriptInclude = new Script();
        scriptInclude.setSrc("js/tools.js");
        others.add(scriptInclude);

        final Script scriptFct = new Script();
        scriptFct.setCodeJs("runOnStart(" + menu.getCodeJs() + ");");
        others.add(scriptFct);
    }

    public static Body factory(final PageMenu menu, final String title)
    {
        final Body body = new Body(menu);

        final Header header = new Header();
        body.div.getOthers().add(header);

        final H1 h1 = new H1();
        h1.setId("title");
        h1.setText(title);
        body.div.getOthers().add(h1);

        final Div div = new Div();
        div.setId("idContainer");
        div.setClassName("container");
        body.div.getOthers().add(div);

        return body;
    }

    public Div getDiv()
    {
        return div;
    }

    public List<Element> getOthers()
    {
        return others;
    }
}
