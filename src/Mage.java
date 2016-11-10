import java.util.Scanner;

public class Mage extends Combattant {

	public Mage(String nom){
	
		this.setEXP(1);
		this.setNom(nom);
		int points = 100 + this.getEXP();
		int min = 0;
		int choix = 0;
		int pointsBonus = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Vous etes un Mage et vous disposez de 1 point d'experience\n");
		System.out.println("Vous disposez de : " + points + " points a repartir en FOR,DEX,INT,CON");
		
		/* Tests pour respecter les contraintes suivantes :
		(FOR + DEX + INT + CON) <= (100 + EXP)
		INT >= max(FOR,DEX) + 15
		CON >= max(FOR,DEX) + 15 */
		
		do{
		
			System.out.println("Votre INT doit etre comprise entre 15 et " + (points - 15) + "");
			System.out.println("INT ?");
			this.setINT(input.nextInt());
		} while(this.getINT() < 15 || this.getINT() > (points - 15));
		
		points = points - this.getINT();
		System.out.println("Il vous reste : " + points + " points");
		
		if(this.getINT() == 86){
			do{			
				System.out.println("Votre CON doit etre egale a 15");
				System.out.println("CON ?");
				this.setCON(input.nextInt());
			} while(this.getCON()!=15);
			
			points = points - this.getCON();
			System.out.println("Il vous reste : " + points + " points");
		
			System.out.println("\nVous avez investi tout vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("INT = " + this.getINT());
			System.out.println("CON = " + this.getCON());
			this.setFOR(0); System.out.println("FOR = " + this.getFOR());
			this.setDEX(0); System.out.println("DEX = " + this.getDEX());
			return;
			}
		
		do{	
			System.out.println("Votre CON doit etre comprise entre 15 et " + points);
			System.out.println("CON ?");
			this.setCON(input.nextInt());
		} while(this.getCON() < 15 || this.getCON() > points);
		
		points = points - this.getCON();
		System.out.println("Il vous reste : " + points + " points");
		
		if(points==0){
			System.out.println("\nVous avez investi tout vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("INT = " + this.getINT());
			System.out.println("CON = " + this.getCON());
			this.setFOR(0); System.out.println("FOR = " + this.getFOR());
			this.setDEX(0); System.out.println("DEX = " + this.getDEX());
			return;
		}
		
		if (this.getINT() < this.getCON()) 
			min = this.getINT();
		else
			min = this.getCON();
		
		do{
		
			if (min==15)
				System.out.println("Votre FOR doit etre egal a 0");
			else if (points < (min-15))
				System.out.println("Votre FOR doit etre comprise entre 0 et " + points); 
			else 
				System.out.println("Votre FOR doit etre comprise entre 0 et " + (min-15)); 
					
			System.out.println("FOR ?");
			this.setFOR(input.nextInt());
		} while(this.getFOR() > points || this.getFOR() > (min-15) || this.getFOR() < 0);
		
		points = points - this.getFOR();
		System.out.println("Il vous reste : " + points + " points");
		
		if(points==0){
			System.out.println("\nVous avez investi tout vos points\n");
			System.out.println("--- Caracteristiques ---");
			System.out.println("INT = " + this.getINT());
			System.out.println("CON = " + this.getCON());
			System.out.println("FOR = " + this.getFOR());
			this.setDEX(0); System.out.println("DEX = " + this.getDEX());
			return;
		}
		
		do{
			if (min==15)
				System.out.println("Votre DEX doit etre egal a 0");
			else if (points < (min-15))
				System.out.println("Votre DEX doit etre comprise entre 0 et " + points); 
			else 
				System.out.println("Votre DEX doit etre comprise entre 0 et " + (min-15)); 
			
			System.out.println("DEX ?");
			this.setDEX(input.nextInt());
		} while(this.getDEX() > points || this.getDEX() > (min-15) || this.getDEX() < 0);
		
		points = points - this.getDEX();
		System.out.println("Il vous reste : " + points + " points");
		
		if (points!=0)
		do{	
			System.out.println("\nVous n'avez pas utilise tous vos points, il vous en reste " + points);
			System.out.println("Voulez-vous les investir en INT ou en CON ? [1 : INT | 2 : CON]");
			choix = input.nextInt();
			switch(choix){
			
			case 1:
				do{	
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setINT(this.getINT() + pointsBonus);
				System.out.println("Votre INT est maintenant de " + this.getINT());
				break;
				
			case 2:
				do{	
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setCON(this.getCON() + pointsBonus);
				System.out.println("Votre CON est maintenant de " + this.getCON());
				break;
			}

			points = points - pointsBonus;
		} while(points != 0);
		
		else
		
		System.out.println("\nVous avez investi tout vos points\n");
		System.out.println("--- Caracteristiques ---");
		System.out.println("INT = " + this.getINT());
		System.out.println("CON = " + this.getCON());
		System.out.println("FOR = " + this.getFOR());
		this.setDEX(0); System.out.println("DEX = " + this.getDEX());
				
	}
}
