package Actions.Products;

import Modals.Products.CategoryModel;
import Services.Products.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SaveCategoryAction extends ActionSupport implements ModelDriven {

    CategoryModel cm = new CategoryModel();

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }


    @Override
    public Object getModel() {
        return cm;
    }

    public String execute() throws UnsupportedEncodingException {

        CategoryService categoryService = new CategoryService();

        if (categoryService.save(cm)) {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));


        }else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
