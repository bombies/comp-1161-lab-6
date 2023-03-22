import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonEntry extends JFrame {
    private JTextField txtName;       //name
    private JTextField txtAge;        //age
    private JButton cmdSave;
    private JButton cmdClose;
    private JButton cmdClearAll;
    private JLabel publishLabel;
    private JCheckBox publishCheckBox;

    private JPanel pnlCommand;
    private JPanel pnlDisplay;

    private final PersonListing personListing;

    public PersonEntry(PersonListing personListing) {
        this.personListing = personListing;

        setTitle("Entering new person");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Age:"));
        txtAge = new JTextField(3);
        pnlDisplay.add(txtAge);
        publishLabel = new JLabel("Will Publish?");
        publishCheckBox = new JCheckBox();
        pnlDisplay.add(publishLabel);
        pnlDisplay.add(publishCheckBox);
        pnlDisplay.setLayout(new GridLayout(3, 2));

        cmdSave = new JButton("Save");
        cmdClose = new JButton("Close");
        cmdSave.addActionListener((event) -> {
            try {
                final var name = this.txtName.getText();
                final var age = Integer.parseInt(this.txtAge.getText());
                final var willPublish = publishCheckBox.isSelected();

                final var names = name.split(" ");
                if (names.length > 1) {
                    personListing.addPerson(new Person(name, age, willPublish));
                    setVisible(false);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }


        });
        cmdClose.addActionListener((event) -> this.setVisible(false));

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }


}