package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	// �α��� â
	
	JLabel lLabel, pwLabel;
	JTextField ltf, pwtf;
	JButton newLbtn, lbtn, cancelbtn;
	static String[] idArr, pwArr, nameArr;
	static int num;
	
	Login() { // ��ġ ����
		setTitle("�α���");
		setSize(300,200);
		JPanel p = new JPanel(null);
		add(p);
		
		lLabel = new JLabel("���̵�");
		pwLabel = new JLabel("��й�ȣ");
		ltf = new JTextField();
		pwtf = new JTextField();
		newLbtn = new JButton("ȸ������");
		lbtn = new JButton("Ȯ��");
		cancelbtn = new JButton("�ּ�");
		
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
	
	Login(String[] idArr, String[] pwArr, String[] nameArr) { // ȸ�������� �� �� ������ �� �迭�� ����
		this();
		Login.idArr = idArr;
		Login.pwArr = pwArr;
		Login.nameArr = nameArr;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newLbtn) { // ȸ������ ��ư�� ������ ��
			setVisible(false);
			new Join();
		} else if(e.getSource() == lbtn) { // Ȯ���� ������ ��
			try {
				for(int i=0;i<LoginInformation.n;i++) { // ���̵� �ִ� �迭�� �� ��ȣ�� ����
					if(ltf.getText().trim().equals(idArr[i])) {
						num = i;
						break;
					}
				}	
				if(!ltf.getText().trim().equals(idArr[num])) { // ���̵� ��
					JOptionPane.showMessageDialog(null, "���̵� �ٸ��ϴ�.");
					ltf.requestFocus();
				} else if(!pwtf.getText().equals(pwArr[num])) { // ��й�ȣ ��
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٸ��ϴ�.");
					pwtf.requestFocus();
				} else { // �� ���� �� �α���
					setVisible(false);
					new ChoiceFunction(nameArr[num]);
				}
			} catch(NullPointerException e1) {
				
			}
		} else if(e.getSource() == cancelbtn) { // ��� ��ư�� ������ ��
			System.exit(0); // �ý��� ����
		}
	}
	
	public static void main(String[] args) {
		new Login(Login.idArr,Login.pwArr,Login.nameArr);
	}
}
