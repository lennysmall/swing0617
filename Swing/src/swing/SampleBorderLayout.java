package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SampleBorderLayout {
	public void createGUI(){
		JFrame frm = new JFrame("Border Layout");
		frm.setBounds(200,100,500,400);
		frm.setLayout(new BorderLayout());
		
		JButton center = new JButton("Center");
		JButton north = new JButton("North");
		JButton south = new JButton("South");
		JButton east = new JButton("East");
		JButton west = new JButton("West");
		
		frm.add(center, BorderLayout.CENTER);
		frm.add(north, BorderLayout.NORTH);
		frm.add(south, BorderLayout.SOUTH);
		frm.add(east, BorderLayout.EAST);
		frm.add(west, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(0,1));
		JButton east1 = new JButton("east1");
		JButton east2 = new JButton("east2");
		JButton east3 = new JButton("east3");
		panelEast.add(east1);
		panelEast.add(east2);
		panelEast.add(east3);
		
		frm.add(panelEast, BorderLayout.EAST);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new SampleBorderLayout().createGUI();

			}

		});


	}

}
