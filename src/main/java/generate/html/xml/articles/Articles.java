package generate.html.xml.articles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Articles
{

    @XmlElement
    private final List<Article> article = new ArrayList<>();

    public List<Article> getArticle()
    {
        return article;
    }
}
