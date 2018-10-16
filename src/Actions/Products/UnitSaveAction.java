package Actions.Products;

import Modals.Products.UnitModal;
import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class UnitSaveAction extends ActionSupport implements ModelDriven {

    UnitModal um = new UnitModal();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return um;
    }

    public String execute() throws UnsupportedEncodingException {

        ProductService productService = new ProductService();

        if (productService.saveUnit(um)) {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
