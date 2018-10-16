package Actions.Works;

import Services.Works.ViewWorksService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class LoadAllEmpAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        ViewWorksService viewWorksService = new ViewWorksService();
        String s = viewWorksService.loadEmployees();

        if (!s.equals("ERROR")){

            inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));

        }

        return "OK";
    }
}
