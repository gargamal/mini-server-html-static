package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Figure implements Element
{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlElement
    private Img img;
    @XmlElement
    private FigCaption figcaption;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setImg(Img img)
    {
        this.img = img;
    }

    public void setFigcaption(FigCaption figcaption)
    {
        this.figcaption = figcaption;
    }
}
