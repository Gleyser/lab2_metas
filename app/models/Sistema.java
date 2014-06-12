package models;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Semana> todasAsSemanas;

	
	public Sistema(){
		this.todasAsSemanas = new ArrayList<Semana>();
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA1));
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA2));
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA3));
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA4));
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA5));
		this.todasAsSemanas.add(new Semana(IdentificadorDaSemana.SEMANA6));
		
	}
	
	public void addMeta(Meta meta){
		int identificador = meta.getSemana().getValor();
		this.todasAsSemanas.get(identificador).addMeta(meta);
	}

	public ArrayList<Semana> getTodasAsSemanas() {
		return todasAsSemanas;
	}

	public void setTodasAsSemanas(ArrayList<Semana> todasAsSemanas) {
		this.todasAsSemanas = todasAsSemanas;
	}
	
	public int numDeMetasNaSemana(IdentificadorDaSemana semana){
		return this.todasAsSemanas.get(semana.getValor()).totalDeMetas();
	}
	
	public Semana getSemana(IdentificadorDaSemana semana){
		return this.todasAsSemanas.get(semana.getValor());
	}
	
	
}
