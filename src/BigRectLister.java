import java.awt.*;
import java.util.ArrayList;

public class BigRectLister
{
    static void main()
    {
        BigRectangleFilter filter = new BigRectangleFilter();
        ArrayList<Object> rectangles = new ArrayList<>();

        // Fill rectangles with rectangles
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(1, 4));
        rectangles.add(new Rectangle(1, 3));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(5, 6));
        rectangles.add(new Rectangle(6, 7));
        rectangles.add(new Rectangle(7, 8));

        System.out.println("The following rectangles have a perimeter greater than 10:\n");
        for (Object rectangle : rectangles)
        {
            if (filter.accept(rectangle))
            {
                System.out.println(rectangle);
            }
        }
    }
}
