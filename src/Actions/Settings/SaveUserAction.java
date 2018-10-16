package Actions.Settings;

import Modals.Settings.UserModel;
import Services.Settings.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SaveUserAction extends ActionSupport implements ModelDriven {

    UserModel um = new UserModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return um;
    }

    public String execute() throws UnsupportedEncodingException {

        UserService userService = new UserService();

        if (userService.saveUser(um)){

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
