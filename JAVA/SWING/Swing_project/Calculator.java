package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Calculator extends JFrame implements ActionListener {
	
	// ����
	
	JPanel p;
	JButton[] btn;
	JButton backBtn;
	JLabel label;
	int x = 24, y = 78, n=0;
	String str = "", num="";
	
	Calculator() {
		//���� ���� �� ��� ����
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
		btn[3].setText("��");
		btn[4].setText("7");
		btn[5].setText("8");
		btn[6].setText("9");
		btn[7].setText("��");
		btn[8].setText("4");
		btn[9].setText("5");
		btn[10].setText("6");
		btn[11].setText("��");
		btn[12].setText("1");
		btn[13].setText("2");
		btn[14].setText("3");
		btn[15].setText("+");
		btn[16].setText("��");
		btn[17].setText("0");
		btn[18].setText("-");
		btn[19].setText("=");

		for(int i=0;i<20;i++) btn[i].addActionListener(this);
		
		Font font = new Font("���� ���",Font.BOLD,30);
		
		label = new JLabel("");
		label.setFont(font);
		label.setBounds(20, 10, 260, 60);
		p.add(label);
		
		backBtn = new JButton("���ư���");
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
		if(e.getSource().equals(btn[1])) { // C�� ������ ��
			str = "";
			num = "";
			label.setText(str);
			btn[15].setEnabled(true);
			btn[18].setEnabled(true);
			btn[7].setEnabled(true);
			btn[11].setEnabled(true);
			btn[2].setEnabled(true);
		} else if(e.getSource().equals(btn[0])) { // CE�� ������ ��
			str = "";
			label.setText(str);
		} else if(e.getSource().equals(btn[15])) { // +�� ������ ��
			n=1;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[18])) { // -�� ������ ��
			n=2;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[7])) { // ���� ������ ��
			n=3; 
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[11])) { // ���� ������ ��
			n=4;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[3])) { // �縦 ������ ��
			int n = str.length();
			if(n!=0) {
				System.out.println(str.length());
				try { // ���� ���� -�� ��� ������ ���� ������ ����ó���� �ǳ� ��
					if(Float.parseFloat(str) == (int)Float.parseFloat(str)) { // ���� �Ҽ����� ���� ��� int���� ��ȯ
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
		} else if(e.getSource().equals(btn[2])) { // %�� ������ ��
			n=5;
			num = str;
			str = "";
			label.setText("");
			btn[18].setEnabled(false);
			btn[7].setEnabled(false);
			btn[15].setEnabled(false);
			btn[2].setEnabled(false);
			btn[11].setEnabled(false);
		} else if(e.getSource().equals(btn[19])) { // =�� ������ ��
			try { // �����ڸ� ������ ���� �Է��� ���� ���� �۵�
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
		} else if(e.getSource().equals(btn[12])) { // 1�� ������ ��
			str += "1";
			label.setText(str);
		} else if(e.getSource().equals(btn[13])) { // 2�� ������ ��
			str += "2";
			label.setText(str);
		} else if(e.getSource().equals(btn[14])) { // 3�� ������ ��
			str += "3";
			label.setText(str);
		} else if(e.getSource().equals(btn[8])) { // 4�� ������ ��
			str += "4";
			label.setText(str);
		} else if(e.getSource().equals(btn[9])) { // 5�� ������ ��
			str += "5";
			label.setText(str);
		} else if(e.getSource().equals(btn[10])) { // 6�� ������ ��
			str += "6";
			label.setText(str);
		} else if(e.getSource().equals(btn[4])) { // 7�� ������ ��
			str += "7";
			label.setText(str);
		} else if(e.getSource().equals(btn[5])) { // 8�� ������ ��
			str += "8";
			label.setText(str);
		} else if(e.getSource().equals(btn[6])) { // 9�� ������ ��
			str += "9";
			label.setText(str);
		} else if(e.getSource().equals(btn[17])) { // 0�� ������ ��
			str += "0";
			label.setText(str);
		} else { // ���� ������ ��
			float n = Float.parseFloat(str);
			n *= -1;
			str = String.valueOf(n);
			intFloat(str);
			label.setText(str);
		} 
		if(e.getSource().equals(backBtn)) { // ���ư��� ������ ��
			setVisible(false);
			new ChoiceFunction(Login.nameArr[Login.num]);
		}
	}
	
	void intFloat(String str) { // �Ҽ����� ���� ��� int������ �ٲ���
		if(Float.parseFloat(str) == (int)Float.parseFloat(str)) {
			float f = Float.parseFloat(str);
			int i = (int)f;
			str = String.valueOf(i);
			this.str = str;
		}
	}

}
