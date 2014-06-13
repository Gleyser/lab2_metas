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

	public ArrayList<Meta> metasASerAlcancadas() {
		return  retornaMetasDeAcordoComParamentroDeEntrada(EstadoDaMeta.ASERALCANCADA);
		
	}
	
	private ArrayList<Meta> retornaMetasDeAcordoComParamentroDeEntrada(EstadoDaMeta estado){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getEstado().equals(estado)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	public ArrayList<Meta> metasComPrioridadeAlta() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getPrioridade().equals(Prioridade.ALTA)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	public ArrayList<Meta> metasComPrioridadeMedia() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getPrioridade().equals(Prioridade.MEDIA)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	public ArrayList<Meta> metasComPrioridadeBaixa() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getPrioridade().equals(Prioridade.BAIXA)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	

}
