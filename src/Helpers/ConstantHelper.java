package Helpers;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdalaziz Abdallah
 */
public class ConstantHelper {

    private static String USERNAME = "123";
    private static String PASSWORD = "123";

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void preventTypeAlphabete(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void preventTypeDigit(KeyEvent evt) {
        if (!(Character.isSpaceChar(evt.getKeyChar()) || Character.isLetter(evt.getKeyChar()))) {
            evt.consume();
        }
    }

    public static void preventTypeAlphabeteOnlyDots(KeyEvent evt) {
        if (!(evt.getKeyChar() == '.' || Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }

    public static String getNewPassword() {
        return "" + (int) ((Math.random() * 99999) + 10000);
    }

    public static boolean checkIDvalid(String text) {

        int a = Integer.parseInt(text);
        int i = a % 10;
        int b = a / 10;

        int sum1 = 0, sum2 = 0, m = 0, j, k, c;
        while (b > 0) {
            j = b % 10;
            if (m % 2 == 0) {
                k = 2 * j;
                if (k > 9) {
                    c = k % 10;
                    c += k / 10;
                    sum1 += c;
                } else {
                    sum1 += k;
                }
            } else {
                sum2 += j;
            }
            b /= 10;
            m++;
        }
        int sum = sum1 + sum2;

        sum %= 10;

        sum = 10 - sum;
        if (sum == 10) {
            sum = 0;
        }
        if (sum != i) {
            return false;
        }

        return true;
    }

    private static String formatString(String greet, String customerName) {
        return "<html>"
                + greet + "<br>"
                + customerName
                + "<html>";

    }

    public static String[] setupGreeting(String customerName) {
        String[] strings = new String[2];
        SimpleDateFormat dayInMonthNumber = new SimpleDateFormat("dd", Locale.getDefault());
        String formattedDayInMonthNumber = dayInMonthNumber.format(new Date()).toString();

        SimpleDateFormat dayAndMonth = new SimpleDateFormat("EEEEE, MMMMM ", Locale.getDefault());
        String formattedDate2 = dayAndMonth.format(new Date()).toString();

        int day = Integer.parseInt(formattedDayInMonthNumber);
        if (day == 1) {
            strings[0] = (formattedDate2 + "" + formattedDayInMonthNumber + "" + "st");
        } else if (day == 2) {
            strings[0] = (formattedDate2 + "" + formattedDayInMonthNumber + "" + "nd");
        } else if (day == 3) {
            strings[0] = (formattedDate2 + "" + formattedDayInMonthNumber + "" + "rd");
        } else {
            strings[0] = (formattedDate2 + "" + formattedDayInMonthNumber + "" + "th");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH.mm", Locale.getDefault());
        String formattedDate = dateFormat.format(new Date()).toString();

        double parseInt = Double.parseDouble(formattedDate);
        if (0 <= parseInt && parseInt <= 11.59) {
            strings[1] = (ConstantHelper.formatString("Good Morining", customerName));
        } else if (12 <= parseInt && parseInt <= 4.59) {
            strings[1] = (ConstantHelper.formatString("Good Afternoon", customerName));
        } else {
            strings[1] = (ConstantHelper.formatString("Good Evening", customerName));
        }

        return strings;
    }

    public static Point getXY() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        if (width < x + 371) {
            x -= 371;
        }
        if (height < y + 465) {
            y -= 465;
        }

        return new Point(x, y);
    }

    public static String encryptPass(String password) {
        try {
            //retrieve instance of the encryptor of SHA-256
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
//retrieve bytes to encrypt
            byte[] encodedhash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodedhash.length);
//perform encryption
            for (int i = 0; i < encodedhash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodedhash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
//return encrypted value
            return encryptionValue.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
