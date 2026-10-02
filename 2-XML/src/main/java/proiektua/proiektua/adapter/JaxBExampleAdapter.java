package proiektua.proiektua.adapter;

import java.io.File;
import java.time.Year;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import proiektua.proiektua.business.Adierazlea;

/**
 * JaxB-ren marshal funtzionalitateen adibide sinplea klase konplexuak erabiltzean, kasu honetan
 * java.time.Year
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleAdapter
{

    public static void main( String[] args )
    {
        try
        {

            /* marshal egiteko datu oso sinpleak */
            Adierazlea adierazlea = new Adierazlea();
            adierazlea.setIzena( "Alokairuko etxebizitza librera iristeko kostua, sexuaren, adin-taldeen eta lurralde historikoen arabera" );
            adierazlea.setKategoria( "Sexua, adin-taldeak eta lurralde historikoak" );
            adierazlea.setKategoriaBalioa( "Gipuzkoa" );
            adierazlea.setBalioa( 54.9 );

            adierazlea.setUrtea( Year.of( 2024 ) );

            /* jaxb marshaller-a hasieratu */
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
            e.printStackTrace();
        }

    }
}
