package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleMouseListener implements MouseListener{
	public void createGUI(){
		JFrame frm = new JFrame();
		frm.setTitle("Mouse Listener Sample");
		frm.setSize(500, 200);
		frm.setLayout(new FlowLayout());
		
		Container container = frm.getContentPane();
		
		JButton btn1 = new JButton("버튼 1");
		JButton btn2 = new JButton("버튼 2");
		btn1.addMouseListener(this);
		btn2.addMouseListener(this);
		
		container.add(btn1);
		frm.add(btn2);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		SampleMouseListener sample = new SampleMouseListener();
		sample.createGUI();
		new SampleMouseListener(){
			@Override
			public void createGUI() {};
		}.createGUI();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		JFrame frm1 = new JFrame();
		frm1.setSize(100,100);
		//frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
}




