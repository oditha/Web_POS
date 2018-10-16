package Actions.Products;

import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class UnitLoadAllAction extends ActionSupport {

InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        ProductService ps = new ProductService();

        inputStream = new ByteArrayInputStream(ps.loadUnits().getBytes("UTF-8"));

        return "OK";
    }
}
