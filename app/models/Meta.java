package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Meta")
public class Meta {
	
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "META_SEQUENCE", sequenceName = "META_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	@Column	
	private String descricao;
	@Column
	private String prioridade;
	@Column
	private String semana;
	@Column
	private String estado;
	
	// Construtor vazio para o Hibernate criar os objetos
		public Meta(){
			this.estado = "ASERALCANCADA";
	}
			
	public Meta(String descricao, String prioridade, String semana){
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.semana = semana;
		this.estado = "ASERALCANCADA";
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void marcarComoAlcancada() {
		this.estado = "ALCANCADA";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((prioridade == null) ? 0 : prioridade.hashCode());
		result = prime * result + ((semana == null) ? 0 : semana.hashCode());
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
		Meta other = (Meta) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prioridade != other.prioridade)
			return false;
		if (semana != other.semana)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meta [descricao=" + descricao + ", prioridade=" + prioridade
				+ ", semana=" + semana + ", estado=" + estado + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
