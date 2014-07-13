package ws.abhis.apps.TheftDetector;

import java.io.IOException;

import junit.framework.TestCase;

public class GetIpAddressTest extends TestCase {
	public void testIp() throws IOException {
		GetIpAddress obj = new GetIpAddress();
		try {
			obj.getExternalIp();
			obj.getInternalIp();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
	}
}
