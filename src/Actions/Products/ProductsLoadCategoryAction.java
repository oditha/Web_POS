package Actions.Products;

import Modals.Settings.DepartmentModel;
import Services.Products.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ProductsLoadCategoryAction extends ActionSupport implements ModelDriven {

    InputStream inputStream;
    DepartmentModel dm = new DepartmentModel();

    @Override
    public Object getModel() {
        return dm;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {


        ProductService productService = new ProductService();

        inputStream = new ByteArrayInputStream(productService.loadCategories(dm).getBytes("UTF-8"));

        return "OK";

    }
}
