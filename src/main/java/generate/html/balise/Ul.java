package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Ul implements Element
{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;

    @XmlElement
    private List<Li> li = new ArrayList<>();

    public void setId(String id)
    {
        this.id = id;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public List<Li> getLi()
    {
        return li;
    }
}
