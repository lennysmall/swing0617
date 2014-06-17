package swing;

// java.awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
// javax.swing

public class testCa1 extends JFrame
{
	private String chkInput; // 현재 연산을 구분할 체크 값 변수 (덧셈인지, 뺄셈인지 구분 하기 위한 변수)
	private int numOne, sum, total, sosu; // 대입연산에 필요한 변수 (numOne, sum, total), 소수인지 정수인지 구별하기 위한 변수 (sosu)
	private int count = 0, inputChk = 0; // 체크값 변수(count), 연산을 구분할 변수 (덧셈인지, 뺄셈인지 구분 하기 위한 변수)
	private final String names[] = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "0", ".", "=", "/"}; // 키 패드 배열
	private JTextField inputText;

	/*
	 * 계산기의 레이아웃 메소드
	 */
	public testCa1(){

		BorderLayout layout = new BorderLayout(2, 2); // 수평, 수직 간격을 각 2, 2 로 지정한다.
		setLayout(layout); // 프레임의 레이아웃을 지정한다.


		JPanel groupPanel = new JPanel(new BorderLayout(5, 2));

		JLabel title = new JLabel("Swing 으로 구현한 계산기", SwingConstants.CENTER); // 타이틀 라벨 생성
		groupPanel.add(title, BorderLayout.NORTH);

		inputText = new JTextField("", SwingConstants.CENTER); // 사용자 입력을 받는 텍스트 필드
		inputText.setHorizontalAlignment(JTextField.RIGHT); // 프롬프트를 오른쪽 정렬 시킨다.

		groupPanel.add(inputText, BorderLayout.CENTER);


		JPanel padPanel = new JPanel(new GridLayout(4, 4)); // 키 패드가 배열로 수평 4, 수직 4 개씩 위치 할 수 있게 GridLayout 을 각각 4,4 로 레이아웃 지정한다.

		JButton buttons[] = new JButton[names.length]; // 키패드 배열 생성

		for(int count = 0; count < names.length; count++)
		{
			buttons[count] = new JButton(names[count]);
			padPanel.add(buttons[count]);

			PadInput handler = new PadInput(); // 키패드 이벤트를 발생 시키기 위해 handler 생성
			buttons[count].addActionListener(handler); // 이벤트 등록
		}

		/*
		 * 하단 클리어 버튼 및 만든이 View
		 */
		JPanel infoView = new JPanel(new BorderLayout(2, 4));
		//4개인 이유찾기
		JButton clear = new JButton("Clear"); // 입력 창을 클리어 시킬 버튼을 생성.
		infoView.add(clear, BorderLayout.NORTH);

		JLabel infoV = new JLabel("만든이 : windydh", SwingConstants.RIGHT);
		infoView.add(infoV, BorderLayout.CENTER);

		JLabel infoV2 = new JLabel("eMail : needcom@lycos.co.kr", SwingConstants.RIGHT);
		infoView.add(infoV2, BorderLayout.SOUTH);

		// 타이틀 라벨과, 텍스트 필드를 담은 groupPanel을 전체 프레임의 최상단에 위치 시킨다. 
		add(groupPanel, BorderLayout.NORTH);
		// 숫자 키패드 패널을 전체 프레임의 중간에 위치 시킨다.
		add(padPanel, BorderLayout.CENTER);
		add(infoView, BorderLayout.SOUTH);

		ClearButton handler = new ClearButton();
		clear.addActionListener(handler);
	}

	/*
	 * 키패드(숫자)가 눌렸을 경우 핸들링 하는 내부 클래스
	 */
	private class PadInput implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String eventText = event.getActionCommand();


			if(eventText.equals("+")) // 덧셈 연산
			{
				inputChk = 1;
			}
			else if(eventText.equals("-")) // 뺄셈 연산
			{
				inputChk = 2;
			}
			else if(eventText.equals("*")) // 곱셈 연산
			{
				inputChk = 3;
			}
			else if(eventText.equals("/")) // 나눗셈 연산
			{
				inputChk = 4;
			}
			else if(eventText.equals("=")) // 연산
			{
				inputChk = 5;
			}
			else
			{
				if(count == 1) // 연산 입력 중 텍스트 필드에 새로운 숫자가 들어 올 경우 텍스트 필드를 비워주기 위한 카운트
				{
					inputText.setText("");
					count = 0;
				}

				inputText.setText(inputText.getText()+event.getActionCommand()); // 사용자가 입력하는 숫자를 조합하여 텍스트 라벨에 표시한다.
			}

			/*
			 * 연산을 위한 조건
			 */
			try
			{
				if((total != 0) && (inputChk <= 5)) // 숫자입력 없이 연산기호만 연속으로 누를 경우 처리
				{
					inputText.setText(inputText.getText()); // 텍스트 라벨에 아무것도 표시 하지 않는다.
				}
				else
				{
					if( inputChk == 1 ) // 덧셈 연산일 경우
					{
						numOne = Integer.parseInt(inputText.getText()); // numOne 함수에 첫번째 수를 입력 하고
						total += numOne; // total 변수에 대입 후 
						numOne = 0; // 새로운 값을 받기위해 numOne 변수는 다시 초기화 한다.

						inputText.setText(String.valueOf(total)); // 텍스트 라벨에는 현재 쌓여 있는 total 값을 보여준다.

						count = 1; // 새로운 두번째 연산 수를 입력 하기 위해 텍스트 라벨을 초기화 한다.
						chkInput = "+"; // 덧셈 연산자를 구분하기 위해 체크 값을 넘겨 연산을 수행 할 수 있게 한다.
					}
					else if( inputChk == 2 ) // 뺄셈 연산일 경우
					{
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;

						inputText.setText(String.valueOf(total));

						count = 1;
						chkInput = "-";
					}
					else if( inputChk == 3 ) // 곱셈 연산일 경우
					{
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;

						inputText.setText(String.valueOf(total));

						count = 1;
						chkInput = "*";
					}
					else if( inputChk == 4 ) // 나눗셈 연산일 경우
					{
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;

						inputText.setText(String.valueOf(total));

						System.out.println(" numBer ==> " + numOne);
						System.out.println(" total ==> " + total);

						count = 1;
						chkInput = "/";
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(" Error ==> " + e);
			}

			/*
			 * 실제 연산을 수행하여 답을 구한다.
			 */
			if(total == 0) // 아무 입력 없이( 빈 텍스트 필드 ) 연산 실행을 할 경우 처리
			{
				inputText.setText(inputText.getText()); // 아무런 반응을 보이지 않음.
			}
			else
			{
				if((inputChk == 5) && chkInput.equals("+")) // 연산 실행이 떨어지고, 그것이 덧셈 일 경우
				{
					numOne = Integer.parseInt(inputText.getText()); // 현재  텍스트 필드에 남아있는 수를 가져온다.
					sum = numOne + total; // 현재 텍스트 필드에 있는 숫자와 누적되어 있는 total 변수 값을 덧셈 한다.

					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum)); // 텍스트 라벨에 현재 sum 결과값을 보여준다.
					//sum = 0;
				}
				else if((inputChk == 5) && chkInput.equals("-")) // 연산 실행이 떨어지고, 그것이 뺄셈 일 경우
				{
					System.out.println("bbb");
					numOne = Integer.parseInt(inputText.getText());
					sum = total - numOne;

					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
					//sum = 0;
				}
				else if((inputChk == 5) && chkInput.equals("*")) // 연산 실행이 떨어지고, 그것이 곱셈 일 경우
				{
					System.out.println("ccc");
					numOne = Integer.parseInt(inputText.getText());
					sum = numOne * total;

					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}
				else if((inputChk == 5) && chkInput.equals("/")) // 연산 실행이 떨어지고, 그것이 나눗셈 일 경우
				{
					System.out.println("ddd");
					numOne = Integer.parseInt(inputText.getText());
					sum = total / numOne;

					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}
			}
		}
	}

	/*
	 * 소숫점 자리 체크
	 */
	public void chkNum(String tField)
	{
		if(tField.indexOf(".") != -1) // tField 에 소숫점이 있을 경우
		{
			sosu = 1;
		}
		else
		{
			sosu = 0;
		}
		return;
	}

	/*
	 * 클리어 버튼을 핸들링 하는 내부 익명 클래스
	 */
	private class ClearButton implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			// 클리어 버튼 시 모든 계산식 함수 초기화
			inputText.setText("");
			numOne = 0;
			total = 0;
			sum = 0;
			count = 0;
			inputChk = 0;
		}
	}

	/*
	 * 계산기를 실행 시키는 메소드
	 */
	public static void main(String args[])
	{
		testCa1 calStart = new testCa1(); // 객체 생성

		//calStart.pack(); // 최소한의 사이즈로 자동으로 프레임 사이즈 조정
		calStart.setSize(210, 350); // 계산기 프레임의 사이즈 정의
		calStart.setResizable(false);
		calStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫을 경우 종료 시킴
		calStart.setVisible(true);
	}}