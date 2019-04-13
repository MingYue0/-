package BusObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

public class NowBus {
	public static int number;
	public static int i;
	public static int count;
	public static int flag=0;
	public static void main(String[] args) throws IOException {
		try {
			Random rand=new Random();
			DatagramSocket socket1 = new DatagramSocket(9004);
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							byte[] a= new byte[1024];
							DatagramPacket re =new DatagramPacket(a,a.length);
							socket1.receive(re);
							String s=new String(re.getData(),0,re.getLength());
							System.out.println("收到的公交号码号码"+s);
							flag=0;
							number  =Integer.parseInt(s);
							if(number==233) {
								count=10;
								i=rand.nextInt(count-1)+1;
								//i=(int) Math.random()+count;
							}
							else if(number==503){
								count=6;
								i=rand.nextInt(count-1)+1;
								//i=(int) Math.random()+count;
							}
							else if(number==504){
								count=8;
								i=rand.nextInt(count-1)+1;
								//i=(int) Math.random()+count;
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
				}
			}).start();
			
			DatagramSocket socket = new DatagramSocket(9003);
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					while (true) {
						try {
							System.out.println(count+"     "+i);
							if(flag==0) {
								byte[] b =(""+i).getBytes();
								DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"),9002);
								socket.send(dp);
								i++;
								if(i==count)
									flag=1;
							}
							else {
								byte[] b =(""+i).getBytes();
								DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"),9002);
								socket.send(dp);
								i--;
								if(i==1)
									flag=0;
							}
							Thread.sleep(2500);
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
