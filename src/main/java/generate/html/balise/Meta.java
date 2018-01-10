package generate.html.balise;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Meta
{

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "http-equiv")
    private String httpequiv;

    @XmlAttribute
    private String content;

    @XmlAttribute
    private String lang;

    @XmlAttribute
    private String property;

    public static Meta newMetaName(final String name, final String content)
    {
        final Meta meta = new Meta();
        meta.name = name;
        meta.content = content;
        return meta;
    }

    public static Meta newMetaName(final String name, final String content, final String lang)
    {
        final Meta meta = new Meta();
        meta.name = name;
        meta.content = content;
        meta.lang = lang;
        return meta;
    }

    public static Meta newMetaHttpequiv(final String httpequiv, final String content)
    {
        final Meta meta = new Meta();
        meta.httpequiv = httpequiv;
        meta.content = content;
        return meta;
    }

    public static Meta newMetaProperty(final String property, final String content)
    {
        final Meta meta = new Meta();
        meta.property = property;
        meta.content = content;
        return meta;
    }

    public final void setContent(String content)
    {
        this.content = content;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHttpequiv(String httpequiv)
    {
        this.httpequiv = httpequiv;
    }

    public void setLang(String lang)
    {
        this.lang = lang;
    }
}
