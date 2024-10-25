package Calc;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Main extends JFrame {
    
    public Main() {
        this.setTitle("둥근 버튼 예제");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // 둥근 버튼 생성
        JButton roundedButton = new JButton("둥근 버튼");
        roundedButton.setPreferredSize(new Dimension(150, 50));
        roundedButton.setBorder(new RoundedBorder(20)); // 둥근 테두리 적용
        roundedButton.setBackground(Color.LIGHT_GRAY);
        
        // 버튼 추가
        this.add(roundedButton);

        this.setVisible(true);
    }

    // 둥근 테두리를 위한 커스텀 Border 클래스
    class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

