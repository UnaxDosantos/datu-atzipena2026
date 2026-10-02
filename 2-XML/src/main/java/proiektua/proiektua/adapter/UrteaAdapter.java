package proiektua.proiektua.adapter;

import java.time.Year;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Year objektuak (adierazle bakoitzaren urtea, adibidez 2024) egokitzen ditu XmlAdapter
 * inplementatuz, JaxB gai izan dadin horiek marshal eta unmarshal egiteko
 * 
 * @author dgutierrez-diez
 */
public class UrteaAdapter extends XmlAdapter<String, Year>
{

    /**
     * XMLko testua (adibidez "2024") Year objektu bihurtzen du
     * 
     * @param urtea String
     * @return Year
     * @throws Exception
     */
    public Year unmarshal( String urtea ) throws Exception
    {
        return Year.parse( urtea.trim() );
    }

    /**
     * Year objektua XMLn idatziko den testu bihurtzen du
     *
     * @param urtea Year
     * @return String
     * @throws Exception
     */
    public String marshal( Year urtea ) throws Exception
    {
        return urtea.toString();
    }

}
