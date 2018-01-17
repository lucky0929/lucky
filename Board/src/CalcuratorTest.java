import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class CalcuratorTest {

	@Test
	public void testSum() {
		Calcurator c = new Calcurator();
		int result = (int)c.sum(100, 200);
		assertEquals(250, result);
	}
}
