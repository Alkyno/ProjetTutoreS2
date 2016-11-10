import java.io.Serializable;

public class Capacite implements Serializable {
	
	private String nom;
	
	private boolean canAtk; // la capacite peut-elle attaquer ?
	private boolean canDef; // la capacite peut-elle defendre ?
	private boolean canSoin; // la capacite peut-elle soigner ?
	
	private double pbaA; // probabilite de reussite attaque
	private double pbaD; // probabilite de reussite defense
	private double pbaS; // probabilite de reussite soin
	
	private double effA; // efficacite attaque
	private double effD; // efficacite defense
	private double effS; // efficacite soin
	
	public double getPBAA() { return this.pbaA; }
	public void setPBA(double a) {  this.pbaA=a; }

	public double getPBAD() { return this.pbaD; }
	public void setPBD(double a) {  this.pbaD=a; }
	
	public double getPBAS() { return this.pbaS; }
	public void setPBAS(double a) { this.pbaS=a; }

	public double getEFFA() { return this.effA; }
	public void setEFFA(double a) {  this.effA=a; }

	public double getEFFD() { return this.effD; }
	public void setEFFD(double a) {  this.effD=a; }
	
	public double getEFFS() { return this.effS; }
	public void setEFFS(double a) { this.effS=a; }
	
	public Capacite(){
		this.nom = "";
	}
	
	public Capacite(String s,boolean atk, boolean def, boolean soin){
		this.nom = s;
		this.canAtk = atk;
		this.canDef = def;
		this.canSoin=soin;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String s){
		this.nom = s;
	}
	
	public boolean getCanDef(){
		return this.canDef;
	}
	
	public void setCanDef(boolean def){
		this.canDef = def;
	}
	
	public boolean getCanAtk(){
		return this.canAtk;
	}
	
	public void setCanAtk(boolean atk){
		this.canAtk = atk;
	}

	public boolean getCanSoin(){
		return this.canSoin;
	}
	
	public void setCanSoin(boolean soin){
		this.canSoin = soin;
	}

	public String toString(){
		String s = "Nom :" + this.getNom() + "\nCategorie :";
		if(this.getCanAtk())
			s+= "Attaque ";
		else if(this.getCanDef())
			s+="Defense ";
		else if (this.getCanSoin())
			s+="Soin ";
		return s;
	}	
}
