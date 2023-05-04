import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartFrame extends JFrame implements ActionListener{

    JTextField input1;
    JButton button1;
    JLabel label1;
    JTextField input2;
    JButton button2;
    JLabel label2;
    JButton finalBtn;
    
    JPanel mainPanel;

    Font font = new Font("Ubuntu Mono Regular", Font.BOLD, 10);

    int width = 400;
    int height = 400;
    static String usern1 = "";
    static String usern2 = "";
    String btn3Act = "";

    StartFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, width, height);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(null);

        setLayout(1, 55, 90, mainPanel, input1, button1, label1, usern1);
        setLayout(2,  155, 190, mainPanel, input2, button2, label2, usern2);
        
        input1 = new JTextField();
        input1.setBounds(50, 50, 200, 30);
        
        input2 = new JTextField();
        input2.setBounds(50, 150, 200, 30);
        
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
        mainPanel.add(input1);
        mainPanel.add(input2);
        this.add(mainPanel);
    }

    void setLayout(int interp,  int btnY, int lblY, JPanel panel, 
                  JTextField input, JButton button,JLabel label, String username)
    {
        button = new JButton();
        button.setBounds(280, btnY, 70, 20);
        button.setFont(font);
        button.setText("Submit");
        button.addActionListener(this);
        button.setActionCommand(String.format("btn%s", interp));
        label = new JLabel();
        label.setBounds(80, lblY, 200, 30);
        label.setText(String.format("Set username for Acc %s", interp));

        panel.add(label);
        panel.add(button);
    }
    
    void checkBtn(String value, ActionEvent e, String username, JTextField input){
        if (e.getActionCommand().equals(value)) {
            username = input.getText();
            System.out.println("Username: " + input.getText());
        }
    }
    
    public void checkBothBtns(){
        if ((usern1.equals("") && usern2.equals(""))
        ||  (usern1.equals("") && usern2.equals("") == false)
        ||  (usern1.equals("") == false && usern2.equals(""))
        ){
            System.out.println("Denied");
        }
        else{
            getFinalBtn();
            System.out.println("Continue");
            
        }
    }

    
    JButton getFinalBtn(){
        finalBtn = new JButton();
        finalBtn.setText("Continue");
        finalBtn.setFont(font);
        finalBtn.setBounds(150, 250, 100, 40);
        finalBtn.addActionListener(this);
        finalBtn.setActionCommand("btn3");
        
        mainPanel.add(finalBtn);
        return finalBtn;   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btn1")) {
            usern1 = input1.getText();
            System.out.println("Username: " + input1.getText());
        }

        else if (e.getActionCommand().equals("btn2")){
            this.usern2 = input2.getText();
            System.out.println("Username: " + input2.getText());
        }

        else if (e.getActionCommand().equals("btn3")) {
            new MainFrame();
            this.dispose();
            System.out.println("banger");
        }

        System.out.println(e.getActionCommand());
        checkBothBtns();
        this.validate();
        this.repaint();
    }

    
}
