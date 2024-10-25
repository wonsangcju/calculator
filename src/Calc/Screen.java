package Calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 윈도우 계산기입니다.
 * 
 * @author 2021011865 전원상
 * @version 1.0
 * 
 * @created 2024.10.23
 * @lastModified 2024.10.23
 * 
 * @changelog
 * <ul>
 * 	<li>2024.10.23 최초 생성</li>
 * </ul>
 */
public class Screen extends JFrame {
	
	/**
	 * 
	 * @param panel
	 * @param button
	 * @param text
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.23 14:00 최초 생성</li>
	 * </ul>
	 */
	public void decorateButton(JPanel panel, JButton button, String text) {
		button.setText(text);
        button.setBackground(Color.black); // 배경색
        button.setForeground(Color.white); // 글자색
        button.setPreferredSize(new Dimension(30, 30));
        button.setBorder(null); // 테두리 제거
        panel.add(button);
	}
	
	/**
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.23 09:00 최초 생성</li>
	 * </ul>
	 */
	
	JButton[] button = new JButton[24];
	public Screen() {
		this.setTitle("계산기");
		this.setSize(335, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		
		//계산기 아이콘 변경
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/Calc.png");
		this.setIconImage(img);
		
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.setBackground(Color.black);
		
		//목록버튼 생성
		ImageIcon listIcon = new ImageIcon("img/listButton.png");
		JButton listButton = new JButton(listIcon);
		listButton.setPreferredSize(new Dimension(40, 40));
		listButton.setBorder(null);
		panel1.add(listButton);
		
		JLabel textLabel = new JLabel("표준");
		textLabel.setFont(new Font("굴림 보통", Font.BOLD, 20));
		textLabel.setForeground(Color.white);
		panel1.add(textLabel);
		
		this.add(panel1, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(Color.black);
		
		//현재 계산하고 있는 식이 써질 텍스트필드 생성
		JTextField calculation = new JTextField("");
		calculation.setBackground(Color.black);
		calculation.setHorizontalAlignment(JTextField.RIGHT);
		calculation.setFont(new Font("Seoge UI", Font.PLAIN, 15));
		calculation.setForeground(Color.gray);
		calculation.setEnabled(false);
		calculation.setBorder(null);
		panel2.add(calculation, BorderLayout.NORTH);
		
		//결과와 현재 숫자가 써질 텍스트필드 생성
		JTextField result = new JTextField("0");
		result.setBackground(Color.black);
		result.setHorizontalAlignment(JTextField.RIGHT);
		result.setFont(new Font("Seoge UI", Font.PLAIN, 50));
		result.setForeground(Color.white);
		result.setEnabled(false);
		result.setBorder(null);
		panel2.add(result, BorderLayout.CENTER);
		
		JPanel memoryPanel = new JPanel();
		memoryPanel.setLayout(new GridLayout(0,6));
		memoryPanel.setBackground(Color.black);
		
		/**
		 * @changelog
		 * <ul>
		 * 	<li>2024.10.23 13:00 최초 생성</li>
		 * </ul>
		 */
		JButton memoryClear = new JButton();
		decorateButton(memoryPanel, memoryClear, "MC");
		JButton memoryRecall = new JButton();
		decorateButton(memoryPanel, memoryRecall, "MR");
		JButton memoryPlus = new JButton();
		decorateButton(memoryPanel, memoryPlus, "M+");
		JButton memoryMinus = new JButton();
		decorateButton(memoryPanel, memoryMinus, "M-");
		JButton memorySave = new JButton();
		decorateButton(memoryPanel, memorySave, "MS");
		JButton memoryList = new JButton();
		decorateButton(memoryPanel, memoryList, "M∨");
		
		panel2.add(memoryPanel, BorderLayout.SOUTH);
		
		this.add(panel2, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(6, 4, 3, 3));
		panel3.setBackground(Color.black);
		
		//연산, 숫자 버튼 생성
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(50, 50));
			button[i].setForeground(Color.white);
			button[i].setBorder(null);
			panel3.add(button[i]);
		}
		button[0].setText("%"); button[1].setText("CE"); button[2].setText("C"); 
		button[3].setText("⌫"); button[4].setText("¹/x"); button[5].setText("x²");
		button[6].setText("²√x"); button[7].setText("÷"); button[8].setText("7");
		button[9].setText("8"); button[10].setText("9"); button[11].setText("×");
		button[12].setText("4"); button[13].setText("5"); button[14].setText("6");
		button[15].setText("-"); button[16].setText("1"); button[17].setText("2");
		button[18].setText("3"); button[19].setText("+"); button[20].setText("+/-");
		button[21].setText("0"); button[22].setText("."); button[23].setText("=");
		
		int[] symbolColor = {0,1,2,3,4,5,6,7,11,15,19};
		for (int i : symbolColor) {
			button[i].setBackground(new Color(50, 50, 50));
		}
		int[] numColor = {8,9,10,12,13,14,16,17,18,20,21,22};
		for (int i : numColor) {
			button[i].setBackground(new Color(59, 59, 59));
		}
		button[23].setBackground(new Color(76, 194, 255));
		
		this.add(panel3, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Screen();
	}

}
