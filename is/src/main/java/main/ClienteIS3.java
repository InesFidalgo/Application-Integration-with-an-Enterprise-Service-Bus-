package main;

import java.util.Scanner;


import artifact.*;



public class ClienteIS3 {

	public static void main(String[] args) {
		int option = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			do {
				try {
					
					System.out.println("1 - Subscribe");
					System.out.println("2 - Unsubscribe");
					System.out.println("3 - List Subscriptions");
					System.out.println("4 - Exit");
					option = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {}
				
			} while(option < 1 || option > 4);

			switch(option) {
				case 1: {
					String email, course;
					System.out.println("Email: ");
					email = sc.nextLine();
					System.out.println("Course: ");
					course = sc.nextLine();
					subscribe(email, course);
					break;
				} case 2: {
					String email, course;
					System.out.println("Insert your e-mail: ");
					email = sc.nextLine();
					System.out.println("Course: ");
					course = sc.nextLine();
					unsubscribe(email, course);
					break;
					
				} case 3:{
					String course;
					System.out.println("Course: ");
					course = sc.nextLine();
					
					listar(course);
					break;
				} case 4: {
					System.exit(0);
					break;
				}
				default: {
					System.out.println("Not Valid");
					break;
				}
			}
			System.out.println();
			System.out.println();
			option = 0;
		}

	}


	public static void subscribe(String email, String course) {
		try {
			System.out.println(course);
			SubscriptionService as = new SubscriptionService();
			Subscription asp = as.getSubscriptionPort();
			
			String result = asp.setParams(email, course);
			System.out.println(result);
			
		} catch(Exception e) {
			System.out.println("No subscription for you!");
		}
	}

	public static void unsubscribe(String email, String course) {
		try {
			UnsubscriptionService as = new UnsubscriptionService();
			Unsubscription asp = as.getUnsubscriptionPort();
			
			String result = asp.setParams(email, course);
			System.out.println(result);
			if(result.compareTo("'1'") == 0) {
				System.out.println("Verify your email to complete this task!");
			} else {
				System.out.println("Error");
			}
		} catch(Exception e) {
			System.out.println("No unsubscription for you!");
		}
	}
	public static void listar(String course) {
		try {
			ListarService as = new ListarService();
			Listar asp = as.getListarPort();
			
			String result = asp.setParams(course);
			
			System.out.println(result);
		} catch(Exception e) {
			System.out.println("No list for you!");
		}
	}
	
	
	

	
	
}
