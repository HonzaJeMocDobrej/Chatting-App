import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener{

    JPanel header;
    JPanel center;
    JPanel left;
    JPanel right;
    JPanel footer;

    JPanel inputContainer;

    JTextField input;

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

        inputContainer.add(input);

        footer.add(inputContainer);

        this.add(header, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
