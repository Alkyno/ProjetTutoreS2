import java.io.*;
import java.util.*;

public class Combattant implements Serializable{

	private String nom;
	
	private int FOR; // force physique
	private int DEX; // dexterite
	private int INT; // intelligence
	private int CON; // capacite de concentration
	
	private double VIT; // vitalite (nb points de vie) ; mort si VIT = 0
	private int EXP; // experience : augmente/diminue en cas de victoire/defaite [1-20]

	private ArrayList<Capacite> capacite = new ArrayList<Capacite>();

	public String getNom() { return this.nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	public int getFOR() { return this.FOR; }
	public void setFOR(int FOR) { this.FOR = FOR; }	
	
	public int getDEX() { return this.DEX; }
	public void setDEX(int DEX) { this.DEX = DEX; }
	
	public int getINT() { return this.INT; }
	public void setINT(int INT) { this.INT = INT; }
	
	public int getCON() { return this.CON; }
	public void setCON(int CON) { this.CON = CON; }
	
	public double getVIT() { return this.VIT; }
	public void setVIT(double VIT) { this.VIT = VIT; }
	
	public int getEXP() { return this.EXP; }
	public void setEXP(int EXP) { this.EXP = EXP; }

	public void setCapacite(Capacite cap) { this.capacite.add(cap) ; }
	
	public Capacite getCapacite (int a) { return this.capacite.get(a); }

	public String toString() {	
	return ("Force : " + this.getFOR() + "\n" + "Dexterite : " + this.getDEX() + "\n" + "Intelligence : " + this.getINT() + "\n" + "Concentration : " + this.getCON() + "\n" +  "Vitalite : " + this.getVIT() + "\n" + "Experience : " + this.getEXP() + "\n"); }

	public int getSize() { return this.capacite.size(); }
		
	}

	
