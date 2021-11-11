import java.awt.*;

public class JF_GuiTools {

    public static final int LOCATION_NONE = -1;
    public static final int LOCATION_TOP = 0;
    public static final int LOCATION_BOTTOM = 1;
    public static final int LOCATION_LEFT = 2;
    public static final int LOCATION_RIGHT = 3;
    public static final int LOCATION_TOP_LEFT = 4;
    public static final int LOCATION_TOP_RIGHT = 5;
    public static final int LOCATION_BOTTOM_LEFT = 6;
    public static final int LOCATION_BOTTOM_RIGHT = 7;

    /**
     * Provides a fast way to get the index of a point in a grid system which one is stored in an array, arraylist or something similar. <br>
     * If the calculated index is out of range/ bounds, the function returns a fitting index based on the location modifier.<br><br>
     * If LOCATION_NONE is used and the index is out range/ bounds, index = -1.<br>
     * If an unallowed location modifier is used, index = -2.<br>
     * If an unknown error in the calculation occurs, index = -3. <br><br>
     * Check the other constants for the location modifier in JF_GuiTools. <br>
     * The wrong usage of a constant might lead to an out-of-bounds error! <br>
     *
     * @param point coordinates in grid system
     * @param dimension width and height of grid system
     * @param type direction modifier
     * @return int index
     */
    public static int pointToStorageIndex(Point point, Dimension dimension, int type) {
        final int width = dimension.width;
        final int height = dimension.height;
        final boolean outOfBounds = (point.x > width) || (point.x < 0) || (point.y > height) || (point.y < 0);
        final boolean allowedModifier = (type == LOCATION_NONE) || (type == LOCATION_TOP) || (type == LOCATION_BOTTOM) || (type == LOCATION_LEFT) || (type == LOCATION_RIGHT) || (type == LOCATION_TOP_RIGHT) || (type == LOCATION_TOP_LEFT) || (type == LOCATION_BOTTOM_RIGHT) || (type == LOCATION_BOTTOM_LEFT);
        final int x = point.x > width ? point.x % width : point.x;
        final int y = point.y > height ? point.y % height : point.y;
        int index;

        if (!outOfBounds) return y * width + x;

        if (!allowedModifier) return -2;

        index = switch (type) {
            case LOCATION_NONE -> -1;
            case LOCATION_TOP -> x;
            case LOCATION_BOTTOM -> (height - 1) * width + x;
            case LOCATION_LEFT -> y * width;
            case LOCATION_RIGHT -> y * width + (width - 1);
            case LOCATION_TOP_LEFT -> 0;
            case LOCATION_TOP_RIGHT -> (width - 1);
            case LOCATION_BOTTOM_LEFT -> (height - 1) * width;
            case LOCATION_BOTTOM_RIGHT -> (height - 1) * width + (width - 1);
            default -> -3;
        };

        return index;
    }
}
