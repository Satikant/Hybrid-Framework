package framework.mobiquityPayX.qnb.fetchOtp;

import com.aventstack.extentreports.ExtentTest;
import globalConstants.RequestType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import propertyManagement.ExecutionProperties;
import reportManagement.ExtentManager;

public class FetchOtp {
     static BaseClass baseClass = new BaseClass();
    protected static JsonPath fetchOtpResponse;
    protected static String otp , txnStatus ;
    public static String  fetchOTP(String msisdn) {
        ExtentTest node = ExtentManager.getTest();
        try {
            Response response = baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Get,
                    ExecutionProperties.getProperty("fetchOtp") + msisdn,
                    "", false);
            if(response.getStatusCode() != 200){
                node.fail("Response Status Code is : "+response.getStatusCode() + "  Reason : " + response.getStatusLine());
                throw new Exception("HttpResponseException + "+ response.getStatusLine());
            }
            System.out.println("RESPONSE :   "+response.asPrettyString());
            fetchOtpResponse = response.jsonPath();
            otp = fetchOtpResponse.get("otp");
            return otp;
        } catch (Exception e) {
           return e.toString();
        }
    }

}
