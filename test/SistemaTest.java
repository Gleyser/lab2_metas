import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;

public class SistemaTest {
	private Sistema sistema;
	private Meta novaMeta;
	private Meta novaMeta1;
	private Meta novaMeta2;
	private Meta novaMeta3;
	private Meta novaMeta4;
	
	@Before
	public void Iniciar(){
		sistema = new Sistema();
		novaMeta = new Meta("descricao", Prioridade.ALTA, IdentificadorDaSemana.SEMANA1);
		novaMeta2 = new Meta("descricao", Prioridade.MEDIA, IdentificadorDaSemana.SEMANA5);
		novaMeta3 = new Meta("descricao", Prioridade.BAIXA, IdentificadorDaSemana.SEMANA4);
		novaMeta4 = new Meta("descricao", Prioridade.ALTA, IdentificadorDaSemana.SEMANA3);
	}
	
	@Test
	public void testaAdicionarMetaNoSistema(){
		sistema.addMeta(novaMeta);
		Assert.assertEquals(1, sistema.getTodasAsSemanas().get(IdentificadorDaSemana.SEMANA1.getValor()).totalDeMetas());
		//Assert.assertEquals(novaMeta, sistema.getTodasAsSemanas().get(0));
		
		sistema.addMeta(novaMeta2);
		Assert.assertEquals(1, sistema.getTodasAsSemanas().get(IdentificadorDaSemana.SEMANA5.getValor()).totalDeMetas());
		
		sistema.addMeta(novaMeta3);
		Assert.assertEquals(1, sistema.getTodasAsSemanas().get(IdentificadorDaSemana.SEMANA4.getValor()).totalDeMetas());
		
		sistema.addMeta(novaMeta4);
		Assert.assertEquals(1, sistema.getTodasAsSemanas().get(IdentificadorDaSemana.SEMANA3.getValor()).totalDeMetas());
		
		
	}

}
