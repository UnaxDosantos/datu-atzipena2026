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
 * azaldutakoaren arabera.
 * 
 * CSVko lerro bakoitza adierazle bat da. Adibidez: "Emantzipazioaren batez besteko adina",
 * 2025, 30.1, "Sexua", "Guztira".
 * 
 * @author dgutierrez-diez
 */
// propOrder: elementuek XMLan izango duten ordena (eskemako xs:sequence-ren ordenarekin bat etorri behar du)
@XmlType( propOrder = { "izena", "urtea", "balioa", "kategoria", "kategoriaBalioa" } )
// XMLko erro-elementuaren izena: <Adierazlea>
@XmlRootElement( name = "Adierazlea" )
public class Adierazlea
{
    /** Adierazlearen izena (CSVko "Indicador" zutabea) */
    String izena;

    /** Datuaren urtea (CSVko "Periodo" zutabea) */
    Year   urtea;

    /** Adierazlearen balioa (CSVko "Valor" zutabea). double motakoa, hamartarrak izan ditzakeelako */
    double balioa;

    /** Zein irizpideren arabera banatzen den: sexua, adina, lurralde historikoa... (CSVko "Categoría 1") */
    String kategoria;

    /** Kategoriaren balio zehatza: Guztira, Emakumeak, Gipuzkoa... (CSVko "Categoría 1-Valor") */
    String kategoriaBalioa;

    /** @return adierazlearen izena */
    public String getIzena()
    {
        return izena;
    }

    /**
     * Anotazioa setter-ean jartzen da: XMLan {@code <Adierazlea_Izena>} elementua izango da
     */
    @XmlElement( name = "Adierazlea_Izena" )
    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    /** @return adierazlearen urtea */
    public Year getUrtea()
    {
        return urtea;
    }

    /**
     * XMLan {@code <Adierazlea_Urtea>} elementua izango da. Year motak ez du JaxB-ren euskarri
     * zuzenik, beraz UrteaAdapter erabiltzen da testu bihurtzeko eta alderantziz
     */
    @XmlElement( name = "Adierazlea_Urtea" )
    @XmlJavaTypeAdapter( UrteaAdapter.class )
    public void setUrtea( Year urtea )
    {
        this.urtea = urtea;
    }

    /** @return adierazlearen balioa */
    public double getBalioa()
    {
        return balioa;
    }

    /**
     * XMLan {@code <Adierazlea_Balioa>} elementua izango da
     */
    @XmlElement( name = "Adierazlea_Balioa" )
    public void setBalioa( double balioa )
    {
        this.balioa = balioa;
    }

    /** @return kategoriaren izena */
    public String getKategoria()
    {
        return kategoria;
    }

    /**
     * XMLan {@code <Adierazlea_Kategoria>} elementua izango da
     */
    @XmlElement( name = "Adierazlea_Kategoria" )
    public void setKategoria( String kategoria )
    {
        this.kategoria = kategoria;
    }

    /** @return kategoriaren balioa */
    public String getKategoriaBalioa()
    {
        return kategoriaBalioa;
    }

    /**
     * XMLan {@code <Adierazlea_Kategoria_Balioa>} elementua izango da. Eskema zorrotzean (balidazioa)
     * derrigorrezkoa da eta onartutako balioen zerrenda bat dauka
     */
    @XmlElement( name = "Adierazlea_Kategoria_Balioa" )
    public void setKategoriaBalioa( String kategoriaBalioa )
    {
        this.kategoriaBalioa = kategoriaBalioa;
    }

    /**
     * Adierazlea testu irakurgarri bihurtzen du, kontsolan erakusteko. Null diren atributuak
     * (urtea, kategoria, kategoria-balioa) ez dira inprimatzen
     */
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
