package Actions.Works;

import Services.Works.WorksService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class GenOrderNOAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        WorksService worksService = new WorksService();

        inputStream = new ByteArrayInputStream(worksService.genOrderno().getBytes("UTF-8"));

        return "OK";
    }


}
