package proiektua.proiektua.unmarshal;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import proiektua.proiektua.business.Adierazleak;

/**
 * Klase honek XML egitura sinple bat java klaseetara nola unmarshal egin erakusten du.
 * adierazleak.xml fitxategia irakurtzen du eta Adierazleak objektu bihurtzen du.
 * 
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBCompleteExample
{
    public static void main( String[] args )
    {

        try
        {

            // irakurriko den XML fitxategia (proiektuaren erroan egon behar da)
            File file = new File( "adierazleak.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Adierazleak.class );

            /**
             * marshal eragiketarekin dagoen desberdintasun bakarra hemen dago
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            // XMLa java objektu bihurtzen da; erroa Adierazleak denez, bihurketa hori egiten da
            Adierazleak adierazleak = (Adierazleak)jaxbUnmarshaller.unmarshal( file );
            // objektuaren toString() metodoari esker, kontsolan adierazle guztiak ikusten dira
            System.out.println( adierazleak );

        }
        catch( JAXBException e )
        {
            // JaxB-ren edozein errore hemen harrapatzen da eta pilaren traza inprimatzen da
            e.printStackTrace();
        }

    }

}
