import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;
import java.io.Console;

public class ImgChooser extends JFrame implements WindowListener {
    JLabel firstImg;
    JPanel bg;

    int labelX = 0;
    int labelY = 0;

    String[] pathArr = {
        "img/amogus.png", "img/rick.png", "img/drake.png", "img/amogus.png",
        "img/amogus.png", "img/amogus.png", "img/amogus.png", "img/amogus.png",
        "img/amogus.png", "img/amogus.png", "img/amogus.png", "img/amogus.png",
        "img/amogus.png", "img/amogus.png", "img/amogus.png", "img/amogus.png"
                        };
    
    ImgChooser(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        

        bg = new JPanel();
        bg.setBounds(0, 0, 400, 400);
        bg.setLayout(null);
        bg.setBackground(Color.BLUE);

        this.setResizable(false);
        this.addWindowListener(this);
        this.setVisible(true);

        for (int i = 1; i <= 16; i++) {
            setImg(i, labelX, labelY, pathArr[i-1]);
            labelX += 100;

            if (i % 4 == 0 ) {
                labelX = 0;
                labelY += 100;
            }
        }

        this.add(bg);
    }

    public void setImg(int arg, int x, int y, String path){
        firstImg = new JLabel(new ImageIcon(path));
        firstImg.setOpaque(true);
        firstImg.setBackground(Color.black);
        firstImg.setBounds(x, y, 100, 100);
        

        bg.add(firstImg);
    }

    
        @Override
        public void windowOpened(WindowEvent e) {
        }
    
        @Override
        public void windowClosing(WindowEvent e) {
            StartFrame.isOpened = false;
            System.out.println(StartFrame.isOpened);
        }
    
        @Override
        public void windowClosed(WindowEvent e) {
        }
    
        @Override
        public void windowIconified(WindowEvent e) {
        }
    
        @Override
        public void windowDeiconified(WindowEvent e) {
        }
    
        @Override
        public void windowActivated(WindowEvent e) {
        }
    
        @Override
        public void windowDeactivated(WindowEvent e) {
        }
}
