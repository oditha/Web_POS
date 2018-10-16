package Actions.LoginPage;

import Modals.LoginPage.LoginModal;
import Services.LoginPage.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginAction extends ActionSupport implements ModelDriven,SessionAware {

    LoginModal lm = new LoginModal();
//    Map<String,Object> httpsesson = new HashMap<>();
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }


    @Override
    public Object getModel() {
        return lm;
    }

    @Override
    public void setSession(Map<String, Object> map) {

        LoginService.httpsesson = map;

    }

    public void validate(){



    }

    public String execute() throws Exception{

        LoginService loginService = new LoginService();
        if (loginService.LoginCheck(lm)){
            System.out.println("LOGGED");
            return "OK";

        }


        return "ERROR";
    }
}
