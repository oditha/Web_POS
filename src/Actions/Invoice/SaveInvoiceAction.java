package Actions.Invoice;

import Modals.Invoice.InvoiceModel;
import Services.GRN.AddGrnService;
import Services.Invoice.AddInvoiceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SaveInvoiceAction extends ActionSupport implements ModelDriven {

    InvoiceModel invoiceModel = new InvoiceModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return invoiceModel;
    }


    public String execute() throws UnsupportedEncodingException {

        AddInvoiceService service = new AddInvoiceService();

        if (service.saveInvoice(invoiceModel)) {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
