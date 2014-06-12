import org.junit.Test;

import models.Meta;

public class MetasTest {
	private Meta novaMeta;
	
	@Test
	public void testaCriaMeta(){
		novaMeta = new Meta("descrição", 1, 3);
	}

}
