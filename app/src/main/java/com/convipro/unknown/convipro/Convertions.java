package com.convipro.unknown.convipro;

/**
 * Created by UNKNOWN on 20/07/2016.
 */
public class Convertions {
    public static final int LENGTH = 0;
    public static final int MASS = 1;
    public static final int SPEED = 2;
    public static final int TEMPERATURE = 3;
    public static final int VOLUME = 4;
    public static final int PRESSURE = 5;
    public static final int ANGLE = 6;
    public static final int FREQUENCY = 7;
    public static final int ENERGY = 8;
    public static final int DIGITAL = 9;

    public static double[] lengthConv = new double[] {1.0, 10.0, 1000.0, 1000000.0, 914.4, 304.8, 25.4, 1609344};
    public static double[] massConv = new double[] {1.0, 1000.0, 1000000.0, 453.5923, 6350.29, 28.3495};
    public static double[] speedConv = new double[] {1.0, 3.6, 1.60934, 1.09728, 1.852};
    public static double[] tempConv = new double[] {1.0 };
    public static double[] volumeConv = new double[] {1.0, 1000.0, 3785.41, 946.353, 473.176, 29.5735, 240, 14.7868, 1000000.0, 28316.8, 16.3871};
    public static double[] pressureConv = new double[] {1.0, 101325.0, 100000.0, 6894.76, 133.322};
    public static double[] angleConv = new double[] {1.0, 60.0, 206.265, 3240.0, 3600.0, 206265.0};
    public static double[] frequencyConv = new double[] {1.0, 1000.0, 1000000.0, 1000000000.0};
    public static double[] energyConv = new double[] {1.0, 1000.0, 4.184, 4184.0, 3600.0, 3600000.0};
    public static double[] digitalConv = new double[] {1.0, 8.0, 8000.0, 8000000.0, 8.0E9, 8.0E12};

    public static double[] getConv(int id) {
        double[] conv = lengthConv;

        switch(id) {
            case LENGTH:
                conv = lengthConv;
                break;
            case MASS:
                conv = massConv;
                break;
            case SPEED:
                conv = speedConv;
                break;
            case TEMPERATURE:
                conv = tempConv;
                break;
            case VOLUME:
                conv = volumeConv;
                break;
            case PRESSURE:
                conv = pressureConv;
                break;
            case ANGLE:
                conv = angleConv;
                break;
            case FREQUENCY:
                conv = frequencyConv;
                break;
            case ENERGY:
                conv = energyConv;
                break;
            case DIGITAL:
                conv = digitalConv;
                break;
        }

        return conv;
    }

    public static double convertTemp(double valueFrom, int typeFrom, int typeTo) {
        double result = 0;

        switch (typeFrom) {
            case 0:
                result = valueFrom;
                break;
            case 1:
                result = (valueFrom - 32) / 1.8;
                break;
            case 2:
                result = valueFrom - 273.15;
                break;
        }

        switch (typeTo) {
            case 0:
                break;
            case 1:
                result = result * 1.8 + 32;
                break;
            case 2:
                result = result + 273.15;
                break;
        }

        return result;
    }
}
