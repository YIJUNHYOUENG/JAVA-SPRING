package s1019;

import java.awt.event.*;

import javax.swing.*;

public class Join extends JFrame implements ActionListener {

	// ȸ������ â
	
	JTextField ltf, ntf, pwtf, repwtf;
	JLabel ll, pwl, repwl, nl;
	JButton jbtn, cbtn;
	
	Join() {
		setSize(300,300);
		
		JPanel p = new JPanel(null);
		add(p);
		
		ll = new JLabel("���̵�");
		pwl = new JLabel("��й�ȣ");
		repwl = new JLabel("��й�ȣ Ȯ��");
		nl = new JLabel("����");		
		ltf = new JTextField();
		pwtf = new JTextField();
		repwtf = new JTextField();
		ntf = new JTextField();
		jbtn = new JButton("����");
		cbtn = new JButton("���");
		
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
		if(e.getSource() == jbtn) { // ������ ������ ��
			if(LoginInformation.n > 0) { // ���̵� �ߺ� Ȯ��
				for(int i=0;i<LoginInformation.n;i++) {
					if(ltf.getText().trim().equals(LoginInformation.idArr[i])) {
						JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.");
						ltf.requestFocus();
					}
				}
			}
			if(ltf.getText().trim().length() < 8) { // ���̵� �ڸ��� Ȯ��
				JOptionPane.showMessageDialog(null, "���̵� 8���� �̻󾲼���.");
				ltf.requestFocus();
			} else if(pwtf.getText().trim().length() < 8) { // ��й�ȣ �ڸ��� Ȯ��
				JOptionPane.showMessageDialog(null, "��й�ȣ�� 8���� �̻󾲼���.");
				pwtf.requestFocus();
			} else if(!repwtf.getText().trim().equals(pwtf.getText().trim())) { // ��й�ȣ �� Ȯ��
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				repwtf.requestFocus();
			} else { // ȸ������ �Ϸ�
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ� �Ǿ����ϴ�.");
				setVisible(false);
				new LoginInformation(ltf.getText().trim(), pwtf.getText().trim(), ntf.getText().trim());
			}
		} else if(e.getSource() == cbtn) { //��Ҹ� ������ ��
			setVisible(false);
			new Login(LoginInformation.idArr, LoginInformation.pwArr, LoginInformation.nameArr);
		}
	}
}
