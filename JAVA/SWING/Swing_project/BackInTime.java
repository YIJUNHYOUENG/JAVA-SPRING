package s1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class BackInTime extends JFrame implements ActionListener, KeyListener {
	
	// �ð��� �Ž��� Ÿ�� ����
	
	JPanel p;
	Thread p_display;
	JLabel title, start;
	JLabel label[] = new JLabel[22];
	JTextField textField[];
	JButton btn1, btn2;
	public static int count=0,num=0,c=0;
	public int cnt=1, ts,t=0,tcnt=0,mm=0;
	
	BackInTime() {
		setTitle("�ð��� �Ž���");
		setSize(500,400);
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		
		p = new JPanel();
		p.setSize(500,400);
		p.setLayout(null);
		add(p);
		
		p.setBorder(tb);
		
		Font font = new Font("���� ���",Font.BOLD,20);
		
		title = new JLabel("�ð��� �Ž���");
		title.setFont(font);
		title.setBounds(180, 10, 300, 50);
		p.add(title);
		
		start = new JLabel("�����Ͻ÷��� shiftŰ�� ��������!");
		start.setBounds(152, 45, 300, 50);
		p.add(start);
		
		label = new JLabel[22];
		label[0] = new JLabel("������ ���� �������");
		label[1] = new JLabel("â���� ����� ������");
		label[2] = new JLabel("�����Ҹ���ŭ �ø� ������");
		label[3] = new JLabel("�� ���� ����� �ִµ�");
		label[4] = new JLabel("������ £������ �׸��� ���");
		label[5] = new JLabel("�ð��� �Ž��� ���� ������");
		label[6] = new JLabel("�� ��ó���� �״� �� �Ⱦ��ָ�");
		label[7] = new JLabel("�������ٵ� ����");
		label[8] = new JLabel("����� ������ ����");
		label[9] = new JLabel("�Բ��� �߾��� ���ƺ�");
		label[10] = new JLabel("����� ������ ������ �״밡");
		label[11] = new JLabel("�� ���� �ӿ��� ���ö��");
		label[12] = new JLabel("������ £������ �׸��� ���");
		label[13] = new JLabel("�ð��� �Ž��� ���� ������");
		label[14] = new JLabel("�� ��ó���� �״� �� �Ⱦ��ָ�");
		label[15] = new JLabel("�������ٵ� ����");
		label[16] = new JLabel("������� ���� �־��ִ�");
		label[17] = new JLabel("�� �ð��� �� �����");
		label[18] = new JLabel("�ٽ� �׶�ó���� �״븦 �ȾƼ�");
		label[19] = new JLabel("�ð��� �Ž��� ���� ������");
		label[20] = new JLabel("�ѹ��̶� ������������");
		label[21] = new JLabel("�������ٵ�");
		
		textField = new JTextField[22];
		for(int i=0;i<22;i++) {
			textField[i] = new JTextField(20);
			textField[i].addKeyListener(this);
		}

		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	BackInTime(int num) {
		this();
		if(num == 0) {
			label[0].setBounds(183,80,200,50);
			label[1].setBounds(183,140,200,50);
			label[2].setBounds(171,200,200,50);
			label[3].setBounds(183,260,200,50);
			
			textField[0].setBounds(180, 125, 130, 20);
			textField[1].setBounds(180, 185, 130, 20);
			textField[2].setBounds(170, 245, 160, 20);
			textField[3].setBounds(180, 305, 130, 20);
		} else if(num == 1) {
			label[4].setBounds(160,80,200,50);
			label[5].setBounds(170,140,200,50);
			label[6].setBounds(166,200,200,50);
			label[7].setBounds(199,260,200,50);
			
			textField[4].setBounds(159, 125, 172, 20);
			textField[5].setBounds(167, 185, 155, 20);
			textField[6].setBounds(163, 245, 169, 20);
			textField[7].setBounds(195, 305, 100, 20);
		} else if(num == 2) {
			label[8].setBounds(184,80,200,50);
			label[9].setBounds(184,140,200,50);
			label[10].setBounds(166,200,200,50);
			label[11].setBounds(180,260,200,50);
			
			textField[8].setBounds(179, 125, 132, 20);
			textField[9].setBounds(179, 185, 132, 20);
			textField[10].setBounds(162, 245, 169, 20);
			textField[11].setBounds(176, 305, 142, 20);
		} else if(num == 3) {
			label[12].setBounds(160,80,200,50);
			label[13].setBounds(170,140,200,50);
			label[14].setBounds(166,200,200,50);
			label[15].setBounds(199,260,200,50);
			
			textField[12].setBounds(159, 125, 172, 20);
			textField[13].setBounds(167, 185, 155, 20);
			textField[14].setBounds(163, 245, 169, 20);
			textField[15].setBounds(195, 305, 100, 20);
		} else if(num == 4) {
			label[16].setBounds(181,80,200,50);
			label[17].setBounds(192,140,200,50);
			label[18].setBounds(164,200,200,50);
			label[19].setBounds(175,260,200,50);
			
			textField[16].setBounds(180, 125, 132, 20);
			textField[17].setBounds(188, 185, 118, 20);
			textField[18].setBounds(160, 245, 178, 20);
			textField[19].setBounds(172, 305, 155, 20);
		} else if(num == 5) {
			label[20].setBounds(170,80,200,50);
			label[21].setBounds(216,140,200,50);
			
			textField[20].setBounds(166, 125, 160, 20);
			textField[21].setBounds(212, 185, 70, 20);
		}
		for(int i=0;i<22;i++) {
			p.add(textField[i]);
			p.add(label[i]);
		}

		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() != KeyEvent.VK_SHIFT & e.getKeyCode() != KeyEvent.VK_ENTER & e.getKeyCode() != KeyEvent.VK_BACK_SPACE) tcnt++;
		if(textField[num].getText().length() > label[num].getText().length()+1) {
			textCheck(num);
			if(num!=21) textField[num+1].requestFocus();
			if(num%4==3) {
				ts = tcnt*60/mm;
				setVisible(false);
				new Continue(count, cnt, c, ts);
			} else if(num == 21) {
				ts = tcnt*60/mm;
				setVisible(false);
				new EndTaza(count, cnt, c, ts);
			}
			num++;
		}
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			textField[num].requestFocus();
			p_display = new Thread(new Runnable() {
				@Override
			    public void run() {
			    	while (p_display == Thread.currentThread()) {
			    		mm = (t) % (1000 * 60) / 100 % 60;
			    		try {
			    			Thread.sleep(10);
			   				t++;
			  			} catch (InterruptedException e1) {}
			   		}
		    	}
		    });
			    
			p_display.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(textField[num].getText().length() >= label[num].getText().length()) {
				textCheck(num);
				if(num!=21) textField[num+1].requestFocus();
				if(num%4==3) {
					ts = tcnt*60/mm;
					setVisible(false);
					new Continue(count, cnt, c, ts);
				} else if(num==21) {
					ts = tcnt*60/mm;
					setVisible(false);
					new EndTaza(count, cnt, c, ts);
				}
				num++;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void textCheck(int num) {
		if(label[num].getText().equals(textField[num].getText().trim())) {
			label[num].setForeground(Color.blue);
			c++;
		} else {
			label[num].setForeground(Color.red);
			count++;
			cnt++;
			c++;
		}
	}
}
