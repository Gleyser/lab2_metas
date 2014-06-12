package models;

public class Meta {
	private String descricao;
	private Prioridade prioridade;
	private Semana semana;
	private EstadoDaMeta estado;
			
	public Meta(String descricao, Prioridade prioridade, Semana semana){
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

	public Semana getSemana() {
		return semana;
	}

	public void setSemana(Semana semana) {
		this.semana = semana;
	}

	public EstadoDaMeta getEstado() {
		return estado;
	}

	public void setEstado(EstadoDaMeta estado) {
		this.estado = estado;
	}
	

}
