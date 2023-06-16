package konwerter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class karol implements ActionListener {

    int number;
	String answer;
  
    JFrame frame;
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JTextField textField = new JTextField();
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonClear = new JButton("WYCZYŒÆ");
    JButton buttonDelete = new JButton("DEL");
    JButton buttondecbin = new JButton("DEC->BIN");
    JButton buttonbindec = new JButton("BIN->DEC");
 
    karol() {
        prepareGUI();
        addComponents();
        addActionEvent();
    }
 
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Konwerter");
        frame.setSize(300, 490);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public void addComponents() {
    	//tu bêdzie wyœwietlany rodzaj zamiany
        label.setBounds(10, 0, 290, 50);
        label.setForeground(Color.white);
        frame.add(label);
        
        //komentarz
        label2.setBounds(10, 70, 290, 50);
        label2.setForeground(Color.white);
        frame.add(label2);
        label2.setText("1. Wpisz liczbê                     2. Wybierz konwersjê");
 
        //g³ówne okienko
        textField.setBounds(10, 40, 275, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        
        //przyciski numeryczne

        buttonSeven.setBounds(10, 230, 70, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSeven);
 
        buttonEight.setBounds(110, 230, 70, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight);
 
        buttonNine.setBounds(210 , 230, 70, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine);
 
        buttonFour.setBounds(10, 290, 70, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour);
 
        buttonFive.setBounds(110, 290, 70, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive);
 
        buttonSix.setBounds(210, 290, 70, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix);
 
        buttonOne.setBounds(10, 350, 70, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne);
 
        buttonTwo.setBounds(110, 350, 70, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo);
 
        buttonThree.setBounds(210, 350, 70, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree);

        buttonZero.setBounds(10, 410, 270, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonZero);
        

        //przyciski wyboru rodzaju konwersji
        
        buttondecbin.setBounds(10, 110, 130, 40);
        buttondecbin.setFont(new Font("Arial", Font.BOLD, 20));
        buttondecbin.setBackground(new Color(239, 188, 2));
        frame.add(buttondecbin);

        buttonbindec.setBounds(150, 110, 130, 40);
        buttonbindec.setFont(new Font("Arial", Font.BOLD, 20));
        buttonbindec.setBackground(new Color(239, 188, 2));
        frame.add(buttonbindec);

        //przyciski wyczyœæ i DEL
        
        buttonDelete.setBounds(150, 170, 130, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        frame.add(buttonDelete);
 
        buttonClear.setBounds(10, 170, 130, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        frame.add(buttonClear);
 
    }
 
    public void addActionEvent() {
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttondecbin.addActionListener(this);
        buttonbindec.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonZero.addActionListener(this);
 
 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonClear) {
            //czyszczenie pól 'label' i 'textfield'
            label.setText("");
            textField.setText("");
        } else if (source == buttonDelete) {
            //przycisk 'DEL'
            int length = textField.getText().length();
            int number = length - 1;
 
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
 
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        } 
        else if (source == buttonbindec) {
            number = (int) Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText("Zamiana z systemu binarnego na dziesiêtny");
            //zamiana na dziesiêtny
            double output=0;
            String temp=textField.getText();
            for(int i=0;i<temp.length();i++){

               if(temp.charAt(i)== '1')
                 output=output + Math.pow(2,temp.length()-1-i);
            }
            answer=Double.toString(output);
	        textField.setText(answer);
        } else if (source == buttondecbin) {
            number = (int) Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText("Zamiana z systemu dziesiêtnego na binarny");
            //zamiana na binarny
            answer = Integer.toBinaryString(number);
            textField.setText(answer);
        } 
 
 
    }
 

	public void enable() {
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttondecbin.setEnabled(true);
        buttonbindec.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonZero.setEnabled(true);
 
    }
 
    public void disable() {
        textField.setText("");
        label.setText(" ");
        buttonClear.setEnabled(false);
        buttonDelete.setEnabled(false);
        buttondecbin.setEnabled(false);
        buttonbindec.setEnabled(false);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonOne.setEnabled(false);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonZero.setEnabled(false);
    }
    
    public static void main(String[] args)
    {
            new karol();
    }
    
}