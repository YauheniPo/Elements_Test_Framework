package popo.elems.framework.util;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Log4j2
public class NetworkHelper {

    public static boolean netIsAvailable(String stageUrl) {
        try {
            final URL url = new URL(stageUrl);
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            log.info("Network connection is available.");
            return true;
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.info("Network connection does not available.");
            return false;
        }
    }
}
