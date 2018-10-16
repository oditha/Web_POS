package Actions.Customers;

import Modals.CustomerModel;
import Services.Customers.AddCustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class AddCustomersAction extends ActionSupport implements ModelDriven {

    CustomerModel cm = new CustomerModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return cm;
    }


    public String execute() throws UnsupportedEncodingException {

        AddCustomerService addCustomerService = new AddCustomerService();
        if (addCustomerService.saveCustomer(cm)){

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
