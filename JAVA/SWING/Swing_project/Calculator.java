package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Calculator extends JFrame implements ActionListener {
	
	// 계산기
	
	JPanel p;
	JButton[] btn;
	JButton backBtn;
	JLabel label;
	int x = 24, y = 78, n=0;
	String str = "", num="";
	
	Calculator() {
		//계산기 외형 및 기능 설정
		setSize(300,400);
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		
		p = new JPanel();
		p.setSize(300,400);
		p.setLayout(null);
		add(p);
		
		p.setBorder(tb);
		
		btn = new JButton[20];
		for(int i=0;i<20;i++) {
			btn[i] = new JButton();
			btn[i].setBounds(x,y,55,45);
			x+=65;
			if((i+1)%4==0) {
				x=24;
				y+=55;
			}
			p.add(btn[i]);
		}
		btn[0].setText("CE");
		btn[1].setText("C");
		btn[2].setText("%");
		btn[3].setText("←");
		btn[4].setText("7");
		btn[5].setText("8");
		btn[6].setText("9");
		btn[7].setText("×");
		btn[8].setText("4");
		btn[9].setText("5");
		btn[10].setText("6");
		btn[11].setText("÷");
		btn[12].setText("1");
		btn[13].setText("2");
		btn[14].setText("3");
		btn[15].setText("+");
		btn[16].setText("±");
		btn[17].setText("0");
		btn[18].setText("-");
		btn[19].setText("=");

		for(int i=0;i<20;i++) btn[i].addActionListener(this);
		
		Font font = new Font("맑은 고딕",Font.BOLD,30);
		
		label = new JLabel("");
		label.setFont(font);
		label.setBounds(20, 10, 260, 60);
		p.add(label);
		
		backBtn = new JButton("돌아가기");
		backBtn.setBounds(20,355,260,30);
		p.add(backBtn);
		backBtn.addActionListener(this);
		
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn[1])) { // C를 눌렀을 때
			str = "";
			num = "";
			label.setText(str);
			btn[15].setEnabled(true);
			btn[18].setEnabled(true);
			btn[7].setEnabled(true);
			btn[11].setEnabled(true);
			btn[2].setEnabled(true);
		} else if(e.getSource().equals(btn[0])) { // CE를 눌렀을 때
			str = "";
			label.setText(str);
		} else if(e.getSource().equals(btn[15])) { // +를 눌렀을 때
			n=1;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[18])) { // -를 눌렀을 때
			n=2;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[7])) { // ×를 눌렀을 때
			n=3; 
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[11])) { // ÷를 눌렀을 때
			n=4;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[3])) { // ←를 눌렀을 때
			int n = str.length();
			if(n!=0) {
				System.out.println(str.length());
				try { // 지울 값이 -일 경우 오류가 나기 때문에 예외처리로 건너 뜀
					if(Float.parseFloat(str) == (int)Float.parseFloat(str)) { // 만약 소수점이 없을 경우 int형을 변환
						float k = Float.parseFloat(str);
						int j = (int)k;	
						str = String.valueOf(j);
						n = str.length();
						label.setText(str);
					}
				} catch(NumberFormatException e2) {}
				str = str.substring(0,n-1);
				label.setText(str);
			}
		} else if(e.getSource().equals(btn[2])) { // %를 눌렀을 때
			n=5;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[19])) { // =를 눌렀을 때
			try { // 연사자를 누르고 숫자 입력을 했을 때만 작동
				if(n==1) {
					str = String.valueOf(Float.parseFloat(num)+Float.parseFloat(str));
					intFloat(str);
				} else if(n==2) {
					str = String.valueOf(Float.parseFloat(num)-Float.parseFloat(str));
					intFloat(str);
				} else if(n==3) {
					str = String.valueOf(Float.parseFloat(num)*Float.parseFloat(str));
					intFloat(str);
				} else if(n==4) {
				str = String.valueOf(Float.parseFloat(num)/Float.parseFloat(str));
				intFloat(str);
				} else if(n==5) {
					str = String.valueOf(Float.parseFloat(num)%Float.parseFloat(str));
					intFloat(str);
				}
				label.setText(str);
				btn[15].setEnabled(true);
				btn[18].setEnabled(true);
				btn[7].setEnabled(true);
				btn[11].setEnabled(true);
				btn[2].setEnabled(true);
			} catch(NumberFormatException e1) {
				
			}
		} else if(e.getSource().equals(btn[12])) { // 1을 눌렀을 때
			str += "1";
			label.setText(str);
		} else if(e.getSource().equals(btn[13])) { // 2를 눌렀을 때
			str += "2";
			label.setText(str);
		} else if(e.getSource().equals(btn[14])) { // 3을 눌렀을 때
			str += "3";
			label.setText(str);
		} else if(e.getSource().equals(btn[8])) { // 4를 눌렀을 때
			str += "4";
			label.setText(str);
		} else if(e.getSource().equals(btn[9])) { // 5를 눌렀을 때
			str += "5";
			label.setText(str);
		} else if(e.getSource().equals(btn[10])) { // 6을 눌렀을 때
			str += "6";
			label.setText(str);
		} else if(e.getSource().equals(btn[4])) { // 7을 눌렀을 때
			str += "7";
			label.setText(str);
		} else if(e.getSource().equals(btn[5])) { // 8을 눌렀을 때
			str += "8";
			label.setText(str);
		} else if(e.getSource().equals(btn[6])) { // 9를 눌렀을 때
			str += "9";
			label.setText(str);
		} else if(e.getSource().equals(btn[17])) { // 0을 눌렀을 때
			str += "0";
			label.setText(str);
		} else { // ±를 눌렀을 때
			float n = Float.parseFloat(str);
			n *= -1;
			str = String.valueOf(n);
			intFloat(str);
			label.setText(str);
		} 
		if(e.getSource().equals(backBtn)) { // 돌아가기 눌렀을 때
			setVisible(false);
			new ChoiceFunction(Login.nameArr[Login.num]);
		}
	}
	
	void intFloat(String str) { // 소수점이 없을 경우 int형으로 바꿔줌
		if(Float.parseFloat(str) == (int)Float.parseFloat(str)) {
			float f = Float.parseFloat(str);
			int i = (int)f;
			str = String.valueOf(i);
			this.str = str;
		}
	}

}
