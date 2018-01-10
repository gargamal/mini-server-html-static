package generate.html.balise;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Head
{

    private String title;

    private List<Meta> meta = new ArrayList<>(
            Arrays.asList(
                    Meta.newMetaHttpequiv("content-type", "text/html; charset=utf-8"),
                    Meta.newMetaName("author", "Daniel PELLIER", "fr"),
                    Meta.newMetaHttpequiv("refresh", "43200"),
                    Meta.newMetaName("viewport", "width=device-width, initial-scale=1"),
                    Meta.newMetaName("robots", "index, follow"),
                    Meta.newMetaName("msvalidate.01", "5D8304514EE429FF8FE427E6CFDF9C33")
            )
    );

    private List<Link> link = new ArrayList<>(
            Arrays.asList(
                    new Link("icon", "images/favicon.png"),
                    new Link("canonical", "http://orleanshypnose.fr"),
                    new Link("alternate", "http://orleanshypnose.fr", "x-default"),
                    new Link("stylesheet", "css/main.css"),
                    new Link("stylesheet", "css/footer.css"),
                    new Link("stylesheet", "css/header.css"),
                    new Link("stylesheet", "css/image.css")
            )
    );

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<Meta> getMeta()
    {
        return meta;
    }

    public void setMeta(List<Meta> meta)
    {
        this.meta = meta;
    }

    public List<Link> getLink()
    {
        return link;
    }

    public void setLink(List<Link> link)
    {
        this.link = link;
    }

}
