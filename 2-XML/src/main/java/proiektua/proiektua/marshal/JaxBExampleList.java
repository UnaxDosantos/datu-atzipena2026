package proiektua.proiektua.marshal;

import java.io.File;
import java.time.Year;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import proiektua.proiektua.business.Adierazlea;
import proiektua.proiektua.business.Adierazleak;

/**
 * JaxB-ren marshal funtzionalitateen adibide sinplea, zerrendak nola kudeatu erakusten duena
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleList
{

    public static void main( String[] args )
    {
        try
        {

            /* marshal egiteko adierazle pare bat dituen zerrenda sortu */
            Adierazlea emakumeak = new Adierazlea();
            emakumeak.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
            emakumeak.setUrtea( Year.of( 2025 ) );
            emakumeak.setBalioa( 29.4 );
            emakumeak.setKategoria( "Sexua" );
            emakumeak.setKategoriaBalioa( "Emakumeak" );

            Adierazlea gizonak = new Adierazlea();
            gizonak.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
            gizonak.setUrtea( Year.of( 2025 ) );
            gizonak.setBalioa( 30.8 );
            gizonak.setKategoria( "Sexua" );
            gizonak.setKategoriaBalioa( "Gizonak" );

            Adierazleak adierazleak = new Adierazleak();
            adierazleak.add( emakumeak );
            adierazleak.add( gizonak );

            /* jaxb marshaller-a hasieratu */
            JAXBContext jaxbContext = JAXBContext.newInstance( Adierazleak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* true jarri irteera formatuarekin ateratzeko */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* java objektuak xml bihurtu (irteera fitxategira eta kontsolara) */
            jaxbMarshaller.marshal( adierazleak, new File( "list_adierazleak.xml" ) );
            jaxbMarshaller.marshal( adierazleak, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
