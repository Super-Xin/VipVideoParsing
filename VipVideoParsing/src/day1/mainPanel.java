package day1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class mainPanel extends JPanel implements ActionListener{
	TextField text1 = new TextField("https://www.iqiyi.com/v_19rqzk9bus.html",50);
	JButton b = new JButton("������ַ");
	String[] api = {"�ӿ�һ","�ӿڶ�","�ӿ���","�ӿ���","�ӿ���"};
	JComboBox box1 = new JComboBox(api);
	boolean isNormalNetwork = false;
	public mainPanel() {
		//���캯��
		setLayout(null);
		setBackground(Color.PINK);
		text1.setFont(new Font(null,Font.BOLD,15));
		text1.setBounds(80, 105, 400, 25);
		text1.selectAll();
		text1.setVisible(true);
		b.setBounds(240, 195, 100, 50);
		b.addActionListener(this);
		box1.setEditable(true);
		box1.setBounds(300, 150 ,80, 30);
		box1.setFont(new Font(null,Font.BOLD,15));
		box1.setEditable(false);
		add(text1);
		add(b);
		add(box1);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.setFont(new Font(null,Font.BOLD,20));
		g.drawString("��ܰ��ʾ��֧�ֹ������еĴ�����Ƶ��վ", 95, 50);
		g.drawString("������Ҫ��������Ƶ��վ��ַ", 150, 80);
		g.drawString("��������ṩ����Ƶ������������̵ĶԽӷ���", 75, 280);
		g.drawString("��������ʹ�ã�������ҵ��;",155, 310);
		g.drawString("ѡ��ӿڣ�", 190, 172);
		
	}
	//�ַ�������
	public String findString()
	{
		String a = text1.getText();
		String[] date={
				".youku.com",
				".iqiyi.com",
				".qq.com",
				".sohu.com",
				".le.com",
				".mgtv.com", 
				".tudou.com",
				".pptv.com",
				".1905.com",
				".miguvideo.com",
				".acfun.cn",
				".yinyuetai.com",
				".m3u8",
				".M3U8",
				};
		for(int i=0;i<date.length;i++)
		{
			int found = a.indexOf(date[i]);
			if(found != -1)
			{
				switch(i)
				{
					case 0:
						return "�ſ���Ƶ";
					case 1:
						return "������";
					case 2:
						return "��Ѷ��Ƶ";
					case 3:
						return "�Ѻ���Ƶ";
					case 4:
						return "������Ƶ";
					case 5:
						return "â��TV";
					case 6:
						return "������Ƶ";
					case 7:
						return "PPTV����";
					case 8:
						return "M1905";
					case 9:
						return "������Ƶ";
					case 10:
						return "AcFun";
					case 11:
						return "����̨";
					case 12:
						return "m3u8ֱ��";
					case 13:
						return "m3u8ֱ��";
						
				}			 
			}
		}
		return "Unknow������ʧ��";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(text1.getText().length()==0)
			JOptionPane.showMessageDialog(this,"���棺�޷������յ�ַ��");
		else{
			//������ͨ�Լ��
			if(!(new netWorkTest(text1.getText()).getRight()))
			{
				//���ʧ��
				JOptionPane.showMessageDialog(this,"���棺���Ӵ�������粻���ã�");
			}
			else{
				//���ɹ�
				Object[] options ={ "��", "��" }; 
				int n = JOptionPane.showOptionDialog(this, "�Ƿ����������", "��Ƶ��Դ��" + findString(),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(n==0)
				{
					int api = box1.getSelectedIndex();
					//�����ӿ�
					String[] jiekou={
							"http://www.98a.ink/vip/hot/?url=",
							"http://app.baiyug.cn:2019/vip/index.php?url=",
							"http://vip.xtxfsm.com:81/skyvideo/jx4.php?url=",
							"http://jx.du2.cc/jx6.php?url=",
							"http://api.ledboke.com/?url=", 
							};
					//�����������
					String url = "rundll32 url.dll,FileProtocolHandler ";
					url += jiekou[api];
					url += text1.getText();
					try {
						Runtime.getRuntime().exec(url);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this,"��ʾ��������ɣ�");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"��ʾ���Ѿ�ȡ��������");
				}
			}
		}
	}
}
