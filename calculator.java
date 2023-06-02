package Pj;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class calculator extends JFrame {
	JTextField display;
	JPanel panel;
	JButton button;
	double operand1 = 0;
	double operand2 = 0; 
	double answer = 0;
	String operator;
	ArrayList<String> historyList = new ArrayList<>();
	
	calculator(){
		this.setBounds(100, 100, 300, 500);
		this.setTitle("계산기");
		this.setLayout(new BorderLayout());
		display = new JTextField(30);
		display.setText("0");
		display.setFont(new Font("궁서체", Font.BOLD, 35));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
	
		this.add(display, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,4));
	
		button = new JButton("%");
		button.addActionListener(e->{
			if (operand1 == 0) {
				display.setText("0");
			}
			else {
				operand2 = Double.parseDouble( display.getText() );
				operand2 = operand1 * operand2 * 0.01;
				display.setText( operand2 + "");
			}
		});
		panel.add(button);
		button = new JButton("CE");
		button.addActionListener(e->{
			display.setText("0");
		});
		panel.add(button);
		button = new JButton("C");
		button.addActionListener(e->{
			display.setText("0");
			operand1 = 0;
			operand2 = 0;
		});
		panel.add(button);
		button = new JButton("<-");
		button.addActionListener(e->{
			display.setText(display.getText().substring(0, display.getText().length()-1));
			if(display.getText().length() == 0) {
				display.setText("0");
			}
		});
		panel.add(button);
		button = new JButton("1/x");
		button.addActionListener(e->{
			double d = Double.parseDouble(display.getText());
			display.setText( 1.0 / d + "");
		});
		panel.add(button);
		button = new JButton("x^2");
		button.addActionListener(e->{
			double d = Double.parseDouble(display.getText());
			display.setText( d * d + "");
		});
		panel.add(button);
		button = new JButton("Sqrt");
		button.addActionListener(e->{
			double d = Double.parseDouble(display.getText());
			display.setText( Math.sqrt(d) + "" );
		});
		panel.add(button);
		button = new JButton("÷");
		button.addActionListener(e->{
			operand1 = Double.parseDouble( display.getText() );
			display.setText("0");
			operator = "÷";
		});
		panel.add(button);
		button = new JButton("7");
		button.addActionListener(e->{
			if( display.getText().equals("0") ) display.setText( "7");
			else display.setText( display.getText() + "7");
		});
		panel.add(button);
		button = new JButton("8");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("8") ;
			else display.setText( display.getText() + "8");
		});
		panel.add(button);
		button = new JButton("9");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("9") ;
			else display.setText( display.getText() + "9");
		});
		panel.add(button);
		button = new JButton("×");
		button.addActionListener(e->{
			operand1 = Double.parseDouble( display.getText() );
			display.setText("0");
			operator = "×";
		});
		panel.add(button);
		button = new JButton("4");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("4") ;
			else display.setText( display.getText() + "4");
		});
		panel.add(button);
		button = new JButton("5");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("5") ;
			else display.setText( display.getText() + "5");
		});
		panel.add(button);
		button = new JButton("6");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("6") ;
			else display.setText( display.getText() + "6");
		});
		panel.add(button);
		button = new JButton("-");
		button.addActionListener(e->{
			operand1 = Double.parseDouble( display.getText() );
			display.setText("0");
			operator = "-";
		});
		panel.add(button);
		button = new JButton("1");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("1") ;
			else display.setText( display.getText() + "1");
		});
		panel.add(button);
		button = new JButton("2");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("2") ;
			else display.setText( display.getText() + "2");
		});
		panel.add(button);
		button = new JButton("3");
		button.addActionListener(e->{
			if(display.getText().equals("0")) display.setText("3") ;
			else display.setText( display.getText() + "3");
		});
		panel.add(button);
		button = new JButton("+");
		button.addActionListener(e->{
			operand1 = Double.parseDouble( display.getText() );
			display.setText("0");
			operator = "+";
		});
		panel.add(button);
		button = new JButton("+/-");
		button.addActionListener(e->{
			if( !display.getText().equals("0") ) {
				if( display.getText().contains("-") ) {
					display.setText( display.getText().substring(1) );
				} else {
					display.setText( "-" + display.getText() );
				}
			}
		});
		panel.add(button);
		button = new JButton("0");
		button.addActionListener(e -> {
			if( !display.getText().equals("0") ) { 
				display.setText( display.getText() + "0");
			}
		});
		panel.add(button);
		button = new JButton(".");
		button.addActionListener(e->{
			if( !display.getText().contains(".") ) {
				display.setText( display.getText() + ".");
			}
		});
		panel.add(button);
		button = new JButton("=");
		button.addActionListener(e-> {
			operand2 = Double.parseDouble( display.getText() );
			switch( operator ) {
			case "+":
				answer = operand1 + operand2;
				break;
			case "-":
				answer = operand1 - operand2;
				break;
			case "×":
				answer = operand1 * operand2;
				break;
			case "÷":
				answer = operand1 / operand2;
				break;
			default:
			}
			String historyRecord = (operand1 + " " + operator + " " + operand2 + " = " + answer);
			historyList.add(historyRecord); // 계산 기록을 ArrayList에 추가
            updateHistoryLabel(); // 계산 기록 레이블 업데이트
            display.setText(answer + "");
		});
		panel.add(button);
		
		
		button = new JButton("History");
		this.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame historyFrame = new JFrame("계산 기록");
                historyFrame.setBounds(200, 200, 300, 300);

                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (String item : historyList) {
                    listModel.addElement(item);
                }

                JList<String> historyList = new JList<>(listModel);
                historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane scrollPane = new JScrollPane(historyList);

                historyFrame.add(scrollPane);
                historyFrame.setVisible(true);
            }
        });
		

		this.add(panel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
}
	
	 private void updateHistoryLabel() {
	        StringBuilder historyText = new StringBuilder("<html>");
	        for (String item : historyList) {
	            historyText.append(item).append("<br>");
	        }
	        historyText.append("</html>");
	    }
public static void main(String[] args) {
	
	new calculator();
	
	}
}