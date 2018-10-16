package Actions.Invoice;

import Services.Invoice.AddInvoiceService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class LoadInvoiceNoAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        AddInvoiceService invoiceService = new AddInvoiceService();
        String invoice = invoiceService.genInvoiceNo();


        inputStream = new ByteArrayInputStream(invoice.getBytes("UTF-8"));

        return "OK";
    }

}
