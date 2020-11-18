import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements MouseListener ,ActionListener{
	
	JPanel jp1;
	static JTextField jf1;
	JButton jb1;
	static JTextArea ja1,area1,area2;
	static ServerSocket skt;
	static Socket st;
	static DataInputStream din;
	static DataOutputStream dout;
	
	public Server()
	{
		jp1=new JPanel();
		jp1.setLayout(null);
		jp1.setBounds(0,0,450,50);
		jp1.setBackground(new Color(7,94,84));
		add(jp1);
		
		ImageIcon i1=new ImageIcon("/home/akhilesh/eclipse-workspace/MyJavaProject/src/image/3.png");
		Image i2=i1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel jl1=new JLabel(i3);
		jl1.setBounds(5, 17, 30, 30);
		jp1.add(jl1);
		
		jl1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me){
				System.exit(0);
			}
		});
					
	
		
		ImageIcon i4=new ImageIcon("/home/akhilesh/eclipse-workspace/MyJavaProject/src/image/1.png");
		Image i5=i4.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel jl2=new JLabel(i6);
		jl2.setBounds(45, 17, 30, 30);
		jp1.add(jl2);
		
		JLabel jl3=new JLabel("Gaitonde");
		jl3.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
		jl3.setForeground(Color.WHITE);
		jl3.setBounds(85,14,80,20);
		jp1.add(jl3);
		
		JLabel jl4=new JLabel("Active Now");
		jl4.setFont(new Font("SAN_SERIF", Font.BOLD, 8));
		jl4.setForeground(Color.WHITE);
		jl4.setBounds(89,30,80,20);
		jp1.add(jl4);
		//
		ImageIcon i7=new ImageIcon("/home/akhilesh/eclipse-workspace/MyJavaProject/src/image/video.png");
		Image i8=i7.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel jl5=new JLabel(i9);
		jl5.setBounds(300, 15, 30, 30);
		jp1.add(jl5);
		
		ImageIcon i10=new ImageIcon("/home/akhilesh/eclipse-workspace/MyJavaProject/src/image/phone.png");
		Image i11=i10.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i12=new ImageIcon(i11);
		JLabel jl6=new JLabel(i12);
		jl6.setBounds(360, 15, 30, 30);
		jp1.add(jl6);
		
		ImageIcon i13=new ImageIcon("/home/akhilesh/eclipse-workspace/MyJavaProject/src/image/3icon.png");
		Image i14=i13.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i15=new ImageIcon(i14);
		JLabel jl7=new JLabel(i15);
		jl7.setBounds(410, 15, 30, 30);
		jp1.add(jl7);
		
		jf1=new JTextField();
		jf1.setBounds(5,650,330,30);
		jf1.setForeground(Color.BLUE);
		add(jf1);
		
		jb1=new JButton("Send");
		jb1.setFont(new Font("SAN_SERIF", Font.BOLD,15));
		jb1.setBackground(new Color(7,94,84));
		jb1.setForeground(Color.GREEN);
		jb1.setBounds(340,650,105,30);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					String out=jf1.getText();
					ja1.setText(ja1.getText()+"\n\t\t"+out);
					jf1.setText("");
					dout.writeUTF(out);
					
					}
					catch(Exception e) {
						
					}
				// TODO Auto-generated method stub
				
			}
		});
		add(jb1);
		
		ja1=new JTextArea();
		ja1.setFont(new Font("SAN_SERIF", Font.BOLD,15));
		ja1.setForeground(Color.DARK_GRAY);
		ja1.setBounds(5,60,440,580);
		ja1.setEditable(false);
		ja1.setLineWrap(true);
		ja1.setWrapStyleWord(true);
		
		add(ja1);
		
		
		
		
		setSize(450,700);
		setLocation(150,20);
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.blue);
	}

	public static void main(String[] args) {
		new Server();
		String  input="";
		try{
			skt=new ServerSocket(6001);
			while(true)
			{
				st=skt.accept();
				din=new DataInputStream(st.getInputStream());
				dout=new DataOutputStream(st.getOutputStream());
				while(true) {
					input=din.readUTF();
					ja1.setText(ja1.getText()+"\n"+input);
				
				}
				
			}
			
			
		}
		catch(Exception e){
			
		}
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


	

}
