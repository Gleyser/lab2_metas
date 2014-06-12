package models;

import java.util.ArrayList;

public class Semana {
	private ArrayList<Meta> todasAsMetas;
	private IdentificadorDaSemana identificador;
	
	public Semana(IdentificadorDaSemana identificadorDaSemana){
		this.identificador = identificadorDaSemana;
		this.todasAsMetas = new ArrayList<Meta>();
	}
	
	public void addMeta(Meta meta){
		this.todasAsMetas.add(meta);
	}
	
	// voltar e rever aqui
	public boolean removerMeta(Meta meta){
		if (this.todasAsMetas.contains(meta)){
			return this.todasAsMetas.remove(meta);
		} else {
			return false;
		}
		
	}
	
	public int totalDeMetas(){
		return this.todasAsMetas.size();
	}
	
	// falta total de metas por alcancar
	// falta total de metas alcancadas
	
	public boolean contenhoMeta(Meta metaAPesquisar){
		for (Meta meta : todasAsMetas){
			if (meta.equals(metaAPesquisar)){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Meta> getTodasAsMetas() {
		return todasAsMetas;
	}

	public void setTodasAsMetas(ArrayList<Meta> todasAsMetas) {
		this.todasAsMetas = todasAsMetas;
	}

	public IdentificadorDaSemana getIdentificador() {
		return identificador;
	}

	public void setIdentificador(IdentificadorDaSemana identificador) {
		this.identificador = identificador;
	}
	
	public ArrayList<Meta> metasAlcancadas(){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : todasAsMetas){
			if (meta.getEstado().equals(EstadoDaMeta.ALCANCADA)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	

}
