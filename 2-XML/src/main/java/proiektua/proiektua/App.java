package proiektua.proiektua;

/**
 * Proiektuaren sarrera-puntu nagusia. Hemen ez du ezer berezirik egiten, "Kaixo mundua!" idazten
 * du soilik. JaxB adibideak beren main metodoetatik exekutatzen dira, klase bakoitza bereizita.
 */
public final class App {

    /**
     * Eraikitzaile pribatua: klase hau ez da instantziatzeko, main metodoa bakarrik du.
     */
    private App() {
    }

    /**
     * Mundua agurtzen du.
     * @param args Programaren argumentuak.
     */
    public static void main(String[] args) {
        // Mezua kontsolan inprimatu
        System.out.println("Kaixo mundua!");
    }
}
