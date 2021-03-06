package generate.html.xml.temoignages;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Temoignage
{

    private String name;
    private String title;
    private String message;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}
