import javax.swing.*;

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
    
    JLabel showedText;
    JLabel picLabel;
    JLabel sendImgLabel;
    JLabel usernLabel;
    JLabel showTopUsern;
    
    JTextField input;

    JButton switchUser;
    
    int x = 0;
    int y = 420;

    int textY = 0;

    int enterCount = 0;
    int lineBreak = 1;

    static String imgPath = "img/userLogo.png";
    String usern = StartFrame.usern1;

    static boolean isUser1 = true;
    
    ArrayList<JPanel> panels = new ArrayList<JPanel>();

    Font f1 = new Font("Ubuntu Mono Regular", Font.PLAIN, 19);

    MainFrame(){
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
        header.setLayout(new GridBagLayout());
        header.setPreferredSize(new Dimension(700, 60));

        center = new JPanel();
        center.setLayout(null);
        center.setBackground(Color.green);

        left = new JPanel();
        left.setBackground(Color.yellow);

        right = new JPanel();
        right.setBackground(Color.red);

        footer = new JPanel();
        footer.setBackground(Color.white);
        footer.setLayout(new BorderLayout());
        footer.setPreferredSize(new Dimension(700, 100));

        inputContainer = new JPanel();
        inputContainer.setBackground(Color.black);
        inputContainer.setLayout(new GridBagLayout());
        inputContainer.setPreferredSize(new Dimension(350, 70));

        rightFooterSection = new JPanel();
        rightFooterSection.setBackground(Color.red);
        rightFooterSection.setLayout(null);
        rightFooterSection.setPreferredSize(new Dimension(160, 100));

        leftFooterSection = new JPanel();
        leftFooterSection.setBackground(Color.red);
        leftFooterSection.setLayout(null);
        leftFooterSection.setPreferredSize(new Dimension(160, 100));

        input = new JTextField();
        input.setPreferredSize(new Dimension(350, 40));
        input.setFont(f1);
        input.addKeyListener(this);

        showTopUsern = new JLabel(usern);
        showTopUsern.setBounds(200, 20, 200, 20);
        showTopUsern.setFont(new Font("Ubuntu Mono Regular", Font.PLAIN, 25));

        sendImgLabel = new JLabel(new ImageIcon("img/img.png"));
        sendImgLabel.setSize(50, 50);
        sendImgLabel.setLocation(10, 25);
        sendImgLabel.addMouseListener(this);

        switchUser = new JButton();
        switchUser.setBounds(30, 35, 100, 30);
        switchUser.setText("Switch user");
        switchUser.setFont(new Font("Ubuntu Mono Regular", Font.PLAIN, 12));
        switchUser.addMouseListener(this);

        inputContainer.add(input);
        rightFooterSection.add(sendImgLabel);
        leftFooterSection.add(switchUser);

        footer.add(inputContainer, BorderLayout.CENTER);
        footer.add(rightFooterSection, BorderLayout.EAST);
        footer.add(leftFooterSection, BorderLayout.WEST);

        header.add(showTopUsern);

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

            if (str.equals("") == false && input.getText().length() <= 200) {

                System.out.println(str);
                
                JPanel textContent = new JPanel();
                textContent.setLayout(null);
                textContent.setBackground(Color.yellow);
                
                
                panels.add(textContent);

                
                for (int i = 0; i < panels.size(); i++) {
                    panels.get(i).setBounds(x, y - (120 * (panels.size() - i)), 700, 100);
                    if (panels.get(i).getY() <= 0) {
                        center.remove(panels.get(i));
                        System.out.println("Panel " + i + " Removed");
                        System.out.println(panels.get(i).getBounds());
                    }
                }
                
                
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
                            textContent.add(showedText);
                            textY += 15;
                    }
                    textY = 0;
                }

                else{
                    showedText = new JLabel();
                    showedText.setSize(700, 50);
                    showedText.setLocation(350, 25);
                    showedText.setText(str);
                    textContent.add(showedText);
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

                textContent.add(showedText);
                textContent.add(picLabel);
                textContent.add(usernLabel);
                center.add(textContent);
            
                input.setText(null);

                this.validate();
                this.repaint();

                enterCount++;
                System.out.println("panels size: " + panels.size()); 
            }

            else{
                input.setText(null);
                System.out.println("\n Text is too long");
            }
            
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

        if (e.getSource() == switchUser) {
            System.out.println(isUser1);
            if (isUser1 == true) {
                setParams(ImgChooser.secondActiveImg, StartFrame.usern2, false);
            }
            else if (isUser1 == false) {
                setParams(ImgChooser.firstActiveImg, StartFrame.usern1, true);
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

