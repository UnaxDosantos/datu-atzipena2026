package proiektua.proiektua.xsd;

import java.io.File;
import java.time.Year;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import proiektua.proiektua.business.Adierazlea;

/**
 * XSD erabileraren adibidea baliozkotzeko errore-kudeatzaile batekin, hemen ez dago marshal-ik
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleXSDErrorHandler
{

    public static void main( String[] args ) throws Exception
    {
        /**
         * errorea emango du kategoria-balioa derrigorrezkoa delako
         */
        Adierazlea kategoriaBalioarikGabe = new Adierazlea();
        kategoriaBalioarikGabe.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        kategoriaBalioarikGabe.setUrtea( Year.of( 2025 ) );
        kategoriaBalioarikGabe.setBalioa( 30.1 );
        kategoriaBalioarikGabe.setKategoria( "Sexua" );

        /**
         * ondo
         */
        Adierazlea zuzena = new Adierazlea();
        zuzena.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        zuzena.setUrtea( Year.of( 2025 ) );
        zuzena.setBalioa( 30.1 );
        zuzena.setKategoria( "Sexua" );
        zuzena.setKategoriaBalioa( "Guztira" );

        /**
         * eskema sortzen da
         */
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "adierazleak_balidazioa.xsd" ) );

        /**
         * testuingurua sortzen da eta adierazle bakoitzarentzako source bat sortzeko erabiltzen da
         */
        JAXBContext jaxbContext = JAXBContext.newInstance( Adierazlea.class );
        JAXBSource sourceKategoriaBalioarikGabe = new JAXBSource( jaxbContext, kategoriaBalioarikGabe );
        JAXBSource sourceZuzena = new JAXBSource( jaxbContext, zuzena );

        /**
         * balidatzailea hasieratzen da
         */
        Validator validator = schema.newValidator();
        validator.setErrorHandler( new MyErrorHandler() );

        // balidatzailea erabiltzen da
        try
        {
            validator.validate( sourceKategoriaBalioarikGabe );
            System.out.println( "kategoria-balioarik gabeko adierazleak ez du arazorik" );
        }
        catch( SAXException ex )
        {
            ex.printStackTrace();
            System.out.println( "kategoria-balioarik gabeko adierazleak arazoak ditu" );
        }
        try
        {
            validator.validate( sourceZuzena );
            System.out.println( "adierazle zuzenak ez du arazorik" );
        }
        catch( SAXException ex )
        {
            ex.printStackTrace();
            System.out.println( "adierazle zuzenak arazoak ditu" );
        }
    }
}
