package day1;
import javax.swing.JFrame;

public class mainFrame extends JFrame {
	public mainFrame() {
		//设置标题
		setTitle("VIP视频解析JAVA图形界面版本_V1.0 By Xin");
		//设置窗体大小及位置
		setBounds(450, 200, 600, 400);
		//设置窗体关闭，程序结束运行
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置不允许最大化
		setResizable(false);
		//设置可见
		setVisible(true);
	}
	public static void main(String[] args) {
		mainPanel a = new mainPanel();
		new mainFrame().add(a);
	}

}
