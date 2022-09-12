package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ChoiceFunction extends JFrame implements ActionListener { 
	
	// ���� â
	
	JLabel name, tazaLabel, calLabel;
	JButton tazaBtn, calBtn, backBtn;
	
	ChoiceFunction(String nn) {
		setSize(400,400);
		
		JPanel p = new JPanel();
		p.setSize(500,400);
		add(p);
		
		p.setLayout(null);
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		p.setBorder(tb);
		
		name = new JLabel(nn);
		name.setBounds(15, 15, 50, 30);
		p.add(name);
		
		Font font = new Font("���� ���",Font.BOLD,20);
		
		tazaLabel = new JLabel("Ÿ�� ����");
		tazaLabel.setFont(font);
		tazaLabel.setBounds(70,60,150,30);
		p.add(tazaLabel);
		
		tazaBtn = new JButton("�̵�");
		tazaBtn.setBounds(250,60,70,30);
		p.add(tazaBtn);
		tazaBtn.addActionListener(this);
		
		calLabel = new JLabel("����");
		calLabel.setFont(font);
		calLabel.setBounds(80,120,150,30);
		p.add(calLabel);
		
		calBtn = new JButton("�̵�");
		calBtn.setBounds(250,120,70,30);
		p.add(calBtn);
		calBtn.addActionListener(this);
		
		backBtn = new JButton("�α׾ƿ�");
		backBtn.setBounds(150, 350, 100, 30);
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
		if(e.getSource().equals(tazaBtn)) { // Taza�� �̵�
			setVisible(false);
			new Taza();
		} else if(e.getSource().equals(calBtn)) { // Calculator�� �̵�
			setVisible(false);
			new Calculator();
		}
		if(e.getSource().equals(backBtn)) { // �α׾ƿ��� ������ ��
			setVisible(false);
			new Login();
		}
	}
	
}
