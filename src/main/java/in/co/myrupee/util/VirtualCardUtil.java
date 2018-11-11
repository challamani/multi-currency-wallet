package in.co.myrupee.util;

import in.co.myrupee.constant.SystemConstants;

import java.util.Random;

public class VirtualCardUtil {

    public static String getUniqueCardByCurrencyCode(String currencyCode){

        return  SystemConstants.V_CARD_INR.concat("-").concat(getRandomFourDigits()).concat("-").concat(getRandomFourDigits()).concat("-").concat(getRandomFourDigits());
    }

    private static String getRandomFourDigits(){

        return String.format("%04d", new Random().nextInt(10000));
    }
}
