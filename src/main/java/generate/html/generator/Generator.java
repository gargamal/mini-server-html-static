package generate.html.generator;

import generate.html.balise.Html;
import generate.html.page.PageActualites;
import generate.html.page.PageAteliers;
import generate.html.page.PageIndex;
import generate.html.page.PageTemoignages;
import generate.html.xml.XmlTools;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author gargamal
 */
public class Generator
{

    private Generator()
    {
    }

    public static void putAll() throws JAXBException, IOException, URISyntaxException
    {
        final Path saveDirectroy = Paths.get(Generator.class.getResource("/html").toURI());

        final PageActualites actualite = new PageActualites(Paths.get(Generator.class.getResource("/xml/actualites.xml").toURI()));
        put(saveDirectroy.resolve("actualites.html"), actualite.generate());

        final PageAteliers ateliers = new PageAteliers(Paths.get(Generator.class.getResource("/xml/ateliers.xml").toURI()));
        put(saveDirectroy.resolve("ateliers.html"), ateliers.generate());

        final PageTemoignages temoignages = new PageTemoignages(Paths.get(Generator.class.getResource("/xml/temoignages.xml").toURI()));
        put(saveDirectroy.resolve("temoignages.html"), temoignages.generate());

        final PageIndex index = new PageIndex(Paths.get(Generator.class.getResource("/xml/pressefb.xml").toURI()));
        put(saveDirectroy.resolve("index.html"), index.generate());
    }

    private static void put(final Path xmlPath, final Html html) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Html.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");

        try (OutputStream os = Files.newOutputStream(xmlPath))
        {
            final StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(html, sw);
            String streamHtml = XmlTools.convertToHtmlText(sw.toString().replace("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>", "<!DOCTYPE html>"));
            os.write(streamHtml.getBytes());

            System.out.println(streamHtml);
        }
    }

    public static void migrateAllToWebSite(final Path saveDirectroy) throws IOException, URISyntaxException
    {
        final Path dir = Paths.get(Generator.class.getResource("/html").toURI());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
        {
            for (Path entry : stream)
            {
                String htmlStream = getFile(entry);

                final String header = getResource("/xml/header.xml");
                htmlStream = htmlStream.replace("<header></header>", header);

                final String footer = getResource("/xml/footer.xml");
                htmlStream = htmlStream.replace("<footer></footer>", footer);

                try (OutputStream os = Files.newOutputStream(saveDirectroy.resolve(entry.getFileName())))
                {
                    os.write(htmlStream.getBytes());
                    System.out.println(entry.getFileName().toString());
                }
            }
        }
    }

    private static String getResource(final String resourceName) throws IOException, URISyntaxException
    {
        final StringBuilder builder = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(Generator.class.getResource(resourceName).toURI())))
        {
            br.lines().forEach(action -> builder.append(action).append("\n"));
        }

        return builder.toString();
    }

    private static String getFile(final Path path) throws IOException {
        final StringBuilder builder = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(path))
        {
            br.lines().forEach(action -> builder.append(action).append("\n"));
        }

        return builder.toString();
    }
}
