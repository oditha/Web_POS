package Actions.Products;

import Modals.Products.CategoryModel;
import Services.Products.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ValidateCategoryCodeAction extends ActionSupport implements ModelDriven {

    CategoryModel cm = new CategoryModel();

    public InputStream getInputStream() {
        return inputStream;
    }

    private InputStream inputStream;

    @Override
    public Object getModel() {
        return cm;
    }

    public String execute() throws UnsupportedEncodingException {

        CategoryService categoryService = new CategoryService();
        if (categoryService.validateCategory(cm)) {
            System.out.println("A");
            inputStream = new ByteArrayInputStream("avb".getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("notavb".getBytes("UTF-8"));

        }


        return "OK";
    }

}
