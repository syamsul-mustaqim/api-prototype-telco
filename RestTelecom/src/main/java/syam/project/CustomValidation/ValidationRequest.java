package syam.project.CustomValidation;

public class ValidationRequest {

    public int ValCustomerDate (String startDate, String endDate)
    {

        int results = 0;
        String regexDate = "[0-9]{4}\\-(01|02|03|04|05|06|07|08|09|10|11|12)\\-[0-3]{1}[0-9]{1} ([0-1]{1}[0-9]{1}|2[0-4]{1})\\:[0-9]{2}\\:[0-9]{2}";
        boolean a =startDate.matches(regexDate);
        boolean b = endDate.matches(regexDate);

        if (a==false||b==false)
        {
            results = 701;
            return results ;
        }
        return results ;
    }

}


