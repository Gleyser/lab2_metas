package models;

public enum Semana {
	SEMANA1(1), SEMANA2(2), SEMANA3(3), SEMANA4(4), SEMANA5(5), SEMANA6(6);

    private int valorDaSemana;

    Semana(int valor) {

            valorDaSemana = valor;

    }

    public int getValor() {

            return valorDaSemana;

    }       


}
