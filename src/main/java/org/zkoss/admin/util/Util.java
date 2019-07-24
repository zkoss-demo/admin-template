package org.zkoss.admin.util;

import java.text.DateFormatSymbols;
import java.util.Random;

public class Util {
    public static Random random = new Random();
    public static String[] MONTHS = new DateFormatSymbols().getMonths();

    public static int nextInt(int high, int low){
        return random.nextInt(high-low) + low;
    }
}
