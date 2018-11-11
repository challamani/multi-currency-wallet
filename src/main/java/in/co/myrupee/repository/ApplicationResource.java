package in.co.myrupee.repository;

import com.google.gson.Gson;
import in.co.myrupee.model.SystemProperties;
import in.co.myrupee.model.TokenInfo;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Logger;

@Component
public class ApplicationResource {


    private static final Logger logger = Logger.getLogger(ApplicationResource.class.getName());
    public static HashMap<String, String> SYSTEM_CREDENTIALS = new HashMap<>();
    public static HashMap<String, TokenInfo> ACTIVE_TOKENS = new HashMap<>();

    private SystemProperties systemProperties;

    public ApplicationResource() throws Exception {
        StringBuffer jsonStr = new StringBuffer();

        try {
            logger.info("System Resource loading ::" + Calendar.getInstance().getTime());
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/systemResources.json")));

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                jsonStr.append(oneLine);
            }
            logger.info("System Resource ::" + jsonStr);
        } catch (IOException e) {
            logger.info(e.getMessage());
            throw e;
        }

        systemProperties = new Gson().fromJson(jsonStr.toString(), SystemProperties.class);
        SYSTEM_CREDENTIALS = systemProperties.getSystemCredentials();
        logger.info("System credentials & service codes are loaded :: " + Calendar.getInstance().getTime());
    }

}
