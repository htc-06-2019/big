package fr.htc.java.operations.types;
import java.lang.Math;

public class Moyenne_EcartType implements Operation {

	@Override
	public void process(String title) {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans le choix : " + title);

		int j = scanner.nextInt();
		int somme = 0;
		double sigma, entreSquar= 0, moyenne ;

		int tableau[] = new int[j];
		
		System.out.println("entrer les " + j + " éléments du tableau");
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = scanner.nextInt();
			somme = somme + tableau[i];
			entreSquar = entreSquar + Math.pow(tableau[i], 2);

		}
		moyenne = somme / tableau.length ;
		sigma = Math.sqrt((entreSquar / tableau.length) - Math.pow(moyenne, 2));
		System.out.println("La moyenne des valeurs entrées est = " + moyenne);
		System.out.println("L'écart type des valeurs entrées est = " + sigma);
	}

}
