import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;  
import java.io.Console;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartFrame extends JFrame implements ActionListener{

    JTextField input1;
    JButton button1;
    JLabel userLabel1;
    static JLabel userImg1;
    JButton userImgButton1;

    JTextField input2;
    JButton button2;
    JLabel userLabel2;
    JLabel userImg2;
    JButton userImgButton2;

    JButton finalBtn;
    
    JPanel mainPanel;

    Font font = new Font("Ubuntu Mono Regular", Font.BOLD, 10);

    int width = 600;
    int height = 600;
    static String usern1 = "";
    static String usern2 = "";
    String btn3Act = "";

    static boolean isOpened = false;

    ImgChooser imgChooser;

    StartFrame(){
        
    }

    public void createFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, width, height);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(null);

        setLayout(1, 55, 90, mainPanel, input1, button1, userLabel1, usern1);
        setLayout(2,  255, 290, mainPanel, input2, button2, userLabel2, usern2);
        
        input1 = new JTextField();
        input1.setBounds(150, 50, 200, 30);

        userImg1 = new JLabel();
        userImg1.setIcon(new ImageIcon(ImgChooser.firstActiveImg));
        userImg1.setBounds(150, 80, 200, 200);

        userImgButton1 = setImgBtn(userImgButton1, "imgBtn1", 165);
        
        input2 = new JTextField();
        input2.setBounds(150, 250, 200, 30);

        userImg2 = new JLabel();
        userImg2.setIcon(new ImageIcon(ImgChooser.firstActiveImg));
        userImg2.setBounds(150, 290, 200, 200);
        
        userImgButton2 = setImgBtn(userImgButton2, "imgBtn2", 380);
        
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
        mainPanel.add(input1);
        mainPanel.add(userImg1);
        mainPanel.add(userImgButton1);
        mainPanel.add(input2);
        mainPanel.add(userImg2);
        mainPanel.add(userImgButton2);
        this.add(mainPanel);
        
        this.repaint();
        this.revalidate();
    }

    public void refresh(){
        this.repaint();
        this.revalidate();
    }
    
    void setLayout(int interp,  int btnY, int lblY, JPanel panel, 
    JTextField input, JButton button,JLabel label, String username)
    {
        button = new JButton();
        button.setBounds(380, btnY, 70, 20);
        button.setFont(font);
        button.setText("Submit");
        button.addActionListener(this);
        button.setActionCommand(String.format("btn%s", interp));
        label = new JLabel();
        label.setBounds(180, lblY, 200, 30);
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
            // System.out.println("Denied");
        }
        else{
            getFinalBtn();
            System.out.println("Continue");
            
        }
    }

    public JButton setImgBtn(JButton btn, String str, int y){
        btn = new JButton("Select");
        btn.setFont(font);
        btn.setBounds(380, y, 70, 20);
        btn.setActionCommand(str);
        btn.addActionListener(this);
        return btn;
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

        else if (e.getActionCommand().equals("imgBtn1")) {
            if (isOpened == false) {
                imgChooser = new ImgChooser();
                isOpened = true;
            }

            else if (isOpened == true) {
                imgChooser.dispose();
                isOpened = false;
            }
            
        }


        System.out.println(e.getActionCommand());
        checkBothBtns();
        this.validate();
        this.repaint();
    }

}
