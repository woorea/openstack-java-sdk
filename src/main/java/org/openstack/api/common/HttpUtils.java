package org.openstack.api.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtils {

	public static final void upload(String method, URL url, Map<String, String> headers, InputStream is) {
		
		try {

		    HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

		    urlc.setRequestMethod("PUT");

		    for(Map.Entry<String, String> entry : headers.entrySet()) {
		    	urlc.setRequestProperty(entry.getKey(), entry.getValue());
		    }

		    urlc.setUseCaches(false);

		    urlc.setChunkedStreamingMode(32768);

		    urlc.setDoInput(true);

		    urlc.setDoOutput(true);

		    OutputStream out = urlc.getOutputStream();

		    int bytesRead = 0;

		    byte b[] = new byte[32768];

		    while (bytesRead >= 0)

		    {

		      bytesRead = is.read(b);

		      if (bytesRead >= 0) out.write(b,0,bytesRead);

		    }

		    is.close();

		    out.close();

		    int code = urlc.getResponseCode();
		    
		    System.out.println(code);

		    urlc.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
