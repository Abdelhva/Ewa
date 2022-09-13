import java.util.Scanner;

public class Encryption {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");;
    static int Keuze;
    static String Naam;
    static String Wachtwoord;
    static String Bericht = "";
    static String wwoord;
    static String EncryptedBericht= "";
    static String DecryptedBericht= "";


    public static void main(String[] args) {
        //Hiermee wordt de KeuzeMenu aangeroepen
        KeuzeMenu();
        //Hiermee wordt het registratieMenu aangeroepen
        Registreren();
    }
    public static void KeuzeMenu(){
        //Print de keuzes uit
        System.out.println("Welkom, kies een van de volgende opties uit: ");
        System.out.println("Om te registreren kies 1");
        System.out.println("Om een bericht te sturen kies 2");
        System.out.println("Om een bericht te decrypten kies 3");
        System.out.println("Om een bericht te verwijderen kies 4");

        //Gebruik de scanner om de keuze in te lezen
        Keuze = scan.nextInt();
        switch(Keuze){
            case 1:
                Registreren();
                break;
            case 2:
                BerichtSturen();
                break;
            case 3:
                Decrypten();
                break;
            case 4:
                BerichtVerwijderen();
                break;
        }
    }
    public static void Registreren(){
        char keuze = 'N';
        System.out.println("Voer uw naam in: ");
        Naam = scan.next();
        System.out.println("Voer uw wachtwoord in: ");
        Wachtwoord = scan.next();
        System.out.println("Zijn de gegevens juist ingevuld?");
        keuze = scan.next().charAt(0);
        if( keuze =='J'){
            System.out.println("Uw bent nu geregistreerd.");
            KeuzeMenu();
        }
        else{
            Registreren();
        }

    }
    public static void BerichtSturen(){
        char keuze = 'N';
        System.out.println("Typ uw bericht in en druk op enter om te versturen o");
        Bericht = scan.next();
        System.out.println("Wilt uw nog een bericht sturen kies dan een J en anders een N om terug te keren naar de keuzemenu?");
        keuze = scan.next().charAt(0);
        System.out.println("Uw bericht wordt nu gecrypted");
        char[] chars = Bericht.toCharArray();
        int i = 0;
        for(char c : chars) {
            c += i;
            i++;
            EncryptedBericht += c;
        }
        System.out.println("Uw gecrypted bericht is:");
        System.out.println(EncryptedBericht);
        if (keuze == 'N'){
            KeuzeMenu();
        }
        else{
            BerichtSturen();
        }


    }
    static public void Decrypten(){
        System.out.println("Uw bericht wordt nu gedecrypted");
        char[] chars = EncryptedBericht.toCharArray();
        int i=0;
        for(char c : chars){
            c-=i;
            i--;
            DecryptedBericht +=c;
        }
        System.out.println(DecryptedBericht);
        KeuzeMenu();
    }
    static public void BerichtVerwijderen(){
        Bericht ="";
        EncryptedBericht = "";
        DecryptedBericht = "";
        KeuzeMenu();
    }
}
