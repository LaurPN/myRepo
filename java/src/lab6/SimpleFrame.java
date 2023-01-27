package lab6;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class SimpleFrame extends Frame implements ActionListener {
    private TextField name, experienceInYearsTxt;
    private Label nameText, gender, jobDescription, experienceInYears, location;
    private Panel p1, p2, p3, p4, p5, p6;
    private CheckboxGroup cbg;
    private TextArea jobDescriptionText;
    private Scrollbar experienceScrollbar;
    private List locationList;
    private Button add, showAll;
    private ArrayList<Person> list;

    private final int DEFAULT_WIDTH = 600;
    private final int DEFAULT_HEIGHT = 600;

    class EventController implements AdjustmentListener {

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            experienceInYearsTxt.setText(String.valueOf(experienceScrollbar.getValue()));
        }
    }

    public SimpleFrame() {
        AdjustmentListener a = new EventController();
        setLayout(new GridLayout(6,1));
        this.name = new TextField(20);
        this.nameText = new Label("name");
        this.gender = new Label("gender");
        this.jobDescription = new Label("Job Description");
        this.experienceInYears = new Label("experience in years");
        this.location = new Label("location");
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        cbg = new CheckboxGroup();
        list = new ArrayList<>();


        jobDescriptionText = new TextArea(5, 20);

        experienceInYearsTxt = new TextField(1);

        experienceScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 1, 100);

        locationList = new List(1, true);

        add = new Button("add");

        showAll = new Button("show all");

        add.addActionListener(this);
        showAll.addActionListener(this);


        locationList.add("Bucuresti");
        locationList.add("Brasov");
        locationList.add("Cluj");


        p1.add(nameText);
        p1.add(name);
        add(p1);

        p2.add(gender);
        p2.add(new Checkbox("M", cbg, false));
        p2.add(new Checkbox("F", cbg, false));
        add(p2);

        p3.add(jobDescription);
        p3.add(jobDescriptionText);
        add(p3);

        p4.add(experienceInYears);
        p4.add(experienceInYearsTxt);
        experienceScrollbar.addAdjustmentListener(a);
        p4.add(experienceScrollbar);
        add(p4);

        p5.add(location);
        p5.add(locationList);
        add(p5);

        p6.add(add);
        p6.add(showAll);
        add(p6);

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if (e.getSource() instanceof Button) {
            if (arg.equals("add")) {
                list.add(new Person(name.getText(), cbg.getSelectedCheckbox().toString(), jobDescriptionText.getText(), Integer.parseInt(experienceInYearsTxt.getText()), locationList.getSelectedItem()));
                name.setText("");
                experienceInYearsTxt.setText("");
                jobDescriptionText.setText("");
            } else if (arg.equals("show all")) {
                System.out.println(list);
                SimpleFrame frame2 = new SimpleFrame();
                frame2.setVisible(true);
                TextArea t = new TextArea(40, 40);
                for (Person p : list) {
                    t.append(p.toString());
                }
                frame2.add(t);
            }
        }
    }
}
