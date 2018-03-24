import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JButton button = new JButton("Press This !");
    private JTextField inpt = new JTextField();
    //    private JTextField inpt2 = new JTextField("",1);
    private JLabel label = new JLabel("Input");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Or this");

    public GUI() {
        super("Simple Example");
        this.setBounds(150, 150, 1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 1, 1, 20));
        container.add(label);
        container.add(inpt);
//        container.add(inpt2);

        ButtonGroup goup = new ButtonGroup();
        goup.add(radio1);
        goup.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    class ButtonEventListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("press");
            DBCoonect dbCoonect = new DBCoonect(GUI.this);
            System.out.println(dbCoonect.doRequestWhenClick());


            String messege = "";
            messege += (dbCoonect.res);
            System.out.println(messege);
            JOptionPane.showMessageDialog(null, messege,"Output", JOptionPane.PLAIN_MESSAGE);

        }

    }

    public JTextField getInpt() {
        return inpt;
    }

    public void setInpt(JTextField inpt) {
        this.inpt = inpt;
    }
}