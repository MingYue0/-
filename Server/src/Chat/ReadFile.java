package Chat;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadFile{
	public static void main(String[] args) throws UnsupportedFlavorException, IOException{
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null);

            if (t != null && t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                // ��Ϊԭϵ�ļ��������ж�����Ϣ, ������, ͼƬ, �ļ���
                // ���жϿ�ʼȡ�õĿɴ���������ǲ�������, �����, ȡ����Щ����

                List<File> s = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                // ͬ��, ��ΪTransferable�е�DataFlavor�Ƕ������͵�,
                // ���Դ���DataFlavor�������, ָ��Ҫȡ���������͵�Data.
                for(File f:s)
                System.out.println(f.getAbsolutePath());

//                final ContextMenu contextMenu = new ContextMenu();
//
//    			MenuItem item1 = new MenuItem("ճ��");
//    			item1.setOnAction(new EventHandler<ActionEvent>() {
//    			    public void handle(ActionEvent e) {
//
//
//
//    			    }
//    			});
//
//    			contextMenu.getItems().addAll(item1);
//    			area.setContextMenu(contextMenu);
	}

	}
}

