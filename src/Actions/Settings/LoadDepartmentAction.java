package Actions.Settings;

import Services.Settings.DespartmentService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LoadDepartmentAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws Exception{

        DespartmentService despartmentService = new DespartmentService();
        inputStream = new ByteArrayInputStream(despartmentService.LoadDepartments().getBytes("UTF-8"));

        return "OK";
    }


}
