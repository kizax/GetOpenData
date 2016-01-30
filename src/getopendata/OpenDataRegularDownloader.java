package getopendata;

import javax.xml.parsers.*;
import java.util.Date;
import java.util.Timer;


public class OpenDataRegularDownloader {

    public static void main(String[] args) throws ParserConfigurationException {

        Date date = new Date();
        Timer time = new Timer();
        time.schedule(new GetOpenDataTask(), date, 1000 * 5 * 60);


    }

}
