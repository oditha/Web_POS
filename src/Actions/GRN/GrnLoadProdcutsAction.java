package Actions.GRN;

import Services.GRN.AddGrnService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class GrnLoadProdcutsAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        AddGrnService grnService = new AddGrnService();
        String products = grnService.loadProducts();
        if (!products.equals("ERROR")){

            inputStream = new ByteArrayInputStream(products.getBytes("UTF-8"));

        }

        return "OK";
    }

}
