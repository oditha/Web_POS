package Actions.Products;

import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ProductsLoadAllAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        ProductService productService = new ProductService();

        if (!productService.loadAllProducts().equals("ERROR")) {

            inputStream = new ByteArrayInputStream(productService.loadAllProducts().getBytes("UTF-8"));

        }
        return "OK";
    }
}
