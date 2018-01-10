package generate.html.balise;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Link
{

    @XmlAttribute
    private String rel;
    @XmlAttribute
    private String href;
    @XmlAttribute
    private String hreflang;

    public Link()
    {
    }

    public Link(String rel, String href)
    {
        this.rel = rel;
        this.href = href;
    }

    public Link(String rel, String href, String hreflang)
    {
        this.rel = rel;
        this.href = href;
        this.hreflang = hreflang;
    }

    public void setRel(String rel)
    {
        this.rel = rel;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public void setHreflang(String hreflang)
    {
        this.hreflang = hreflang;
    }
}
