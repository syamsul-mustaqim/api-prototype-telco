package syam.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunction {


    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public int getPN(String pageNo)
    {
        int X = Integer.parseInt(pageNo);
        if (X>0)
        {
            X=X-1;
            return X;
        }
        else
        {
            X=1;
            return X;
        }

    }

    public int getPR(String pageRow)
    {
        int Y = Integer.parseInt(pageRow);
        if (Y<1 || Y>10)
        {
            Y=10;
            return Y;
        }
        else
        {
            return Y;
        }

    }
}



