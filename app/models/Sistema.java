package models;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Meta> todasAsMetas;

	
	public Sistema(){
		this.todasAsMetas = new ArrayList<Meta>();
		
		
	}
	
	public void addMeta(Meta meta){
		this.todasAsMetas.add(meta);
	}

	public ArrayList<Meta> getTodasAsMetas() {
		return this.todasAsMetas;
	}

	public void setTodasAsMetas(ArrayList<Meta> todasAsMetas) {
		this.todasAsMetas = todasAsMetas;
	}
	
	/*public int numDeMetasNaSemana(IdentificadorDaSemana semana){
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
*/
	
}
