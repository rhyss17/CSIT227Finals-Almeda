import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame {
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;

    public App() {
        ButtonGroup type = new ButtonGroup();
        type.add(rbCustomer);
        type.add(rbClerk);
        type.add(rbManager);
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());

                    if(age < 0){
                        throw (new AgeNegativeException("Invalid Age"));
                    }
                    if (rbCustomer.isSelected()) {
                        persons.add(new Person.Customer(name, age));
                    } else if (rbClerk.isSelected()) {
                        int month = Integer.parseInt(tfMonths.getText());
                        int salary = Integer.parseInt(tfSalary.getText());
                        persons.add(new Person.Employee.Clerk(name, age, month, salary));
                    } else if (rbManager.isSelected()) {
                        int month = Integer.parseInt(tfMonths.getText());
                        int salary = Integer.parseInt(tfSalary.getText());
                        persons.add(new Person.Employee.Manager(name, age, month, salary));
                    }
                }catch (InputMismatchException a){
                    JOptionPane.showMessageDialog(null, "Invalid");
                }catch(AgeNegativeException b){
                    JOptionPane.showMessageDialog(null, b.getMessage());
                }catch (NumberFormatException c){
                    JOptionPane.showMessageDialog(null, "tried to enter letter as a number");
                }catch (Exception d){

                }

                tfName.setText(null);
                tfAge.setText(null);
                tfMonths.setText(null);
                tfSalary.setText(null);
                tfLoad.setText(null);
                }
            }
        });

     btnClear.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             tfName.setText(null);
             tfAge.setText(null);
             tfMonths.setText(null);
             tfSalary.setText(null);
             tfLoad.setText(null);
         }
     });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(500, 300);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    static void giveReward(int n) {

    }
}
