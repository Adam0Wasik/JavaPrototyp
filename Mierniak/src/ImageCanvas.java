
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageCanvas extends JPanel {
        private BufferedImage img;
        private int sizeX= 408;
        private int sizeY= 275;
        private int value =-100;
        private Color myColor;
        private JButton startBaton;
        private JPanel topPanel,botPanel;
        private JTextField field;
        private int thicknes;

    public int getSizeX() {
        return sizeX;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Color getMyColor() {
        return myColor;
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    public int getThicknes() {
        return thicknes;
    }

    public void setThicknes(int thicknes) {
        this.thicknes = thicknes;
    }
       
        public ImageCanvas()  {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension (600,650));
            startBaton = new JButton("Start");
            field = new JTextField(20);
            topPanel = new JPanel();
            botPanel = new JPanel();
            topPanel.setPreferredSize(new Dimension(600,50));
            botPanel.setPreferredSize(new Dimension(600,550));
            add(topPanel, BorderLayout.NORTH);
            add(botPanel, BorderLayout.CENTER);
            
            startBaton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    value =  Integer.parseInt(field.getText());
                    repaint();
                }
            });
             topPanel.add(startBaton);
             topPanel.add(field);
             try {
                img = ImageIO.read(new File("C:\\Users\\adam\\Documents\\NetBeansProjects\\Mierniak\\src\\Images\\tarcza.png"));
              
                //getClass().getResource("tarcza.png");
                //ImageIO.read(new File("tarcza.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            field.setVisible(true);
            startBaton.setVisible(true);
            topPanel.setVisible(true);
        }
        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }
        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(thicknes));
        g2d.setColor(myColor);
        g2d.drawImage(img, 0,0, sizeX,sizeY,botPanel);
        g2d.drawLine(img.getWidth()/2, (int) (img.getHeight()*0.73), img.getWidth()/2+value, (int) (img.getHeight()*0.45));   
                }
        
}
        
   
