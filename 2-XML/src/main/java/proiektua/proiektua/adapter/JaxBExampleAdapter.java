package proiektua.proiektua.adapter;

import java.io.File;
import java.time.Year;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import proiektua.proiektua.business.Adierazlea;

/**
 * JaxB-ren marshal funtzionalitateen adibide sinplea klase konplexuak erabiltzean, kasu honetan
 * java.time.Year. Adierazleak urtea Year motakoa du, eta UrteaAdapter-ari esker JaxB gai da
 * hori XML bihurtzeko.
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleAdapter
{

    public static void main( String[] args )
    {
        try
        {

            /* marshal egiteko datu oso sinpleak: adierazle bat CSVko lerro batetik hartuta */
            Adierazlea adierazlea = new Adierazlea();
            adierazlea.setIzena( "Alokairuko etxebizitza librera iristeko kostua, sexuaren, adin-taldeen eta lurralde historikoen arabera" );
            adierazlea.setKategoria( "Sexua, adin-taldeak eta lurralde historikoak" );
            adierazlea.setKategoriaBalioa( "Gipuzkoa" );
            adierazlea.setBalioa( 54.9 );

            // Year motako atributua: UrteaAdapter-ak testu bihurtuko du XMLrako
            adierazlea.setUrtea( Year.of( 2024 ) );

            /* jaxb marshaller-a hasieratu */
            // testuingurua sortzen da Adierazlea klasearentzat
            JAXBContext jaxbContext = JAXBContext.newInstance( Adierazlea.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* true jarri irteera formatuarekin ateratzeko */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* java objektuak xml bihurtu (irteera fitxategira eta kontsolara) */
            jaxbMarshaller.marshal( adierazlea, new File( "adierazlea_adapter.xml" ) );
            jaxbMarshaller.marshal( adierazlea, System.out );

        }
        catch( JAXBException e )
        {
            // JaxB-ren edozein errore hemen harrapatzen da eta pilaren traza inprimatzen da
            e.printStackTrace();
        }

    }
}
