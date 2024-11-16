package org.example.demoforjjavaspringbootgradleone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.json.JSONException;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RespContainsMobileNoTest {

    private static final Logger log = LoggerFactory.getLogger(RespContainsMobileNoTest.class);

    String strJsonData = "{\n" +
            "    \"userNo\": null,\n" +
            "    \"userName\": \"오두선\",\n" +
            "    \"userId\": \"01068145143\",\n" +
            "    \"idType\": null,\n" +
            "    \"mobileNumber\": \"01068145143\",\n" +
            "    \"emailAddress\": null,\n" +
            "    \"userIdList\": [\n" +
            "      {\n" +
            "        \"userId\": \"doosun.acc.qa.1011@yopmail.com\",\n" +
            "        \"idType\": \"LGE\",\n" +
            "        \"displayUserId\": \"doosun.acc.qa.1011@yopmail.com\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"userId\": \"01068145143\",\n" +
            "        \"idType\": \"LGP\",\n" +
            "        \"displayUserId\": \"01068145143\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }";

    Object jsonBody = "{userNo=null, userName=오두선, userId=01068145143, idType=null, mobileNumber=01068145143, emailAddress=null, userIdList=[{userId=doosun.acc.qa.1011@yopmail.com, idType=LGE, displayUserId=doosun.acc.qa.1011@yopmail.com}, {userId=01068145143, idType=LGP, displayUserId=01068145143}]}";

    @Test
    public void ModifyMobileNo() {

        //String jsonResp = "{\"account\":{\"userNo\":null,\"userName\":\"ì\\u0098¤ë\\u0091\\u0090ì\\u0084 \",\"userId\":\"01068145143\",\"idType\":null,\"mobileNumber\":\"01068145143\",\"emailAddress\":null,\"userIdList\":[{\"userId\":\"doosun.acc.qa.1011@yopmail.com\",\"idType\":\"LGE\",\"displayUserId\":\"doosun.acc.qa.1011@yopmail.com\"},{\"userId\":\"01068145143\",\"idType\":\"LGP\",\"displayUserId\":\"01068145143\"}]}}";
        //String jsonResp = "{\"name\":\"John Doe\",\"contact\":{\"phone\":\"1234567890\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        Object jsonResp = "{\"name\":\"Doosun OH\",\"contact\":{\"phone\":\"01068145143\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        //String jsonResp = "{\"name\":\"Doosun OH\",\"contact\":{\"phone\":\"1068145143\",\"email\":\"doosun.acc.qa.1011@yopmail.com\"}}";
        String countryCode = "KR";

        JSONObject jsonObject = new JSONObject((Map) jsonResp);

        String jsonStr = jsonObject.toJSONString();

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

    }

    @Test
    public void getRidOfCntryNum() {

        String phoneNum = "{\"account\":{\"userNo\":null,\"userName\":\"오두선\",\"userId\":\"+821068145143\",\"idType\":null,\"mobileNumber\":\"+821068145143\",\"emailAddress\":null,\"userIdList\":[{\"userId\":\"doosun.acc.qa.1011@yopmail.com\",\"idType\":\"LGE\",\"displayUserId\":\"doosun.acc.qa.1011@yopmail.com\"},{\"userId\":\"+821068145143\",\"idType\":\"LGP\",\"displayUserId\":\"+821068145143\"}]}}";

        String cntryNum = "82";     // 국가번호
        String numOfDigit = "10";   // 몇자리

        String moblNoPattern = "\\+"+cntryNum+"(\\d{"+numOfDigit+"})"; // +제외 12자리

        //String moblNoPattern = "\\+82(\\d{10})"; // +82 제외 10자리
        //String moblNoPattern = "\\+91(\\d{10})"; // +91 제외 10자리
        //String moblNoPattern = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";
        //String moblNoPattern = "^\\+[1-9]{1}[0-9]{3,14}$";
        String removeCntryNum = "0$1";
        Pattern pattern = Pattern.compile(moblNoPattern);
        Matcher matcher = pattern.matcher(phoneNum);
        String clenanNumber = matcher.replaceAll(removeCntryNum);
        log.info("Result of Replacement : " + clenanNumber);

    }
    ///  "account":

    @Test
    public void getJsonStringToObject(){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Map map = mapper.readValue(objToStr, Map.class);
            Map map = mapper.readValue(strJsonData, Map.class);
            log.info("Result of Map ::: "+map);

            JSONObject jsonObject = new JSONObject(map);
            String jsonStr = jsonObject.toJSONString();
            log.info("Result of jsonStr ::: " + jsonStr);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}