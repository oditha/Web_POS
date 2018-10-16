package singleton;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDates {

    static SimpleDateFormat companycode;
    static SimpleDateFormat parsedate;
    static SimpleDateFormat string;
    static SimpleDateFormat Time;
    static SimpleDateFormat Month;
    static SimpleDateFormat curDate;


    public static String getcompanycode() {

        if (companycode == null) {

            companycode = new SimpleDateFormat("YYMMDDhhmmss");

        }

        return companycode.format(new Date());

    }


    public static java.sql.Date parseDate(String date) throws ParseException {

        if (parsedate == null) {

            parsedate = new SimpleDateFormat("yyyy-MM-dd");

        }

        Date parse = parsedate.parse(date);
        System.out.println(parse);
        return new java.sql.Date(parse.getTime());

    }

    public static Date parseMongoDate(String date) throws ParseException {

        if (parsedate == null) {

            parsedate = new SimpleDateFormat("yyyy-MM-dd");

        }

        Date parse = parsedate.parse(date);
        return parse;

    }

    public static String dateToString(Date given) throws ParseException {

        if (string == null) {

            string = new SimpleDateFormat("yyyy-MM-dd");

        }

        return string.format(given);
    }

    public static Timestamp getTime() {


        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public static String getMonth() {

        if (Month == null) {

            Month = new SimpleDateFormat("MMM-yyyy");

        }

        return Month.format(new Date());
    }

    public static String getDate() {

        if (curDate == null) {

            curDate = new SimpleDateFormat("yyyy-MM-dd");

        }

        return curDate.format(new Date());
    }


    public static void main(String[] args) {


    }


}
