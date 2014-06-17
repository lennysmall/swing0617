package swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloSwing {
	public void createGUI(){
		//윈도우 창 객체를 생성한다.
		JFrame frm = new JFrame("Hello Swing");
		//크기 지정
		frm.setSize(300, 200);
		//배치 관리자 지정
		frm.setLayout(new GridLayout(3,2));
		//화면 위치 지정
		frm.setLocation(400, 200);
		
		JButton btn1 = new JButton("버튼 1");
		JButton btn2 = new JButton("버튼 2");
		JButton btn3 = new JButton("버튼 3");
		JButton btn4 = new JButton("버튼 4");
		JButton btn5 = new JButton("버튼 5");
		JButton btn6 = new JButton("버튼 6");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 1이 눌러졌어요.");
			}
		});
		MyActionListener listener = new MyActionListener();
		btn3.addActionListener(listener);
		btn5.addActionListener(listener);
		
		frm.add(btn1);
		frm.add(btn2);
		frm.add(btn3);
		frm.add(btn4);
		frm.add(btn5);
		frm.add(btn6);
		
		//종료 버튼 클릭시 동작 지정
		frm.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		//윈도우 창을 나타나게 한다.
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HelloSwing().createGUI();
			}
		});
	}
}

class MyActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 눌러졌어요");
	}
}

