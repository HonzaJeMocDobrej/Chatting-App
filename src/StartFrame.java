import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartFrame extends JFrame{

    JTextField input1;
    JButton button1;
    JLabel label1;
    JTextField input2;
    JButton button2;
    JLabel label2;
    
    JPanel mainPanel;

    Font font = new Font("Ubuntu Mono Regular", Font.BOLD, 10);

    int width = 400;
    int height = 400;

    StartFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, width, height);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(null);

        setInput(1, 50, 55, 90, mainPanel, input1, button1, label1);
        setInput(2, 150, 155, 190, mainPanel, input2, button2, label2);
        
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        
        this.add(mainPanel);
    }

    void setInput(int interp, int inpY, int btnY, int lblY, JPanel panel, 
                  JTextField input, JButton button,JLabel label)
    {
        input = new JTextField();
        input.setBounds(50, inpY, 200, 30);
        button = new JButton();
        button.setBounds(280, btnY, 70, 20);
        button.setFont(font);
        button.setText("Submit");
        label = new JLabel();
        label.setBounds(80, lblY, 200, 30);
        label.setText(String.format("Set username for Acc %s", interp));

        panel.add(label);
        panel.add(input);
        panel.add(button);
    }
}
