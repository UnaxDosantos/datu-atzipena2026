package nio;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        // Scanner-a sortzen dugu erabiltzaileak teklatutik
        Scanner sc = new Scanner(System.in);

        int aukera;

        do {

            // Menu nagusia pantailan erakusten dugu.
            System.out.println();
            System.out.println("==============================");
            System.out.println("          NIO ARIKETAK");
            System.out.println("==============================");

            System.out.println("1. Path-a egiaztatu");
            System.out.println("2. Karpeta baten edukia");
            System.out.println("3. Karpeta-egitura sortu");
            System.out.println("4. Deskribapen fitxategia sortu");
            System.out.println("5. Karpeta zerrendatu");
            System.out.println("6. Fitxategien izenak aldatu");

            // 0 aukerak programa ixteko balioko du.
            System.out.println("0. Irten");

            System.out.println("==============================");

            // Erabiltzaileari aukera bat eskatzen dio.
            System.out.print("Aukeratu aukera bat: ");

            aukera = sc.nextInt();

            sc.nextLine();

            System.out.println();


            switch (aukera) {

                case 1:

                    // Ariketa1-eko main metodoa exekutatzen dugu.
                    Ariketa1.main(new String[]{});

                    break;

                case 2:

                    // Ariketa2 exekutatzen dugu.
                    Ariketa2.main(new String[]{});

                    break;

                case 3:

                    // Ariketa3 exekutatzen dugu.
                    // Honek karpeta-egitura sortzen du.
                    Ariketa3.main(new String[]{});

                    break;

                case 4:

                    // Ariketa4 exekutatzen dugu.
                    // Erabiltzaileari deskribapen bati buruzko
                    // informazioa galdetzen dio.
                    Ariketa4.main(new String[]{});

                    break;

                case 5:

                    // Ariketa5 exekutatzen dugu.
                    // JFileChooser erabiliz erabiltzaileak
                    // karpeta bat aukeratu dezake.
                    Ariketa5.main(new String[]{});

                    break;

                case 6:

                    // Ariketa6 exekutatzen dugu.
                    // Fitxategien izenen lehen karakterea
                    // maiuskulaz aldatzen du.
                    Ariketa6.main(new String[]{});

                    break;

                case 0:

                    // 0 aukeratuz gero, programa amaituko da.
                    System.out.println("Programa amaitzen...");

                    break;

                default:

                    // 1 eta 6 arteko aukera bat edo 0 ez bada
                    // sartu, errore-mezua erakusten dugu.
                    System.out.println("Aukera okerra.");

                    break;
            }

            // 0 aukeratu ez badugu, erabiltzaileari ENTER
            // sakatzea eskatzen diogu menu nagusira itzultzeko.
            if (aukera != 0) {

                System.out.println();
                System.out.println(
                    "Sakatu ENTER menu nagusira itzultzeko..."
                );

                sc.nextLine();
            }

        } while (aukera != 0);

        sc.close();
    }
}