package org.example.demoforjjavaspringbootgradleone;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RespContainsMobileNoTest {

    private static final Logger log = LoggerFactory.getLogger(RespContainsMobileNoTest.class);

    @Test
    public void ModifyMobileNo() {

        //String jsonResp = "{\"account\":{\"userNo\":null,\"userName\":\"ì\\u0098¤ë\\u0091\\u0090ì\\u0084 \",\"userId\":\"01068145143\",\"idType\":null,\"mobileNumber\":\"01068145143\",\"emailAddress\":null,\"userIdList\":[{\"userId\":\"doosun.acc.qa.1011@yopmail.com\",\"idType\":\"LGE\",\"displayUserId\":\"doosun.acc.qa.1011@yopmail.com\"},{\"userId\":\"01068145143\",\"idType\":\"LGP\",\"displayUserId\":\"01068145143\"}]}}";
        //String jsonResp = "{\"name\":\"John Doe\",\"contact\":{\"phone\":\"1234567890\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        String jsonResp = "{\"name\":\"Doosun OH\",\"contact\":{\"phone\":\"01068145143\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        //String jsonResp = "{\"name\":\"Doosun OH\",\"contact\":{\"phone\":\"1068145143\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        String countryCode = "KR";

        try {
            JSONObject jsonObject = new JSONObject(jsonResp);

            String jsonStr = jsonObject.toString();

            //String moblNoPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
            //String moblNoPattern = "^0(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
            //String moblNoPattern = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
            /* 11자리 */
            String moblNoPattern = "\\b(\\d{11})\\b";

            String internationalFormat = "+91-$1";

            Pattern pattern = Pattern.compile(moblNoPattern);

            Matcher matcher = pattern.matcher(jsonStr);

            String updateJsonStr = matcher.replaceAll(internationalFormat);

            log.info("Updated Result"+updateJsonStr);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}