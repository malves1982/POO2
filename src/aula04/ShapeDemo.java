package aula04;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;


public class ShapeDemo extends Applet {
    final static int maxCharHeight = 15;
    final static int minFontSize = 6;
    final static Color bg = Color.lightGray;
    final static Color fg = Color.black;

    Dimension totalSize;
    FontMetrics fontMetrics;

    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }

    FontMetrics pickFont(Graphics g,
                         String longString,
                         int xSpace) {
        boolean fontFits = false;
        Font font = g.getFont();
        FontMetrics fontMetrics = g.getFontMetrics();
        int size = font.getSize();
        String name = font.getName();
        int style = font.getStyle();

        while (!fontFits) {
            if ( (fontMetrics.getHeight() <= maxCharHeight)
              && (fontMetrics.stringWidth(longString) 
		  <= xSpace)) {
                fontFits = true;
            } else {
                if (size <= minFontSize) {
                    fontFits = true;
                } else {
                    g.setFont(font = new Font(name,
                                              style,
                                              --size));
                    fontMetrics = g.getFontMetrics();
                }
            }
        }

        return fontMetrics;
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        int gridWidth = d.width / 7;
        int gridHeight = d.height / 2;

        if ( (totalSize == null)
          || (totalSize.width != d.width)
          || (totalSize.height != d.height) ) {
            totalSize = d;
            fontMetrics = pickFont(g, "drawRoundRect()",
                                   gridWidth);
        }

        Color fg3D = Color.lightGray;

        g.setColor(fg3D);
        g.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
        g.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
        g.setColor(fg);

        int x = 5;
        int y = 7;
        int rectWidth = gridWidth - 2*x;
        int stringY = gridHeight - 5 - 
		      fontMetrics.getDescent();
        int rectHeight = stringY - fontMetrics.getMaxAscent()
                         - y - 2;

        // drawLine(x1, y1, x2, y2) 
        g.drawLine(x, y+rectHeight-1, x + rectWidth, y);
        g.drawString("drawLine()", x, stringY);
        x += gridWidth;

        // drawRect(x, y, w, h) 
        g.drawRect(x, y, rectWidth, rectHeight);
        g.drawString("drawRect()", x, stringY);
        x += gridWidth;

        // draw3DRect(x, y, w, h, raised) 
        g.setColor(fg3D);
        g.draw3DRect(x, y, rectWidth, rectHeight, true);
        g.setColor(fg);
        g.drawString("draw3DRect()", x, stringY);
        x += gridWidth;

        // drawRoundRect(x, y, w, h, arcw, arch) 
        g.drawRoundRect(x, y, rectWidth, rectHeight, 10, 10);
        g.drawString("drawRoundRect()", x, stringY);
        x += gridWidth;

        // drawOval(x, y, w, h) 
        g.drawOval(x, y, rectWidth, rectHeight);
        g.drawString("drawOval()", x, stringY);
        x += gridWidth;

        // drawArc(x, y, w, h) 
        g.drawArc(x, y, rectWidth, rectHeight, 90, 135);
        g.drawString("drawArc()", x, stringY);
        x += gridWidth;

        // drawPolygon(xPoints, yPoints, numPoints) 
        int x1Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y1Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.drawPolygon(x1Points, y1Points, x1Points.length); 
        g.drawString("drawPolygon()", x, stringY);

        // NEW ROW
        x = 5;
        y += gridHeight;
        stringY += gridHeight;

        // drawPolyline(xPoints, yPoints, numPoints) 
        // Note: drawPolygon would close the polygon.
        int x2Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y2Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.drawPolyline(x2Points, y2Points, x2Points.length); 
        g.drawString("drawPolyline()", x, stringY);
        x += gridWidth;

        // fillRect(x, y, w, h)
        g.fillRect(x, y, rectWidth, rectHeight);
        g.drawString("fillRect()", x, stringY);
        x += gridWidth;

        // fill3DRect(x, y, w, h, raised) 
        g.setColor(fg3D);
        g.fill3DRect(x, y, rectWidth, rectHeight, true);
        g.setColor(fg);
        g.drawString("fill3DRect()", x, stringY);
        x += gridWidth;

        // fillRoundRect(x, y, w, h, arcw, arch)
        g.fillRoundRect(x, y, rectWidth, rectHeight, 10, 10);
        g.drawString("fillRoundRect()", x, stringY);
        x += gridWidth;

        // fillOval(x, y, w, h)
        g.fillOval(x, y, rectWidth, rectHeight);
        g.drawString("fillOval()", x, stringY);
        x += gridWidth;

        // fillArc(x, y, w, h)
        g.fillArc(x, y, rectWidth, rectHeight, 90, 135);
        g.drawString("fillArc()", x, stringY);
        x += gridWidth;

        // fillPolygon(xPoints, yPoints, numPoints) 
        int x3Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y3Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.fillPolygon(x3Points, y3Points, x3Points.length); 
        g.drawString("fillPolygon()", x, stringY);
    }
}
