package pacman;

import java.util.ArrayList;
import java.awt.*;

public class ConnectedSet implements Drawable {
    // private ArrayList pixels;
    int x, y;
    int width, height;
    int fg; // the value of the FG pixels
    int xMin, xMax, yMin, yMax;
    int pTot;
    int tot;
    Color c;
    public int px, py;
    boolean valid = false;

    
    /**
     * MEtodo para pintar el Extracted.
     */
    public void draw(Graphics g, int w, int h) {
        // int div = 1;
        validate();
        g.setColor(c);
        if (ghostLike()) {
            g.fillRect(xMin, yMin, width, height); // tamaño fantasmas
            // System.out.println(width + " : " + height);
        } else {
            if (powerPill() || pill() && true) {
                g.drawRect(xMin, yMin, width+1, height+1); //tamaño pills
            }
        }
    }

    public void validate() {
        if (!valid) {
            width = xMax - xMin;
            System.out.println(width);
            height = yMax - yMin;
            // px = xMin + (xMax - xMin) / div;
            // py = yMin + (yMax - yMin) / div;
            valid = true;
        }
    }

    public boolean ghostLike() { // Asegura que es un Fantasma
        validate();
        return ghostColor(fg) && width >= 10 && height >= 10;
        // return width == 13 && height == 13; // fg == MsPacInterface.inky;
    }

    public boolean edible() { // Asegura que se puede comer a un fantasma 
        validate();
        return MsPacInterface.edible == fg && width >= 10 && height >= 10;
        // return width == 13 && height == 13; // fg == MsPacInterface.inky;
    }

    public boolean ghostColor(int c) {
        return c == MsPacInterface.blinky ||
                c == MsPacInterface.pinky ||
                c == MsPacInterface.inky ||
                c == MsPacInterface.sue;
    }

    public boolean isPacMan() { // Asegura que es MsPacman
        validate();
        return fg == MsPacInterface.pacMan && width >= 10 && height >= 10;
        // return width == 13 && height == 13; // fg == MsPacInterface.inky;
    }

    public boolean pill() { // Asegura que es una pildora
        validate();
        return width == 1 && height == 1 && fg == MsPacInterface.pill; // between(width, 2, 3) && between(height, 2, 3);
    }

    public boolean powerPill() { // Asegura que es una powerPill
        validate();
        return width == 7 && height == 7; // between(width, 2, 3) && between(height, 2, 3);
    }

    public static boolean between(int x, int low, int high) {
        return x >= low && x <= high;
    }

    public int x() {
        return xMin + (xMax - xMin) / 2;
    }

    public int y() {
        return yMin + (yMax - yMin) / 2;
    }

    public void rescale(double fac) {
        // do nothing
    }

    public ConnectedSet(int x, int y, int fg) {
        // pixels = new ArrayList();
        this.x = x;
        this.y = y;
        xMin = x;
        xMax = x;
        yMin = y;
        yMax = y;
        this.fg = fg;
        c = new Color((fg & 0xFF0000) >> 16, (fg & 0xFF00) >> 8, (fg & 0xFF));
        // System.out.println("Color: " + c + " : " + fg);
    }

    public void add(int px, int py, int pos, int val) {
        xMin = Math.min(px, xMin);
        xMax = Math.max(px, xMax);
        yMin = Math.min(py, yMin);
        yMax = Math.max(py, yMax);
        pTot += (1 + px - x) * (1 + py - y);
        tot++;
        valid = false;
    }

    public int hashCode() {
        return pTot;
    }

    public boolean equals(Object obj) {
        ConnectedSet cs = (ConnectedSet) obj;
        return cs.pTot == pTot;
    }

    public String toString() {
        return x + " : " + y + " : " + pTot;
    }

    public int dist(Position p) {		//Distancia de la instancia a p 
        return (int) Math.sqrt(sqr(x - p.x) + sqr(y - p.y));
    }

    public static int sqr(int x) { 
        return x * x;
    }


}
