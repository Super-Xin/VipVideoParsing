package day1;
import javax.swing.JFrame;

public class mainFrame extends JFrame {
	public mainFrame() {
		//���ñ���
		setTitle("VIP��Ƶ����JAVAͼ�ν���汾_V1.0 By Xin");
		//���ô����С��λ��
		setBounds(450, 200, 600, 400);
		//���ô���رգ������������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��������
		setResizable(false);
		//���ÿɼ�
		setVisible(true);
	}
	public static void main(String[] args) {
		mainPanel a = new mainPanel();
		new mainFrame().add(a);
	}

}
