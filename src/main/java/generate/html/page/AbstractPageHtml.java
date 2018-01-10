package generate.html.page;

import generate.html.balise.Body;
import generate.html.balise.Head;
import generate.html.balise.Html;

import java.nio.file.Path;

/**
 *
 * @author gargamal
 */
public abstract class AbstractPageHtml implements PageHtml
{

    private final Path xmlPath;

    protected AbstractPageHtml(final Path xmlPath)
    {
        this.xmlPath = xmlPath;
    }

    @Override
    public Html generate()
    {
        final Html html = new Html();
        html.setHead(generateHead());
        html.setBody(generateBody());
        return html;
    }

    protected abstract Head generateHead();

    protected abstract Body generateBody();

    protected final Path getXmlPath()
    {
        return xmlPath;
    }
}
