package ws.abhis.apps.TheftDetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class GetIpAddress {
	public String getExternalIp() throws IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));
			String ip = in.readLine();
			return ip;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					return e.getMessage();
				}
			}
		}
	}
	
	public String getInternalIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}
}
