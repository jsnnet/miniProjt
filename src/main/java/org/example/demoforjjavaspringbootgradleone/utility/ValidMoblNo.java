package org.example.demoforjjavaspringbootgradleone.utility;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ValidMoblNo {

    public static boolean isPhoneNumberId(String userId){

        /* KR 이면 ASIS */
        //String moblNoPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
        //String moblNoPattern = "^0(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        String moblNoPattern = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
        if(Pattern.matches(moblNoPattern, userId)){
            return true;
        }else {
            return false;
        }
    }

    public static String getRidOfCountryNumber(String countryCode, String jsonString){

        /*
        * params
        *   String countryInfo
        *   String jsonString
        * */

        String clenanNumber = null;

        if(!countryCode.equals("KR")) {

            String moblNoPattern = "\\b(\\d{11})\\b";         // 번호 11자리
            String internationalFormat = "+91-$1";
            Pattern pattern = Pattern.compile(moblNoPattern);
            Matcher matcher = pattern.matcher(jsonString);
            clenanNumber = matcher.replaceAll(internationalFormat);
            log.info("Result of Replacement : " + clenanNumber);

            //log.info("Result of Replacement : " + jsonString);
            ////Pattern pattern = Pattern.compile("^(\\+\\d{1,3}|\\d{1,3})");
            //String moblNoPattern = "\\+"+"82"+"\\b(\\d{11})\\b";         // 번호 11자리
            //Pattern pattern = Pattern.compile(moblNoPattern);
            //Matcher matcher = pattern.matcher(jsonString);
            //String removeNum = "0$1";
            //clenanNumber = matcher.replaceAll(removeNum); // 특수문자 포함 판단
            //log.info("Result of Replacement : " + clenanNumber);

        }
        return clenanNumber;
    }
}
