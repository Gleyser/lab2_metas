package models;

public enum IdentificadorDaSemana {
	SEMANA1(0), SEMANA2(1), SEMANA3(2), SEMANA4(3), SEMANA5(4), SEMANA6(5);

    private int valorDaSemana;

    IdentificadorDaSemana(int valor) {

            valorDaSemana = valor;

    }

    public int getValor() {

            return valorDaSemana;

    }       


}
