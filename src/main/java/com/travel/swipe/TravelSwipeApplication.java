package com.travel.swipe;

import com.google.firebase.FirebaseApp;
import com.travel.swipe.ui.ConsoleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TravelSwipeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TravelSwipeApplication.class, args);
		System.out.println("Firebase Apps: " + FirebaseApp.getApps());
		ConsoleApp app = context.getBean(ConsoleApp.class);
		app.run();
	}
}
