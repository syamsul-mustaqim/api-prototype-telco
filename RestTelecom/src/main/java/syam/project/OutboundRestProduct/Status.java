package syam.project.OutboundRestProduct;

public class Status
{
    private String responseMessage;

    private String responseDate;

    private String responseDetail;

    private String responseId;

    private String responseCode;

    public String getResponseMessage ()
    {
        return responseMessage;
    }

    public void setResponseMessage (String responseMessage)
    {
        this.responseMessage = responseMessage;
    }

    public String getResponseDate ()
    {
        return responseDate;
    }

    public void setResponseDate (String responseDate)
    {
        this.responseDate = responseDate;
    }

    public String getResponseDetail ()
    {
        return responseDetail;
    }

    public void setResponseDetail (String responseDetail)
    {
        this.responseDetail = responseDetail;
    }

    public String getResponseId ()
    {
        return responseId;
    }

    public void setResponseId (String responseId)
    {
        this.responseId = responseId;
    }

    public String getResponseCode ()
    {
        return responseCode;
    }

    public void setResponseCode (String responseCode)
    {
        this.responseCode = responseCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [responseMessage = "+responseMessage+", responseDate = "+responseDate+", responseDetail = "+responseDetail+", responseId = "+responseId+", responseCode = "+responseCode+"]";
    }
}