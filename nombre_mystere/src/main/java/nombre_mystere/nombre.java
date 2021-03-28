package nombre_mystere;

import java.util.Random;
import java.util.Scanner;

public class nombre {
	
	public nombre() {
		
	}
	
	public static int[] getNumber(int[] nbr) {
		int nombre;
		Scanner input = new Scanner(System.in);
		System.out.print("Votre nombre ? ");
		nombre = input.nextInt();
		for(int y = 4; y > 0; y--)
		{
			nbr[y-1] = nombre%10;
			nombre = nombre/10;
		}
		return nbr;
	}
	
	public static int[] getMystere() {
		int[] mystere = new int[4];
		Random rng = new Random();
		for(int i = 0; i < mystere.length; i++)
		{
			mystere[i] = rng.nextInt(10);
		}
		return mystere;
	}
	
	public static void afficheNbr(int[] nbr) {
		for(int i = 0; i < nbr.length; i++)
		{
			System.out.print(nbr[i]);
		}
	}
	
	public static void afficheRep(int[] mystere, int[] nbrjoueur) {
		for(int i = 0; i < mystere.length; i++)
		{
			if(mystere[i] == nbrjoueur[i])
			{
				System.out.print("=");
			}
			else if(mystere[i] < nbrjoueur[i])
			{
				System.out.print("-");
			}
			else
			{
				System.out.print("+");
			}
		}
	}
}
