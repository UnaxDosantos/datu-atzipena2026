package proiektua.proiektua.xsd;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

/**
 * {@link ValidationEventHandler} interfazearen inplementazioa. JaxB-k marshal edo unmarshal
 * egitean arazo bat aurkitzen duenean, klase honek arazoaren xehetasunak kontsolan erakusten
 * ditu.
 * 
 * @author dgutierrez-diez
 *
 */
public class MyValidationEventHandler implements ValidationEventHandler
{

    /**
     * Balidazio-arazo bakoitzeko deitzen da.
     * 
     * @param event arazoaren informazioa (larritasuna, mezua, salbuespena, objektua)
     * @return false: prozesua geratzeko esaten dio JaxB-ri; true itzuliz gero, arazoa
     *         alde batera utzi eta jarraituko luke
     */
    @Override
    public boolean handleEvent( ValidationEvent event )
    {
        System.out.println( "Errorea harrapatuta!!" );
        // larritasuna: abisua, errorea edo errore larria
        System.out.println( "event.getSeverity():  " + event.getSeverity() );
        // arazoaren mezua
        System.out.println( "event:  " + event.getMessage() );
        // arazoa eragin duen salbuespena, baldin badago
        System.out.println( "event.getLinkedException():  " + event.getLinkedException() );
        // locator-ak informazio gehiago dauka: lerroa, zutabea, etab.
        System.out.println( "event.getLocator().getObject():  " + event.getLocator().getObject() );
        return false;
    }

}
