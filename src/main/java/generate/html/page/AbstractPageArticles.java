package generate.html.page;

import generate.html.balise.*;
import generate.html.xml.XmlTools;
import generate.html.xml.articles.Article;
import generate.html.xml.articles.Articles;

import java.nio.file.Path;

/**
 *
 * @author gargamal
 */
public abstract class AbstractPageArticles extends AbstractPageHtml
{

    protected AbstractPageArticles(Path xmlPath)
    {
        super(xmlPath);
    }

    protected void build(final Articles articles, final Body body)
    {
        final Ul ul = new Ul();

        for (Article article : articles.getArticle())
        {
            final Li li = new Li();
            ul.getLi().add(li);
            XmlTools.buildTitle(article.getTitle(), li);
            XmlTools.buildIntroduction(article.getIntroduction(), li);
            XmlTools.buildImage(article.getImage(), article.getTitle(), article.getCaption(), li);
            XmlTools.buildParagraphe(article.getMessage(), li);
        }

        final Div div = ((Div) body.getDiv().getOthers().get(2));
        div.getOthers().add(ul);

        final Footer footer = new Footer();
        div.getOthers().add(footer);
    }
}
