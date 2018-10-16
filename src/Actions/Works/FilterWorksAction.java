package Actions.Works;

import Modals.Works.WorksFilterModel;
import Services.Works.ViewWorksService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

public class FilterWorksAction extends ActionSupport implements ModelDriven {

    WorksFilterModel wm = new WorksFilterModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException, ParseException {

        ViewWorksService viewWorksService = new ViewWorksService();

        String loadWorks = viewWorksService.filterWorks(wm);
        if (!loadWorks.equals("ERROR")) {

            inputStream = new ByteArrayInputStream(loadWorks.getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream(loadWorks.getBytes("UTF-8"));


        }


        return "OK";
    }

    @Override
    public Object getModel() {
        return wm;
    }
}
