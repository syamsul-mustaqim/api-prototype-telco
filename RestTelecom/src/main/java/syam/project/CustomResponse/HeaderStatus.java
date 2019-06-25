package syam.project.CustomResponse;

import syam.project.CommonFunction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HeaderStatus {
    private String responseId;
    private String responseDate;
    private String responseCode;
    private String responseMessage;
    private String responseDetail;

    public String getResponseId() {
        this.responseId = "TRX-0001";
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getResponseDate() {
        CommonFunction CF = new CommonFunction();
        this.responseDate = CF.getCurrentTimeStamp();
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseDetail() {
        return responseDetail;
    }

    public void setResponseDetail(String responseDetail) {
        this.responseDetail = responseDetail;
    }


}
