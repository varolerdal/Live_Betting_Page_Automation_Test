package utils;

import org.openqa.selenium.Dimension;

public class ReusableMethods {

    // Creates methods to set viewport sizes based on the device types (desktop and mobile)
    public static void setDimension (String device) {
        if (device.equalsIgnoreCase("desktop")) {
            drivers.DriverManager.getDriver().manage().window().maximize();
        } else if (device.equalsIgnoreCase("mobile")) {
            drivers.DriverManager.getDriver().manage().window().setSize(new Dimension(375, 812));
        } else {
            throw new IllegalArgumentException("Unsupported device type: " + device);
        }
    }
}
