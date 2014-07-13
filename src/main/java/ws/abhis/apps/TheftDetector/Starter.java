package ws.abhis.apps.TheftDetector;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Starter {
	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException, AWTException {
		ObjectMapper mapper = new ObjectMapper();
		ConfigType objConfigType = new ConfigType();
		objConfigType = mapper.readValue(new File("config.json"),
				ConfigType.class);

		String remoteAddress = objConfigType.getRemoteUri();
		
		URL url = new URL(remoteAddress);
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = "";
		String totText = "";
		while ((line = br.readLine()) != null) {
			totText += line;
		}
		if (totText.toLowerCase().trim().equals("true")) {
			CaptureScreen obj1 = new CaptureScreen();
			obj1.getScreenShot("latest.png");
			GetIpAddress obj2 = new GetIpAddress();

			SendEmail.sendEmail(objConfigType, obj2.getExternalIp(),
					obj2.getInternalIp());
		} else if (totText.toLowerCase().trim().equals("false")) {
			// do nothing
		}
		br.close();
	}

}
