package generate.html.balise;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Footer implements Element
{

    @XmlValue
    private String text = "";
}
