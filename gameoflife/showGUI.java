package gameoflife;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class showGUI extends JFrame{
    
    int size;
    Drawing canvas;
    
    public showGUI(ArrayList< ArrayList <Boolean> > matrix, int size){
        this.size = size;
        canvas = new Drawing(matrix, size);
        canvas.setBounds(0, 0, 900, 500);
        add(canvas);
        
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        
        
    }
    
    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                     
        int notches = evt.getWheelRotation();
        if (notches < 0) {
           size = Integer.max(size + notches, 1);
        } 
        else {
           size += notches;
        }
    }          
    
    public void change(ArrayList< ArrayList <Boolean> > matrix){
        canvas.change(matrix, size);
    }
}

class Drawing extends Canvas {
    ArrayList< ArrayList <Boolean> > matrix;
    int size = 5;
    
    public Drawing(ArrayList< ArrayList <Boolean> > matrix, int size){
        this.matrix = matrix;
        this.size = size;
        setForeground(new Color(0, 204, 102));
    }
    
    public void change(ArrayList< ArrayList <Boolean> > matrix, int size){
        this.matrix = matrix;
        this.size = size;
        repaint();
    }

    public void paint(Graphics g) {
        for (int i=0; i<matrix.size(); i++){
            for (int j=0; j<matrix.size(); j++){
                if (matrix.get(i).get(j) == true){
                    g.fillRect(i*size, j*size, size, size);
                }
            }
        }
    }
}
