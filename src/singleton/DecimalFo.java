package singleton;

import java.text.DecimalFormat;

public class DecimalFo {

    private static DecimalFormat price;
    private static DecimalFormat Code;



    public static String setAmount(Double amo) {

        if (price == null) {

            price = new DecimalFormat("##.00");

        }

        return price.format(amo);

    }



    public static String setInvNo(Integer amo) {

        if (Code == null) {

            Code = new DecimalFormat("00000");

        }

        return "UC/INV/"+Code.format(amo);

    }





}
