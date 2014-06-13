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
		return  retornaMetasComBaseNoEstado(EstadoDaMeta.ALCANCADA);
		
	}

	public ArrayList<Meta> metasASerAlcancadas() {
		return  retornaMetasComBaseNoEstado(EstadoDaMeta.ASERALCANCADA);
		
	}
	
	// Retorna de acordo com o estado que for passado na entrada
	private ArrayList<Meta> retornaMetasComBaseNoEstado(EstadoDaMeta estado){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getEstado().equals(estado)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	public ArrayList<Meta> metasComPrioridadeAlta() {
		return retornaMetasComBaseNaPrioridade(Prioridade.ALTA);
		
	}
	
	public ArrayList<Meta> metasComPrioridadeMedia() {
		return retornaMetasComBaseNaPrioridade(Prioridade.MEDIA);
		
	}
	
	public ArrayList<Meta> metasComPrioridadeBaixa() {
		return retornaMetasComBaseNaPrioridade(Prioridade.BAIXA);
		
	}
	
	// Retorna de acordo com a prioridade que for passado na entrada
	private ArrayList<Meta> retornaMetasComBaseNaPrioridade(Prioridade prioridade){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getPrioridade().equals(prioridade)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	

}
