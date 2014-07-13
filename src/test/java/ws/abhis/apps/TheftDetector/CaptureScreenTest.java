package ws.abhis.apps.TheftDetector;

import java.awt.AWTException;
import java.io.IOException;

import junit.framework.TestCase;

public class CaptureScreenTest extends TestCase {
	public void testGetScreenShot() {
		CaptureScreen obj = new CaptureScreen();
		try {
			obj.getScreenShot("hello.png");
			assertTrue(true);
		} catch (AWTException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
