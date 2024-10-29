package Calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * 	<li>2024.10.23 09:00 최초 생성</li>
 * </ul>
 */
public class Screen extends JFrame implements ActionListener {
	
	/**
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.23 09:00 최초 생성</li>
	 * 	<li>2024.10.25 10:00 각 패널들을 별도의 메소드로 분리</li>
	 * 	<li>2024.10.29 19:00 버튼들을 개별 생성</li>
	 * </ul>
	 */

	JTextField calculation, result;
	
	JButton rateButton, clearEntryButton, clearButton, deleteButton, reciprocalButton, 
	squareButton, rootButton, divideButton, sevenButton, eightButton, nineButton, 
	multiplyButton, fourButton, fiveButton, sixButton, minusButton, oneButton, twoButton, 
	threeButton, plusButton, nepoButton, zeroButton, pointButton, equalButton;
	
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
		
		northPanel();
		centerPanel();
		southPanel();
		
		this.setVisible(true);
	}
	
	public void northPanel() {
		
		/**
		 * @changelog
		 * <ul>
		 * 	<li>2024.10.25 별도의 메소드로 분리</li>
		 * <ul>
		 */
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.setBackground(new Color(32, 32, 32));
		
		//목록버튼 생성
		ImageIcon listIcon = new ImageIcon("img/listButton.png");
		JButton listButton = new JButton(listIcon);
		listButton.setPreferredSize(new Dimension(40, 40));
		listButton.setBorder(null);
		northPanel.add(listButton);
		
		JLabel textLabel = new JLabel("표준");
		textLabel.setFont(new Font("굴림 보통", Font.BOLD, 20));
		textLabel.setForeground(Color.white);
		northPanel.add(textLabel);
		
		this.add(northPanel, BorderLayout.NORTH);
	}
	
	public void centerPanel() {
		
		/**
		 * @changelog
		 * <ul>
		 * 	<li>2024.10.25 별도의 메소드로 분리</li>
		 * <ul>
		 */
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(Color.black);
		
		//현재 계산하고 있는 식이 써질 텍스트필드 생성
		calculation = new JTextField("");
		calculation.setBackground(new Color(32, 32, 32));
		calculation.setHorizontalAlignment(JTextField.RIGHT);
		calculation.setFont(new Font("Seoge UI", Font.PLAIN, 15));
		calculation.setForeground(Color.gray);
		calculation.setEnabled(false);
		calculation.setBorder(null);
		panel2.add(calculation, BorderLayout.NORTH);
		
		//결과와 현재 숫자가 써질 텍스트필드 생성
		result = new JTextField("0");
		result.setBackground(new Color(32, 32, 32));
		result.setHorizontalAlignment(JTextField.RIGHT);
		result.setFont(new Font("Seoge UI", Font.PLAIN, 50));
		result.setForeground(new Color(255, 255, 255));
		result.setEditable(false);
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
		new decorateMemoryButton(memoryPanel, memoryClear, "MC");
		JButton memoryRecall = new JButton();
		new decorateMemoryButton(memoryPanel, memoryRecall, "MR");
		JButton memoryPlus = new JButton();
		new decorateMemoryButton(memoryPanel, memoryPlus, "M+");
		JButton memoryMinus = new JButton();
		new decorateMemoryButton(memoryPanel, memoryMinus, "M-");
		JButton memorySave = new JButton();
		new decorateMemoryButton(memoryPanel, memorySave, "MS");
		JButton memoryList = new JButton();
		new decorateMemoryButton(memoryPanel, memoryList, "M∨");
		
		panel2.add(memoryPanel, BorderLayout.SOUTH);
		
		this.add(panel2, BorderLayout.CENTER);
	}
	
	public void southPanel() {
		
		/**
		 * @changelog
		 * <ul>
		 * 	<li>2024.10.25 별도의 메소드로 분리</li>
		 * 	<li>2024.10.29 14:00 버튼 개별로 작성</li>
		 * <ul>
		 */
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(6, 4, 3, 3));
		southPanel.setBackground(Color.black);
		
		rateButton = new JButton();
		new decorateNumberButton(rateButton, southPanel, "%", 50, 50, 50);
		clearEntryButton = new JButton();
		new decorateNumberButton(clearEntryButton, southPanel, "CE", 50, 50, 50);
		clearButton = new JButton();
		new decorateNumberButton(clearButton, southPanel, "C", 50, 50, 50);
		deleteButton = new JButton();
		new decorateNumberButton(deleteButton, southPanel, "⌫", 50, 50, 50);
		reciprocalButton = new JButton();
		new decorateNumberButton(reciprocalButton, southPanel, "¹/x", 50, 50, 50);
		squareButton = new JButton();
		new decorateNumberButton(squareButton, southPanel, "x²", 50, 50, 50);
		rootButton = new JButton();
		new decorateNumberButton(rootButton, southPanel, "²√x", 50, 50, 50);
		divideButton = new JButton();
		new decorateNumberButton(divideButton, southPanel, "÷", 50, 50, 50);
		sevenButton = new JButton();
		new decorateNumberButton(sevenButton, southPanel, "7", 59, 59, 59);
		sevenButton.addActionListener(this);
		eightButton = new JButton();
		new decorateNumberButton(eightButton, southPanel, "8", 59, 59, 59);
		eightButton.addActionListener(this);
		nineButton = new JButton();
		new decorateNumberButton(nineButton, southPanel, "9", 59, 59, 59);
		nineButton.addActionListener(this);
		multiplyButton = new JButton();
		new decorateNumberButton(multiplyButton, southPanel, "×", 50, 50, 50);
		fourButton = new JButton();
		new decorateNumberButton(fourButton, southPanel, "4", 59, 59, 59);
		fourButton.addActionListener(this);
		fiveButton = new JButton();
		new decorateNumberButton(fiveButton, southPanel, "5", 59, 59, 59);
		fiveButton.addActionListener(this);
		sixButton = new JButton();
		new decorateNumberButton(sixButton, southPanel, "6", 59, 59, 59);
		sixButton.addActionListener(this);
		minusButton = new JButton();
		new decorateNumberButton(minusButton, southPanel, "-", 50, 50, 50);
		oneButton = new JButton();
		new decorateNumberButton(oneButton, southPanel, "1", 59, 59, 59);
		oneButton.addActionListener(this);
		twoButton = new JButton();
		new decorateNumberButton(twoButton, southPanel, "2", 59, 59, 59);
		twoButton.addActionListener(this);
		threeButton = new JButton();
		new decorateNumberButton(threeButton, southPanel, "3", 59, 59, 59);
		threeButton.addActionListener(this);
		plusButton = new JButton();
		new decorateNumberButton(plusButton, southPanel, "+", 50, 50, 50);
		nepoButton = new JButton();
		new decorateNumberButton(nepoButton, southPanel, "+/-", 59, 59, 59);
		zeroButton = new JButton();
		new decorateNumberButton(zeroButton, southPanel, "0", 59, 59, 59);
		zeroButton.addActionListener(this);
		pointButton = new JButton();
		new decorateNumberButton(pointButton, southPanel, ".", 59, 59, 59);
		pointButton.addActionListener(this);
		equalButton = new JButton();
		new decorateNumberButton(equalButton, southPanel, "=", 76, 194, 255);
				
		this.add(southPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickButton = (JButton) e.getSource();
		result.setText(result.getText() + clickButton.getText());
	}
	public static void main(String[] args) {
		new Screen();
	}

}
