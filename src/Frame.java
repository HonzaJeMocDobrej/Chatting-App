import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Frame extends JFrame implements ActionListener, KeyListener{

    JPanel header;
    JPanel center;
    JPanel left;
    JPanel right;
    JPanel footer;

    JPanel inputContainer;

    JTextField input;

    Font f1 = new Font("Ubuntu Mono Regular", Font.PLAIN, 19);

    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        mainGuiContent();

        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    void mainGuiContent(){
        header = new JPanel();
        header.setBackground(Color.white);
        header.setPreferredSize(new Dimension(60, 60));

        center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(Color.green);

        left = new JPanel();
        left.setBackground(Color.yellow);

        right = new JPanel();
        right.setBackground(Color.red);

        footer = new JPanel();
        footer.setBackground(Color.white);
        footer.setLayout(new GridBagLayout());
        footer.setPreferredSize(new Dimension(100, 100));

        inputContainer = new JPanel();
        inputContainer.setBackground(Color.black);
        inputContainer.setLayout(new GridBagLayout());
        inputContainer.setPreferredSize(new Dimension(500, 70));

        input = new JTextField();
        input.setPreferredSize(new Dimension(500, 40));
        input.setFont(f1);
        input.addKeyListener(this);

        inputContainer.add(input);

        footer.add(inputContainer);

        this.add(header, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String str = input.getText();
            System.out.println(str);

            JLabel test = new JLabel();
            test.setText(str);

            center.add(test);

            this.validate();
            this.repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
