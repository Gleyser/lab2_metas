import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;

public class MetaTest {
	private Meta novaMeta;
	
	@Before
	public void CriaMeta(){
		novaMeta = new Meta("descricao", "ALTA", "SEMANA1");
	}
	
	@Test
	public void testaCriarMeta(){
		Assert.assertEquals("descricao", novaMeta.getDescricao());
		Assert.assertEquals("ALTA", novaMeta.getPrioridade());
		Assert.assertEquals("SEMANA1", novaMeta.getSemana());
		Assert.assertEquals("ASERALCANCADA", novaMeta.getEstado());
	}

}
