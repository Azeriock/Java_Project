package nombre_mystere;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class jeu {
	Scanner input = new Scanner(System.in);
	private int choice;
	private int gameMode;
	public int[] mystere = new int[4];
	public int[] nbjoueur = new int[4];
	public int[] nbordinateur = new int[4];
	public int nessais;
	
	public jeu() {
		this.nessais = 10;
		this.mystere = new int [4];
		this.nbjoueur = new int [4];
		this.input = new Scanner(System.in);
	}
	
	public void start() {
		affichage.accueil();
		choice = input.nextInt();
		gameMode = choice;
		game();
	}
	
	public void end() {
		affichage.ecranFin();
		choice = input.nextInt();
		
		switch(choice) {
		case 1:
			game();
			break;
		case 2:
			start();
		case 3:
			System.out.println("A bientot !");
			System.exit(0);
			break;
		}
	}
	
	public void game() {
		nessais = 10;
		if(gameMode!=1) {
			nombre.getNumber(mystere);
		}
		else
		{
			mystere = nombre.getMystere();
		}
		while (true)
		{
			if(gameMode==1)
			{
				if (nessais < 1)
				{
					System.out.println("tu as perdu");
					System.out.print("le nombre mystère etait : ");
					nombre.afficheNbr(mystere);
					System.out.println("");
					end();
					break;
				}
				nombre.getNumber(nbjoueur);
				--nessais;
				if (Arrays.equals(nbjoueur, mystere))
				{
					System.out.println("==> Gagne !");
					end();
					break;
				}
				else
				{
					System.out.print("Proposition : ");
					nombre.afficheNbr(nbjoueur);
					System.out.print(" -> Réponse : ");
					nombre.afficheRep(mystere, nbjoueur);
					System.out.println("");
				}
			}
			else
			{
				if (nessais < 1)
				{
					System.out.println("l'ordinateur n'a pas reussi a trouver le bon nombre");
					end();
				}
				nbordinateur = nombre.getMystere();
				--nessais;
				System.out.println("l'ordinateur propose un nombre..");
				System.out.print("Proposition : ");
				nombre.afficheNbr(nbordinateur);
				System.out.print(" -> Réponse : ");
				if (Arrays.equals(nbordinateur, mystere))
				{
					System.out.println("==> l'ordinateur a trouver le bon nombre !");
					end();
					break;
				}
				nombre.afficheRep(mystere, nbordinateur);
				System.out.println("");
				try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	}
	
}
