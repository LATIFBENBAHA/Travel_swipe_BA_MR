package com.travel.swipe.ui;

import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import com.travel.swipe.model.FavorisActivite;
import com.travel.swipe.model.User;
import com.travel.swipe.repository.ActiviteRepository;
import com.travel.swipe.service.ActiviteService;
import com.travel.swipe.service.FavorisActiviteService;
import com.travel.swipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleApp {
//    private final DestinationService destinationService;
    private final ActiviteService activiteService;
    private final UserService userService;
    private FavorisActiviteService favorisActiviteService;
    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    public ConsoleApp(ActiviteService activiteService, UserService userService,FavorisActiviteService favorisActiviteService) {
        this.activiteService= activiteService;
        this.userService = userService;
        this.favorisActiviteService = favorisActiviteService;
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
                    rechercherActivite();
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
        System.out.print("password : ");
        String password = scanner.nextLine();

        User user = new User();
        user.setName(nom);
        user.setEmail(email);
        user.setMotdepass(password);

        userService.saveUser(user);

        System.out.println("Utilisateur ajouté !");
    }

    private void rechercherActivite() {
        List<Activite> activites=activiteService.getAllActivites();
        for (Activite act : activites){
            System.out.print("do you like :"+act.getName()+"\n");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {

                favorisActiviteService.likerActivite(1L,act.getId());
            }
        }
//        System.out.print("do you like :"+);
//        String choice = scanner.nextLine();
//        if (choice.equals('Y')){
//
//        }
//        Activite activites = activiteService.getActiviteByname(name);
//
//        List<Destination> destinations = destinationService.getDestinationsByType(type);
//
//        if (activites.equals(null)) {
//            System.out.println("Aucune activite trouvée.");
//        } else {
//            for (Destination dest : destinations) {
//                System.out.println(dest.getNom() + " - " + dest.getPays());
//            }
//        }
    }
}
