package proiektua.proiektua.adapter;

import java.time.Year;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Year objektuak (adierazle bakoitzaren urtea, adibidez 2024) egokitzen ditu XmlAdapter
 * inplementatuz, JaxB gai izan dadin horiek marshal eta unmarshal egiteko.
 * 
 * JaxB-k ez daki berez java.time.Year motako objektuak XML bihurtzen, beraz egokitzaile honek
 * Year eta String artean bihurketa egiten du: XMLan urtea testu bezala agertzen da ({@code <2024>}),
 * eta javan Year objektu bezala erabiltzen da.
 * 
 * XmlAdapter<String, Year>: lehenengo parametroa XMLan erabiltzen den mota da (String), eta
 * bigarrena javako klasean erabiltzen dena (Year).
 * 
 * @author dgutierrez-diez
 */
public class UrteaAdapter extends XmlAdapter<String, Year>
{

    /**
     * Unmarshal egitean (XML -> java) deitzen da: XMLko testua (adibidez "2024") Year objektu
     * bihurtzen du
     * 
     * @param urtea String
     * @return Year
     * @throws Exception
     */
    public Year unmarshal( String urtea ) throws Exception
    {
        // trim() erabiltzen da testuaren aurretik edo ondoren dauden zuriuneak kentzeko
        return Year.parse( urtea.trim() );
    }

    /**
     * Marshal egitean (java -> XML) deitzen da: Year objektua XMLn idatziko den testu bihurtzen du
     *
     * @param urtea Year
     * @return String
     * @throws Exception
     */
    public String marshal( Year urtea ) throws Exception
    {
        // Year.toString() urtea soilik itzultzen du, adibidez "2024"
        return urtea.toString();
    }

}
