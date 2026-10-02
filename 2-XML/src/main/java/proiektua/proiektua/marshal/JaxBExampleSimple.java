package proiektua.proiektua.marshal;

import java.io.File;
import java.time.Year;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import proiektua.proiektua.business.Adierazlea;

/**
 * JaxB-ren marshal funtzionalitateen adibide sinplea
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleSimple
{

    public static void main( String[] args )
    {
        try
        {

            /* marshal egiteko datu oso sinpleak */
            Adierazlea batezBestekoAdina = new Adierazlea();
            batezBestekoAdina.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
            batezBestekoAdina.setUrtea( Year.of( 2025 ) );
            batezBestekoAdina.setBalioa( 30.1 );
            batezBestekoAdina.setKategoria( "Sexua" );
            batezBestekoAdina.setKategoriaBalioa( "Guztira" );

            /* jaxb marshaller-a hasieratu */
            JAXBContext jaxbContext = JAXBContext.newInstance( Adierazlea.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* true jarri irteera formatuarekin ateratzeko */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* java objektuak xml bihurtu (irteera fitxategira eta kontsolara) */
            jaxbMarshaller.marshal( batezBestekoAdina, new File( "adierazlea.xml" ) );
            jaxbMarshaller.marshal( batezBestekoAdina, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
