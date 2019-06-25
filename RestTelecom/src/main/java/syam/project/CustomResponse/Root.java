package syam.project.CustomResponse;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

    private Object Header;
    private Object Body;


    public Object getHeader() {
        return Header;
    }
    public Object getBody() { return Body; }


    public void setResponseBody(Object body)
    {
        Content CT = new Content();
        CT.setContent(body);
        CT.getContent();
        this.Body = CT;
    }
    public void setResponseHeader(int statusCode, int pageNo, int pageRow, int totalPage, int totalRow) {
        Header RH = new Header();
        RH.setPaging(pageNo,pageRow,totalPage, totalRow);
        RH.setStatus(statusCode);
        this.Header =RH;
    }




}
