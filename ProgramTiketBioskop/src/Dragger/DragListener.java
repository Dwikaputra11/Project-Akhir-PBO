package Dragger;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
// import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.dnd.DropTargetEvent;

public class DragListener implements DropTargetListener {
    private static JLabel imageLabel = new JLabel();
    private static JLabel pathLabel = new JLabel();

    private static final int HEIGHT = 0;

    public DragListener(JLabel image, JLabel path) {
        imageLabel = image;
        pathLabel = path;
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        
    }

    // -- MENGAMBIL IMAGE YANG DI DROP DAN MENAMBAHKAN KE LABEL
    @Override
    public void drop(DropTargetDropEvent dropTarget) {
        // -- MENERIMA ITEM YANG DIDROP
        dropTarget.acceptDrop(DnDConstants.ACTION_COPY);

        // -- ITEM YANG DI DROP
        Transferable t = dropTarget.getTransferable();

        // -- AMBIL FORMAT DATA DARI ITEM
        DataFlavor[] df = t.getTransferDataFlavors();

        // -- LOOPING DATA FLAVOR
        for(DataFlavor f:df) {
            try {
                // -- CEK TIPE FILE
                if(f.isFlavorJavaFileListType()) {
                    // -- MASUKKAN DATA KE LIST
                    // @SuppressWarnings("unchecked")
                    File files = (File) t.getTransferData(f);

                    System.out.println(files);

                    displayImage(files.getPath());
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Gagal Memasukkan Gambar!", "Alert", HEIGHT);
                System.out.println(exception.getMessage());
            }
        }
    }

    private void displayImage(String path) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(path));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ImageIcon icon = new ImageIcon(img);
        imageLabel.setIcon(icon);
        pathLabel.setText(path);
    }
    
}
