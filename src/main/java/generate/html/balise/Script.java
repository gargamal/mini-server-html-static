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
public class Script implements Element
{

    @XmlAttribute
    private String src;

    @XmlValue
    private String codeJs = "";
    
    @XmlAttribute
    private String type;

    public void setCodeJs(String codeJs)
    {
        this.codeJs = codeJs;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
