package proiektua.proiektua.xsd;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * {@link ErrorHandler} interfazearen inplementazioa. Balidatzaileak aurkitzen duen arazo
 * mota bakoitza (abisua, errorea, errore larria) salbuespen bihurtzen du, horrela balidazioa
 * berehala geldituko da lehenengo arazoa aurkitzean.
 * 
 * @author dgutierrez-diez
 *
 */
public class MyErrorHandler implements ErrorHandler
{

    /**
     * Abisu bat aurkitzen denean deitzen da; salbuespena jaurtitzen du
     */
    @Override
    public void warning( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

    /**
     * Errore bat aurkitzen denean deitzen da (adibidez, eskemaren aurkako datu bat); salbuespena
     * jaurtitzen du
     */
    @Override
    public void error( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

    /**
     * Errore larri bat aurkitzen denean deitzen da (adibidez, XMLa ongi osatua ez dagoenean);
     * salbuespena jaurtitzen du
     */
    @Override
    public void fatalError( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

}
