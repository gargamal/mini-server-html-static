package generate.html.xml.articles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

/**
 *
 * @author gargamal
 */
public class ArticleFactory
{

    public static Articles get(final Path xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Articles.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Articles) unmarshaller.unmarshal(xmlPath.toFile());
    }
}
