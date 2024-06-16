import javax.swing.*;
import java.awt.*;

public class Snowman extends Canvas {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Снеговик");
        Snowman t = new Snowman();
        jFrame.add(t);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 700);
        jFrame.setLocation(500, 10);
    }

    @Override
    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        // Draw the snowman's body
        drawBody(g);
        // Draw the buttons
        drawButtons(g);
        // Draw the left arm
        drawLeftArm(g);
        // Draw the right arm
        drawRightArm(g);
        // Draw the face
        drawFace(g);
        // Draw the hat
        drawHat(g);
    }

    private void drawBody(Graphics g) {
        // Draw body segments
        drawOval(g, Color.BLACK, 207, 450, 215, 186);
        drawOval(g, Color.WHITE, 210, 453, 209, 180);
        drawOval(g, Color.BLACK, 235, 350, 150, 130);
        drawOval(g, Color.WHITE, 238, 353, 144, 124);
    }

    private void drawButtons(Graphics g) {
        // Draw buttons
        drawButton(g, 320, 396);
        drawButton(g, 320, 421);
        drawButton(g, 320, 446);
    }

    private void drawButton(Graphics g, int x, int y) {
        drawOval(g, Color.BLACK, x, y, 15, 15);
        drawOval(g, Color.WHITE, x + 3, y + 3, 9, 9);
    }

    private void drawLeftArm(Graphics g) {
        // Draw left arm
        int[] xp = {252, 182, 169, 158, 167, 147, 144, 164, 153, 161, 176, 246};
        int[] yp = {392, 363, 334, 338, 357, 351, 363, 368, 381, 390, 374, 403};
        drawPolygon(g, Color.BLACK, xp, yp);

        int[] xp1 = {248, 179, 167, 163, 172, 150, 148, 170, 157, 161, 175, 245};
        int[] yp1 = {393, 364, 338, 340, 361, 355, 360, 367, 381, 385, 371, 399};
        drawPolygon(g, Color.WHITE, xp1, yp1);
    }

    private void drawRightArm(Graphics g) {
        // Draw right arm
        int[] xp2 = {378, 437, 448, 457, 449, 472, 477, 457, 474, 467, 443, 383};
        int[] yp2 = {391, 360, 334, 338, 356, 347, 356, 365, 376, 385, 370, 403};
        drawPolygon(g, Color.BLACK, xp2, yp2);

        int[] xp22 = {381, 439, 450, 454, 443, 471, 473, 451, 469, 466, 443, 383};
        int[] yp22 = {393, 363, 337, 339, 362, 351, 355, 364, 376, 381, 366, 399};
        drawPolygon(g, Color.WHITE, xp22, yp22);
    }

    private void drawFace(Graphics g) {
        // Draw face
        drawOval(g, Color.BLACK, 270, 280, 80, 80);
        drawOval(g, Color.WHITE, 273, 283, 74, 74);

        // Draw mouth
        int[] mouthXs = {303, 313, 322, 330};
        int[] mouthYs = {336, 342, 342, 336};
        for (int i = 0; i < mouthXs.length; i++) {
            drawMouthPiece(g, mouthXs[i], mouthYs[i]);
        }
        // Draw eyes
        drawEye(g, 294, 304);
        drawEye(g, 324, 304);
        // Draw nose
        int[] xp3 = {317, 380, 319};
        int[] yp3 = {321, 320, 334};
        drawPolygon(g, Color.BLACK, xp3, yp3);
        int[] xp4 = {320, 366, 321};
        int[] yp4 = {323, 322, 331};
        drawPolygon(g, Color.WHITE, xp4, yp4);
    }

    private void drawMouthPiece(Graphics g, int x, int y) {
        drawOval(g, Color.BLACK, x, y, 6, 6);
        drawOval(g, Color.WHITE, x + 2, y + 2, 2, 2);
    }

    private void drawEye(Graphics g, int x, int y) {
        drawOval(g, Color.BLACK, x, y, 12, 12);
        drawOval(g, Color.WHITE, x + 2, y + 2, 8, 8);
    }

    private void drawHat(Graphics g) {
        // Draw hat
        drawOval(g, Color.BLACK, 260, 275, 100, 22);
        drawOval(g, Color.WHITE, 263, 278, 94, 16);
        drawRoundRect(g, Color.BLACK, 282, 242, 56, 41, 12, 12);
        drawRoundRect(g, Color.WHITE, 285, 245, 50, 35, 10, 10);
        g.setColor(Color.BLACK);
        g.fillRect(283, 265, 55, 3);
    }

    private void drawOval(Graphics g, Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    private void drawPolygon(Graphics g, Color color, int[] xPoints, int[] yPoints) {
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    private void drawRoundRect(Graphics g, Color color, int x, int y, int width, int height, int arcWidth, int arcHeight) {
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
}