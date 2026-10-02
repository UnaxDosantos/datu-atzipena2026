package proiektua.proiektua.business;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * JaxB ez da gai zerrendak zuzenean erro-elementu gisa marshal egiteko, beraz adierazleen
 * zerrendarentzat edukiontzi bat behar da. Getter eta Setter-ak jaxb-k erabiltzen ditu
 * 
 * @author dgutierrez-diez
 */
@XmlRootElement( name = "Adierazleak" )
public class Adierazleak
{
    List<Adierazlea> adierazleak;

    public List<Adierazlea> getAdierazleak()
    {
        return adierazleak;
    }

    /**
     * xml-an marshal egingo den elementua
     */
    @XmlElement( name = "Adierazlea" )
    public void setAdierazleak( List<Adierazlea> adierazleak )
    {
        this.adierazleak = adierazleak;
    }

    /**
     * Metodo hau ez du jaxb-k erabiltzen, erosotasunerako baino ez da. Klase hau xml eskemetatik
     * sortuko balitz, metodo hau sortutako klasean edo laguntza-klaseren batean gehitu beharko
     * litzateke
     * 
     * @param adierazlea
     */
    public void add( Adierazlea adierazlea )
    {
        if( this.adierazleak == null )
        {
            this.adierazleak = new ArrayList<Adierazlea>();
        }
        this.adierazleak.add( adierazlea );

    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Adierazlea adierazlea : this.adierazleak )
        {
            str.append( adierazlea.toString() );
            str.append( "\n" );
        }
        return str.toString();
    }

}
