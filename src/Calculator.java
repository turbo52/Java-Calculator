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
	static float one = 0; // переменные для вычислений 
	static float two = 0;
	static float finResult = 0;

	// Метод для проверки полей ввода (проверка на то, что там число)
	// (Не используется, в связи с реализацией обработки исключений)
	
	public static boolean mask(String testString) {  
		Pattern check = Pattern.compile("(\\d{1,8}+\\.\\d{1,8})|(\\d{1,8})"); 
        Matcher m = check.matcher(testString);  
        return m.matches();  
	 }
	
	
	public static void main(String[] args) {
		JFrame form = new JFrame();                          // Создали основную форму, где будем всё размещать
		JPanel panel = new JPanel();                         // Создали панель, которую поместим на форму
		panel.setLayout(null);
		panel.setSize(222, 340);
		form.add(panel);                                     // Добавили панель на форму
		form.setSize(222, 340);                              // Задаём размер нашей формы
		form.setResizable(false);
		form.setTitle("Калькулятор");                        // Задали название
		
		Font font = new Font("Arial", Font.PLAIN, 14);       // Параметры форматирования для текста на кнопках
		JButton plus = new JButton("+");                     // Задаём элементы калькулятора
		plus.setFont(font);
		JButton minus = new JButton("-");
		minus.setFont(font);
		JButton multiply = new JButton("*");
		multiply.setFont(font);
		JButton divided = new JButton("/");
		divided.setFont(font);
		JButton reset = new JButton("C");
		reset.setFont(font);
		JButton divided_ost = new JButton("Деление с остатком");
		JButton remainder = new JButton("Остаток от деления");
		JButton exit = new JButton("[x]");
		JLabel number_one = new JLabel("Число 1: ");
		JLabel number_two = new JLabel("Число 2: ");
		JLabel result = new JLabel("Результат вычисления:");
		JTextField result_value = new JTextField();
		JTextField num1 = new JTextField();                 // Создали поле для ввода 1
		num1.setEditable(true);
		JTextField num2 = new JTextField();                 // Создали поле для ввода 2
		num2.setEditable(true);

		plus.setBounds(6, 80, 50, 50); // Кнопочки     
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
		num1.setBounds(108, 10, 100, 30); // Поля для ввода
		panel.add(num1);
		num2.setBounds(108, 45, 100, 30);
		panel.add(num2);
		number_one.setBounds(48, 10 ,100, 30); // Текстовые поля
		panel.add(number_one);
		number_two.setBounds(48, 45, 100, 30);
		panel.add(number_two);
		result.setBounds(40, 240, 150, 30); // Результат
		panel.add(result);
		result_value.setBounds(6, 270, 204, 37); // Числовой результат
		result_value.setEditable(false);
		panel.add(result_value);
		///***ГРАФИЧЕСКАЯ ЧАСТЬ ЗАВЕРШЕНА***///

		plus.addActionListener(new ActionListener() {                   // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {               // Реализующий интерфейс ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
		    		 two = Float.parseFloat(num2.getText());
		    		 finResult = one + two;                               
		    		 result_value.setText(" " + finResult); 
		    		 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		    	 }
		});
		
		minus.addActionListener(new ActionListener() {                  // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {               // Реализующий интерфейс ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
		    		 two = Float.parseFloat(num2.getText());
		    		 finResult = one - two;                                 
		    		 result_value.setText(" " + finResult); 
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		     }
		});
		multiply.addActionListener(new ActionListener() {               // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {               // Реализующий интерфейс ActionListener
		    	 try {
		    		 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = one * two;                                 
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		     }
		});
		divided.addActionListener(new ActionListener() {                // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {               // Реализующий интерфейс ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = (one / two);                               // деление без остатка
			    	 result_value.setText(" " + (int) finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		     }
		});
		divided_ost.addActionListener(new ActionListener() {            // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {               // Реализующий интерфейс ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText()); 
			    	 two = Float.parseFloat(num2.getText());
			    	 finResult = (one / two);                           // деление 
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		     }
		});
		reset.addActionListener(new ActionListener() {            // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {         // Реализующий интерфейс ActionListener
		    	 one = 0; two = 0; finResult = 0;                 // очистить все поля
		    	 num1.setText("");
		    	 num2.setText("");
		    	 result_value.setText("");
		     }
		});
		exit.addActionListener(new ActionListener() {            // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {        // Реализующий интерфейс ActionListener
		    	 System.exit(0);                                 // завершить работу программы
		     }
		});
		remainder.addActionListener(new ActionListener()  {       // Создаем анонимный класс,
		     public void actionPerformed(ActionEvent e) {         // Реализующий интерфейс ActionListener
		    	 try {
			    	 one = Float.parseFloat(num1.getText());          // ОСТАТОК ОТ ДЕЛЕНИЯ
			    	 two = Float.parseFloat(num2.getText());     
			    	 finResult = one % two;                               
			    	 result_value.setText(" " + finResult);
		    	 }
		    	 catch (NumberFormatException x) {
		    		 result_value.setText("Ошибка ввода!");
		    		 }
		     }
		});
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Принимает константу при закрытии
		form.setLocationRelativeTo(null);                    // Отображение формы по середине экрана
		form.setVisible(true);                               // Для отображения формы (1 или 0)
	} 
}
