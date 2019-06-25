package syam.project.OutboundRestProduct;


public class Body
{
    private Product[] product;

    public Product[] getProduct ()
    {
        return product;
    }

    public void setProduct (Product[] product)
    {
        this.product = product;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [product = "+product+"]";
    }
}