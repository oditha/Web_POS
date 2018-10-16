package Actions.Products;

import Modals.Products.ProductsModel;
import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ProductSaveAction extends ActionSupport implements ModelDriven {

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

        ProductService productService = new ProductService();
        if (productService.saveProduct(pm)){

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
