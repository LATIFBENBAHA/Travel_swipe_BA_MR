import com.travel.swipe.model.User;
import com.travel.swipe.service.UserService;

import java.util.Scanner;

public class ConsoleApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue sur TravelSwipe !");
        while (true) {
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Rechercher une destination");
            System.out.println("3. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la ligne

            switch (choix) {
                case 1:
                    ajouterUtilisateur();
                    break;
                case 2:
                    rechercherDestination();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private static void ajouterUtilisateur() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();

        User user = new User();
        user.setNom(nom);
        user.setEmail(email);

        UserService userService = new UserService();
        userService.saveUser(user);

        System.out.println("Utilisateur ajouté !");
    }

    private static void rechercherDestination() {
        System.out.print("Type de destination (plage, nature, etc.) : ");
        String type = scanner.nextLine();

        DestinationService destinationService = new DestinationService();
        List<Destination> destinations = destinationService.getDestinationsByType(type);

        if (destinations.isEmpty()) {
            System.out.println("Aucune destination trouvée.");
        } else {
            for (Destination dest : destinations) {
                System.out.println(dest.getNom() + " - " + dest.getPays());
            }
        }
    }
}
