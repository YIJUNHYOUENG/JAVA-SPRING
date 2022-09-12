package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ChoiceFunction extends JFrame implements ActionListener { 
	
	// 선택 창
	
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
		
		Font font = new Font("맑은 고딕",Font.BOLD,20);
		
		tazaLabel = new JLabel("타자 연습");
		tazaLabel.setFont(font);
		tazaLabel.setBounds(70,60,150,30);
		p.add(tazaLabel);
		
		tazaBtn = new JButton("이동");
		tazaBtn.setBounds(250,60,70,30);
		p.add(tazaBtn);
		tazaBtn.addActionListener(this);
		
		calLabel = new JLabel("계산기");
		calLabel.setFont(font);
		calLabel.setBounds(80,120,150,30);
		p.add(calLabel);
		
		calBtn = new JButton("이동");
		calBtn.setBounds(250,120,70,30);
		p.add(calBtn);
		calBtn.addActionListener(this);
		
		backBtn = new JButton("로그아웃");
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
		if(e.getSource().equals(tazaBtn)) { // Taza로 이동
			setVisible(false);
			new Taza();
		} else if(e.getSource().equals(calBtn)) { // Calculator로 이동
			setVisible(false);
			new Calculator();
		}
		if(e.getSource().equals(backBtn)) { // 로그아웃을 눌렀을 때
			setVisible(false);
			new Login();
		}
	}
	
}
