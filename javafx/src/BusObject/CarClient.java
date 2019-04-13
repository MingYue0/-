package BusObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CarClient extends Application {
	public static ArrayList<String> str = new ArrayList<>();
	public static int number;
	public static int count;
	public static TextField textField;
	public static Button button;
	public static Line line1;
	public static GridPane pane1;
	public static VBox vb;
	public static ArrayList<Text> at = new ArrayList<>();
	public static Text t1;
	public static VBox hb;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		BorderPane pane2 = new BorderPane();
		pane1 = new GridPane();
		hb = new VBox(50);
		textField = new TextField();
		button = new Button("查询");

		pane2.setCenter(textField);
		pane2.setRight(button);

		pane.setTop(pane2);
		pane.setCenter(pane1);
		Scene scene = new Scene(pane, 500, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
		conncet();

	}

	private void conncet() {
		try {
			Socket s = new Socket("127.0.0.1", 2007);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						DataInputStream in = new DataInputStream(s.getInputStream());
						DataOutputStream out = new DataOutputStream(s.getOutputStream());
						while (true) {
							button.setOnMouseClicked(new EventHandler<MouseEvent>() {
								public void handle(MouseEvent me) {
									String aString = textField.getText().toString();
									int number = Integer.parseInt(aString);
									try {
										out.writeInt(number);
										System.out.println(number);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									String a = "A";
									try {
										count = Integer.parseInt(in.readUTF());
										System.out.println(count);
										str.clear();
										for (int i = 0; i < count; i++) {
											a = in.readUTF();
											if(a.equals("无此班车"))
												break;
											str.add(a);
										}
									} catch (NumberFormatException | IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									for (int i = 0; i < str.size(); i++)
										System.out.println(str.get(i));

									Platform.runLater(new Runnable() {
										public void run() {
											pane1.getChildren().clear();
											vb = new VBox(50);
											line1 = new Line(0, 10, 0, str.size() * 70);
											line1.setStroke(Color.GREEN);
											line1.setStrokeWidth(5);
											System.out.println(str.size());
											for (int i = 0; i < str.size(); i++) {
												t1 = new Text("               ");
												t1.setText(str.get(i));
												vb.getChildren().add(t1);
											}
											pane1.add(new Text("              "), 0, 0);
											pane1.add(new Text("              "), 1, 0);
											pane1.add(vb, 2, 1);
											pane1.add(line1, 4, 1);

										}
									});
								}
							});
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}).start();

			ServerSocket ss = new ServerSocket(2008);

			Socket scoket = ss.accept();
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							DataInputStream in = new DataInputStream(scoket.getInputStream());
							int a =Integer.parseInt(in.readUTF());
							System.out.println(a);
							Platform.runLater(new Runnable() {
								public void run() {
									hb.getChildren().clear();
									hb= new VBox(50);
									Circle c =new Circle();
									c.setRadius(10);
									//pane1.getChildren().remove(3);
									for(int i=1;i<str.size()+1;i++) {
										if(i==a) {
											hb.getChildren().add(c);
										}
										else 
											hb.getChildren().add(new Text("站点 ："+i));
									}
									//hb.getChildren().add(c);
									pane1.add(hb, 5, 1);
								}
							});
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		launch(args);
	}
}
