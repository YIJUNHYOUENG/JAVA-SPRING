package s1019;

import java.awt.event.*;

import javax.swing.*;

public class Join extends JFrame implements ActionListener {

	// 회원가입 창
	
	JTextField ltf, ntf, pwtf, repwtf;
	JLabel ll, pwl, repwl, nl;
	JButton jbtn, cbtn;
	
	Join() {
		setSize(300,300);
		
		JPanel p = new JPanel(null);
		add(p);
		
		ll = new JLabel("아이디");
		pwl = new JLabel("비밀번호");
		repwl = new JLabel("비밀번호 확인");
		nl = new JLabel("별명");		
		ltf = new JTextField();
		pwtf = new JTextField();
		repwtf = new JTextField();
		ntf = new JTextField();
		jbtn = new JButton("가입");
		cbtn = new JButton("취소");
		
		ll.setBounds(50,20,50,30);
		pwl.setBounds(44,60,50,30);
		ltf.setBounds(140,25,100,20);
		pwtf.setBounds(140,65,100,20);
		repwl.setBounds(30,100,80,30);
		repwtf.setBounds(140, 105, 100, 20);
		ntf.setBounds(140, 145, 100, 20);
		nl.setBounds(50, 140, 50, 30);
		jbtn.setBounds(50, 200, 70, 30);
		cbtn.setBounds(160, 200, 70, 30);
		
		jbtn.addActionListener(this);
		cbtn.addActionListener(this);
		
		p.add(ll);
		p.add(pwl);
		p.add(ltf);
		p.add(pwtf);
		p.add(repwl);
		p.add(repwtf);
		p.add(ntf);
		p.add(nl);
		p.add(jbtn);
		p.add(cbtn);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn) { // 가입을 눌렀을 때
			if(LoginInformation.n > 0) { // 아이디 중복 확인
				for(int i=0;i<LoginInformation.n;i++) {
					if(ltf.getText().trim().equals(LoginInformation.idArr[i])) {
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
						ltf.requestFocus();
					}
				}
			}
			if(ltf.getText().trim().length() < 8) { // 아이디 자릿수 확인
				JOptionPane.showMessageDialog(null, "아이디를 8글자 이상쓰세요.");
				ltf.requestFocus();
			} else if(pwtf.getText().trim().length() < 8) { // 비밀번호 자릿수 확인
				JOptionPane.showMessageDialog(null, "비밀번호를 8글자 이상쓰세요.");
				pwtf.requestFocus();
			} else if(!repwtf.getText().trim().equals(pwtf.getText().trim())) { // 비밀번호 재 확인
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				repwtf.requestFocus();
			} else { // 회원가입 완료
				JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다.");
				setVisible(false);
				new LoginInformation(ltf.getText().trim(), pwtf.getText().trim(), ntf.getText().trim());
			}
		} else if(e.getSource() == cbtn) { //취소를 눌렀을 때
			setVisible(false);
			new Login(LoginInformation.idArr, LoginInformation.pwArr, LoginInformation.nameArr);
		}
	}
}
