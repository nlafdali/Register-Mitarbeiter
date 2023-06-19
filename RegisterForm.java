package MeinFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.ImageIcon;

public class RegisterForm extends JFrame {

    private JPanel contentPane;
    private JTextField textName;
    private JTextField textGehalt;
    private JTable table;

    private final ButtonGroup buttonGroup = new ButtonGroup();

    DefaultTableModel myTable = new DefaultTableModel();
    
    

  
    
    public RegisterForm() {
        	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 100, 646, 815);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 0));
        panel.setBounds(10, 10, 612, 760);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(10, 53, 592, 664);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblName = new JLabel("Name Mitarbeiter");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblName.setBounds(10, 25, 147, 25);
        panel_1.add(lblName);

        JLabel lblGehalt = new JLabel("Gehalt");
        lblGehalt.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGehalt.setBounds(10, 74, 147, 25);
        panel_1.add(lblGehalt);

        JLabel lblGender = new JLabel("Geschlecht");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGender.setBounds(10, 114, 147, 25);
        panel_1.add(lblGender);

        JLabel lblAbteilung = new JLabel("Abteilung");
        lblAbteilung.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAbteilung.setBounds(10, 166, 147, 25);
        panel_1.add(lblAbteilung);

        textName = new JTextField();
        textName.setBounds(209, 25, 345, 23);
        panel_1.add(textName);
        textName.setColumns(10);

        textGehalt = new JTextField();
        textGehalt.setColumns(10);
        textGehalt.setBounds(209, 65, 345, 23);
        panel_1.add(textGehalt);

        table = new JTable();
        table.setSurrendersFocusOnKeystroke(true);
        table.setBackground(new Color(128, 128, 128));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 225, 572, 344);
        panel_1.add(scrollPane);

        JComboBox<String> comboBox_Abteilung = new JComboBox<String>();
        comboBox_Abteilung.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox_Abteilung.setForeground(new Color(128, 0, 0));
        comboBox_Abteilung.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Personal", "IT_Abteilung", "Buchhaltung", "Verwaltung", "Logistik" }));
        comboBox_Abteilung.setToolTipText("");
        comboBox_Abteilung.setBounds(209, 169, 345, 21);
        panel_1.add(comboBox_Abteilung);

        JRadioButton rdbtnMan = new JRadioButton("männlich");
        rdbtnMan.setForeground(new Color(0, 0, 0));
        rdbtnMan.setFont(new Font("Tahoma", Font.BOLD, 13));
        rdbtnMan.setSelected(true);
        rdbtnMan.setBounds(209, 117, 103, 21);
        panel_1.add(rdbtnMan);

        JRadioButton rdbtnWeiblich = new JRadioButton("weiblich");
        rdbtnWeiblich.setBounds(349, 117, 103, 21);
        panel_1.add(rdbtnWeiblich);

        buttonGroup.add(rdbtnMan);
        buttonGroup.add(rdbtnWeiblich);

        JButton btn_add = new JButton("einfügen");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!textName.getText().isEmpty() && !textGehalt.getText().isEmpty()) {
                    String mitarbeiterName = textName.getText();
                    double mitarbeiterGehalt = Double.parseDouble(textGehalt.getText());
                    String geschlecht;
                    if (rdbtnMan.isSelected()) {
                        geschlecht = "männlich";
                    } else {
                        geschlecht = "weiblich";
                    }
                    String abteilungName = comboBox_Abteilung.getSelectedItem().toString();
                    JOptionPane.showMessageDialog(null,
                            "Die Name der Mitarbeiter: " + mitarbeiterName + "\nGehalt ist: " + mitarbeiterGehalt
                                    + "\nist: " + geschlecht + " \narbeitet in der " + abteilungName + "Abteilung");

                    myTable.addRow(new Object[] { mitarbeiterName, mitarbeiterGehalt, geschlecht, abteilungName });
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus.");
                }
            }
        });
        btn_add.setBackground(new Color(128, 0, 0));
        btn_add.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_add.setBounds(457, 607, 125, 32);
        panel_1.add(btn_add);

        myTable.addColumn("Mitarbeiter Name");
        myTable.addColumn("Gehalt");
        myTable.addColumn("Geschlecht");
        myTable.addColumn("Abteilung");

        table.setModel(myTable);
        
        JLabel lblNewLabel = new JLabel("Unternehmen");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Student\\eclipse-workspace\\MeinTaschenRechner\\src\\MeinFrame\\Coura-icon.png"));
        lblNewLabel.setBounds(178, 10, 232, 51);
        panel.add(lblNewLabel);
    }
}