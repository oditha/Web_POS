package Actions.GRN;

import Modals.GRN.GrnModel;
import Services.GRN.AddGrnService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class GrnSaveAction extends ActionSupport implements ModelDriven {

    GrnModel grn = new GrnModel();

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Object getModel() {
        return grn;
    }


    public String execute() throws UnsupportedEncodingException {

        AddGrnService service = new AddGrnService();

        if (service.saveGrn(grn)) {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        } else {

            inputStream = new ByteArrayInputStream("done".getBytes("UTF-8"));

        }

        return "OK";
    }

}
