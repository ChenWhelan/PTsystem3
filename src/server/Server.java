package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import messages.Message;


public class Server {
	

	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new  ServerSocket(8888);
			
			while(true) {
				//�����̲߳�����
				Socket socket = serverSocket.accept();
				new MyThread(socket).start();
			}
			
			
			
		
		}
		             catch (Exception e) {
		         	// TODO Auto-generated catch block
			        e.printStackTrace();
		}
	}
	
	//����һ���߳���
	public static class MyThread extends Thread{
		Socket socket;
		public MyThread(Socket socket) {
			this.socket=socket;
		}
		@Override
		public void run() {
			try {
				ObjectInputStream dis = new ObjectInputStream(socket.getInputStream()) ;
				ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream()) ;
				System.out.println("����������ɹ���");
				while(true) {
					Message mess = (Message)dis.readObject();
				    if(mess.getType()==0){               
				    	System.out.println("���е�¼");
					}  
				
					 
				}
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}