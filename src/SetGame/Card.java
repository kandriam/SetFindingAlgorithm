package SetGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Set Game's Card values, traits and UI.
 * 
 * @author Phil Reitz-Jones
 * @author Kaliana Andriamananjara
 */

public class Card {
    private int color;
    private int num;
    private int shape;
    private int fill;

    public static final int CARD_PADDING = 20;

    public static final int CARD_WIDTH = 120;
    public static final int CARD_HEIGHT = 200;

    public static final int SHAPE_WIDTH = 80;
    public static final int SHAPE_HEIGHT = 40;

    public static final int SHAPE_AND_CARD_STROKE_WIDTH = 2;

    // List of base colors 
    private final List<Color> colors = List.of(
        Color.RED,
        new Color(0, 200, 0),
        Color.BLUE
    );

    // List of lighter versions of colors (instead of lined) for middle shading
    private final List<Color> halfColors = List.of(
        new Color(255, 127, 127),
        new Color(200, 255, 200),
        new Color(127, 127, 255)
    );


    /**
     * @param color     Color value of a card (red, green, blue)
     * @param num       Number value of a card (1, 2, 3 of each shape)
     * @param shape     Shape of a card (triangle, diamond, rectangle)
     * @param fill      Shading of a card (empty, light or full/dark)
     */
    public Card(int color, int num, int shape, int fill) {
        this.color = color;
        this.num = num;
        this.shape = shape;
        this.fill = fill;
    }

    /**
     * @param trait     Takes in what kind of trait the caller wants (color, number, shape or shading)
     * @return          The value of the trait (which color, number, shape or shading)
     */
    public Integer getTrait(int trait){
        switch (trait) {
            case 0:
                return color;

            case 1:
                return num;
            
            case 2:
                return shape;
            
            case 3:
                return fill;
        
            default:
                return null;
        }
    }

    /**
     * Returns the color of fill based on its color AND fill status (aka full, half full or empty)
     * @param colorInt      Which color it is between red, green, blue
     * @param fillInt       Whether it is empty, light or dark
     * @return              The color that the shape will be filled
     */
    private Color getColorFromInt(int colorInt, int fillInt) {
        if (fillInt == 1) {
            return halfColors.get(colorInt);
        } else if (fillInt == 2) {
            return colors.get(colorInt);
        } else {
            return Color.WHITE;
        }
    }
}
