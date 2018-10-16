package Actions.Stock;

import Services.Stock.StockService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class StockViewAction extends ActionSupport {

    InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String execute() throws UnsupportedEncodingException {

        StockService stockService = new StockService();
        String stock = stockService.viewStock();
        System.out.println(stock);
        if (!stock.equals("ERROR")){

            inputStream = new ByteArrayInputStream(stock.getBytes("UTF-8"));

        }

        return "OK";

    }

}
