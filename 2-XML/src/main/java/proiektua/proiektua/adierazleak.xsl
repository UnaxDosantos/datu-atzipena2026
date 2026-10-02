<?xml version="1.0" encoding="UTF-8"?>
<!--
    adierazleak.xml fitxategia taula bihurtzen duen hoja-estiloa (XSLT 1.0).
    Irteera XML da (XHTML izen-espazioarekin, beraz nabigatzaileak taula gisa erakusten ditu).
    Adierazle bakoitzeko taula bat sortzen da, izenaren arabera taldekatuta.
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Irteera: XML ongi osatua, UTF-8 kodeketarekin eta koskekin -->
    <xsl:output method="xml" encoding="UTF-8" indent="yes" />

    <!--
        Adierazleak izenaren arabera taldekatzeko gakoa (Muenchian metodoa):
        izen berdina duten adierazleak talde berean geratzen dira, eta talde bakoitzeko taula bat sortuko da
    -->
    <xsl:key name="izenaren-arabera" match="Adierazlea" use="Adierazlea_Izena" />

    <!-- Erro-txantiloia: <Adierazleak> elementua aurkitzean orri osoa sortzen da -->
    <xsl:template match="/Adierazleak">
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <title>Gazteen emantzipazioa</title>
                <!-- Estilo sinplea: letra-mota, taulen ertzak eta goiburuaren atzeko kolorea -->
                <style type="text/css">
                    body { font-family: Arial, sans-serif; max-width: 800px; margin: 2em auto; padding: 0 1em; color: #222; }
                    h1 { font-size: 1.5em; }
                    h2 { font-size: 1.05em; margin: 2em 0 0.5em; }
                    table { border-collapse: collapse; width: 100%; }
                    th, td { border: 1px solid #ccc; padding: 6px 10px; text-align: left; }
                    th { background: #f0f0f0; }
                    td.balioa, th.balioa { text-align: right; }
                </style>
            </head>
            <body>
                <h1>Gazteen emantzipazioa</h1>

                <!--
                    Izen bakoitzeko lehen agerpena bakarrik hartzen da (generate-id bidez),
                    horrela izenburu eta taula bat sortzen da adierazle mota bakoitzeko
                -->
                <xsl:for-each select="Adierazlea[generate-id() = generate-id(key('izenaren-arabera', Adierazlea_Izena)[1])]">
                    <!-- Taularen izenburua: adierazlearen izena -->
                    <h2><xsl:value-of select="Adierazlea_Izena" /></h2>
                    <table>
                        <!-- Taularen goiburua -->
                        <tr>
                            <th>Urtea</th>
                            <th>Kategoria</th>
                            <th>Kategoria-balioa</th>
                            <th class="balioa">Balioa</th>
                        </tr>
                        <!-- Izen bereko adierazle guztiak, errenkada bat bakoitzeko -->
                        <xsl:for-each select="key('izenaren-arabera', Adierazlea_Izena)">
                            <tr>
                                <td><xsl:value-of select="Adierazlea_Urtea" /></td>
                                <td><xsl:value-of select="Adierazlea_Kategoria" /></td>
                                <td><xsl:value-of select="Adierazlea_Kategoria_Balioa" /></td>
                                <td class="balioa"><xsl:value-of select="Adierazlea_Balioa" /></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
