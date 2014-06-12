import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;

public class MetaTest {
	private Meta novaMeta;
	
	@Before
	public void CriaMeta(){
		novaMeta = new Meta("descricao", Prioridade.ALTA, Semana.SEMANA1);
	}
	
	@Test
	public void testaCriarMeta(){
		Assert.assertEquals("descricao", novaMeta.getDescricao());
		Assert.assertEquals(Prioridade.ALTA, novaMeta.getPrioridade());
		Assert.assertEquals(Semana.SEMANA1, novaMeta.getSemana());
		Assert.assertEquals(EstadoDaMeta.ASERALCANCADA, novaMeta.getEstado());
	}

}
