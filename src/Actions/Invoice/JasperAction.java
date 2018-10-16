package Actions.Invoice;

import Holder.InvoiceJasperHolder;
import Services.Invoice.AddInvoiceService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.JasperCompileManager;

import java.util.ArrayList;
import java.util.List;

public class JasperAction extends ActionSupport {

    private List<InvoiceJasperHolder> list = new ArrayList<>();

    public List<InvoiceJasperHolder> getList() {
        return list;
    }

    public void setList(List<InvoiceJasperHolder> list) {
        this.list = list;
    }

    public String execute() {


        try {

            list = AddInvoiceService.holder;
            JasperCompileManager.compileReportToFile("/Jasper/Invoice_web_pos.jrxml, /Jasper/Invoice_web_pos.jasper");


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";

        }

        return "OK";
    }

}
