package syam.project.OutboundRestProduct;

public class Paging
{
    private String pageRow;

    private String totalRow;

    private String pageNo;

    private String totalPage;

    public String getPageRow ()
    {
        return pageRow;
    }

    public void setPageRow (String pageRow)
    {
        this.pageRow = pageRow;
    }

    public String getTotalRow ()
    {
        return totalRow;
    }

    public void setTotalRow (String totalRow)
    {
        this.totalRow = totalRow;
    }

    public String getPageNo ()
    {
        return pageNo;
    }

    public void setPageNo (String pageNo)
    {
        this.pageNo = pageNo;
    }

    public String getTotalPage ()
    {
        return totalPage;
    }

    public void setTotalPage (String totalPage)
    {
        this.totalPage = totalPage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pageRow = "+pageRow+", totalRow = "+totalRow+", pageNo = "+pageNo+", totalPage = "+totalPage+"]";
    }
}
