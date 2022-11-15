import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.awt.*;

public class TEST {

    // Driver  method
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Object[][] arr = new Object[map.size()][2];
        Set entries = map.entrySet();
        Iterator entriesIterator = entries.iterator();

        int i = 0;
        while(entriesIterator.hasNext()){

            Map.Entry mapping = (Map.Entry) entriesIterator.next();

            arr[i][0] = mapping.getKey();
            arr[i][1] = mapping.getValue();

            i++;
        }



    }
}