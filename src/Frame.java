import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener, KeyListener{

    JPanel header;
    JPanel center;
    JPanel left;
    JPanel right;
    JPanel footer;

    JPanel inputContainer;
    
    JLabel showedText;
    
    JTextField input;
    JLabel picLabel;
    
    int x = 0;
    int y = 420;

    int textY = 0;

    int enterCount = 0;
    int lineBreak = 1;
    
    ArrayList<JPanel> panels = new ArrayList<JPanel>();
    
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
        center.setLayout(null);
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
                
                picLabel = new JLabel(new ImageIcon("img/userLogo.png"));
                picLabel.setSize(100, 100);
                picLabel.setLocation(50,0);

                textContent.add(showedText);
                textContent.add(picLabel);
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

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}

