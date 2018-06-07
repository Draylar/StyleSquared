package com.github.draylar;

public class Settings {

    // ---------- SINGLETON PATTERN -------------- //

    private static Settings instance;
    // size for the grid of the calculator
    public final int CALCULATOR_GRID_HEIGHT = 10;
    public final int CALCULATOR_GRID_WIDTH = 5;

    // ------------ SETTINGS -------------- //
    // color settings
    public final String LIGHT_COLOR = "#dbdbdb";
    public final String DARK_COLOR = "#c1c1c1";
    public final String MIDDLE_COLOR = "#d1d1d1";
    // screen size
    public double SCREEN_WIDTH = 400;
    public double SCREEN_HEIGHT = 600;

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null) instance = new Settings();
        return instance;
    }
}
