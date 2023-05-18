import javax.swing.*;
import javax.swing.plaf.TreeUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener, KeyListener,MouseListener{

    JPanel header;
    JPanel center;
    JPanel left;
    JPanel right;
    JPanel footer;

    JPanel inputContainer;
    JPanel rightFooterSection;
    JPanel leftFooterSection;
    JPanel textContent1;
    JPanel textContent;
    
    JLabel showedText;
    JLabel picLabel;
    JLabel sendImgLabel;
    JLabel usernLabel;
    JLabel showTopUsern;
    JLabel errorLabel;

    JScrollPane scroll;
    
    JTextField input;

    JButton switchUser1;
    JButton switchUser2;
    
    int x = 0;
    int y = -95;

    int textY = 0;
    int centerY = 395;

    int enterCount = 0;
    int lineBreak = 1;

    static String imgPath = "img/userLogo.png";
    String usern = StartFrame.usern1;
    String colorPanel = "#ade8f4";
    String colorHeadFoot = "#f2f2f2";

    static boolean isUser1 = true;
    
    ArrayList<JPanel> panels = new ArrayList<JPanel>();

    Font f1 = StartFrame.font;

    ImageIcon icon = new ImageIcon("img/chatIcon.png");
    

    MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setTitle("Chat App");
        this.setIconImage(icon.getImage());
        
        mainGuiContent();

        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    void mainGuiContent(){
        header = new JPanel();
        header.setBackground(Color.decode(colorHeadFoot));
        header.setLayout(new GridBagLayout());
        header.setPreferredSize(new Dimension(700, 60));

        center = new JPanel();
        center.setLayout(null);
        center.setBackground(Color.white);
        center.setPreferredSize(new Dimension(600, centerY));

        left = new JPanel();
        left.setBackground(Color.yellow);

        right = new JPanel();
        right.setBackground(Color.decode(colorHeadFoot));

        footer = new JPanel();
        footer.setBackground(Color.white);
        footer.setLayout(new BorderLayout());
        footer.setPreferredSize(new Dimension(700, 100));

        inputContainer = new JPanel();
        inputContainer.setBackground(Color.decode(colorHeadFoot));
        inputContainer.setLayout(new GridBagLayout());
        inputContainer.setPreferredSize(new Dimension(350, 70));

        rightFooterSection = new JPanel();
        rightFooterSection.setBackground(Color.decode(colorHeadFoot));
        rightFooterSection.setLayout(null);
        rightFooterSection.setPreferredSize(new Dimension(160, 100));

        leftFooterSection = new JPanel();
        leftFooterSection.setBackground(Color.decode(colorHeadFoot));
        leftFooterSection.setLayout(null);
        leftFooterSection.setPreferredSize(new Dimension(160, 100));

        input = new JTextField();
        input.setPreferredSize(new Dimension(350, 40));
        input.setFont(f1);
        input.setMargin(new Insets(0, 10, 0, 0));
        input.addKeyListener(this);

        showTopUsern = new JLabel(usern);
        showTopUsern.setBounds(200, 20, 200, 20);
        showTopUsern.setFont(new Font("Poppins.ttf", Font.BOLD, 25));

        sendImgLabel = new JLabel(new ImageIcon("img/img.png"));
        sendImgLabel.setSize(50, 50);
        sendImgLabel.setLocation(10, 25);
        sendImgLabel.addMouseListener(this);

        switchUser1 = new JButton();
        StartFrame.setBtnDesign(switchUser1, 35, 30, "Switch user");
        switchUser1.addMouseListener(this);
        
        switchUser2 = new JButton();
        StartFrame.setBtnDesign(switchUser2, 35, 30, "Switch user");
        switchUser2.addMouseListener(this);

        scroll = new JScrollPane(center);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            protected JButton noButtons(){
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                return button;
            }

                @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode("#9c9c9c");
            }
            
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return noButtons();
            }
            
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return noButtons();
            }
        });

        inputContainer.add(input);
        rightFooterSection.add(switchUser2);
        leftFooterSection.add(switchUser1);

        footer.add(inputContainer, BorderLayout.CENTER);
        footer.add(rightFooterSection, BorderLayout.EAST);
        footer.add(leftFooterSection, BorderLayout.WEST);

        header.add(showTopUsern);

        this.add(header, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
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

            if (str.trim().equals("") == false && input.getText().length() <= 200) {

                System.out.println(str);
                
                textContent1 = new JPanel();
                textContent1.setLayout(null);
                textContent1.setBackground(Color.decode(colorPanel));
                
                panels.add(textContent1);

                    int i = 0;
                    panels.get(panels.size() - 1).setBounds(x, y + (120 * (panels.size() - i)), 700, 100);
                    center.setPreferredSize(new Dimension(600, centerY));
                    if (panels.size() >= 3) {
                        centerY += 120;
                    }
                    i++;
                
                if (input.getText().length() >= 40) {
                    System.out.println("Letters: " + input.getText().length());
                    
                        String[] chunks = str.split("(?<=\\G.{40})");

                        for (String string : chunks) {
                            System.out.println(string);
                            String formattedText = "<html>" + 
                            string.replaceAll("\n", "<br>") + "</html>";

                            showedText = new JLabel();
                            showedText.setSize(700, 50);
                            showedText.setLocation(350, textY);
                            showedText.setText(formattedText);
                            textContent1.add(showedText);
                            textY += 15;
                    }
                    textY = 0;
                }

                else{
                    showedText = new JLabel();
                    showedText.setSize(700, 50);
                    showedText.setLocation(350, 25);
                    showedText.setText(str);
                    showedText.setFont(f1);
                    textContent1.add(showedText);
                }
                
                picLabel = new JLabel();
                picLabel.setIcon(new ImageIcon(imgPath));
                picLabel.setSize(100, 100);
                picLabel.setLocation(50,0);

                usernLabel = new JLabel();
                usernLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
                usernLabel.setText(usern);
                usernLabel.setSize(180, 50);
                usernLabel.setLocation(170, 23);

                textContent1.add(showedText);
                textContent1.add(picLabel);
                textContent1.add(usernLabel);
                center.add(textContent1);

                
                input.setText(null);
                
                enterCount++;
                System.out.println("panels size: " + panels.size()); 
                
                if (errorLabel != null) {
                    center.remove(errorLabel);
                }
            }

            else{
                if (errorLabel == null) {
                    errorLabel = new JLabel("", SwingConstants.CENTER);
                }
                errorLabel.setBounds(250, -10, 200, 50);
                errorLabel.setForeground(Color.decode("#fe8686"));
                if (str.trim().equals("")) {
                    errorLabel.setText("You cant send empty message");
                }
                else if (input.getText().length() >= 200) {
                    
                    errorLabel.setText("Text is too long");
                }
                center.add(errorLabel);
                input.setText(null);
            }
            this.validate();
            this.repaint();

        }
    }

    void setParams(String path, String mainFrameUsern, Boolean checkUsr){
        imgPath = path;
        usern = mainFrameUsern;
        isUser1 = checkUsr;
        showTopUsern.setText(mainFrameUsern);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == sendImgLabel) {
            System.out.println("Image clicked");
        }

        if (e.getSource() == switchUser1 || e.getSource() == switchUser2) {
            System.out.println(isUser1);
            if (isUser1 == true) {
                setParams(ImgChooser.secondActiveImg, StartFrame.usern2, false);
                colorPanel = "#0077b6";
            }
            else if (isUser1 == false) {
                setParams(ImgChooser.firstActiveImg, StartFrame.usern1, true);
                colorPanel = "#ade8f4";
            }
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}

