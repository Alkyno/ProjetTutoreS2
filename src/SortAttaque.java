import java.util.*;
import java.io.Serializable;

public class SortAttaque extends Capacite implements Serializable {
	
	private static final boolean CANATK= true; //un sort d'attaque peut attquer
	private static final boolean CANDEF = false; //un sort d'attaque ne peut pas defendre
	private static final boolean CANSOIN = false; //un sort d'attaque ne peut pas soigner
	private double pui; //puissance
	private double fac; //facilite

	
	public SortAttaque(){
		
		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.pui=0;
		this.fac=0;	

	}
	
	public SortAttaque(String s, int pui, int fac){
		super(s, CANATK, CANDEF, CANSOIN);
		this.pui = pui;
		this.fac = fac;
	}
	
	public double getPui(){
		return this.pui;
	}
	
	public void setPui(int pui){
		this.pui = pui;
	}
	
	public double getFac(){
		return this.fac;
	}
	
	public void setFac(int fac){
		this.fac = fac;
	}
	
	public void initSortAttaque(int a, int in,int con){
		
		this.setCanAtk(CANATK);
		this.setCanSoin(CANSOIN);
		this.setCanDef(CANDEF);
		
			if(a==1){
				System.out.println("Vous avez choisi la capacite Boule de feu \n");
				this.setNom("Boule de feu");
				this.pui=80;
				this.fac=20;
		}

		if(a==2){ 
			System.out.println("Vous avez choisi la capacite Eclair \n");
			this.setNom("Eclair");
			this.pui=50;
			this.fac=50;	
		}
		
		if(a==3){
			System.out.println("Vous avez choisi la capacite Pluie de meteores \n");
			this.setNom("Pluie de meteores");
			this.pui=65;
			this.fac=35;	
		}

		this.setPBA(in*this.fac/2500);
		this.setEFFA(con*this.pui/100);
			
	}

	public String toString(){
		return "\n\n"+super.toString()+"\nType :Sort d'attaque\nPuissance :"+this.getPui() + "\nFacilite :" +this.getFac() + "\nEfficacité :" +this.getEFFA();
	}
}


