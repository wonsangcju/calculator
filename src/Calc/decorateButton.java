package Calc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class decorateButton {
	
	/**
	 * 버튼의 배경색, 글자색, 크기를 변경, 테두리를 제거하는 클래스
	 * 
	 * @param panel 추가하고 싶은 패널
	 * @param button 변경하고 싶은 버튼
	 * @param text 변경될 버튼의 문구
	 * @param r, g, b 버튼의 배경색 rgb값
	 * @param listener 버튼에 사용될 액션리스너
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.29 14:00 최초 생성</li>
	 * 	<li>2024.10.30 16:00 listener 변수 추가</li>
	 * </ul>
	 */
	public decorateButton(JButton button, JPanel panel, String text, int r, int g, int b, ActionListener listener) {
		button.setText(text);
		button.setPreferredSize(new Dimension(50, 50));
		button.setFont(new Font("Seoge UI", Font.PLAIN, 17));
        button.setForeground(Color.white); // 글자색 설정
        button.setBackground(new Color(r, g, b)); // 배경색 설정
        button.setBorder(null); // 테두리 제거
        button.addActionListener(listener); // 리스너 추가
        panel.add(button);
	}
}
