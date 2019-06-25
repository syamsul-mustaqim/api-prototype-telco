package syam.project.OutboundRestProduct;

public class Product
{
    private String timeLimit;

    private String createdDate;

    private String updatedBy;

    private String createdBy;

    private String name;

    private String id;

    private String updatedDate;

    private String type;

    private String value;

    private String measurement;

    public String getTimeLimit ()
    {
        return timeLimit;
    }

    public void setTimeLimit (String timeLimit)
    {
        this.timeLimit = timeLimit;
    }

    public String getCreatedDate ()
    {
        return createdDate;
    }

    public void setCreatedDate (String createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy ()
{
    return updatedBy;
}

    public void setUpdatedBy (String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy ()
    {
        return createdBy;
    }

    public void setCreatedBy (String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUpdatedDate ()
    {
        return updatedDate;
    }

    public void setUpdatedDate (String updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getMeasurement ()
    {
        return measurement;
    }

    public void setMeasurement (String measurement)
    {
        this.measurement = measurement;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timeLimit = "+timeLimit+", createdDate = "+createdDate+", updatedBy = "+updatedBy+", createdBy = "+createdBy+", name = "+name+", id = "+id+", updatedDate = "+updatedDate+", type = "+type+", value = "+value+", measurement = "+measurement+"]";
    }
}