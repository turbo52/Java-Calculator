import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	static float one = 0; // ���������� ��� ���������� 
	static float two = 0;
	static float finResult = 0;

	// ����� ��� �������� ����� ����� (�������� �� ��, ��� ��� �����)
	// (�� ������������, � ����� � ����������� ��������� ����������)
	
	public static boolean mask(String testString) {  
		Pattern check = Pattern.compile("(\\d{1,8}+\\.\\d{1,8})|(\\d{1,8})"); 
        Matcher m = check.matcher(testString);  
        return m.matches();  
	 }
	
	
	public static void main(String[] args) {
		JFrame form = new JFrame();                          // ������� �������� �����, ��� ����� �� ���������
		JPanel panel = new JPanel();                         // ������� ������, ������� �������� �� �����
		panel.setLayout(null);
		panel.setSize(222, 340);
		form.add(panel);                                     // �������� ������ �� �����
		form.setSize(222, 340);                              // ����� ������ ����� �����
		form.setResizable(false);
		form.setTitle("�����������");                        // ������ ��������
		
		Font font = new Font("Arial", Font.PLAIN, 14);       // ��������� �������������� ��� ������ �� �������
		JButton plus = new JButton("+");                     // ����� �������� ������������
		plus.setFont(font);
		JButton minus = new JButton("-");
		minus.setFont(font);
		JButton multiply = new JButton("*");
		multiply.setFont(font);
		JButton divided = new JButton("/");
		divided.setFont(font);
		JButton reset = new JButton("C");
		reset.setFont(font);
		JButton divided_ost = new JButton("������� � ��������");
		JButton remainder = new JButton("������� �� �������");
		JButton exit = new JButton("[x]");
		JLabel number_one = new JLabel("����� 1: ");
		JLabel number_two = new JLabel("����� 2: ");
		JLabel result = new JLabel("��������� ����������:");
		JTextField result_value = new JTextField();
		JTextField num1 = new JTextField();                 // ������� ���� ��� ����� 1
		num1.setEditable(true);
		JTextField num2 = new JTextField();                 // ������� ���� ��� ����� 2
		num2.setEditable(true);

		plus.setBounds(6, 80, 50, 50); // ��������     
		panel.add(plus);
		minus.setBounds(57, 80, 50, 50);
		panel.add(minus);
		multiply.setBounds(108, 80, 50, 50);
		panel.add(multiply);
		divided.setBounds(159, 80, 50, 50);
		panel.add(divided);
		divided_ost.setBounds(6, 131, 152, 50);
		panel.add(divided_ost);
		remainder.setBounds(6, 182, 152, 50);
		panel.add(remainder);
		reset.setBounds(159, 131, 50, 50);
		panel.add(reset);
		exit.setBounds(159, 182, 50, 50);
		panel.add(exit);
		num1.setBounds(108, 10, 100, 30); // ���� ��� �����
		panel.add(num1);
		num2.setBounds(108, 45, 100, 30);
		panel.add(num2);
		number_one.setBounds(48, 10 ,100, 30); // ��������� ����
		panel.add(number_one);
		number_two.setBounds(48, 45, 100, 30);
		panel.add(number_two);
		result.setBounds(40, 240, 150, 30); // ���������
		panel.add(result);
		result_value.setBounds(6, 270, 204, 37); // �������� ���������
		result_value.setEditable(false);
		panel.add(result_value);
		///***����������� ����� ���������***///

		plus.addActionListener(new ActionListener() {                   // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {               // ����������� ��������� ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
		    		 two = Float.parseFloat(num2.getText());
		    		 finResult = one + two;                               
		    		 result_value.setText(" " + finResult); 
		    		 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		    	 }
		});
		
		minus.addActionListener(new ActionListener() {                  // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {               // ����������� ��������� ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
		    		 two = Float.parseFloat(num2.getText());
		    		 finResult = one - two;                                 
		    		 result_value.setText(" " + finResult); 
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		     }
		});
		multiply.addActionListener(new ActionListener() {               // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {               // ����������� ��������� ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = one * two;                                 
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		     }
		});
		divided.addActionListener(new ActionListener() {                // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {               // ����������� ��������� ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = (one / two);                               // ������� ��� �������
			    	 result_value.setText(" " + (int) finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		     }
		});
		divided_ost.addActionListener(new ActionListener() {            // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {               // ����������� ��������� ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = (one / two);                           // ������� 
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		     }
		});
		reset.addActionListener(new ActionListener() {            // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {         // ����������� ��������� ActionListener
		    	 one = 0; two = 0; finResult = 0;                 // �������� ��� ����
		    	 num1.setText("");
		    	 num2.setText("");
		    	 result_value.setText("");
		     }
		});
		exit.addActionListener(new ActionListener() {            // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {        // ����������� ��������� ActionListener
		    	 System.exit(0);                                 // ��������� ������ ���������
		     }
		});
		remainder.addActionListener(new ActionListener()  {       // ������� ��������� �����,
		     public void actionPerformed(ActionEvent e) {         // ����������� ��������� ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText());          // ������� �� �������
			    	 two = Float.parseFloat(num2.getText());     
			    	 finResult = one % two;                               
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("������ �����!");
		    		 }
		     }
		});
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ��������� ��������� ��� ��������
		form.setLocationRelativeTo(null);                    // ����������� ����� �� �������� ������
		form.setVisible(true);                               // ��� ����������� ����� (1 ��� 0)
	} 
}
