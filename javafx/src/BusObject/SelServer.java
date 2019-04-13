package BusObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import tcp_3_3.Server_add.MyThread;

public class SelServer {
	public static String[] A503 = { "6", "�ϲ���վ", "���ڻ�԰", "�ϸ�ɽ��԰", "ʡ��ͨ��", "ʡ��ͨ��", "ʡ��ͨ��" };
	public static String[] A504 = { "8", "�ϲ���վ", "���ڻ�԰", "��ʹ����", "�ϲ����մ�ѧ", "�뱱��·����[�к�վ]", "�뱱��·����[�к�վ]", "�뱱��·����[�к�վ]",
			"�뱱��·����[�к�վ]" };
	public static String[] A233 = { "10", "�ϲ���վ����Ŧ(���㳡������վ̨)", "���˴�ּ��η�·�ڡ����ų����Ұ���", "����������˴�ֿ�", "��������Ž��ֿ�",
			"ʡ��������(�����㳡��)", "ʡ��ͨ��", "�뱱��·����ϴ����", "�뱱��·����[�к�վ]", "����ϴ���뱱һ·��", "�ϲ����մ�ѧǰ��У��" };
	public static String[] str;
	public static int number;
	public static DatagramSocket socket;
	public static int flag=1;
	public static String nowbus=""+1;

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2007);
			while (true) {
				Socket s = ss.accept();
				new MyThread(s).start();
				new Thread1().start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class MyThread extends Thread {
		Socket s = null;

		public MyThread(Socket s) {
			this.s = s;
		}

		public void run() {
			while (true) {
				try {
					DataInputStream in = new DataInputStream(s.getInputStream());
					DataOutputStream out = new DataOutputStream(s.getOutputStream());
					number = in.readInt();
					System.out.println(number);
					
					
					if (number == 503) {
						for (int i = 0; i < A503.length; i++)
							out.writeUTF(A503[i]);
					} else if (number == 504) {
						for (int i = 0; i < A504.length; i++)
							out.writeUTF(A504[i]);
					} else if (number == 233) {
						for (int i = 0; i < A233.length; i++)
							out.writeUTF(A233[i]);
					}
					else {
						out.writeUTF("�޴ΰ೵");
					}
					
					udpconnect();
					
					Thread.sleep(1000);

				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void udpconnect() throws SocketException {
			DatagramSocket socket1 = new DatagramSocket();
			byte[] b = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			new Thread(new Runnable() {
				@Override
				public void run() {
					
						try {
							byte[] se = new byte[1024];
							se = (""+number).getBytes();
							DatagramPacket dpse = new DatagramPacket(se, se.length, InetAddress.getByName("127.0.0.1"),
									9004);
							socket1.send(dpse);
							Thread.sleep(5000);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
						
				}
			}).start();
			socket = new DatagramSocket(9002);
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							socket.receive(dp);
							String s = new String(dp.getData(), 0, dp.getLength());
							System.out.println("��ǰվ��"+s);
							//d = Double.parseDouble(s);
							nowbus=s;
							Thread.sleep(500);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			}).start();
		}
	}

	public static class Thread1 extends Thread{
		Socket s = null;

		public Thread1() {
		}

		public void run() {
			DataOutputStream out;
			try {
				Socket socket = new Socket("127.0.0.1", 2008);
				while(true) {
					out = new DataOutputStream(socket.getOutputStream());
					out.writeUTF(nowbus);
					Thread.sleep(1000);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(nowbus);
		}
	}
}
