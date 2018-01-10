package generate.html.xml.temoignages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gargamal
 */
@XmlRootElement
public class Temoignages
{

    @XmlElement
    private final List<Temoignage> temoignage = new ArrayList<>();

    public List<Temoignage> getTemoignage()
    {
        return temoignage;
    }
}
