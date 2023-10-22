import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[12];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton,cosButton,sinButton,tanButton;
	JPanel panel;
	
	Font myFont = new Font("Book Antiqua",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 600);
		frame.setLayout(null);
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setBackground(Color.GRAY);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		cosButton=new JButton("cos");
		sinButton=new JButton("sin");
		tanButton=new JButton("tan");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = cosButton;
		functionButtons[10] = sinButton;
		functionButtons[11] = tanButton;

		
		for(int i =0;i<12;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		cosButton.setBounds(50, 420, 100 ,50 );
		sinButton.setBounds(150, 420, 100 ,50 );
		tanButton.setBounds(250, 420, 100 ,50 );
		negButton.setBounds(50,480,100,50);
		delButton.setBounds(150,480,100,50);
		clrButton.setBounds(250,480,100,50);

		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.GRAY);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(cosButton);
		frame.add(sinButton);
		frame.add(tanButton);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource()==cosButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			//textfield.setText(textfield.getText().concat("cos(").concat(String.valueOf(num1)).concat((")")));
			result=Math.cos(num1);
			textfield.setText(String.valueOf(result));
			num1=result;

		}
		if(e.getSource()==sinButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			//textfield.setText(textfield.getText().concat("sin(").concat(String.valueOf(num1)).concat((")")));
			result=Math.sin(num1);
			textfield.setText(String.valueOf(result));
			num1=result;


		}
		if(e.getSource()==tanButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			//textfield.setText(textfield.getText().concat("tan(").concat(String.valueOf(num1)).concat((")")));
			result=Math.cos(num1);
			textfield.setText(String.valueOf(result));
			num1=result;

		}
	}
}
