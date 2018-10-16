package Actions.Products;

import Modals.Products.ProductsFilterModel;
import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ProductsFilterAction extends ActionSupport implements ModelDriven {

    ProductsFilterModel pf = new ProductsFilterModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return pf;
    }

    public String execute() throws UnsupportedEncodingException {

        ProductService service = new ProductService();
        String filter = service.productsFilter(pf);
        if (!filter.equals("ERROR")) {
            System.out.println(filter);
            inputStream = new ByteArrayInputStream(filter.getBytes("UTF-8"));

        }

        return "OK";
    }

}
