package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Taza extends JFrame implements ActionListener{

	// Ÿ�� ���� ���� â
	
	JLabel  l;
	JButton btn1, btn2;
	Choice c1;
	JFrame f1;
	
	Taza() {
		setSize(300,150);
		
		JPanel p = new JPanel();
		p.setSize(300,150);
		add(p);
		
		p.setLayout(null);
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		p.setBorder(tb);
		
		c1 = new Choice();
		c1.setBounds(70,30, 200, 50);
		c1.add("�ð��� �Ž���");
		c1.add("����Ÿ����");
		p.add(c1);
		
		btn1 = new JButton("����");
		btn2 = new JButton("����");
		btn1.setBounds(80, 80, 60, 40);
		btn2.setBounds(160, 80, 60, 40);
		p.add(btn1);
		p.add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			if(c1.getSelectedItem().equals("�ð��� �Ž���")) {
				setVisible(false);
				new BackInTime(0);
			} else if(c1.equals("�� ��� ����")) {
				
			}
		} else if(e.getSource() == btn2) {
			setVisible(false);
			new ChoiceFunction(Login.nameArr[Login.num]);
		}
	}
}
