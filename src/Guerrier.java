
import java.util.Scanner;

public class Guerrier extends Combattant {
	
	private static final int FORCE_MIN=30;

	public Guerrier(String nom){
		
		this.setEXP(1);
		this.setNom(nom);
		int points = 100 + this.getEXP();
		Scanner input = new Scanner(System.in);	
		
		System.out.println("Vous etes un Guerrier et vous disposez de 1 point d'experience\n");
		System.out.println("Vous disposez de : " + points + " points a repartir en FOR,DEX,INT,CON");
		
		/* tests pour respecter les contraintes suivantes :
		(FOR + DEX + INT + CON) <= (100 + EXP)
		FOR >= (DEX + 10) >= (INT + 10) >= CON */
		
		do{
		
			System.out.println("Votre FOR doit etre comprise entre " + FORCE_MIN +  " et " + points);
			System.out.println("FOR ?");
			this.setFOR(input.nextInt());
		} while (this.getFOR() > points || this.getFOR() < 0 || this.getFOR() < FORCE_MIN);
		
			points = points - this.getFOR();
			System.out.println("Il vous reste : " + points + " points");
		
		if(points==0){
			System.out.println("\nVous avez investi tous vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("FOR = " + this.getFOR());
			this.setDEX(0); System.out.println("DEX = " + this.getDEX());
			this.setINT(0); System.out.println("INT = " + this.getINT());
			this.setCON(0); System.out.println("CON = " + this.getCON());
			return;
		}
		
		
		do{	
			
			System.out.print("Votre DEX doit etre comprise entre 0 et ");
			if(this.getFOR() - 10 > points)
				System.out.println(points);
			else
				System.out.println(this.getFOR() - 10);
			System.out.println("DEX ?");
			this.setDEX(input.nextInt());
		} while(this.getDEX() > points || this.getDEX() > this.getFOR() - 10 || this.getDEX() < 0 );
						
		points = points - this.getDEX();
		System.out.println("Il vous reste : " + points + " points");
		
		if(points==0){
			System.out.println("\nVous avez investi tous vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("FOR = " + this.getFOR());
			System.out.println("DEX = " + this.getDEX());
			this.setINT(0); System.out.println("INT = " + this.getINT());
			this.setCON(0); System.out.println("CON = " + this.getCON());
			return;
		}

		do{
		
			System.out.print("Votre INT doit etre comprise entre 0 et ");
			if(points < this.getDEX())
				System.out.println(points);
			else
				System.out.println(this.getDEX());
			if(this.getDEX()!=0){
				System.out.println("INT ?"); 
				this.setINT(input.nextInt());
			}
			
			else{ 
				this.setINT(0); 
				System.out.println("INT =  " + this.getINT());
			}
			
		} while(this.getINT() > points || this.getINT() > this.getDEX() || this.getINT() < 0);
		
		points = points - this.getINT();	
		System.out.println("Il vous reste : " + points + " points");
		
		if (points == 0){
			System.out.println("\nVous avez investi tous vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("FOR = " + this.getFOR());
			System.out.println("DEX = " + this.getDEX());
			System.out.println("INT = " + this.getINT());
			this.setCON(0); System.out.println("CON = " + this.getCON());
			return;
		}

		do{
		
			System.out.print("Votre CON doit etre comprise entre 0 et ");
			if (points < this.getINT() + 10)
				System.out.println(points);
			else 
				System.out.println(this.getINT() + 10);
			this.setCON(input.nextInt());
		} while (this.getCON() > points || this.getCON() > this.getINT() + 10 || this.getCON() < 0 );
		
		points = points - this.getCON();

		if (points == 0)
			System.out.println("\nVous avez investi tous vos points\n");
		else if (points > 0){
			System.out.println("Il vous reste " + points + " point(s) a investir. Les points restants ont ete assigne a l'attribut FOR");
			this.setFOR(getFOR() + points);
		}
			
			System.out.println("--- Caracteristiques ---");
			System.out.println("FOR = " + this.getFOR());
			System.out.println("DEX = " + this.getDEX());
			System.out.println("INT = " + this.getINT());
			System.out.println("CON = " + this.getCON());
		
}
}
