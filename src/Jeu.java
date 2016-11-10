import java.util.Scanner;
import javax.swing.JFrame;
 import java.io.IOException;
import java.util.*; 
import java.io.*; 
import java.util.Random;

public class Jeu {

	public static Combattant creerCombattant(){
	
		Combattant persoCree = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Quel est le nom de votre combattant ?");
		String nom = input.nextLine();
		boolean classeIncorrecte = true;

		do
		{
			System.out.println("Quelle est la classe de votre combattant ? [1 : Guerrier | 2 : Mage | 3 : Chasseur]");
			int classeChoisie = input.nextInt();
			switch(classeChoisie)
			{
			case 1:
				persoCree = new Guerrier(nom);			
				classeIncorrecte = false;
			break;
			case 2: 
				persoCree = new	Mage(nom);	
				classeIncorrecte = false;
			break;
			case 3:
				persoCree = new Chasseur(nom);
				classeIncorrecte = false;
			break;
			}
		} while (classeIncorrecte);
			System.out.println("Votre EXP est de : " + persoCree.getEXP() + "\n");
			for (int i=0; i< persoCree.getEXP() || i<2;i++) 
			creerCapacite(persoCree);
			
			return persoCree;
	}

	public static void creerCapacite(Combattant perso){	
	
		boolean capaciteIncorrecte = true;
		
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Quelle Capacite voulez vous ?\n\n1- Arme \n2- Sort d'attaque \n3- Bouclier \n4- Sort de defense \n5- Remede \n6- Sort de soin");
	  int i = sc.nextInt();	
	  int a=0;
	  do
	  {	
		  switch(i)	
		  {
			case 1:
				do 
				{ 
					System.out.println("Quelle Arme voulez vous ? \n\n1- Arc [Impact=65 | Maniabilite=25] \n2- Baton [Impact=70 | Maniabilite=30] \n3- Dague [Impact=65 | Maniabilite=35] \n4- Epee [Impact=60 | Maniabilite=40] \n5- Hache [Impact=80 | Maniabilite=20]");
                    a = sc.nextInt(); 
                } while( (a < 1 || a > 5) && a!=999);
				
				Arme c1 = new Arme();
							
				c1.initArme(a,perso.getDEX(), perso.getFOR());

				System.out.println("La probabilite de reussite de votre capacite pour une attaque est de " + c1.getPBAA());
				System.out.println("La probabilite de reussite de votre capacite pour une defense est de " + c1.getPBAD()+ "\n");
				perso.setCapacite(c1);
				capaciteIncorrecte = false;
			break;
			
			case 2: 
				do 
				{ 
					System.out.println("Quel Sort d'attaque voulez vous ? \n\n1- Boule de feu [Puissance=80 | Facilite=20] \n2- Eclair [Puissance=50 | Facilite=50] \n3- Pluie de meteores [Puissance=65 | Facilite=35]");
                    a = sc.nextInt(); 
                } while(a < 1 || a > 3);	
				
				SortAttaque c2 = new SortAttaque();		
				
				c2.initSortAttaque(a,perso.getINT(), perso.getCON());

				if(c2.getPBAA()<1)
					System.out.println("La probabilite de reussite de votre capacite pour une attaque est de " + c2.getPBAA()+ "\n");
				else
					System.out.println("La probabilite de reussite de votre capacite pour une attaque est de 1\n");
				
				perso.setCapacite(c2);
				capaciteIncorrecte = false; 
			break;
			
			case 3:
				do 
				{ 
					System.out.println("Quel Bouclier voulez vous ? \n\n1- Bouclier normand [Protection=60 | Maniabilite=40] \n2- Ecu [Protection=40 | Maniabilite=60] \n3- Pavois [Protection=50 | Maniabilite=50]");
                    a = sc.nextInt(); 
                } while(a < 1 || a > 3);
			
				Bouclier c3 = new Bouclier();
							
				c3.initBouclier(a,perso.getDEX(), perso.getFOR());

				if(c3.getPBAA()<1)
					System.out.println("La probabilite de reussite de votre capacite pour une attaque est de " + c3.getPBAA());
				else
					System.out.println("La probabilite de reussite de votre capacite pour une attaque est de 1\n");
				
				if(c3.getPBAD()<1)
					System.out.println("La probabilite de reussite de votre capacite pour une defense est de " + c3.getPBAD()+ "\n");
				else 
					System.out.println("La probabilite de reussite de votre capacite pour une defense est de 1\n");
				
				perso.setCapacite(c3);
				capaciteIncorrecte = false;
			break;
			
			case 4:	
				do
				{ 
					System.out.println("Quel Sort de defense voulez vous ? \n\n1- Barriere de glace [Puissance=80 | Facilite=20] \n2- Purification [Puissance=70 | Facilite=30] \n3- Suppression de douleur [Puissance=50 | Facilite=50]");
                    a = sc.nextInt();
				} while(a < 1 || a > 3);
				
				SortDefense c4 = new SortDefense();
						
				c4.initSortDefense(a,perso.getINT(), perso.getCON());

				if(c4.getPBAD()<1)
					System.out.println("La probabilite de reussite de votre capacite pour une defense est de " + c4.getPBAD()+ "\n");
				else
					System.out.println("La probabilite de reussite de votre capacite pour une defense est de 1\n");
				perso.setCapacite(c4);
				capaciteIncorrecte = false;
			break;

			case 5:
				do 
				{ 
					System.out.println("Quel Remede voulez-vous ? \n\n1- Herbe guerissante [Puissance=60 | Facilite=40] \n2- Potion de soin [Puissance=50 | Facilite=50] \n3- Remede miracle [Puissance=80 | Facilite=20]");
					a = sc.nextInt(); 
				} while(a < 1 || a > 3);
				
				Remede c5 = new Remede();
			
				c5.initRemede(a,perso.getDEX(),perso.getFOR());
				if(c5.getPBAS()<1)
					System.out.println("La probabilite de reussite de votre capacite pour un soin est de " + c5.getPBAS()+ "\n");
				else
					System.out.println("La probabilite de reussite de votre capacite pour un soin est de 1\n");
				
				perso.setCapacite(c5);
				capaciteIncorrecte = false;
			break;

			case 6:
				do 
				{ 
					System.out.println("Quel Sort de soin voulez-vous ? \n\n1- Soins rapides [Puissance=50 | Facilite=50] \n2- Rajeunissement [Puissance=70 | Facilite=30] \n3- Vague de soins [Puissance=60 | Facilite=40]");
					a = sc.nextInt(); 
				} while(a < 1 || a > 3);
				
				SortSoin c6= new SortSoin();
				
				c6.initSortSoin(a,perso.getINT(),perso.getCON());
				if(c6.getPBAS()<1)
					System.out.println("La probabilite de reussite de votre capacite pour un soin est de " + c6.getPBAS()+ "\n");
				else
					System.out.println("La probabilite de reussite de votre capacite pour un soin est de 1\n");
				perso.setCapacite(c6);
				capaciteIncorrecte = false;
			break;
			}
		} while (capaciteIncorrecte);
	}

	public static double pourcentageAugmentation(double nombre){
		
	int nbAleatoire = (int) (-26+Math.random() * 52 - 0	); // [-25 -> 25]
	
    return (nombre + (nbAleatoire * nombre) / 100);
	}	

	public static boolean estReussi(double p, boolean action){
		
		double pbR = (double) (Math.random() *1 - 0	); // [0 -> 1]
		if(action == true)
		{
			if(p-pbR>0)
			{ 
				System.out.println("Votre attaque a reussie");
				return true;
			}
		
			else  
			{ 
				System.out.println("Votre attaque a echouee"); 
				return false; 
			} 
		}
	
		else 
		{
			if(p-pbR>0)
			{ 
				System.out.println("Votre parade a reussie"); 
				return true; 
			}
	
			else  
			{ 
				System.out.println("Votre parade a echouee"); 
				return false; 
			} 
		}
	}

	public static double attaquer(Combattant c1){
		
			double degats=0;
			boolean action = true;
			int b;
			int f=0;
			Scanner sc = new Scanner(System.in);
			do{ 
				System.out.println(" \n--------------- Trie des Capacites pouvant attaquer ---------------");
				for(int i=0; i<c1.getSize(); i++){
					if (c1.getCapacite(i).getCanAtk()==true)
						if(c1.getCapacite(i).getPBAA()*100<100)
							System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+c1.getCapacite(i).getPBAA()*100+ ") ............"+ i);
						else
							System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+"100"+ ") ............"+ i);
					f=i;
				}
				
			System.out.println("\nAnnuler........." +(f+1));
			System.out.println("Votre choix :"); 
			b = sc.nextInt(); 
			} while(b>f+1);
			
			for (int i=0; i<c1.getSize(); i++){
				if (c1.getCapacite(i).getCanAtk()==true && i==b){	
				if(estReussi(c1.getCapacite(b).getPBAA(),action)==true){ 
					degats=pourcentageAugmentation(c1.getCapacite(b).getEFFA());
					
				System.out.println("Vous pouvez infliger " + degats + " de degats au prochain tour si le coup n'est pas parre");  
				return degats; 
				}
				
			}
			} 			
			return 0;	
			}

	public static int defendre(Combattant c1, double attaque){

		
		double defense = 0;
		boolean action = false;
		Scanner sc = new Scanner(System.in);
		int b;	
		int f=0;
		
		do{
			System.out.println(" \n--------------- Trie des Capacites pouvant defendre ---------------");
			for(int i=0; i<c1.getSize(); i++){
				if (c1.getCapacite(i).getCanDef()==true)
					if(c1.getCapacite(i).getPBAD()*100<100)
						System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+c1.getCapacite(i).getPBAD()*100+ ") ............"+ i);
					else
						System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+"100"+ ") ............"+ i);
				f=i;
			} 
			
			System.out.println("\n Annuler........." +(f+1));
			System.out.println("Votre choix :"); 
			b = sc.nextInt();
			} while(b>f+1);
		
			if(b==f+1) return 1;	
			
			for(int i=0; i<c1.getSize(); i++){
				if (c1.getCapacite(i).getCanDef()==true && i==b){		
				if(estReussi(c1.getCapacite(b).getPBAD(), action)==true){ 
					defense=pourcentageAugmentation(c1.getCapacite(b).getEFFD());	  
					defense=defense-attaque;
										    
				if (defense>0){ 
					defense=0; 
					System.out.println("Votre bouclier s'est avere plus efficace que l'attaque avec une efficacite de "+c1.getCapacite(b).getEFFD()+"Vous avez parre le coup avec succes, vous avez "+ c1.getVIT()+"de vie"); 
				}
				else{   
					c1.setVIT((c1.getVIT()-(defense*-1)));
					System.out.println("Malgre votre parade reussie, vous avez encaisse " + defense*-1 + " de degats votre vie est donc de " + c1.getVIT()); 
				} 
			}

				else{ 
					c1.setVIT((c1.getVIT()-attaque)); 
					System.out.println("Vous n'avez pas reussi a parrer le coup, votre vie est maintenant de " + c1.getVIT() ) ; 
				}
				
				  }
				 
			} return 0;
		}
	
	public static int soigner(Combattant c1){

		double soin = 0;
		boolean action = false;
		Scanner sc = new Scanner(System.in);
		int b=0;
		int f=0;
		do{	
			System.out.println(" \n--------------- Trie des Capacites pouvant soigner ---------------");
			for (int i=0; i<c1.getSize(); i++){
				if (c1.getCapacite(i).getCanSoin()==true)
					if(c1.getCapacite(i).getPBAS()*100<100)
						System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+c1.getCapacite(i).getPBAS()*100+ ") ............"+ i); 
					else
						System.out.println(c1.getCapacite(i).getNom()+" (Chance de reussite "+"100"+ ") ............"+ i);
				f=i;
		} 
			System.out.println("\nAnnuler........." +(f+1));
			System.out.println("Votre choix :"); 
			b = sc.nextInt(); 
		} while(b>f+1);
		
		if(b==f+1) return 1;

		for(int i=0; i<c1.getSize(); i++){
				if (c1.getCapacite(i).getCanSoin()==true && i==b){		
				if(estReussi(c1.getCapacite(b).getPBAS(), action)==true){ 
					soin=pourcentageAugmentation(c1.getCapacite(b).getEFFS());
					c1.setVIT(c1.getVIT()+soin);
					if (c1.getVIT()>200 - (c1.getFOR() + c1.getDEX() + c1.getINT() + c1.getCON()) + c1.getEXP()*3-1)
					c1.setVIT(200 - (c1.getFOR() + c1.getDEX() + c1.getINT() + c1.getCON()) + c1.getEXP()*3-1);
										  
				System.out.println("Vous avez regenere "+c1.getCapacite(b).getEFFS()+" de vie, votre vitalite est maintenant de "+ c1.getVIT()+" de vie"); 
				}
				
				else{
					System.out.println("Vous n'avez pas reussi a vous soigner, votre vie est maintenant de " + c1.getVIT() ) ; 
				}	
			}				 
		} return 0;
	}

	public static void affichage(Combattant c1){
		
	System.out.println("\n\n"+c1.getNom()+" A vous de jouer \n Vie : "+c1.getVIT()+"\n Experience : "+c1.getEXP());
	
	}

	public static void combattre(Combattant c1, Combattant c2){

			double attaque=0;
		    Scanner sc = new Scanner(System.in);
			int c=0;
			boolean capituler1=false;
			boolean capituler2=false;
			int choixAction2;
			
			do 
			{                  
				boolean classeIncorrecte= true;
				if(c%2==0)
			do
			{
				
				affichage(c1);
				System.out.println("Que voulez vous faire ?\n1- Attaquer\n2- Defendre\n3- Vous soigner\n4- Capituler\n5- Ajouter une capacite");		
				choixAction2 = sc.nextInt(); 		
		
			switch(choixAction2)
			{
				case 1 :		
					if( attaque !=0){
						System.out.println("Vous avez subi " + attaque + " de degats");	
						c1.setVIT(((c1.getVIT())-attaque));
						attaque=0;
					}
					
					if(c1.getVIT()<0){			 
						classeIncorrecte = false; 
						break;
					}
					
				
				int g=0;
				
				for (int i=0; i<c1.getSize(); i++)
				{
					if (c1.getCapacite(i).getCanAtk()==true) 
						g++;	
					}	
					
					if(g>0){			
					attaque=attaquer(c1);
					}
					
					else{ 
						System.out.println("Vous n'avez pas de capacite vous permettant d'attaquer"); 
						break;
					}

				classeIncorrecte = false;
			
				break;
			
				case 2:		
					if(attaque > 0){
						int r=0;
						for (int i=0; i<c1.getSize(); i++)
						{	
							if (c1.getCapacite(i).getCanDef()==true) 
								r++;	
						}	
						if(r>0)			
						{ 
							if (defendre(c1,attaque)==1){
								c--; 
								break;
							} 
						}
			
						else{ 
							System.out.println("Vous n'avez pas de capacite vous permettant de vous defendre"); 
							c-- ;
						}
				 }
					
						else {System.out.println("Vous ne vous faites pas attaquer ! Vous n'avez pas besoin de defendre"); 
							c--;
				break;
				}

			attaque=0;

				case 3 :    
					if( attaque !=0){
						System.out.println("Vous avez subi " + attaque + " de degats");	
						c1.setVIT(((c1.getVIT())-attaque));
						attaque=0; 
						}
					if(c1.getVIT()<0){
						classeIncorrecte = false; 
						break; 
					}
		
					  int gz=0;
				for (int i=0; i<c1.getSize(); i++){
					if (c1.getCapacite(i).getCanSoin()==true) 
						gz++;	
					}	
					
					if(gz>0)			
						soigner(c1);
					else{ 
						System.out.println("Vous n'avez pas de capacite vous permettant de vous soigner"); 
						break;
					}
			
			  classeIncorrecte=false; 
			  break;

				case 4 : 
					capituler1=true; 
					classeIncorrecte = false;
					break;
			
				case 5 : 
					if(c1.getEXP()/2==6){
						System.out.println("Vous pouvez ajouter une capacite");
						creerCapacite(c1);
						c1.setEXP(1);
					}		
					else
						System.out.println("Vous ne pouvez pas ajouter de capacite");
			
					combattre(c1,c2);
			}

		 classeIncorrecte = false; 
		 break; 

		} while (classeIncorrecte); 

		else
			do 
			{   
				affichage(c2);
				System.out.println("Que voulez vous faire ?\n1- Attaquer\n2- Defendre\n3- Vous soigner\n4- Capituler\n5- Ajouter une capacite");	
				int choixAction = sc.nextInt();
			
			switch(choixAction){
			
				case 1 :        
					if( attaque > 0){
						System.out.println("Vous avez subi " + attaque + " de degats");	
						c2.setVIT(((c2.getVIT())-attaque));
						attaque=0; 
					}
					
					if(c2.getVIT()<0){ 
						classeIncorrecte = false; 
						break; 
					}
					
					int g=0;
					for (int i=0; i<c2.getSize(); i++){
							if (c2.getCapacite(i).getCanAtk()==true) 
							g++;	
							}	
					
					if(g>0)			
					{
						attaque=attaquer(c2);
					}
					else{
						System.out.println("Vous n'avez pas de capacite vous permettant d'attaque"); 
						break;
					}
					
			classeIncorrecte = false;
			break;

				case 2:
					if(attaque > 0)
					{ 
						int u=0;
						for (int i=0; i<c2.getSize(); i++){
							if (c2.getCapacite(i).getCanDef()==true) 
							u++;	
						}	
					
						if(u>0){	
							if(defendre(c2,attaque)==1){
								c--;
								break;
							}
						}
						else{ 
							System.out.println("Vous n'avez pas de capacite vous permettant de vous defendre"); 
							break;
						}
				 }
	
						else{
							System.out.println("Vous ne vous faites pas attaquer ! Vous n'avez pas besoin de defendre");
							c--; break;
						}
			attaque=0;
			
			classeIncorrecte = false ; break; 

				case 3 :   
					if( attaque > 0){
						System.out.println("Vous avez subi " + attaque + " de degats");	
						c2.setVIT(((c2.getVIT())-attaque));
						attaque=0; 
					}
					if(c2.getVIT()<0){ 
						classeIncorrecte = false;
						break; 
					}

					int ga=0;
					for (int i=0; i<c2.getSize(); i++){
						if (c2.getCapacite(i).getCanSoin()==true) 
						ga++;	
					}
					
					if(ga>0)			
						soigner(c2);
					else{ 
						System.out.println("Vous n'avez pas de capacite vous permettant de vous soigner"); 
						break;
					}
					
			 classeIncorrecte=false; 
			 break;

			
				case 4  : 
					capituler2 = true; 
					classeIncorrecte = false; 
					break; 
	
				case 5 : 
		
					if(c2.getEXP()/2==6){
						System.out.println("Vous pouvez ajouter une capacite");
						creerCapacite(c2);
						c1.setEXP(1);
					}
					else
						System.out.println("Vous ne pouvez pas ajouter de capacite");
					
					combattre(c2,c1);
				}

		} while (classeIncorrecte); 
	
	c++;

	} while(c1.getVIT()> 0 && c2.getVIT()>0 && capituler1==false && capituler2==false);

			if (c2.getVIT()<0 && c1.getVIT()>0)
				{ c1.setEXP(c1.getEXP()+1); System.out.println(c1.getNom() +" vous avez battu " + c2.getNom() + ", vous avez donc gagne 1 point d'experience, votre experience est de : " + c1.getEXP() ); }
			if (c1.getVIT()<0 && c2.getVIT()>0 )
				{ c2.setEXP(c2.getEXP()+1); System.out.println(c2.getNom() +" vous avez battu " + c1.getNom() + ", vous avez donc gagne 1 point d'experience, votre experience est de : " + c2.getEXP() ); }

			if (capituler2==true)
				{ c1.setEXP(c1.getEXP()+1); System.out.println(c2.getNom() +" vous avez capitule \n" + c1.getNom() + ", vous avez donc gagne 1 point d'experience, votre experience est de : " + c1.getEXP() ); }
			if (capituler1==true)
				{ c2.setEXP(c2.getEXP()+1); System.out.println(c1.getNom() +" vous avez capitule \n" + c2.getNom() + ", vous avez donc gagne 1 point d'experience, votre experience est de : " + c2.getEXP() );
		 } 

	
			else if (c2.getVIT()<0 && c1.getVIT()<0 ){
				System.out.println("\nVous vous etes entretues\n");
			}	
		 }

	public static void premierTour(Combattant c1, Combattant c2){
	
		int random = (int) ( Math.random() * 2 + 1); //random = 1 ou random = 2 pour savoir quel joueur commence en cas d'egalite
		
		c1.setVIT(200 - (c1.getFOR() + c1.getDEX() + c1.getINT() + c1.getCON()) + c1.getEXP()*3-1);
		System.out.println("Vitalite du premier combattant : " + c1.getVIT());
		
		c2.setVIT(200 - (c2.getFOR() + c2.getDEX() + c2.getINT() + c2.getCON()) + c2.getEXP()*3-1);
		System.out.println("Vitalite du deuxieme combattant : " + c2.getVIT()); 
		
		if(c1.getEXP() > c2.getEXP()){
			System.out.println("Le combattant qui commence est " + c1.getNom());
			combattre(c1,c2);  
		}
		else if(c2.getEXP() > c1.getDEX()){
			System.out.println("Le combattant qui commence est " + c2.getNom());
			combattre(c2,c1);
		}
		else
			System.out.println("Les deux combattants ont un niveau d'experience identique, on procede a un tirage au sort pour savoir lequel commence");
			if(random == 1){
				System.out.println("Le combattant qui commence est " + c1.getNom()); 
				combattre(c1,c2); 
				}
			else{
				 System.out.println("Le combattant qui commence est " + c2.getNom()); 
				combattre(c2,c1);
			}	
	}
	
	public static void menuPrincipal(ArrayList<Combattant> combattant) throws IOException{             
		
		boolean choixIncorrect=true;
		
		do { 
			System.out.println("\n--- Menu Principal ---\n\n1- Creer un combattant\n2- Charger la derniere sauvegarde\n3- Sauvegarder les combattants (ecrasera la derniere sauvagarde)\n4- Commencer un duel\n5- Quitter le jeu");
			Scanner sc = new Scanner(System.in);

			int c = sc.nextInt(); 
			switch(c) 
			{
				case 1 :
					Combattant a = creerCombattant(); 
					combattant.add(a); 
					choixIncorrect=false; 
					break;
				 
				case 2 : 
					combattant = charger();		

				case 3 : 
					for(int i=0; i<combattant.size();i++){ 			 
						sauvegarder(combattant);
					} 
					choixIncorrect=false; 
					break;

				case 4 : 
					int annuler=0; 
					if(combattant.size()>0) 
						do{					 
							System.out.println("Choisissez un premier combattant"); 
							for(int i=0; i<combattant.size();i++){
							System.out.print(i + "- " + (combattant.get(i).getNom() + "\n"));  
						} 	
							
					System.out.println((combattant.size() + "- Annuler"));
					c = sc.nextInt();
					if (c==combattant.size()){				 
						choixIncorrect=false; 
						break;
					}
					
					Combattant c1= combattant.get(c); 
					
					do{ 
						System.out.println("Choisissez un second combattant"); 
						for(int i=0; i<combattant.size();i++){
						System.out.print(i + "- " + (combattant.get(i).getNom() + "\n"));  	
					}
						
					System.out.println((combattant.size() + "- Annuler"));
					int f=0;
					do{  
						c=sc.nextInt();  
					if(c==combattant.size()){					 
						choixIncorrect=false; 
						break;
					} 
					f++; 
					} while (f==0);					
					} while(annuler != combattant.size() && c>combattant.size());
					
					if (c != combattant.size()){
						Combattant c2= combattant.get(c);
						premierTour(c1,c2);  
					}
					
					choixIncorrect=false; 
					break; 
					} while(c != combattant.size() && c>combattant.size());
					
					else 
						System.out.println("Vous n'avez cree aucun combattant ! "); 
						choixIncorrect=false; 
						break;
						
				case 5 : 
					choixIncorrect=false; System.exit(0); 
					break;  
					} 
			} while (choixIncorrect=true);
}
	
	public static void sauvegarder(Object c){
		
		try{			
			FileOutputStream fos= new FileOutputStream("Sauvegarder.txt");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(c);	
			oos.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public static ArrayList<Combattant>  charger() throws IOException{
		
		ArrayList<Combattant> list= new ArrayList<Combattant>();
		try{
			FileInputStream fis= new FileInputStream("Sauvegarder.txt");
			ObjectInputStream ois= new ObjectInputStream(fis);
			System.out.println("Succes");
			try{  
				ArrayList<Combattant> objet1=(ArrayList<Combattant>)ois.readObject();
			list = objet1;	
			ois.close();
			return list; 
			} 
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}       
		} 
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return list; 
		}

	public static void main(String[] args) throws IOException{

		
		ArrayList<Combattant>combattant = new ArrayList<Combattant>();		
		menuPrincipal(combattant);	
		}
	
	}



