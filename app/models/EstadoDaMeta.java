package models;

public enum EstadoDaMeta {
	ASERALCANCADA(1), ALCANCADA(2);

    private int valorDoEstado;

    EstadoDaMeta(int valor) {

            valorDoEstado = valor;

    }

    public int getValor() {

            return valorDoEstado;

    }       
	
}
