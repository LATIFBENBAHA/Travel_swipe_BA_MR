package com.travel.swipe.ui;

import com.travel.swipe.model.Destination;
import com.travel.swipe.model.User;
import com.travel.swipe.service.DestinationService;
import com.travel.swipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleApp {
    private final DestinationService destinationService;
    private final UserService userService;
    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    public ConsoleApp(DestinationService destinationService, UserService userService) {
        this.destinationService = destinationService;
        this.userService = userService;
    }

    public void run() {
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

    private void ajouterUtilisateur() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();

        User user = new User();
        user.setNom(nom);
        user.setEmail(email);

        userService.saveUser(user);

        System.out.println("Utilisateur ajouté !");
    }

    private void rechercherDestination() {
        System.out.print("Type de destination (plage, nature, etc.) : ");
        String type = scanner.nextLine();

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
