import java.util.*;
import java.io.Serializable;

public class Bouclier extends Capacite implements Serializable {
	
	private static final boolean CANATK= true; //un bouclier peut attaquer
	private static final boolean CANDEF = true; //un bouclier peut defendre
	private static final boolean CANSOIN = false; //un bouclier ne peut pas soigner
	private int PRO; //protection
	private int MAN; //maniabilite	
	
	public Bouclier(){
		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.PRO=0;
		this.MAN=0;
	}
	
	public Bouclier(String s, int PRO, int MAN){
		super(s, CANATK, CANDEF, CANSOIN);
		this.PRO = PRO;
		this.MAN = MAN;
	}
	
	public double getPRO(){
		return this.PRO;
	}
	
	public void setPRO(int PRO){
		this.PRO = PRO;
	}
	
	public double getMAN(){
		return this.MAN;
	}
	
	public void setMAN(int MAN){
		this.MAN = MAN;
	}
	
	public void initBouclier(int a, double dex,double force){ // 3 boucliers disponibles
		this.setCanAtk(CANATK);
		this.setCanSoin(CANSOIN);
		this.setCanDef(CANDEF);
		
			if(a==1){
				System.out.println("Vous avez choisi un Bouclier normand \n");		
				this.setNom("Bouclier normand");
				this.PRO=60;
				this.MAN=40;
			}
		
			if(a==2){
				System.out.println("Vous avez choisi un Ecu \n");
				this.setNom("Ecu");
				this.PRO=40;
				this.MAN=60;	
			}
		
			if(a==3){
				System.out.println("Vous avez choisi un Pavois \n");
				this.setNom("Pavois");
				this.PRO=50;
				this.MAN=50;	
			}
		

		this.setPBA(dex*this.MAN/5000); // 10000 -> 5000
		this.setPBD(dex*this.MAN/2500); // 5000 -> 2500
		this.setEFFA(force*this.PRO/500);
		this.setEFFD(force*this.PRO/100); // 50 -> 500
		
	}
	
	
	public String toString(){
		return "\n\n"+super.toString()+"\nType :Bouclier\nProtection :"+this.getPRO() + "\nManiabilite :" +this.getMAN()+ "\nEfficacite :" +this.getEFFA();
	}
}
