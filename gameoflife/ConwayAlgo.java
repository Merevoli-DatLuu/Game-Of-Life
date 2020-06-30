package gameoflife;

import java.util.ArrayList;
import java.util.Random;

public class ConwayAlgo {

    int size;
    int percent;
    ArrayList< ArrayList <Boolean> > matrix = new ArrayList<>(); 
    
    public ConwayAlgo(int size, int percent) {
        this.size = size;
        this.percent = percent;
    }
     
    public void init(){
        Random rd = new Random();
        
        for (int i=0; i<size; i++){
            ArrayList <Boolean> sub_matrix = new ArrayList<>();
            for (int j=0; j<size; j++){
                sub_matrix.add(rd.nextInt(100) < percent);
            }
            matrix.add(sub_matrix);
        }
    }
    
    public void change(){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                int count = 0;
                if (i != 0){
                    count += (matrix.get(i-1).get(j) == true)?1:0;
                }
                if (j != 0){
                    count += (matrix.get(i).get(j-1) == true)?1:0;
                }
                if (i != size - 1){
                    count += (matrix.get(i+1).get(j) == true)?1:0;
                }
                if (j != size - 1){
                    count += (matrix.get(i).get(j+1) == true)?1:0;
                }
                if (i != 0 && j != 0){
                    count += (matrix.get(i-1).get(j-1) == true)?1:0;
                }
                if (i != size - 1 && j != size - 1){
                    count += (matrix.get(i+1).get(j+1) == true)?1:0;
                }
                if (i != 0 && j != size - 1){
                    count += (matrix.get(i-1).get(j+1) == true)?1:0;
                }
                if (i != size - 1 && j != 0){
                    count += (matrix.get(i+1).get(j-1) == true)?1:0;
                }
                if (matrix.get(i).get(j) == true){
                    if (count < 2 || count > 3){
                       matrix.get(i).set(j, false);
                    }
                }
                else{
                    if (count == 3){
                        matrix.get(i).set(j, true);
                    }
                }
            }
        }
    }
    
    public ArrayList< ArrayList <Boolean> > getMatrix(){
        return matrix;
    }
}
