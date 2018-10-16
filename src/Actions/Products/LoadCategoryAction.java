package Actions.Products;

import Services.Products.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class LoadCategoryAction extends ActionSupport {

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        CategoryService categoryService = new CategoryService();

        inputStream = new ByteArrayInputStream(categoryService.loadCategories().getBytes("UTF-8"));

        return "OK";
    }
}
