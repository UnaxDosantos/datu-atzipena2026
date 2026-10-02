package proiektua.proiektua.business;

import java.time.Year;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import proiektua.proiektua.adapter.UrteaAdapter;

/**
 * Gazteen emantzipazioaren adierazlea (iovj-emancipacion.csv): izena, urtea, balioa, zein
 * kategoriaren arabera banatzen den (sexua, adina, lurralde historikoa...) eta kategoria horren
 * balioa. Atributu hauek ordena honetan agertzen dira sortutako XMLan, XmlType oharrean
 * azaldutakoaren arabera
 * 
 * @author dgutierrez-diez
 */
@XmlType( propOrder = { "izena", "urtea", "balioa", "kategoria", "kategoriaBalioa" } )
@XmlRootElement( name = "Adierazlea" )
public class Adierazlea
{
    String izena;

    Year   urtea;

    double balioa;

    String kategoria;

    String kategoriaBalioa;

    public String getIzena()
    {
        return izena;
    }

    @XmlElement( name = "Adierazlea_Izena" )
    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    public Year getUrtea()
    {
        return urtea;
    }

    @XmlElement( name = "Adierazlea_Urtea" )
    @XmlJavaTypeAdapter( UrteaAdapter.class )
    public void setUrtea( Year urtea )
    {
        this.urtea = urtea;
    }

    public double getBalioa()
    {
        return balioa;
    }

    @XmlElement( name = "Adierazlea_Balioa" )
    public void setBalioa( double balioa )
    {
        this.balioa = balioa;
    }

    public String getKategoria()
    {
        return kategoria;
    }

    @XmlElement( name = "Adierazlea_Kategoria" )
    public void setKategoria( String kategoria )
    {
        this.kategoria = kategoria;
    }

    public String getKategoriaBalioa()
    {
        return kategoriaBalioa;
    }

    @XmlElement( name = "Adierazlea_Kategoria_Balioa" )
    public void setKategoriaBalioa( String kategoriaBalioa )
    {
        this.kategoriaBalioa = kategoriaBalioa;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer( "Adierazlea: " + getIzena() + "\n" );

        if( getUrtea() != null )
        {
            str.append( "Urtea: " + getUrtea().toString() + "\n" );
        }

        str.append( "Balioa: " + getBalioa() + "\n" );

        if( getKategoria() != null )
        {
            str.append( "Kategoria: " + getKategoria() + "\n" );
        }

        if( getKategoriaBalioa() != null )
        {
            str.append( "Kategoria-Balioa: " + getKategoriaBalioa() + "\n" );
        }

        return str.toString();
    }
}
