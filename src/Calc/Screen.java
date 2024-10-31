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
 *            <ul>
 *            <li>2024.10.23 09:00 최초 생성</li>
 *            </ul>
 */
public class Screen extends JFrame {

	/**
	 * @changelog
	 *            <ul>
	 *            <li>2024.10.23 09:00 최초 생성</li>
	 *            <li>2024.10.25 10:00 각 패널들을 별도의 메소드로 분리</li>
	 *            <li>2024.10.29 19:00 버튼들을 개별 생성</li>
	 *            <li>2024.10.30 16:00 ActionListener 추가</li>
	 *            </ul>
	 */

	JTextField calculation, result;

	JButton rateButton, clearEntryButton, clearButton, deleteButton, reciprocalButton, squareButton, rootButton,
			divideButton, sevenButton, eightButton, nineButton, multiplyButton, fourButton, fiveButton, sixButton,
			minusButton, oneButton, twoButton, threeButton, plusButton, nepoButton, zeroButton, pointButton,
			equalButton;

	private boolean isCalculationPerformed = false; // 이전에 계산을 한적이 있는지 검사하는 변수

	public Screen() {
		this.setTitle("계산기");
		this.setSize(335, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);

		// 계산기 아이콘 변경
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
		 *            <ul>
		 *            <li>2024.10.25 별도의 메소드로 분리</li>
		 *            <ul>
		 */

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.setBackground(new Color(32, 32, 32));

		// 목록버튼 생성
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
		 *            <ul>
		 *            <li>2024.10.25 별도의 메소드로 분리</li>
		 *            <ul>
		 */

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(Color.black);

		// 현재 계산하고 있는 식이 써질 텍스트필드 생성
		calculation = new JTextField("");
		calculation.setBackground(new Color(32, 32, 32));
		calculation.setHorizontalAlignment(JTextField.RIGHT);
		calculation.setFont(new Font("Seoge UI", Font.PLAIN, 15));
		calculation.setForeground(new Color(156, 156, 156));
		calculation.setEnabled(false);
		calculation.setBorder(null);
		panel2.add(calculation, BorderLayout.NORTH);

		// 결과와 현재 숫자가 써질 텍스트필드 생성
		result = new JTextField("0");
		result.setBackground(new Color(32, 32, 32));
		result.setHorizontalAlignment(JTextField.RIGHT);
		result.setFont(new Font("Seoge UI", Font.PLAIN, 50));
		result.setForeground(new Color(255, 255, 255));
		result.setEditable(false);
		result.setBorder(null);
		panel2.add(result, BorderLayout.CENTER);

		JPanel memoryPanel = new JPanel();
		memoryPanel.setLayout(new GridLayout(0, 6));
		memoryPanel.setBackground(Color.black);

		/**
		 * @changelog
		 *            <ul>
		 *            <li>2024.10.23 13:00 최초 생성</li>
		 *            </ul>
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
		 *            <ul>
		 *            <li>2024.10.25 별도의 메소드로 분리</li>
		 *            <li>2024.10.29 14:00 버튼 개별로 작성</li>
		 *            <ul>
		 */

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(6, 4, 3, 3));
		southPanel.setBackground(Color.black);

		numberButtonListener numListener = new numberButtonListener();
		calculateButtonListener calListener = new calculateButtonListener();
		deleteButtonListener deleteListener = new deleteButtonListener();

		rateButton = new JButton();
		new decorateButton(rateButton, southPanel, "%", 50, 50, 50, calListener);
		clearEntryButton = new JButton();
		new decorateButton(clearEntryButton, southPanel, "CE", 50, 50, 50, calListener);
		clearButton = new JButton();
		new decorateButton(clearButton, southPanel, "C", 50, 50, 50, calListener);
		deleteButton = new JButton();
		new decorateButton(deleteButton, southPanel, "⌫", 50, 50, 50, deleteListener);
		reciprocalButton = new JButton();
		new decorateButton(reciprocalButton, southPanel, "¹/x", 50, 50, 50, calListener);
		squareButton = new JButton();
		new decorateButton(squareButton, southPanel, "x²", 50, 50, 50, calListener);
		rootButton = new JButton();
		new decorateButton(rootButton, southPanel, "²√x", 50, 50, 50, calListener);
		divideButton = new JButton();
		new decorateButton(divideButton, southPanel, "÷", 50, 50, 50, calListener);
		sevenButton = new JButton();
		new decorateButton(sevenButton, southPanel, "7", 59, 59, 59, numListener);
		eightButton = new JButton();
		new decorateButton(eightButton, southPanel, "8", 59, 59, 59, numListener);
		nineButton = new JButton();
		new decorateButton(nineButton, southPanel, "9", 59, 59, 59, numListener);
		multiplyButton = new JButton();
		new decorateButton(multiplyButton, southPanel, "×", 50, 50, 50, calListener);
		fourButton = new JButton();
		new decorateButton(fourButton, southPanel, "4", 59, 59, 59, numListener);
		fiveButton = new JButton();
		new decorateButton(fiveButton, southPanel, "5", 59, 59, 59, numListener);
		sixButton = new JButton();
		new decorateButton(sixButton, southPanel, "6", 59, 59, 59, numListener);
		minusButton = new JButton();
		new decorateButton(minusButton, southPanel, "-", 50, 50, 50, calListener);
		oneButton = new JButton();
		new decorateButton(oneButton, southPanel, "1", 59, 59, 59, numListener);
		twoButton = new JButton();
		new decorateButton(twoButton, southPanel, "2", 59, 59, 59, numListener);
		threeButton = new JButton();
		new decorateButton(threeButton, southPanel, "3", 59, 59, 59, numListener);
		plusButton = new JButton();
		new decorateButton(plusButton, southPanel, "+", 50, 50, 50, calListener);
		nepoButton = new JButton();
		new decorateButton(nepoButton, southPanel, "+/-", 59, 59, 59, numListener);
		zeroButton = new JButton();
		new decorateButton(zeroButton, southPanel, "0", 59, 59, 59, numListener);
		pointButton = new JButton();
		new decorateButton(pointButton, southPanel, ".", 59, 59, 59, numListener);
		equalButton = new JButton();
		new decorateButton(equalButton, southPanel, "=", 76, 194, 255, calListener);

		this.add(southPanel, BorderLayout.SOUTH);
	}

	public class numberButtonListener implements ActionListener {

		/**
		 * 숫자버튼을 눌렀을때 작동하는 리스너 클래스
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.10.30 16:00 최초 생성</li>
		 *            </ul>
		 */

		public void actionPerformed(ActionEvent e) {
			JButton clickNumberButton = (JButton) e.getSource();

			if (isCalculationPerformed) {
				result.setText(clickNumberButton.getText());
				isCalculationPerformed = false;
			} else {
				if (result.getText().equals("0")) { // result 필드의 텍스트가 0일 경우 지우고 숫자 작성
					result.setText(clickNumberButton.getText());
				} else {
					result.setText(result.getText() + clickNumberButton.getText());
				}
			}
		}
	}

	public class calculateButtonListener implements ActionListener {

		/**
		 * 숫자버튼을 제외한 연산버튼을 눌렀을때 작동하는 리스너 클래스
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.10.30 16:00 최초 생성</li>
		 *            <li>2024.10.31 12:00 버튼의 종류에 따른 작동을 else if가 아닌 case로 변경</li>
		 *            <li>2024.10.31 13:00 C버튼, CE버튼 기능 추가</li>
		 *            </ul>
		 */

		private int orgNum = 0;
		private String lastButton = "";

		public void actionPerformed(ActionEvent e) {
			JButton clickCalButton = (JButton) e.getSource();

			// "C" 버튼 처리
			if (clickCalButton == clearButton) {
				calculation.setText("");
				result.setText("0");
				lastButton = "";
				orgNum = 0;
				isCalculationPerformed = false;
				return;
			}
			// "CE" 버튼 처리
			if (clickCalButton == clearEntryButton) {
				result.setText("0");
				isCalculationPerformed = true;
				return;
			}

			String num = result.getText() ;
			int value = Integer.parseInt(num); // 현재 숫자

			// 첫 연산 처리
			if (calculation.getText().isEmpty()) {
				orgNum = value;
				calculation.setText("" + value + clickCalButton.getText());
				result.setText("");
			} else {
				// 연산 버튼이 눌러진 상태로 숫자 버튼을 누르지 않고 다시 연산 버튼을 누를 경우
				if (lastButton.equals("+") || lastButton.equals("-") || lastButton.equals("*")
						|| lastButton.equals("/")) {

					// 첫 연산 이후 연산 처리
					switch (lastButton) {
					// 마지막으로 누른 버튼에 따라 계산
						case "+":
							orgNum += value;
							break;
						case "-":
							orgNum -= value;
							break;
						case "*":
							orgNum *= value;
							break;
						case "/":
							if (value == 0) {
								result.setText("0으로 나눌 수 없습니다");
								return;
							} else {
								orgNum /= value;
							}
							break;
					}

					lastButton = clickCalButton.getText();
					calculation.setText(orgNum + lastButton); // 다음 연산자로 바꿈
					result.setText("");
				} else {
					calculation.setText(calculation.getText() + clickCalButton.getText());
				}
			}
			// "=" 버튼 처리
			if (clickCalButton == equalButton) {
				calculation.setText(calculation.getText() + num + "=");
				result.setText(String.valueOf(orgNum));
				lastButton = "";
			} else {
				// 다음 연산 처리
				calculation.setText(orgNum + clickCalButton.getText());
				result.setText("");
				lastButton = clickCalButton.getText();
			}

			isCalculationPerformed = true;
		}
	}

	public class deleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String currentText = result.getText();

			// 문자열이 1개 이상일 경우 마지막 글자를 제거
			if (!currentText.isEmpty() && !currentText.equals("0")) {
				result.setText(currentText.substring(0, currentText.length() - 1));
			}
			// 마지막 한 글자만 남은 경우, 지운 후 0으로 초기화
			if (result.getText().isEmpty()) {
				result.setText("0");
			}
		}
	}

	public static void main(String[] args) {
		new Screen();
	}

}
