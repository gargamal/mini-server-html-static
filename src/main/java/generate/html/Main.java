package generate.html;

import generate.html.generator.Generator;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author gargamal
 */
public class Main
{
    
    private static final Path DIR_HTML = Paths.get("/home/gargamal/project/maudbaurrault-hypnocoach.fr/project/maudbarrault-hypnocoach.js/public_html");
    
    public static void main(String[] args) throws JAXBException, IOException, URISyntaxException
    {
        Generator.putAll();
        Generator.migrateAllToWebSite(DIR_HTML);
    }
}
