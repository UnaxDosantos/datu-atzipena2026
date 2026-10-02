package proiektua.proiektua.xsd;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * {@link ErrorHandler} interfazearen inplementazioa
 * @author dgutierrez-diez
 *
 */
public class MyErrorHandler implements ErrorHandler
{

    @Override
    public void warning( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

    @Override
    public void error( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

    @Override
    public void fatalError( SAXParseException exception ) throws SAXException
    {
        throw exception;

    }

}
