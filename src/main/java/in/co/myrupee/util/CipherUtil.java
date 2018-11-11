package in.co.myrupee.util;


import in.co.myrupee.exception.NoSuchSystemUserException;
import in.co.myrupee.repository.ApplicationResource;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.logging.Logger;

public class CipherUtil {

    public static final Logger logger = Logger.getLogger("CipherUtil");

    public static String[] decodeBase64Str(String str) {
        return new String(Base64.getMimeDecoder().decode(str.getBytes())).split(":");
    }


    public static String getMessageDigest(String str) {

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte byteData[] = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }


    public static boolean basicAuthValidation(String[] credentials) throws NoSuchSystemUserException {

        logger.info("basic auth: " + credentials[0]);
        if (!ApplicationResource.SYSTEM_CREDENTIALS.containsKey(credentials[0])) {
            throw new NoSuchSystemUserException("SYSTEM_USER_NOT_FOUND", "System user NotFound");
        }
        return (CipherUtil.getSHA256Digest(credentials[1]).equals(ApplicationResource.SYSTEM_CREDENTIALS.get(credentials[0])));
    }



    public static String getSHA256Digest(String str) {

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            byte byteData[] = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

}
