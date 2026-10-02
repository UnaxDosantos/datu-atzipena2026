package proiektua.proiektua.xsd;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

/**
 * {@link ValidationEventHandler} interfazearen inplementazioa
 * @author dgutierrez-diez
 *
 */
public class MyValidationEventHandler implements ValidationEventHandler
{

    @Override
    public boolean handleEvent( ValidationEvent event )
    {
        System.out.println( "Errorea harrapatuta!!" );
        System.out.println( "event.getSeverity():  " + event.getSeverity() );
        System.out.println( "event:  " + event.getMessage() );
        System.out.println( "event.getLinkedException():  " + event.getLinkedException() );
        // locator-ak informazio gehiago dauka: lerroa, zutabea, etab.
        System.out.println( "event.getLocator().getObject():  " + event.getLocator().getObject() );
        return false;
    }

}
