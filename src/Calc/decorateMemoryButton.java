package Calc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class decorateMemoryButton {
	
	/**
	 * 메모리버튼의 배경색, 글자색, 크기를 변경, 테두리를 제거하는 클래스
	 * 
	 * @param panel 버튼을 배치할 패널
	 * @param button 변경하고 싶은 버튼
	 * @param text 변경하고 싶은 버튼의 문구
	 * @param listener 버튼에 사용될 액션리스너
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.10.23 14:00 최초 생성</li>
	 * 	<li>2024.10.25 10:00 별도 클래스로 분리</li>
	 * 	<li>2024.11.01 20:00 listener 매개변수 추가</li>
	 * </ul>
	 */
	
	public decorateMemoryButton(JPanel panel, JButton button, String text, ActionListener listener) {
		button.setText(text);
        button.setBackground(new Color(32, 32, 32)); // 배경색
        button.setForeground(Color.white); // 글자색
        button.setPreferredSize(new Dimension(30, 30)); //크기 변경
        button.setBorder(null); // 테두리 제거
        button.addActionListener(listener); // 리스너 추가
        panel.add(button); // 패널에 추가
        
	}
}
