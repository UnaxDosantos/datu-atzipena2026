package proiektua.proiektua.marshal;

import java.io.File;
import java.time.Year;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import proiektua.proiektua.business.Adierazlea;
import proiektua.proiektua.business.Adierazleak;

/**
 * JaxB-ren marshal funtzionalitateen adibide sinplea, zerrendak nola kudeatu erakusten duena.
 * Adierazle bat baino gehiago Adierazleak edukiontzian sartu eta XML bakar batean idazten dira.
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
            // lehenengo adierazlea: emakumeen batez besteko adina
            Adierazlea emakumeak = new Adierazlea();
            emakumeak.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
            emakumeak.setUrtea( Year.of( 2025 ) );
            emakumeak.setBalioa( 29.4 );
            emakumeak.setKategoria( "Sexua" );
            emakumeak.setKategoriaBalioa( "Emakumeak" );

            // bigarren adierazlea: gizonen batez besteko adina
            Adierazlea gizonak = new Adierazlea();
            gizonak.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
            gizonak.setUrtea( Year.of( 2025 ) );
            gizonak.setBalioa( 30.8 );
            gizonak.setKategoria( "Sexua" );
            gizonak.setKategoriaBalioa( "Gizonak" );

            // bi adierazleak edukiontzian gehitzen dira
            Adierazleak adierazleak = new Adierazleak();
            adierazleak.add( emakumeak );
            adierazleak.add( gizonak );

            /* jaxb marshaller-a hasieratu */
            // oraingoan testuingurua Adierazleak klasearentzat sortzen da (erroa)
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
            // JaxB-ren edozein errore hemen harrapatzen da eta pilaren traza inprimatzen da
            e.printStackTrace();
        }

    }
}
