package com.example.jchat;

import javafx.scene.paint.Color;

import java.util.HashMap;


public class GuiColors {

    public enum Colors {
        BLUE,
        LIGHT_BLUE,
    }

    public HashMap<Colors, Color> colorMap = new HashMap<>();

    public GuiColors() {
        // Where the colors for UI are located
        colorMap.put(Colors.BLUE, Color.rgb(0, 0, 255));
        colorMap.put(Colors.LIGHT_BLUE, Color.rgb(141, 181, 247));

    }
}