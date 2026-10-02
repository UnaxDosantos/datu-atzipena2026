package proiektua.proiektua.unmarshal;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import proiektua.proiektua.business.Adierazleak;

/**
 * Klase honek XML egitura sinple bat java klaseetara nola unmarshal egin erakusten du
 * 
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBCompleteExample
{
    public static void main( String[] args )
    {

        try
        {

            File file = new File( "adierazleak.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Adierazleak.class );

            /**
             * marshal eragiketarekin dagoen desberdintasun bakarra hemen dago
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Adierazleak adierazleak = (Adierazleak)jaxbUnmarshaller.unmarshal( file );
            System.out.println( adierazleak );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

}
