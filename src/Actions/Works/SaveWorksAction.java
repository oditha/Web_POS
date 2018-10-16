package Actions.Works;

import Modals.Works.WorksModel;
import Services.Works.WorksService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SaveWorksAction extends ActionSupport implements ModelDriven {

    WorksModel wm = new WorksModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return wm;
    }

    public String execute() throws UnsupportedEncodingException {

        WorksService worksService = new WorksService();

        if (worksService.saveWorks(wm)){

            inputStream  = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }else {

            inputStream  = new ByteArrayInputStream("error".getBytes("UTF-8"));

        }

        return "OK";
    }

}
