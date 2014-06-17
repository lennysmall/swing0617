package swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SampleText implements ActionListener{
	JTextField id;
	JPasswordField passwd;
	
	public void createGUI(){
		JFrame frm = new JFrame("Sample Text");
		frm.setBounds(200, 200, 300, 150);
		//그리드레이아웃은 세로세로 크기지정
		frm.setLayout(new GridLayout(2,2));
		
		JLabel labelId = new JLabel("ID", SwingConstants.RIGHT);
		JLabel labelPassword = new JLabel("Password", SwingConstants.RIGHT);
		
		id = new JTextField(10);
		passwd = new JPasswordField(10);
		//에코캐릭터를 *로 바꾸면 *로 나옴. 문자지정 변경 가능
		passwd.setEchoChar('@');
		passwd.addActionListener(this);
		
		frm.add(labelId);
		frm.add(id);
		frm.add(labelPassword);
		frm.add(passwd);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new SampleText().createGUI();

	}


	//액션리스너 구성
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ID : "+id.getText());
		System.out.println("Password : "+ new String(passwd.getPassword()));
		//패스워드는 캐릭터로 들어가기때문에 스트링으로 변환해야함
		
		id.setText(" ");
		passwd.setText(" ");
	}

}
