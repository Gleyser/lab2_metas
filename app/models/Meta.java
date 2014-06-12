package models;

public class Meta {
	private String descricao;
	private Prioridade prioridade;
	private IdentificadorDaSemana semana;
	private EstadoDaMeta estado;
			
	public Meta(String descricao, Prioridade prioridade, IdentificadorDaSemana semana){
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.semana = semana;
		this.estado = EstadoDaMeta.ASERALCANCADA;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public IdentificadorDaSemana getSemana() {
		return semana;
	}

	public void setSemana(IdentificadorDaSemana semana) {
		this.semana = semana;
	}

	public EstadoDaMeta getEstado() {
		return estado;
	}

	public void setEstado(EstadoDaMeta estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		if (prioridade != other.prioridade)
			return false;
		if (semana != other.semana)
			return false;
		return true;
	}
	
	

}
