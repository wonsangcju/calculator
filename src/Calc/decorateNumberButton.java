package Calc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class decorateNumberButton {
	
	/**
	 * 버튼의 배경색, 글자색, 크기를 변경, 테두리를 제거하는 클래스
	 * 
	 * @param panel 추가하고 싶은 패널
	 * @param button 변경하고 싶은 버튼
	 * @param text 변경될 버튼의 문구
	 * @param r, g, b 버튼의 배경색 rgb값
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.29 14:00 최초 생성</li>
	 * </ul>
	 */
	public decorateNumberButton(JButton button, JPanel panel, String text, int r, int g, int b) {
		button.setText(text);
		button.setPreferredSize(new Dimension(50, 50));
		button.setFont(new Font("Seoge UI", Font.PLAIN, 17));
        button.setForeground(Color.white); // 글자색
        button.setBackground(new Color(r, g, b)); // 배경색
        button.setBorder(null); // 테두리 제거
        panel.add(button);
	}
}