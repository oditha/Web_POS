package Actions.Products;

import Modals.Products.ProductsModel;
import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ProductViewAction extends ActionSupport implements ModelDriven {

    ProductsModel pm = new ProductsModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return pm;
    }

    public String execute() throws UnsupportedEncodingException {

        ProductService service = new ProductService();

        String product = service.viewProduct(pm);

        if (!product.equals("ERROR")){

            inputStream = new ByteArrayInputStream(product.getBytes("UTF-8"));

        }

        return "OK";
    }
}
