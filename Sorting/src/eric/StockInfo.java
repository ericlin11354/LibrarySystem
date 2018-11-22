/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eric;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 349361337
 */
public class StockInfo implements Comparable<StockInfo>{
    //data: https://www150.statcan.gc.ca/t1/tbl1/en/tv.action?pid=1310037101
    File data = new File("data.csv");
    Scanner sc;
    
    public StockInfo() throws IOException{
        sc = new Scanner(data);
    }
    
    @Override
    public int compareTo(StockInfo other){
        return 1;
    }
    
    
}
