package Actions.Charts;

import Services.Charts.ChartsService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class UserViseChartODKAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        ChartsService chartsService = new ChartsService();

        inputStream = new ByteArrayInputStream(chartsService.loadUserViseODK().getBytes("UTF-8"));

        return "OK";
    }
}
