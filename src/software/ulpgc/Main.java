package software.ulpgc;

import software.ulpgc.io.UrlDriverReader;
import software.ulpgc.model.Driver;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/toUpperCase78/formula1-datasets/master/Formula1_2025Season_Drivers.csv");
        List<Driver> drivers = new UrlDriverReader(url).load();

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}
