import java.util.*;
import java.io.Serializable;

public class SortDefense extends Capacite implements Serializable {
	
	private static final boolean CANATK= false; //un sort de defense ne peut pas attaquer
	private static final boolean CANDEF = true; //un sort de defense peux defendre
	private static final boolean CANSOIN = false; //un sort de defense ne peut pas soigner
	private double pui; //puissance
	private double fac; //facilite
	
	public SortDefense(){

		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.pui=0;
		this.fac=0;	

	}
	
	public SortDefense(String s, int pui, int fac){
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
	
	public void initSortDefense(int a, int in,int con){
		
		this.setCanAtk(CANATK);
		this.setCanSoin(CANSOIN);
		this.setCanDef(CANDEF);
		
			if(a==1){
				System.out.println("Vous avez choisi le sort Barriere de glace \n");
				this.setNom("Barriere de glace");
				this.pui=80;
				this.fac=20;
		}

		if(a==2){
				System.out.println("Vous avez choisi le sort Purification \n");
				this.setNom("Purification");
				this.pui=70;
				this.fac=30;	
		}
		
		if(a==3){
				System.out.println("Vous avez choisi le sort Suppression de douleur\n");
				this.setNom("Suppression de douleur");
				this.pui=50;
				this.fac=50;	
		}

		this.setPBD(in*this.fac/2500);
		this.setEFFD(con*this.pui/100);
					
	}
		
	public String toString(){
		return "\n\n"+super.toString()+"\nType :Sort de Defense \nPuissance :"+this.getPui() + "\nFacilite :" +this.getFac()+ "\nEfficacité :" +this.getEFFA();
	}
}


