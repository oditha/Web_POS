package Actions.LoginPage;

import Modals.LoginPage.CompanyStartupModel;
import Services.LoginPage.SaveStartupService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLOutput;

public class SaveCompanyAction extends ActionSupport implements ModelDriven<CompanyStartupModel> {

    CompanyStartupModel cms = new CompanyStartupModel();

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }


    @Override
    public CompanyStartupModel getModel() {
        System.out.println("GET MODEL");
        return cms;
    }

    @Override
    public void validate() {
        System.out.println("VALIDATE");
        if (!cms.getPassword().equals(cms.getRepassword())) {

            addFieldError("repassword", "Password mismatch");

        }


    }

    @Override
    public String execute() throws Exception {
        System.out.println("EXECUTE");
        String Status = "error";

        SaveStartupService service = new SaveStartupService();

        if (service.save(cms)) {

            Status = "done";

        }

        inputStream = new ByteArrayInputStream(Status.getBytes("UTF-8"));
        System.out.println(Status);
        return Status;
    }


}
