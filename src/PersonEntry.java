import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonEntry extends JFrame
{
    private JTextField  txtName;       //name
    private JTextField  txtAge;        //age
    private JButton     cmdSave;
    private JButton     cmdClose;
    private JButton     cmdClearAll;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
  
    public PersonEntry()
    {
        setTitle("Entering new person");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Name:")); 
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Age:"));
        txtAge = new JTextField(3);
        pnlDisplay.add(txtAge);
        pnlDisplay.setLayout(new GridLayout(2,4));
       
        cmdSave      = new JButton("Save");
        cmdClose   = new JButton("Close");

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }




}