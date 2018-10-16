package Actions.Suppliers;

import Modals.Suppliers.SuppliersModel;
import Services.Suppliers.SupplierService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SupplierSaveAction extends ActionSupport implements ModelDriven {

    SuppliersModel sm = new SuppliersModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return sm;
    }

    public String execute() throws UnsupportedEncodingException {

        SupplierService supplierService = new SupplierService();

        if (supplierService.saveSupplier(sm)){

            inputStream = new ByteArrayInputStream("DONE".getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream("ERROR".getBytes("UTF-8"));

        }

        return "OK";
    }

}
