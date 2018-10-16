package Actions.GRN;

import Modals.GRN.GrnModel;
import Services.GRN.ViewGrnService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class GrnViewDataAction extends ActionSupport implements ModelDriven {

    GrnModel gm = new GrnModel();
    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return gm;
    }

    public String execute() throws UnsupportedEncodingException {


        ViewGrnService viewGrnService = new ViewGrnService();
        String grnData = viewGrnService.viewGrnData(gm);
        if (!grnData.equals("ERROR")) {

            inputStream = new ByteArrayInputStream(grnData.getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("ERROR".getBytes("UTF-8"));

        }

        return "OK";
    }

}
