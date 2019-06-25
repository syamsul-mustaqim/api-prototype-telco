package syam.project.OutboundRestProduct;

public class Header
{
    private Paging paging;

    private Status status;

    public Paging getPaging ()
    {
        return paging;
    }

    public void setPaging (Paging paging)
    {
        this.paging = paging;
    }

    public Status getStatus ()
    {
        return status;
    }

    public void setStatus (Status status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [paging = "+paging+", status = "+status+"]";
    }
}