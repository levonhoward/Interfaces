import java.awt.*;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        final int perimeterThreshold = 10;
        Rectangle rect = (Rectangle) x;
        double rectPerimeter = (rect.getHeight() * 2) + (rect.getWidth() * 2);

        return (rectPerimeter > perimeterThreshold);
    }
}
