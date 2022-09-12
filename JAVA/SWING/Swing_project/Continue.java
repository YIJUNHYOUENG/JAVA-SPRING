package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Continue extends JFrame implements ActionListener { 

	// Ÿ�ڿ��� ����� �� ���� 
	
	JPanel p;
	JButton btn1, btn2;
	JLabel l1, l2, l3;
	public static int k=0;
	double n;
	
	Continue() { // �⺻ ����
		setSize(300,200);
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		
		p = new JPanel();
		p.setSize(300,200);
		p.setBorder(tb);
		p.setLayout(null);
		add(p);
		
		btn1 = new JButton("���");
		btn2 = new JButton("�׸�");
		btn1.setBounds(60,130,70,30);
		btn2.setBounds(160,130,70,30);
		p.add(btn1);
		p.add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		

	}
	
	Continue(int count, int cnt, int num, int ts) { // BackInTime���� ���� ����
		this();
		
		l1 = new JLabel("��Ȯ�� :" + mathCnt(cnt)+"%");
		l1.setBounds(90, 30, 150, 30);
		p.add(l1);
		l2 = new JLabel("�� ��Ȯ��" + mathCount(count, num)+"%");
		l2.setBounds(90, 60, 150, 30);
		p.add(l2);
		l3 = new JLabel("Ÿ�� :"+ ts);
		l3.setBounds(90, 90, 150, 30);
		p.add(l3);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public float mathCnt(int cnt) { // ��Ȯ��
		if(cnt == 1) return 100;
		else if(cnt == 2) return 75;
		else if(cnt == 3) return 50;
		else if(cnt == 4) return 25;
		else return 0;
	} 
	
	public float mathCount(int count, int num) { // �� ��Ȯ��
		return ((num-count)/(float)num)*100;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) { // ����� ������ ��
			setVisible(false);
			k++;
			new BackInTime(k);
		} else if(e.getSource() == btn2) { // �׸��� ������ ��
			setVisible(false);
			new Taza();
		}
	}
}
