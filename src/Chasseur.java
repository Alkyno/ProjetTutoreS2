import java.util.Scanner;

public class Chasseur extends Combattant {	

	public Chasseur(String nom){
		this.setEXP(1);
		this.setNom(nom);
		int points = (100-80) + this.getEXP();
		int pointsBonus = 0;
		int choix=0;
		Scanner input = new Scanner(System.in);
	
		this.setFOR(20); this.setDEX(20); this.setINT(20); this.setCON(20);
		
		System.out.println("Vous etes un Chasseur et vous disposez de 1 point d'experience\n");
		System.out.println("Etant un Chasseur, chaque attribut a 20 points minimum [FOR : 20 ; DEX : 20 ; INT : 20 ; CON : 20]");
		
		/* tests pour respecter les contraintes suivantes :
		(FOR + DEX + INT + CON) <= (100 + EXP)
		FOR >= 20 ; DEX >= 20 ; INT >= 20; CON >= 20 */
		
		do{		
			System.out.println("Vous disposez de : " + (points) + " points a repartir en FOR,DEX,INT,CON");
			System.out.println("Voulez-vous les investir en FOR,DEX,INT,CON ? [1 : FOR | 2 : DEX | 3 : INT | CON : 4]");
			choix = input.nextInt();
			switch(choix){		
				case 1:
				do{		
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setFOR(this.getFOR() + pointsBonus);
				System.out.println("Votre FOR est maintenant de " + this.getFOR());
				break;
				
			case 2:
				do{	
					
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setDEX(this.getDEX() + pointsBonus);
				System.out.println("Votre DEX est maintenant de " + this.getDEX());
				break;
				
			case 3:
				do{
				
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setINT(this.getINT() + pointsBonus);
				System.out.println("Votre INT est maintenant de " + this.getINT());
				break;
				
			case 4:
				do{
					
					System.out.println("Combien ? [0 - " + points + "]");
					pointsBonus = input.nextInt(); 
				} while(pointsBonus < 0 || pointsBonus > points);
				
				this.setCON(this.getCON() + pointsBonus);
				System.out.println("Votre CON est maintenant de " + this.getCON());
				break;
			}
			points = points - pointsBonus;
		} while(points > 0);
		
		System.out.println("\nVous avez investi tout vos points\n");
		System.out.println("--- Caracteristiques ---");
		System.out.println("FOR = " + this.getFOR());
		System.out.println("DEX = " + this.getDEX());
		System.out.println("INT = " + this.getINT());
		System.out.println("CON = " + this.getCON());
		
	}
}
