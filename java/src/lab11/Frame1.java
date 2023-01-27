package lab11;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Frame1 extends Frame implements ActionListener {
    private Panel name_p, surname_p, gender_p, age_p, city_p, country_p, buttons_p;
    private TextField name_textField, surname_textField, city_textField, age_textField;
    private CheckboxGroup cbg;
    private Scrollbar ageScrollbar;
    private Choice country_list;
    private Button add, showAll;
    private ArrayList<Person> persons = new ArrayList<>();
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;


    class EventController implements AdjustmentListener {

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            age_textField.setText(String.valueOf(ageScrollbar.getValue()));
        }
    }

    public Frame1() throws FileNotFoundException {
        AdjustmentListener a = new EventController();
        setLayout(new GridLayout(7, 1));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });

        try {
            fos = new FileOutputStream("persons.dat");
            oos = new ObjectOutputStream(fos);
        } catch (IOException i) {
            i.printStackTrace();
        }

        File file = new File("persons.dat");

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    persons = (ArrayList<Person>) ois.readObject();

                } catch (EOFException error) {break;} catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            ois.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

        country_list = new Choice();
        country_list.setBounds(100, 100, 75, 75);
        country_list.add("Romania");
        country_list.add("UK");
        country_list.add("USA");
        country_list.add("France");
        country_list.add("Italy");

        name_p = new Panel();
        name_p.add(new Label("Name:"));
        name_p.add(name_textField = new TextField(20));

        surname_p = new Panel();
        surname_p.add(new Label("Surname:"));
        surname_p.add(surname_textField = new TextField(20));

        gender_p = new Panel();
        cbg = new CheckboxGroup();
        gender_p.add(new Label("gender:"));
        gender_p.add(new Checkbox("M", cbg, false));
        gender_p.add(new Checkbox("F", cbg, false));

        age_p = new Panel();
        age_p.add(new Label("Age:"));
        age_p.add(ageScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 1, 100));
        ageScrollbar.addAdjustmentListener(a);
        age_p.add(age_textField = new TextField(2));

        city_p = new Panel();
        city_p.add(new Label("City:"));
        city_p.add(city_textField = new TextField(20));

        country_p = new Panel();
        country_p.add(new Label("Country:"));
        country_p.add(country_list);

        buttons_p = new Panel();
        buttons_p.add(add = new Button("Add"));
        buttons_p.add(showAll = new Button("Show all"));

        add(name_p);
        add(surname_p);
        add(gender_p);
        add(age_p);
        add(city_p);
        add(country_p);
        add(buttons_p);

        setSize(300, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if (e.getSource() instanceof Button) {
            if (arg.equals("Add")) {
                try {
                    oos.writeObject(new Person(
                            name_textField.getText(),
                            surname_textField.getText(),
                            cbg.getSelectedCheckbox().toString(),
                            Integer.parseInt(age_textField.getText()),
                            city_textField.getText(),
                            country_list.getSelectedItem()
                    ));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (arg.equals("Show all")) {
                System.out.println(persons);
            }
        }
    }
}
