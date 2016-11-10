import java.util.*;
import java.io.Serializable;

public class Remede extends Capacite implements Serializable {
	
	private static final boolean CANATK= false; //un remede ne peut pas attaquer
	private static final boolean CANDEF = false; //un remede ne peut pas defendre
	private static final boolean CANSOIN= true; //un remede peut soigner
	private double pui; //puissance
	private double fac; //facilite
	
	public Remede(){

		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.setCanSoin(CANSOIN);
		this.pui=0;
		this.fac=0;

	}
	
	public Remede(String s, int pui, int fac){
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
	
	public void initRemede(int a, int dex,int force){
	
		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.setCanSoin(CANSOIN);

		if(a==1){
			System.out.println("Vous avez chosii une Herbe guerissante \n");
			this.setNom("Herbe guerissante");
			this.pui=60;
			this.fac=40;	
		}
		
		if(a==2){
			System.out.println("Vous avez choisi une Potion de soin\n");
			this.setNom("Potion de soin");
			this.pui=50;
			this.fac=50;	
		}
		
			if(a==3){
				System.out.println("Vous avez choisi un Remede miracle\n");
				this.setNom("Remede miracle");
				this.pui=80;
				this.fac=20;
		}

		this.setPBAS(dex*this.fac/1000);
		this.setEFFS(force*this.pui/300);
	
	}
		
	public String toString(){
		return "\n\n"+super.toString()+"\nType :Remede \nPuissance :"+this.getPui() + "\nFacilite :" +this.getFac();
	}
}


