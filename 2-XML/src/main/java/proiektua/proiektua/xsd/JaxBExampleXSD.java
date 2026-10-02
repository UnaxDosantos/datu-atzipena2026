package proiektua.proiektua.xsd;

import java.io.File;
import java.time.Year;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import proiektua.proiektua.business.Adierazlea;

/**
 * XSD erabileraren adibidea baliozkotzerik gabe
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleXSD
{

    public static void main( String[] args ) throws Exception
    {
        Adierazlea batezBestekoAdina = new Adierazlea();
        batezBestekoAdina.setIzena( "Emantzipazioaren batez besteko adina, sexuaren arabera" );
        batezBestekoAdina.setUrtea( Year.of( 2025 ) );
        batezBestekoAdina.setBalioa( 30.1 );
        batezBestekoAdina.setKategoria( "Sexua" );
        batezBestekoAdina.setKategoriaBalioa( "Guztira" );

        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "adierazleak.xsd" ) );

        JAXBContext jaxbContext = JAXBContext.newInstance( Adierazlea.class );

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        marshaller.setSchema( schema );
        marshaller.marshal( batezBestekoAdina, System.out );

    }

}

/*
 * http://www.w3schools.com/schema/schema_example.asp
 * 
 * http://blog.bdoughan.com/2010/12/jaxb-and-marshalunmarshal-schema.html
 */
