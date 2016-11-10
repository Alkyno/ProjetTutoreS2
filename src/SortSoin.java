import java.io.Serializable;

public class SortSoin extends Capacite implements Serializable {
	
	private static final boolean CANATK= false; //un sort de soin ne peut pas attaquer
	private static final boolean CANDEF = false; //un sort de soin ne peut pas soigner
	private static final boolean CANSOIN= true; //un sort de soin peut soigner
	private double pui; //puissance
	private double fac; //facilite
	
	public SortSoin(){

		this.setCanAtk(CANATK);
		this.setCanDef(CANDEF);
		this.setCanSoin(CANSOIN);
		this.pui=0;
		this.fac=0;
	}
	
	public SortSoin(String s, int pui, int fac){
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
	
	public void initSortSoin(int a, int in,int con){

		this.setCanAtk(CANATK);
		this.setCanSoin(CANSOIN);
		this.setCanDef(CANDEF);

		if(a==1){
			System.out.println("Vous avez choisi le sort Soins rapides \n");		
			this.setNom("Soins rapides");
			this.pui=50;
			this.fac=50;	
		}
		
		if(a==2){
			System.out.println("Vous avez choisi le sort Rajeunissement \n");		
			this.setNom("Rajeunissement");
			this.pui=70;
			this.fac=30;
		}
		
		if(a==3){
			System.out.println("Vous avez choisi le sort Vague de soins \n");		
			this.setNom("Vague de soins");
			this.pui=60;
			this.fac=40;
		}

		this.setPBAS(in*this.fac/2500);
		this.setEFFS(con*this.pui/100);
			
	}
		
	public String toString(){
		return "\n\n"+super.toString()+"\nType :Sort de Soin \nPuissance :"+this.getPui() + "\nFacilite :" +this.getFac();
	}
}


