import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StateData extends JFrame implements ActionListener {
    static HashMap<String, unemploymentInfo> StateInfo = new HashMap<String,unemploymentInfo>();
//    private String mAbbreviation1;
//    private String mStateName1;
//    private float mURate1;

//    String mStateName1;
//    float mURate1;

    private JLabel StateName;
    private JLabel SAbbreviation;
    private JLabel SName;
    private JLabel SRate;
    private JPanel StateBox;
    private JPanel info;
    private JTextField abbreviation;
    private JButton button;
    private JFrame stateFrame;
    public static void main(String[] args)
    {
        new StateData();
        LoadUnemployment();

    }

    public StateData()
    {

       stateFrame = new JFrame();
       stateFrame.setPreferredSize(new Dimension(600,200));
       StateBox = new JPanel();
       info = new JPanel();
       abbreviation = new JTextField();
       abbreviation.setPreferredSize(new Dimension(20,40));

       button = new JButton("Enter: ");
       button.addActionListener(this);
       StateName = new JLabel("State: ");
       SAbbreviation = new JLabel("Abbreviation: ");
       SName = new JLabel("State name: ");
       SRate = new JLabel("Unemployment rate: ");
       StateBox.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
       StateBox.setLayout(new GridLayout(0, 3));
       StateBox.add(StateName);
       StateBox.add(abbreviation);
       StateBox.add(button);
        StateBox.add(SAbbreviation);
        StateBox.add(SName);
        StateBox.add(SRate);
       stateFrame.add(StateBox, BorderLayout.NORTH);
       stateFrame.add(info, BorderLayout.CENTER);
       stateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       stateFrame.setTitle("Let's Learn About States!");
       stateFrame.pack();
       stateFrame.setVisible(true);
    }

       private static HashMap<String, unemploymentInfo> LoadUnemployment() {
           Scanner reader = null;
           File unemployment = new File("unemployment.csv");
           try {
               reader = new Scanner(unemployment);
           } catch (FileNotFoundException e) {
               System.out.println("ERROR! FILE CANNOT BE FOUND!");
           }
           if(reader == null)
           {
               return null;
           }
           reader.nextLine();
          // HashMap<String, unemploymentInfo> StateInfo = new HashMap<String, unemploymentInfo>();// eat header
           while (reader.hasNext()) {
               String line = reader.nextLine();
               StringTokenizer tokenizer = new StringTokenizer(line, ",");

               String abb = tokenizer.nextToken();
               String sname = tokenizer.nextToken();
               float urate =  Float.valueOf(tokenizer.nextToken());

               unemploymentInfo s = new unemploymentInfo(abb,sname,urate);
               //System.out.println("tis object: " + s);

//               HashMap<String, unemploymentInfo> StateInfo = new HashMap<String, unemploymentInfo>();
               StateInfo.put(s.getmAbbreviation(),s);
           }
           return StateInfo;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(" new map: " + StateInfo);
        System.out.println("abbrev: " + abbreviation);
        String invalidInput = "";

        invalidInput = abbreviation.getText();
        if (invalidInput == null || invalidInput.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT AN ABBREVIATION!",
                    "Input Error",JOptionPane.ERROR_MESSAGE);
            return;
        }


        String abbreviationFromTextBox = abbreviation.getText().toUpperCase();

//        String invalidAbb = String.valueOf(StateInfo.get(abbreviationFromTextBox));
//        if (StateInfo.get(abbreviationFromTextBox).getmAbbreviation() == null)
//    {
//        JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT AN EXISTING STATE ABBREVIATION!",
//                "Input Error",JOptionPane.ERROR_MESSAGE);
//        return;
//    }

        SAbbreviation.setText("Abbreviation: " + StateInfo.get(abbreviationFromTextBox).getmAbbreviation());
        SName.setText("State name: " + StateInfo.get(abbreviationFromTextBox).getmStateName());
        SRate.setText("Unemployment rate: " + StateInfo.get(abbreviationFromTextBox).getmURate() + " %");

        System.out.println(StateInfo);

    }
}
