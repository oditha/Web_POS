package Actions.LoginPage;

import ORM.Company;
import Services.LoginPage.ValidateStartupService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StartUpAction extends ActionSupport {

    static String companyname;
    public static String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    private InputStream is;

    public InputStream getIs() {
        return is;
    }


    public String execute() throws Exception {

        ValidateStartupService startup = new ValidateStartupService();

        if (startup.idateCompany()) {

            is = new ByteArrayInputStream("avb".getBytes("UTF-8"));


        } else {

            is = new ByteArrayInputStream("navb".getBytes("UTF-8"));


        }

        setCompanyname(new Company().getComapanyName());

//        String test = "TEXT AJAX";

        return "done";
    }
}
