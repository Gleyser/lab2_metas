import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;

public class SistemaTest {
	private Sistema sistema;
	private Meta meta1;
	private Meta meta2;
	private Meta meta3;
	private Meta meta4;
	private Meta meta5;
	
	@Before
	public void Iniciar(){
		sistema = new Sistema();
		meta1 = new Meta("descricao0", Prioridade.ALTA, IdentificadorDaSemana.SEMANA1);
		meta2 = new Meta("descricao1", Prioridade.ALTA, IdentificadorDaSemana.SEMANA2);
		meta3 = new Meta("descricao2", Prioridade.MEDIA, IdentificadorDaSemana.SEMANA3);
		meta4 = new Meta("descricao3", Prioridade.BAIXA, IdentificadorDaSemana.SEMANA4);
		meta5 = new Meta("descricao4", Prioridade.ALTA, IdentificadorDaSemana.SEMANA5);
	}
	
	@Test
	public void testaAdicionarMetaNoSistema(){
		sistema.addMeta(meta1);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA1).contenhoMeta(meta1));
		
		sistema.addMeta(meta2);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA2));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA2).contenhoMeta(meta2));
		
		sistema.addMeta(meta3);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA3));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA3).contenhoMeta(meta3));
		
		sistema.addMeta(meta4);
		Assert.assertEquals(1, sistema.getTodasAsSemanas().get(IdentificadorDaSemana.SEMANA4.getValor()).totalDeMetas());
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA4).contenhoMeta(meta4));
		
		sistema.addMeta(meta5);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA5));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA5).contenhoMeta(meta5));
		
		
	}

}
