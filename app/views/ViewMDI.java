package app.views;

import java.awt.*;
import javax.swing.*;

public class ViewMDI extends JFrame
{
    private int width;
    private int height;

    private int posX;
    private int posY;

    private Image appIcon;
    
    private Toolkit toolkit;
    private Dimension screen;

    private PanelMDI PanelMDI;

    public ViewMDI()
    {

        this.toolkit = Toolkit.getDefaultToolkit();
        this.screen = this.toolkit.getScreenSize();

        this.width = 500;
        this.height = 200;
        this.posX = (this.screen.width /2) - (this.width /2);
        this.posY = (this.screen.height /2) - (this.height /2);

        this.appIcon = toolkit.getImage("app/views/icons/application.png");

        this.setVisible(true);
        this.setSize(this.width,this.height);
        this.setLocation(this.posX,this.posY);
        this.setResizable(false);
        this.setTitle("Aplicacion");
        this.setIconImage(this.appIcon);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.PanelMDI = new PanelMDI();

        // Layout.
        this.add(this.PanelMDI);

    }

    private class PanelMDI extends JPanel
    {

        public void paintComponent(Graphics g){

            super.paintComponent(g);
            g.drawRect(10,10,480,180);

        }
    }

}