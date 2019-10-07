package fr.htc.java.operations.types;

import java.util.Scanner;

public class Moy_Ecat_type implements Operation {

	@Override
	public void process(String title) {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans le choix : " + title);

	Scanner scanner= new Scanner(System.in);
		int j = scanner.nextInt();
		int somme = 0;
		double sig, entreSquar= 0, moy ;

		int tableau[] = new int[j];
		
		System.out.println("entrer les  éléments du tableau"+ j);
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = scanner.nextInt();
			somme = somme + tableau[i];
			entreSquar = entreSquar + Math.pow(tableau[i], 2);

		}
		moy = somme / tableau.length ;
		sig = Math.sqrt((entreSquar / tableau.length) - Math.pow(moy, 2));
		System.out.println("La moyenne des valeurs entrées est = " + moy);
		System.out.println("L'écart type des valeurs entrées est = " + sig);
	}

}
