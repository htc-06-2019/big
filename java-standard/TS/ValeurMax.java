package fr.htc.java.operations.types;

import java.util.Arrays;

public class ValeurMax implements Operation {

	@Override
	public void process(String title) {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans le choix : " + title);
		System.out.println("entrer la taille du tableau");
		int j= scanner.nextInt();
		
		
		int tableau[]= new int[j];
		
		for (int i=0; i<tableau.length;i++) {
			System.out.println("entrer le "+ (i+1) +" élément du tableau");
			tableau[i] = scanner.nextInt();
			
		}

		//int Tableau[] = { 5, 3, 12, 4, 7, 9, 1, 8, 19, 2 };

		int test = Arrays.stream(tableau).max().getAsInt();

		System.out.println("la plus grand valeur du tableau est: " + test);

	}

}
