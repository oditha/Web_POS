package Actions.Settings;

import Modals.Settings.DepartmentModel;
import Services.Settings.DespartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DeleteDepartmentAction extends ActionSupport implements ModelDriven {

    DepartmentModel dm = new DepartmentModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws Exception{

        DespartmentService despartmentService = new DespartmentService();
        if (despartmentService.delete(dm)){

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }


        return "OK";
    }

    @Override
    public Object getModel() {
        return dm;
    }
}
