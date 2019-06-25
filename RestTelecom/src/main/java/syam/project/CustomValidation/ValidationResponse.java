package syam.project.CustomValidation;

public class ValidationResponse {

    int ResponseCode;
    String ResponseMessage;
    String ResponseDetail;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }

    public String getResponseDetail() {
        return ResponseDetail;
    }

    public void setResponseDetail(String responseDetail) {
        ResponseDetail = responseDetail;
    }

    public void getValidationReponse(int statusCode) {

        if (statusCode == 0)
        {
            setResponseCode(0);
            setResponseMessage("SUCCESS");
            setResponseDetail("Successfully Executed");
        }
        else if (statusCode == 100) {
            setResponseCode(100);
            setResponseMessage("ERROR");
            setResponseDetail("Invalid Authorization");
        }
        else if (statusCode == 701) {

            setResponseCode(701);
            setResponseMessage("ERROR");
            setResponseDetail("Invalid Date Format, Accepted YYYY-MM-DD HH24:mm:ss");
        }
    }
}
