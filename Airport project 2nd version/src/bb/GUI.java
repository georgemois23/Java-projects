package bb;

import java.awt.*;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame {

    JPanel panel = new JPanel();
    private JTextField OriginAirportCity;
    private String findflight;
    public GUI() {

        setSize(400, 200);
        setTitle("Airport Page");
        
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        OriginAirportCity = new JTextField(20);
        panel.add(OriginAirportCity);
        JButton findbutton = new JButton("Find");
        add(panel);

        setVisible(true); //set panels visibility 
        

        findbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input from the JTextField
                String userInput = OriginAirportCity.getText();
//                System.out.println(userInput);
                if (CentralRegistry.CityAirport(userInput) == null) {
                    JOptionPane.showMessageDialog(null, userInput + " does not have an airport", "Message",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    // Make the current panel invisible
                	setVisible(false);
                    
                                       

                    // Create a new frame
                    JFrame newFrame = new JFrame();
                    newFrame.setSize(850, 450);
                    newFrame.setTitle("Airport Page");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Dispose instead of exit
                    newFrame.setVisible(true);
                    
                    //make the frame not resizable 
                    newFrame.setResizable(false);
                    
                    // Create a new panel
                    JPanel newPanel = new JPanel(new GridLayout(4, 1, 5, 5));
                    newFrame.add(newPanel);
                    JPanel borderedPanel = new JPanel();

                    borderedPanel.setBorder(BorderFactory.createEtchedBorder());
                    borderedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

                    // 5 text fields with airport details
                    
                    //airport name
                    JTextField textField1 = new JTextField(15);
//                    textField1.setSize(getPreferredSize());
                    textField1.setText(CentralRegistry.CityAirport(userInput).getName());
                    textField1.setEditable(false);
                    borderedPanel.add(textField1);

                    //airport code
                    JTextField textField2 = new JTextField(15);
//                    textField2.setSize(getPreferredSize());
                    textField2.setText(CentralRegistry.CityAirport(userInput).getCode());
                    textField2.setEditable(false);
                    borderedPanel.add(textField2);

                    //airport city
                    JTextField textField3 = new JTextField(15);
//                    textField3.setSize(getPreferredSize());
                    textField3.setText(CentralRegistry.CityAirport(userInput).getCity());
                    textField3.setEditable(false);
                    borderedPanel.add(textField3);

                    //airport country
                    JTextField textField4 = new JTextField(15);
//                    textField4.setSize(getPreferredSize());
                    textField4.setEditable(false);
                    textField4.setText(CentralRegistry.CityAirport(userInput).getCountry());
                    borderedPanel.add(textField4);

                    //airport airlines
                    //using set in order to get only distinct airlines 
//                    System.out.println(CentralRegistry.CityAirport(userInput).getAirlines());
                    HashSet<String> distinctSet = new HashSet<String>();
                    for (String element : CentralRegistry.CityAirport(userInput).getAirlines()) {
                        distinctSet.add(element);
                    }
                    
                    //add the set to textarea
                    JTextArea textArea = new JTextArea();
                    textArea.setText(String.join("\n", distinctSet));
                    textArea.setEditable(false);
                    borderedPanel.add(textArea);
                    newPanel.add(borderedPanel);
                    

                    JTextField findFlights = new JTextField(20);
                    JButton submitFindFlights = new JButton("Find Flights");
                    
                    //southpanel is "find flights" panel
                    JPanel southPanel = new JPanel();
                    southPanel.add(findFlights);
                    southPanel.add(submitFindFlights,"Center");
                    newPanel.add(southPanel, BorderLayout.CENTER);
                    
                    
                    //newlinepanel is the panel with the 2 boxes 
                    JPanel newLinePanel = new JPanel();
                    newLinePanel.setPreferredSize(new java.awt.Dimension(800, 100));
                    newLinePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                    Box box1 = Box.createVerticalBox();
                    box1.setBorder(BorderFactory.createTitledBorder(""));
                    box1.setSize(200,200);
                    
                    //the textarea of the boxes will be in the box#TextArea
                    JTextArea box1TextArea = new JTextArea();
                    JTextArea box2TextArea = new JTextArea();
                    box1.add(box1TextArea);
                    
                    box1TextArea.setEditable(false);
                    JPanel SubmitPanelBackToSearch= new JPanel();
                    JButton submitBackToSearch = new JButton("Back to Search Screen");
                    //submitBackToSearch.setPreferredSize(new Dimension(150, 30));
                    SubmitPanelBackToSearch.add(submitBackToSearch,"Center");
                    
                    submitBackToSearch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	newFrame.setVisible(false);
                        	setVisible(true);
                        	OriginAirportCity.setText("");                        	
                        }});
                    
                    
                    Box box2 = Box.createVerticalBox();
                    box2.setBorder(BorderFactory.createTitledBorder(""));
                    box2.add(box2TextArea);
                    box2.setVisible(true); 
                    box2TextArea.setEditable(false); //set the textarea not editable
                    JPanel boxesPanel = new JPanel();
                    boxesPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 1 row, 2 columns, horizontal gap of 10 pixels
                    boxesPanel.add(box1);
                    boxesPanel.add(box2);
                    boxesPanel.setVisible(false);
                    newLinePanel.add(boxesPanel,"Center");
                    
                    newPanel.add(newLinePanel,BorderLayout.SOUTH);
                    newPanel.add(SubmitPanelBackToSearch);
                   
                    
                    submitFindFlights.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            findflight = findFlights.getText();
                            
                                                       
                            
                            //if the city that the user typed does not have an airport error message
                            if(CentralRegistry.CityAirport(findflight)==null) {JOptionPane.showMessageDialog(null,"This city does not have an airport!", "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            findFlights.setText("");
                            }
                            //if the city that the user typed have an airport...
                            else {
                            
                            //if the city that the user typed is the same as the origin error 
                            if (findflight.equals(userInput) || findflight==null) {
                                JOptionPane.showMessageDialog(null,"Arrival and departure city cannot be the same!", "Message",
                                        JOptionPane.INFORMATION_MESSAGE);
                                findFlights.setText("");
                                
                            //if the city that the user typed is not the same then...     
                            } else {
                                
                            	boxesPanel.setVisible(true); //show the 2 boxes that were visible until now    	
                  
                    Airport findflightuser=CentralRegistry.CityAirport(getFindFlight()); //store in findflightuser the airport that user searched now 
                    Airport originaluserinput=CentralRegistry.CityAirport(userInput); //store in originaluserinput the origin airport
                    
                    
                    if (CentralRegistry.getDirectFlightsDetails(findflightuser, originaluserinput)!=null){
                    //if the two airports have direct flights
                    box1TextArea.setText("DIRECT FLIGHTS DETAILS\n"+CentralRegistry.getDirectFlightsDetails(findflightuser, originaluserinput));}
                  //if the two airports does not have direct flights
                    else {
                    	
                   box1TextArea.setText("DIRECT FLIGHTS DETAILS\n"+"There are not direct flights");}
                   // box1.add(new TextArea("Hello"));
                    
                    if(CentralRegistry.getInDirectFlightsDetails(findflightuser, originaluserinput)!=null){
                    //if the two airports have indirect flights	
                    box2TextArea.setText("INDIRECT FLIGHTS through...\n"+CentralRegistry.getInDirectFlightsDetails(findflightuser, originaluserinput));}
                    else {
                   	//if the two airports does not have indirect flights		
                    box2TextArea.setText("INDIRECT FLIGHTS through...\n"+"There are not indirect flights");}
                   
                   
                } } }} );
                }}});
        panel.add(findbutton);
    }
    public String getFindFlight() {
        return findflight;
    }}

