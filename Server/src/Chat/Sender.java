package Chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Sender {
	public String info;
	private PrintWriter pw;
	private JFrame frame;
	private JPanel pane_buttom;
	private JSplitPane pane_center;
	private JScrollPane pane_showWindow;
	private JScrollPane pane_inputWindow;
	private JTextArea area_showWindow;
	private JTextArea area_inputWindow;

	private JButton btn_send;
	private JButton btn_send1;

	private Dimension dimension;

	// ��ʼ��
	public Sender() {
		frame = new JFrame();
		pane_buttom = new JPanel();
		pane_showWindow = new JScrollPane();
		pane_inputWindow = new JScrollPane();
		area_showWindow = new JTextArea();
		area_inputWindow = new JTextArea();
		pane_center = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, pane_showWindow, pane_inputWindow);
		btn_send = new JButton("send");
		btn_send1 = new JButton("�����ļ�");

		dimension = new Dimension(50, 300);
	}

	// ���÷�����ʾ����
	public void showFrame() throws UnsupportedFlavorException, IOException {
		initFrame();
		initChatTextArea();
		initButton();
		btn_send1();
		btn_send();

	}

	// ������
	public void initFrame() {
		frame.setTitle("sender");
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setBounds(width / 2, height / 2, 400, 450);
		frame.setVisible(true);
	}

	// ������ʾ�ı�������������ı���
	private void initChatTextArea() {
		// ȡ����ͼ����
		pane_showWindow.getViewport().add(area_showWindow);
		pane_inputWindow.getViewport().add(area_inputWindow);
		// ����ʾ�ı�������Ϊ���ɱ༭
		area_showWindow.setEditable(false);
		// ������ʾ�ı���������Ĵ�С
		pane_showWindow.setMinimumSize(dimension);
		frame.add(pane_center, BorderLayout.CENTER);
	}

	// �����ļ����������ݰ�ť
	public void initButton() {
		pane_buttom.add(btn_send);
		pane_buttom.add(btn_send1);
		frame.add(pane_buttom, BorderLayout.SOUTH);
	}

	private void btn_send() {
		aaa();
	}

	private void btn_send1() {
		new Thread(new Runnable() {
			public void run() {
				try {
					receiveFile();
				} catch (IOException | InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}).start();
		btn_send1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("sssssssssssssssssssssss");
					sendFile();
				} catch (UnsupportedFlavorException | IOException | InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		// TODO Auto-generated method stub
	}

	private void aaa() {
		try {
			DatagramSocket socket = new DatagramSocket(8015);
			new Thread(new Runnable() {
				@Override
				public void run() {
					btn_send.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							info = area_inputWindow.getText();
							area_showWindow.append("sender�� " + info + "\r\n");
							// pw.println(info);
							area_inputWindow.setText("");
							if (info != null) {
								byte[] b = info.getBytes();
								DatagramPacket dp;
								try {
									dp = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"), 8014);
									socket.send(dp);
								} catch (UnknownHostException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						}
					});

				}
			}).start();

			try {
				// jie
				DatagramSocket socketse = new DatagramSocket(8016);
				byte[] b = new byte[1024];
				DatagramPacket dp = new DatagramPacket(b, b.length);
				while (true) {
					socketse.receive(dp);
					area_showWindow.append("receiver:" + new String(dp.getData(), 0, dp.getLength()) + "\r\n");
				}

			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendFile() throws UnsupportedFlavorException, IOException, InterruptedException {
		String files = null;
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if (t != null && t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			List<File> s = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
			for (File f : s)
				files = f.getAbsolutePath();
		}
		DatagramSocket datagramSocket = new DatagramSocket();
		File file = new File(files);
		System.out.println(file.getName());
		FileInputStream is = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] b = new byte[1024];
		// ���ļ�ѭ������
		int n = is.available() / b.length;// ���ʹ���
		// �����ļ����ʹ���
		String num = n + "********" + file.getName();
		DatagramPacket datagramPacket = new DatagramPacket(num.getBytes(), num.getBytes().length,
				InetAddress.getByName("127.0.0.1"), 9006);
		datagramSocket.send(datagramPacket);
		Thread.sleep(1);
		for (int i = 0; i < n; i++) {
			bis.read(b, 0, b.length);
			datagramPacket = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"), 9004);
			datagramSocket.send(datagramPacket);
			Thread.sleep(1);
		}
		// �ļ�ĩβ
		bis.read(b, 0, b.length);
		System.out.println("����:\n" + new String(b));
		datagramPacket = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"), 9004);
		datagramSocket.send(datagramPacket);
		Thread.sleep(1);

		is.close();
	}

	public void receiveFile() throws IOException, InterruptedException {
		DatagramSocket datagramSocket1 = new DatagramSocket(9005);
		DatagramSocket datagramSocket = new DatagramSocket(9003);
		while (true) {
			byte[] b1 = new byte[1024];
			DatagramPacket datagramPacket1 = new DatagramPacket(b1, b1.length);
			datagramSocket1.receive(datagramPacket1);// �����߳�
			String sName = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
			if (sName != null) {
				String fileName = sName.substring(sName.indexOf("********") + 8);
				int num = Integer.parseInt(sName.substring(0, sName.indexOf("********")));
				while (true) {
					byte[] b = new byte[1024];
					FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
					// ѭ��������ļ�
					for (int i = 0; i < num; i++) {
						DatagramPacket datagramPacket = new DatagramPacket(b, b.length);
						datagramSocket.receive(datagramPacket);// �����߳�
						fileOutputStream.write(datagramPacket.getData(), 0, datagramPacket.getLength());
						Thread.sleep(1);
					}
					// �����ļ�ĩβ
					DatagramPacket datagramPacket = new DatagramPacket(b, b.length);
					datagramSocket.receive(datagramPacket);// �����߳�
					String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
					fileOutputStream.write(s.getBytes("UTF-8"));
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws UnsupportedFlavorException, IOException {
		Sender chat = new Sender();
		chat.showFrame();
	}
}
