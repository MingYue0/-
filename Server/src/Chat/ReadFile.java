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
                // 因为原系的剪贴板里有多种信息, 如文字, 图片, 文件等
                // 先判断开始取得的可传输的数据是不是文字, 如果是, 取得这些文字

                List<File> s = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                // 同样, 因为Transferable中的DataFlavor是多种类型的,
                // 所以传入DataFlavor这个参数, 指定要取得哪种类型的Data.
                for(File f:s)
                System.out.println(f.getAbsolutePath());

//                final ContextMenu contextMenu = new ContextMenu();
//
//    			MenuItem item1 = new MenuItem("粘贴");
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

