package jonas.guiFirst;

public class MainDrawDemo {

    /**
     * Class to run the DrawDemo class.
     * @param args
     */
    public static void main(String... args) {
        DrawDemo drawDemo = new DrawDemo();

        drawDemo.drawSquare();
        drawDemo.drawTriangle();
        drawDemo.drawPentagon();
        drawDemo.drawPolygon(5);
        drawDemo.drawSpiral();
        drawDemo.drawWheel();

    }
}
