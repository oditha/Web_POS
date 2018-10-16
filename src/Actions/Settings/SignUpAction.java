package Actions.Settings;

import Modals.Settings.SignUpModel;
import Services.Settings.SignUpService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SignUpAction extends ActionSupport implements ModelDriven {

    SignUpModel sm = new SignUpModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return sm;
    }

    public String execute() throws UnsupportedEncodingException {

        SignUpService signUpService = new SignUpService();

        if (signUpService.saveUser(sm)) {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";

    }

}
