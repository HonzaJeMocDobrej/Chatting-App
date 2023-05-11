import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;
import java.io.Console;

public class ImgChooser extends JFrame implements WindowListener, MouseListener {
    JLabel img;
    JPanel bg;

    int labelX = 0;
    int labelY = 0;

    String[] pathArr = {
        "img/amogus.png", "img/rick.png", "img/drake.png", "img/beetlej.png",
        "img/honzaK.png", "img/majkl.png", "img/fandak.png", "img/fryhaus.png",
        "img/wazovski.png", "img/pikachu.png", "img/chungus.png", "img/discordMod.png",
        "img/travis.png", "img/kanye.png", "img/ronaldo.png", "img/messi.png"
                        };

    JLabel[] imgLabels = new JLabel[16];
    
    ImgChooser(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(410, 435);
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
            imgLabels[i-1] = setImg(i, labelX, labelY, pathArr[i-1], i);
            labelX += 100;

            if (i % 4 == 0 ) {
                labelX = 0;
                labelY += 100;
            }
        }

        this.add(bg);
    }

    public JLabel setImg(int arg, int x, int y, String path, int i){
        img = new JLabel(new ImageIcon(path));
        img.setOpaque(true);
        img.setBackground(Color.black);
        img.setBounds(x, y, 100, 100);
        img.addMouseListener(this);

        int index = i;
        
        bg.add(img);

        return img;
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

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(imgLabels[2]);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            for (JLabel jLabel : imgLabels) {
                jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
}
