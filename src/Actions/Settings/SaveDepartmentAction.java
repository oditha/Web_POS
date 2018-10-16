package Actions.Settings;

import Modals.Settings.DepartmentModel;
import ORM.Department;
import Services.Settings.DespartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SaveDepartmentAction extends ActionSupport implements ModelDriven {

    DepartmentModel dm = new DepartmentModel();
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return dm;
    }


    public String execute() throws UnsupportedEncodingException {

        DespartmentService despartmentService = new DespartmentService();

        if (despartmentService.SaveDepatment(dm)){

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }

        return "OK";
    }

}
