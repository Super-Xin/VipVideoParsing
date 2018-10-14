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
	JButton b = new JButton("解析地址");
	String[] api = {"接口一","接口二","接口三","接口四","接口五"};
	JComboBox box1 = new JComboBox(api);
	boolean isNormalNetwork = false;
	public mainPanel() {
		//构造函数
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
		g.drawString("温馨提示：支持国内所有的大型视频网站", 95, 50);
		g.drawString("请输入要解析的视频网站网址", 150, 80);
		g.drawString("本程序仅提供与视频解析服务服务商的对接服务", 75, 280);
		g.drawString("仅供交流使用，不做商业用途",155, 310);
		g.drawString("选择接口：", 190, 172);
		
	}
	//字符串查找
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
						return "优酷视频";
					case 1:
						return "爱奇艺";
					case 2:
						return "腾讯视频";
					case 3:
						return "搜狐视频";
					case 4:
						return "乐视视频";
					case 5:
						return "芒果TV";
					case 6:
						return "土豆视频";
					case 7:
						return "PPTV聚力";
					case 8:
						return "M1905";
					case 9:
						return "咕咪视频";
					case 10:
						return "AcFun";
					case 11:
						return "音悦台";
					case 12:
						return "m3u8直链";
					case 13:
						return "m3u8直链";
						
				}			 
			}
		}
		return "Unknow，可能失败";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(text1.getText().length()==0)
			JOptionPane.showMessageDialog(this,"警告：无法解析空地址！");
		else{
			//网络连通性检测
			if(!(new netWorkTest(text1.getText()).getRight()))
			{
				//检测失败
				JOptionPane.showMessageDialog(this,"警告：链接错误或网络不可用！");
			}
			else{
				//检测成功
				Object[] options ={ "是", "否" }; 
				int n = JOptionPane.showOptionDialog(this, "是否继续解析？", "视频来源：" + findString(),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(n==0)
				{
					int api = box1.getSelectedIndex();
					//解析接口
					String[] jiekou={
							"http://www.98a.ink/vip/hot/?url=",
							"http://app.baiyug.cn:2019/vip/index.php?url=",
							"http://vip.xtxfsm.com:81/skyvideo/jx4.php?url=",
							"http://jx.du2.cc/jx6.php?url=",
							"http://api.ledboke.com/?url=", 
							};
					//调用浏览器打开
					String url = "rundll32 url.dll,FileProtocolHandler ";
					url += jiekou[api];
					url += text1.getText();
					try {
						Runtime.getRuntime().exec(url);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this,"提示：解析完成！");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"提示：已经取消解析！");
				}
			}
		}
	}
}
