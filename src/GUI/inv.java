package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;



public class inv extends JApplet implements MouseListener {

    JList listbox;



     public void init()
     {


    String  listData[] = { "Item 1","Item 2","Item 3","Item 4" };
listbox = new JList( listData );

     listbox.addMouseListener( new MouseAdapter()
     {
        public void mousePressed(MouseEvent e)
        {
            if ( SwingUtilities.isRightMouseButton(e) )
            {
                System.out.println("at "+listbox.getSelectedIndex());
               // listbox.setSelectedIndex(getRow(e.getPoint()));
            }
        }
     });

    listbox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        add(listbox);
                    listbox.setVisible(true);

            listbox.setFocusable(false);

     }



     private int getRow(Point point)
     {
        return listbox.locationToIndex(point);
}

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mouseClicked(MouseEvent e) {
      }


     public void stop()
     {
     }

     public void paint(Graphics g)
     {
     }
}