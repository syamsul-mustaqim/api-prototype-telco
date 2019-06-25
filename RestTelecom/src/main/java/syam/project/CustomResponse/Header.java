package syam.project.CustomResponse;

import syam.project.CustomValidation.ValidationResponse;

public class Header {

    private Object Paging;
    private Object Status;

    public Object getStatus() {
        return Status;
    }
    public Object getPaging() {
        return Paging;
    }


    public void setPaging(int pageNo, int pageRow, int totalPage, int totalRow)
    {
        pageNo = pageNo + 1;
        if (pageRow != 0) {
            HeaderPaging PP = new HeaderPaging();
            PP.setPageNo(pageNo);
            PP.setPageRow(pageRow);
            PP.setTotalPage(totalPage);
            PP.setTotalRow(totalRow);
            Paging = PP;
        }
        else
        {Paging = null;}
    }


    public void setStatus(int statusCode)
    {
        HeaderStatus SP = new HeaderStatus();
        ValidationResponse VR = new ValidationResponse();
        VR.getValidationReponse(statusCode);
        int i = VR.getResponseCode();
        String rc = Integer.toString(i);
        SP.setResponseCode(rc);
        SP.setResponseDetail(VR.getResponseDetail());
        SP.setResponseMessage(VR.getResponseMessage());
        this.Status = SP;
    }
}
