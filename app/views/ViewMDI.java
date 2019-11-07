package app.views;

import java.awt.*;
import java.awt.event.*;
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

    private Menu menu;

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
        //this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.menu = new Menu();

        // Menú.
        this.setJMenuBar(this.menu);

    }

    // Menú.
    private class Menu extends JMenuBar{

        private Archivo      archivo;
        private Herramientas herramientas;
        private Exportar     exportar;
        private Ayuda        ayuda;

        public Menu(){

            this.setSize(500,24);
            this.setLocation(0,0);
            this.setVisible(true);
            this.archivo      = new Archivo();
            this.herramientas = new Herramientas();
            this.exportar     = new Exportar();
            this.ayuda        = new Ayuda();

            this.add(this.archivo);
            this.add(this.herramientas);
            this.add(this.exportar);
            this.add(this.ayuda);

        }

        private class Archivo extends JMenu{

            private Logout logout;
            private Exit   exit;

            public Archivo(){

                this.setText("Archivo");
                this.logout = new Logout();
                this.exit   = new Exit();

                this.add(this.logout);
                this.add(this.exit);

            }

            private class Logout extends JMenuItem{

                public Logout(){

                    this.setText("Cerrar la sesion.");

                }

            }

            private class Exit extends JMenuItem{

                public Exit(){

                    this.setText("Salir de la aplicación.");

                }

            }

        }

        private class Herramientas extends JMenu{

            public Herramientas(){

                this.setText("Herramientas");

            }
        }

        private class Exportar extends JMenu{

            private ExportarWord exportarWord;
            private ExportarWeb  exportarWeb;
            private ExportarPDF  exportarPDF;

            public Exportar(){

                this.setText("Exportar");
                this.exportarWord = new ExportarWord();
                this.exportarWeb  = new ExportarWeb();
                this.exportarPDF  = new ExportarPDF();

                this.add(this.exportarWord);
                this.add(this.exportarWeb);
                this.add(this.exportarPDF);

            }

            private class ExportarWord extends JMenuItem{

                public ExportarWord(){

                    this.setText("Exportar a Word.");

                }

            }

            private class ExportarWeb  extends JMenuItem{

                public ExportarWeb(){

                    this.setText("Exportar a la Web.");

                }

            }

            private class ExportarPDF  extends JMenuItem{

                public ExportarPDF(){

                    this.setText("Exportar a PDF");

                }

            }
        }

        private class Ayuda extends JMenu{

            private AcercaDe acercaDe;
            private Manual manual;

            public Ayuda(){

                this.setText("Ayuda...");
                this.acercaDe = new AcercaDe();
                this.manual   = new Manual();

                this.add(this.acercaDe);
                this.add(this.manual);
            }

            private class AcercaDe extends JMenuItem{

                public AcercaDe(){

                    this.setText("Acerca de...");
                }

            }

            private class Manual   extends JMenuItem{

                public Manual(){

                    this.setText("Manual de Usuario");
                }
            }
        }
        
    }

}