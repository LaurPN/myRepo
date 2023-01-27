package lab10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Frame1 extends Frame implements ActionListener {
    private TextArea airport_text_field;
    private Panel p1, p2, p3, p2_aux, p2_aux_2, p2_aux_3, p2_aux_4, p4;
    private TextField id_text_field, departure_text_field, arrival_text_field, time_text_field;
    private Button load_flights, compute_cost, add_flight;
    private Airport airport;



    public Frame1(Airport airport) {
        this.airport = airport;
        setLayout(new GridLayout(2, 1));
         airport_text_field = new TextArea(5, 20);
         p1 = new Panel();
         p1.setLayout(new GridLayout(1,2));
         p2 = new Panel();
         p2.setLayout(new GridLayout(4, 1));
         p1.add(p2);
         p3 = new Panel();

         p2_aux = new Panel();
         p2_aux.add(new Label("ID"));
         id_text_field = new TextField(20);
         p2_aux.add(id_text_field);

         p2_aux_2 = new Panel();
         p2_aux_2.add(new Label("departure"));
         departure_text_field = new TextField(20);
         p2_aux_2.add(departure_text_field);

         p2_aux_3 = new Panel();
         p2_aux_3.add(new Label("Arrival"));
         arrival_text_field = new TextField(20);
         p2_aux_3.add(arrival_text_field);

         p2_aux_4 = new Panel();
         p2_aux_4.add(new Label("Time"));
         time_text_field = new TextField(20);
         p2_aux_4.add(time_text_field);

         airport_text_field = new TextArea(40,30);
         p3.add(new Label("Airport"));
         p3.add(airport_text_field);

         load_flights = new Button("Load flights");
         compute_cost = new Button("Compute cost");
         add_flight = new Button("Add flight");

         load_flights.addActionListener(this);
         compute_cost.addActionListener(this);
         add_flight.addActionListener(this);

         p4 = new Panel();
         p4.setLayout(new FlowLayout());
         p4.add(load_flights);
         p4.add(compute_cost);
         p4.add(add_flight);


         p2.add(p2_aux);
         p2.add(p2_aux_2);
         p2.add(p2_aux_3);
         p2.add(p2_aux_4);
         p1.add(p3);
         add(p1);
         add(p4);


         setSize(600, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if (e.getSource() instanceof Button) {
            if (arg.equals("Load flights")) {
                airport_text_field.setText(airport.getFlights().toString());
            } else if (arg.equals("Add flight")) {
                InternalFlight flight = new InternalFlight(Long.parseLong(id_text_field.getText()), departure_text_field.getText(), arrival_text_field.getText(), Integer.parseInt(time_text_field.getText()));
                List<Flight> flightList= airport.getFlights();
                flightList.add(flight);
                airport.setFlights(flightList);
            }
        }
    }
}
