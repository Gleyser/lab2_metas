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
	private Meta meta11;
	private Meta meta12;
	
	@Before
	public void Iniciar(){
		sistema = new Sistema();
		meta1 = new Meta("descricao0", Prioridade.ALTA, IdentificadorDaSemana.SEMANA1);
		meta2 = new Meta("descricao1", Prioridade.ALTA, IdentificadorDaSemana.SEMANA2);
		meta3 = new Meta("descricao2", Prioridade.MEDIA, IdentificadorDaSemana.SEMANA3);
		meta4 = new Meta("descricao3", Prioridade.BAIXA, IdentificadorDaSemana.SEMANA4);
		meta5 = new Meta("descricao4", Prioridade.ALTA, IdentificadorDaSemana.SEMANA5);
		meta11 = new Meta("descricao0", Prioridade.BAIXA, IdentificadorDaSemana.SEMANA1);
		meta12 = new Meta("descricao0", Prioridade.MEDIA, IdentificadorDaSemana.SEMANA1);
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
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA4));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA4).contenhoMeta(meta4));
		
		sistema.addMeta(meta5);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA5));
		Assert.assertTrue(sistema.getSemana(IdentificadorDaSemana.SEMANA5).contenhoMeta(meta5));
				
	}
	
	@Test
	public void testaNumTotalDeMetas(){
		sistema.addMeta(meta1);
		sistema.addMeta(meta11);
		sistema.addMeta(meta12);
		Assert.assertEquals(3, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
	}
	
	@Test
	public void testaNumTotalDeMetasAlcancadasNaSemana(){
		sistema.addMeta(meta1);
		meta11.setEstado(EstadoDaMeta.ALCANCADA);
		sistema.addMeta(meta11);
		meta12.setEstado(EstadoDaMeta.ALCANCADA);
		sistema.addMeta(meta12);
		Assert.assertEquals(3, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		Assert.assertEquals(2, sistema.numDeMetasAlcancadasNaSemana(IdentificadorDaSemana.SEMANA1));
	}
	
	@Test
	public void testaNumTotalDeMetasASerAlcancadasNaSemana(){
		sistema.addMeta(meta1);
		meta11.setEstado(EstadoDaMeta.ALCANCADA);
		sistema.addMeta(meta11);
		meta12.setEstado(EstadoDaMeta.ALCANCADA);
		sistema.addMeta(meta12);
		Assert.assertEquals(3, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		Assert.assertEquals(1, sistema.numDeMetasASerAlcancadasNaSemana(IdentificadorDaSemana.SEMANA1));
	}
	
	@Test
	public void testaRemoverMetas(){
		sistema.addMeta(meta1);
		sistema.addMeta(meta11);
		sistema.addMeta(meta12);
		Assert.assertEquals(3, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		sistema.removerMeta(meta1);
		Assert.assertEquals(2, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		sistema.removerMeta(meta11);
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
		sistema.removerMeta(meta3); // quando nao tem a meta, o metodo de remover nao faz nada
		Assert.assertEquals(1, sistema.numDeMetasNaSemana(IdentificadorDaSemana.SEMANA1));
	}
	
	@Test
	public void testaOrdenarPelaSemana(){
		sistema.addMeta(meta1);
		sistema.addMeta(meta4);
		sistema.addMeta(meta3);
		sistema.addMeta(meta5);
		sistema.addMeta(meta2);
		Assert.assertEquals(meta1, sistema.metasOrdenadasPorSemana().get(0));
		Assert.assertEquals(meta2, sistema.metasOrdenadasPorSemana().get(1));
		Assert.assertEquals(meta3, sistema.metasOrdenadasPorSemana().get(2));
		Assert.assertEquals(meta4, sistema.metasOrdenadasPorSemana().get(3));
		Assert.assertEquals(meta5, sistema.metasOrdenadasPorSemana().get(4));
	}

}
