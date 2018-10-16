package Actions.GRN;

import Services.GRN.ViewGrnService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class LoadAllGrnAction extends ActionSupport{

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        ViewGrnService service = new ViewGrnService();
        String viewAllGrn = service.viewAllGrn();

        if (!viewAllGrn.equals("ERROR")){

            inputStream = new ByteArrayInputStream(viewAllGrn.getBytes("UTF-8"));

        }else {

            inputStream = new ByteArrayInputStream(viewAllGrn.getBytes("UTF-8"));
        }

        return "OK";
    }

}
