package pack2;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("Simple Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);
		getContentPane().add( new MyPanel());
	}
	public static void main(String[]args)
	{
		new MyFrame().setVisible(true);;
	}
}
