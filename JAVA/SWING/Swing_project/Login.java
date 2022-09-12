package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	// 로그인 창
	
	JLabel lLabel, pwLabel;
	JTextField ltf, pwtf;
	JButton newLbtn, lbtn, cancelbtn;
	static String[] idArr, pwArr, nameArr;
	static int num;
	
	Login() { // 위치 설정
		setTitle("로그인");
		setSize(300,200);
		JPanel p = new JPanel(null);
		add(p);
		
		lLabel = new JLabel("아이디");
		pwLabel = new JLabel("비밀번호");
		ltf = new JTextField();
		pwtf = new JTextField();
		newLbtn = new JButton("회원가입");
		lbtn = new JButton("확인");
		cancelbtn = new JButton("최소");
		
		lLabel.setBounds(50,20,50,30);
		pwLabel.setBounds(44,60,50,30);
		ltf.setBounds(140,25,100,20);
		pwtf.setBounds(140,65,100,20);
		newLbtn.setBounds(20,110,85,30);
		lbtn.setBounds(125,110,60,30);
		cancelbtn.setBounds(205,110,60,30);
		
		newLbtn.addActionListener(this);
		lbtn.addActionListener(this);
		cancelbtn.addActionListener(this);
		
		p.add(lLabel);
		p.add(pwLabel);
		p.add(ltf);
		p.add(pwtf);
		p.add(newLbtn);
		p.add(lbtn);
		p.add(cancelbtn);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	Login(String[] idArr, String[] pwArr, String[] nameArr) { // 회원가입을 한 후 정보를 각 배열에 저장
		this();
		Login.idArr = idArr;
		Login.pwArr = pwArr;
		Login.nameArr = nameArr;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newLbtn) { // 회원가입 버튼을 눌렀을 때
			setVisible(false);
			new Join();
		} else if(e.getSource() == lbtn) { // 확인을 눌렀을 때
			try {
				for(int i=0;i<LoginInformation.n;i++) { // 아이디가 있는 배열에 방 번호를 구함
					if(ltf.getText().trim().equals(idArr[i])) {
						num = i;
						break;
					}
				}	
				if(!ltf.getText().trim().equals(idArr[num])) { // 아이디 비교
					JOptionPane.showMessageDialog(null, "아이디가 다릅니다.");
					ltf.requestFocus();
				} else if(!pwtf.getText().equals(pwArr[num])) { // 비밀번호 비교
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
					pwtf.requestFocus();
				} else { // 다 맞을 시 로그인
					setVisible(false);
					new ChoiceFunction(nameArr[num]);
				}
			} catch(NullPointerException e1) {
				
			}
		} else if(e.getSource() == cancelbtn) { // 취소 버튼을 눌렀으 때
			System.exit(0); // 시스템 종료
		}
	}
	
	public static void main(String[] args) {
		new Login(Login.idArr,Login.pwArr,Login.nameArr);
	}
}
