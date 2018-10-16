package Actions.Invoice;

import Services.GRN.AddGrnService;
import Services.Invoice.AddInvoiceService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class LoadCustomersAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        AddInvoiceService invoiceService = new AddInvoiceService();
        String suppliers = invoiceService.loadCustomers();
        if (!suppliers.equals("ERROR")){

            inputStream = new ByteArrayInputStream(suppliers.getBytes("UTF-8"));

        }

        return "OK";
    }

}
