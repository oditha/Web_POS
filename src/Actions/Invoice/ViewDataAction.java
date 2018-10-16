package Actions.Invoice;

import Modals.GRN.GrnModel;
import Modals.Invoice.InvoiceModel;
import Services.GRN.ViewGrnService;
import Services.Invoice.ViewInvoiceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ViewDataAction extends ActionSupport implements ModelDriven {

    InvoiceModel gm = new InvoiceModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return gm;
    }

    public String execute() throws UnsupportedEncodingException {


        ViewInvoiceService viewGrnService = new ViewInvoiceService();
        String grnData = viewGrnService.viewInvoiceData(gm);
        if (!grnData.equals("ERROR")) {

            inputStream = new ByteArrayInputStream(grnData.getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("ERROR".getBytes("UTF-8"));

        }

        return "OK";
    }

}
