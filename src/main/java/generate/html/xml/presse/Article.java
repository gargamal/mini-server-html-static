package generate.html.xml.presse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Article
{

    @XmlElement
    private String dateofpost;
    @XmlElement
    private String image;
    @XmlElement
    private String link;
    @XmlElement
    private String text;

    public String getDateofpost()
    {
        return dateofpost;
    }

    public String getImage()
    {
        return image;
    }

    public String getLink()
    {
        return link;
    }

    public String getText()
    {
        return text;
    }

}
