package Actions.GRN;

import Modals.GRN.GrnFilterModel;
import Services.GRN.ViewGrnService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class GrnFilterAction extends ActionSupport implements ModelDriven {

    GrnFilterModel gf = new GrnFilterModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return gf;
    }

    public String execute() throws UnsupportedEncodingException {

        ViewGrnService service = new ViewGrnService();
        String filter = service.grnFilter(gf);
        if (!filter.equals("ERROR")){

            inputStream = new ByteArrayInputStream(filter.getBytes("UTF-8"));

        }else {


            inputStream = new ByteArrayInputStream("ERROR".getBytes("UTF-8"));

        }

        return "OK";
    }

}
