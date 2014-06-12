package models;

public enum Prioridade {	

        ALTA(1), MEDIA(2), BAIXA(3);

        private int valorDePrioridade;

        Prioridade(int valor) {

                valorDePrioridade = valor;

        }

        public int getValor() {

                return valorDePrioridade;

        }       

}
