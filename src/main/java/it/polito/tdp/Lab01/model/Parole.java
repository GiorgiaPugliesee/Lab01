package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	List<String> parole;
		
	public Parole() {
		parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		
		return parole;
	}
	
	public void reset() {
		this.parole.clear();
	}
	
	public void removeParola(String p) {
		this.parole.remove(p);
	}

}