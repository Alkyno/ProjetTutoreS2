import java.io.Serializable;
import java.util.*;

	public class Arme extends Capacite implements Serializable  {
	
	private static final boolean CANATK= true; //une arme peut attaquer
	private static final boolean CANDEF = true; //une arme peut defendre
	private static final boolean CANSOIN = false; // une arme ne peut pas soigner
	private int IMP; //impact
	private int MAN; //maniabilite	
	
	public Arme(){
		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.IMP=0;
		this.MAN=0;

	}
	public Arme(String s, int IMP, int MAN) {
		super(s, CANATK, CANDEF, CANSOIN);
		this.IMP = IMP;
		this.MAN = MAN;
	}
	
	public double getIMP(){
		return this.IMP;
	}
	
	public void setIMP(int IMP){
		this.IMP = IMP;
	}
	
	public double getMAN(){
		return this.MAN;
	}
	
	public void setMAN(int MAN){
		this.MAN = MAN;
	}
	
	public void initArme(int a, double dex,double force){ // 5 armes disponibles dont 1 secrete
		
		this.setCanAtk(CANATK);
		this.setCanSoin(CANSOIN);
		this.setCanDef(CANDEF);
		
			if(a==1){
				System.out.println("Vous avez choisi un Arc \n");
				this.setNom("Arc");
				this.IMP=65;
				this.MAN=25;
			}

			if(a==2){
				System.out.println("Vous avez choisi un Baton \n");
				this.setNom("Baton");
				this.IMP=70;
				this.MAN=30;	
			}
		
			if(a==3){
				System.out.println("Vous avez choisi une Dague \n");
				this.setNom("Dague");
				this.IMP=65;
				this.MAN=35;	
			}	
		
			if(a==4){
				System.out.println("Vous avez choisi une Epee \n");
				this.setNom("Epee");
				this.IMP=60;
				this.MAN=40;	
			}
		
			if(a==5){
				System.out.println("Vous avez choisi une Hache \n");
				this.setNom("Hache");
				this.IMP=80;
				this.MAN=20;	
			}
			
		this.setPBA(dex*this.MAN/2000);
		this.setPBD(dex*this.MAN/2500);
		this.setEFFA(force*this.IMP/50);
		this.setEFFD(force*this.IMP/500);

			if (a==999){ // arme secrete
				System.out.println("Vous avez debloque l'arme de destruction massive\n");
				this.setNom("Arme secrete de destruction massive");
				this.IMP=80;
				this.MAN=20;	
		
		this.setPBA(100);
		this.setPBD(100);
		this.setEFFA(100);
		this.setEFFD(100);   
	}	
	}
	
	public String toString(){
		return "\n\n"+super.toString()+"\nType :Arme\nImpact :"+this.getIMP() + "\nManiabilite :" +this.getMAN()+ "\nEfficacite :" +this.getEFFA();
	}
	}
