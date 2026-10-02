package proiektua.proiektua.xsd;

import java.io.File;
import java.time.Year;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import proiektua.proiektua.business.Adierazlea;

/**
 * XSD-en erabileraren adibidea marshal egitean, inplikatutako objektuak baliozkotuz. Hiru kasu
 * probatzen dira: eremu bat falta da, balio okerra, eta adierazle zuzena
 * 
 * @author dgutierrez-diez
 *
 */
public class JaxBExampleXSDValidation
{

    public static void main( String[] args ) throws Exception
    {
        /**
         * baliozkotzeak huts egingo du kategoria-balioa derrigorrezkoa delako
         */
        Adierazlea kategoriaBalioarikGabe = new Adierazlea();
        kategoriaBalioarikGabe.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        kategoriaBalioarikGabe.setUrtea( Year.of( 2025 ) );
        kategoriaBalioarikGabe.setBalioa( 30.1 );
        kategoriaBalioarikGabe.setKategoria( "Sexua" );

        // eskema kargatzen da (bertsio zorrotza)
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "adierazleak_balidazioa.xsd" ) );

        JAXBContext jaxbContext = JAXBContext.newInstance( Adierazlea.class );

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        marshaller.setSchema( schema );
        // eskemak validation handler bat erabiltzen du objektuak baliozkotzeko
        marshaller.setEventHandler( new MyValidationEventHandler() );
        // lehenengo kasua: eremu bat falta da
        try
        {
            marshaller.marshal( kategoriaBalioarikGabe, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

        /**
         * kategoria-balioa okerra da (baimendutako zerrendan ez dago) eta baliozkotzeak huts egingo du
         */
        Adierazlea kategoriaOkerra = new Adierazlea();
        kategoriaOkerra.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        kategoriaOkerra.setUrtea( Year.of( 2025 ) );
        kategoriaOkerra.setBalioa( 30.1 );
        kategoriaOkerra.setKategoria( "Sexua" );
        kategoriaOkerra.setKategoriaBalioa( "Nafarroa" );

        // bigarren kasua: balioa ez dago enumerazioan
        try
        {
            marshaller.marshal( kategoriaOkerra, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

        /**
         * azkenik, dena ondo
         */
        Adierazlea zuzena = new Adierazlea();
        zuzena.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        zuzena.setUrtea( Year.of( 2025 ) );
        zuzena.setBalioa( 30.1 );
        zuzena.setKategoria( "Sexua" );
        zuzena.setKategoriaBalioa( "Guztira" );

        // hirugarren kasua: adierazle zuzena, XMLa kontsolan idatziko da
        try
        {
            marshaller.marshal( zuzena, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

    }

}
