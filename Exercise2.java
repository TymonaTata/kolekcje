package pl.swieczkowski.kolekcje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise2 {
    public static final String ADD_NAME = "1";
    public static final String EXIT = "-";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, String> pairNames = new HashMap<>();

        String pairName1;
        String pairName2;
        String option;
        boolean input = true;
        while (input) {
            System.out.println("Wybierz opcje:\n\"1\" Dodaj parę imon do mapy\n\"-\" Zakończ dodawanie imion i zamknij mapę");
            option = sc.nextLine();
            switch (option) {
                case ADD_NAME:
                    System.out.println("Wprowadź pierwsze imię pary:");
                    pairName1 = sc.nextLine();
                    System.out.println("Wprowdź drugie imię pary:");
                    pairName2 = sc.nextLine();
                    pairNames.put(pairName1, pairName2);
                    System.out.println("Wprowadzono do mapy parę imion: " + pairName1 + ", " + pairName2);
                    break;
                case EXIT:
                    System.out.println("Zakończono dodawanie imion. Mapa została zamknięta!");
                    input = false;
                    break;
                default:
                    System.out.println("Błędny wybór, spróbuj jeszcze raz!");
            }

        }
        String foundName;
        String key = "";
        String value = "";
        boolean notFound = true;
        while (notFound) {
            System.out.println("Podaj imię dla którego chcesz wyszukać odpowaidające mu imię z pary:");
            foundName = sc.nextLine();
            for (Map.Entry<String, String> entry : pairNames.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if (foundName.equals(key)) {
                    System.out.println("Imię " + key + " jest w parze z imieniem " + value);
                    notFound = false;
                    break;
                }
                if (foundName.equals(value)) {
                    System.out.println("Imię " + value + " jest w parze z imieniem " + key);
                    notFound = false;
                    break;
                }
            }
            boolean nameWasFound = foundName.equals(key) || foundName.equals(value);
            if (!nameWasFound) {
                System.out.println("Imię "
                        + foundName + " nie zostało znalezione w mapie. Spróbuj jeszcze raz!");
            }
            System.out.println();
        }

        sc.close();
    }
}


