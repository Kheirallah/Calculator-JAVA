import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.lang.*;

public class Calculator extends JFrame implements ActionListener 
{
   //Creating the buttons
    JButton buttonOne;          JButton buttonFour;         JButton buttonSeven;   JButton buttonZero;
    JButton buttonTwo;          JButton buttonFive;         JButton buttonEight;   JButton buttonAddition;
    JButton buttonThree;        JButton buttonSix;          JButton buttonNine;    JButton buttonClear;
    
    JButton buttonDivision;     
    JButton buttonMultiplication;      
    JButton buttonSubtraction; 
    JButton buttonEqual;
    
    //Creates the display area for output
    JTextArea display;
    
    boolean val;
  public Calculator()
          {
              //Assigning values to the buttons
              buttonOne = new JButton("1");
              buttonTwo = new JButton("2");
              buttonThree = new JButton("3");
              buttonFour = new JButton("4");
              buttonFive = new JButton("5");
              buttonSix = new JButton("6");
              buttonSeven = new JButton("7");
              buttonEight = new JButton("8");
              buttonNine = new JButton("9");
              buttonZero= new JButton("0");
              
              buttonMultiplication = new JButton("*");
              buttonDivision = new JButton ("/");
              buttonSubtraction = new JButton("-");
              buttonAddition = new JButton("+");
              
              buttonClear = new JButton("Clear");
              buttonEqual = new JButton("=");
              
               //Setting calculator layout
              JPanel panelOne = new JPanel();
              panelOne.setLayout(new GridLayout(3,4,2,2));
              panelOne.add(buttonOne);
              panelOne.add(buttonTwo);
              panelOne.add(buttonThree);
              panelOne.add(buttonDivision);
              panelOne.add(buttonFour);
              panelOne.add(buttonFive);
              panelOne.add(buttonSix);
              panelOne.add(buttonMultiplication);
              panelOne.add(buttonSeven);
              panelOne.add(buttonEight);
              panelOne.add(buttonNine);
              panelOne.add(buttonSubtraction);      
              
              
              JPanel panelTwo = new JPanel();
              panelTwo.setLayout(new GridLayout(2,2,2,2));
              panelTwo.add(buttonZero);
              panelTwo.add(buttonAddition);
              panelTwo.add(buttonClear);
              panelTwo.add(buttonEqual);
              
    
              JPanel panelThree = new JPanel();
              display = new JTextArea();
              panelThree.add(display);
              display.setEditable(false);
              display.setVisible(true);
              display.setPreferredSize(new Dimension (375, 40));
              
              //Action Listeners
               buttonOne.addActionListener(this);
               buttonTwo.addActionListener(this);
               buttonThree.addActionListener(this);
               buttonDivision.addActionListener(this);
               buttonFour.addActionListener(this);
               buttonFive.addActionListener(this);
               buttonSix.addActionListener(this);
               buttonMultiplication.addActionListener(this);
               buttonSeven.addActionListener(this);
               buttonEight.addActionListener(this);
               buttonNine.addActionListener(this);
               buttonSubtraction.addActionListener(this);
               buttonZero.addActionListener(this);
               buttonAddition.addActionListener(this);
               buttonClear.addActionListener(this);
               buttonEqual.addActionListener(this);
              
              //Creating Content Pane
              getContentPane().add(panelThree, BorderLayout.NORTH);
              getContentPane().add(panelOne, BorderLayout.CENTER);
              getContentPane().add(panelTwo, BorderLayout.SOUTH);
              
               
          }
          
  public void actionPerformed(ActionEvent event)
  {
     
     if (val)
     {
     display.setText("");
     val = false;
     }
     
      
      if(event.getSource() == buttonOne)
      {
          display.append("1");
      }
      if(event.getSource() == buttonTwo)
      {
          display.append("2");
      }
      if(event.getSource() == buttonThree)
      {
          display.append("3");
      }
      if(event.getSource() == buttonDivision)
      {
          display.append("/");
      }
      if(event.getSource() == buttonFour)
      {
          display.append("4");
      }
      if(event.getSource() == buttonFive)
      {
          display.append("5");
      }
      if(event.getSource() == buttonSix)
      {
          display.append("6");
      }
      if(event.getSource() == buttonMultiplication)
      {
          display.append("*");
      }
      if(event.getSource() == buttonSeven)
      {
          display.append("7");
      }
      if(event.getSource() == buttonEight)
      {
          display.append("8");
      }
      if(event.getSource() == buttonNine)
      {
          display.append("9");
      }
      if(event.getSource()== buttonSubtraction)
      {
          display.append("-");
      }
      if(event.getSource() == buttonZero)
      {
          display.append("0");
      }
      if(event.getSource() == buttonAddition)
      {
          display.append("+");
      }
      if(event.getSource() == buttonClear)
      {
          display.setText("");
      }
      
      if(event.getSource() == buttonEqual)
      {   
          String Holder;
          Holder = display.getText();
          //Holder is the input passed in as a string once user presses equal sign
          Calculation(Holder);
          val = true;
      }
  }
  
  //Function to perform actual calculations 
  void Calculation(String testValue)
  {
      String valueOne="";
      String valueTwo="";
      float numberValueOne; 
      float numberValueTwo;
      char [] operator = testValue.toCharArray();
      char op = 'A';
      int counterOne;
      int counterTwo;
      float result = 0;

      
     
      
      //Retrieves the operator and two values from the string      
      for(counterOne=0; counterOne<operator.length; counterOne++)
      {
          if(operator[counterOne] == '+' || operator[counterOne] == '-' || operator[counterOne] == '*' || operator[counterOne ]== '/')
          {
              op = operator[counterOne];
              break;
          }
          
          else
          {
              valueOne = valueOne+operator[counterOne];
             
          }
      }
      
      for(counterTwo = counterOne +1; counterTwo < operator.length; counterTwo++)
      {
              valueTwo = valueTwo+operator[counterTwo];
      }
     
      
      numberValueOne = Float.parseFloat(valueOne);
      numberValueTwo = Float.parseFloat(valueTwo);
    
      
      if( op == '+')
      {
         result = numberValueOne+numberValueTwo;
         System.out.println(result);
      }
     
      if(op == '-')
      {
          result = numberValueOne - numberValueTwo;
         System.out.println(result);
      }
      
      if(op == '/')
      {
      
         //test case to check for division by zero
          if (numberValueTwo == 0)
          {
          result = 0;
          System.out.println("Division by zero is not allowed");
          }

          else
          result = numberValueOne/numberValueTwo;

         System.out.println(result);
      }
      
      if(op == '*')
      {
          result = numberValueOne*numberValueTwo;
          System.out.println(result);
        
      }
      
      //Appends results to display
      display.append("=");
      display.append(String.valueOf(result)); 
      
     
 }
  
    public static void main(String[] args) 
    {
       Calculator newCalc = new Calculator();
       newCalc.setVisible(true);
       newCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       newCalc.setSize(400,400);
       
    }
    
}
