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

	public Object numDeMetasAlcancadasNaSemana(IdentificadorDaSemana semana) {
		return this.todasAsSemanas.get(semana.getValor()).metasAlcancadas().size();
	}

	public Object numDeMetasASerAlcancadasNaSemana(IdentificadorDaSemana semana) {
		return this.todasAsSemanas.get(semana.getValor()).metasASerAlcancadas().size();
	}

	public void removerMeta(Meta meta) {
		this.todasAsSemanas.get(meta.getSemana().getValor()).removerMeta(meta);
		
	}

	public ArrayList<Meta> metasOrdenadasPorSemana() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metas = semana.getTodasAsMetas();
			for (Meta meta: metas){
				retorno.add(meta);
			}
		}
		return retorno;
	}

	public ArrayList<Meta> metasOrdenadasPorPrioridade() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		retorno.addAll(retornaMetasOrdenadasPelaPrioridadeAlta());
		retorno.addAll(retornaMetasOrdenadasPelaPrioridadeMedia());
		retorno.addAll(retornaMetasOrdenadasPelaPrioridadeBaixa());
		return retorno;
		
		/*for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeAlta = semana.metasComPrioridadeAlta();
			for (Meta meta: metasComPrioridadeAlta){
				retorno.add(meta);
			}
		}
		
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeMedia = semana.metasComPrioridadeMedia();
			for (Meta meta: metasComPrioridadeMedia){
				retorno.add(meta);
			}
		}
		
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeBaixa = semana.metasComPrioridadeBaixa();
			for (Meta meta: metasComPrioridadeBaixa){
				retorno.add(meta);
			}
		}
		return retorno;*/
	}
	
	private ArrayList<Meta> retornaMetasOrdenadasPelaPrioridadeAlta(){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeAlta = semana.metasComPrioridadeAlta();
			for (Meta meta: metasComPrioridadeAlta){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	private ArrayList<Meta> retornaMetasOrdenadasPelaPrioridadeMedia(){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeMedia = semana.metasComPrioridadeMedia();
			for (Meta meta: metasComPrioridadeMedia){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	private ArrayList<Meta> retornaMetasOrdenadasPelaPrioridadeBaixa(){
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Semana semana : this.todasAsSemanas){
			ArrayList<Meta> metasComPrioridadeBaixa = semana.metasComPrioridadeBaixa();
			for (Meta meta: metasComPrioridadeBaixa){
				retorno.add(meta);
			}
		}
		return retorno;
	}

	
}
