package syam.project.OutboundRestProduct;

public class ProductPojo
{
    private Header header;

    private Body body;

    public Header getHeader ()
    {
        return header;
    }

    public void setHeader (Header header)
    {
        this.header = header;
    }

    public Body getBody ()
    {
        return body;
    }

    public void setBody (Body body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [header = "+header+", body = "+body+"]";
    }
}