package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Sistema")
public class Sistema {
	// Todo Id tem que ter o GeneratedValue a nÃ£o ser que ele seja setado
	@Id
	@SequenceGenerator(name = "SISTEMA_SEQUENCE", sequenceName = "SISTEMA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Meta> todasAsMetas;

	// Construtor vazio para o Hibernate criar os objetos
	public Sistema(){
		this.todasAsMetas = new ArrayList<Meta>();
				
	}
	
	public void addMeta(Meta meta){
		this.todasAsMetas.add(meta);
	}

	public List<Meta> getTodasAsMetas() {
		return this.todasAsMetas;
	}

	public void setTodasAsMetas(List<Meta> todasAsMetas) {
		this.todasAsMetas = todasAsMetas;
	}
	
	public boolean contenhoMeta(Meta meta){
		return this.todasAsMetas.contains(meta);
	}

	public int numDeMetasNaSemana(String semana) {
		return metasPorSemana(semana).size();
	}
	
	public ArrayList<Meta> metasPorSemana(String semana) {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getSemana().equals(semana)){
				retorno.add(meta);
			}
		}
		return retorno;
	}

	public Object numDeMetasAlcancadasNaSemana(String semana) {
		return MetasNaSemanaPorEstado(semana, "ALCANCADA").size();
	}
	
	public Object numDeMetasASerAlcancadasNaSemana(String semana) {
		return MetasNaSemanaPorEstado(semana, "ASERALCANCADA").size();
	}
	
	public ArrayList<Meta> MetasNaSemanaPorEstado(String semana, String estado) {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : metasPorSemana(semana)){
			if (meta.getEstado().equals(estado)){
				retorno.add(meta);
			}
		}
		return retorno;
	}
	
	// Quando a meta nao existe ele retorna falso
	public boolean removerMeta(Meta meta) {
		return this.todasAsMetas.remove(meta);
		
	}
	
	public ArrayList<Meta> metasOrdenadasPorSemana() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		retorno.addAll(metasPorSemana("SEMANA1"));
		retorno.addAll(metasPorSemana("SEMANA2"));
		retorno.addAll(metasPorSemana("SEMANA3"));
		retorno.addAll(metasPorSemana("SEMANA4"));
		retorno.addAll(metasPorSemana("SEMANA5"));
		retorno.addAll(metasPorSemana("SEMANA6"));
		return retorno;
	}
	
	public ArrayList<Meta> metasOrdenadasPorPrioridade() {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		retorno.addAll(metasComPrioridadeAlta());
		retorno.addAll(metasComPrioridadeMedia());
		retorno.addAll(metasComPrioridadeBaixa());
		return retorno;
	}
		
	public ArrayList<Meta> metasComPrioridadeAlta() {
		return metasPorPrioridade("ALTA");
	}
	
	public ArrayList<Meta> metasComPrioridadeMedia() {
		return metasPorPrioridade("MEDIA");
	}
	
	public ArrayList<Meta> metasComPrioridadeBaixa() {
		return metasPorPrioridade("BAIXA");
	}
	
	public ArrayList<Meta> metasPorPrioridade(String prioridade) {
		ArrayList<Meta> retorno = new ArrayList<Meta>();
		for (Meta meta : this.todasAsMetas){
			if (meta.getPrioridade().equals(prioridade)){
				retorno.add(meta);
			}
		}
		return retorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((todasAsMetas == null) ? 0 : todasAsMetas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (todasAsMetas == null) {
			if (other.todasAsMetas != null)
				return false;
		} else if (!todasAsMetas.equals(other.todasAsMetas))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
