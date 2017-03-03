package ксх;

import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class FXMLController implements Initializable{
    public TextField x1,x2,x3,x4,x5,x6,x7,x8;
    public TextField p1,p2,p3,p4,p5,p6,p7,p8;
    public TextField math,disp,otkl,assim,eksc;
    double[] x=new double[9];
    double[] p=new double[9];
    double g;
    int i;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public void x1tc(){ 
        try{
        x[1] = Double.valueOf(x1.getText());
        x[1]=new BigDecimal(x[1]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x1.clear();};
    }
    
    public void x2tc(){
        try{   
        x[2] = Double.valueOf(x2.getText());
        x[2]=new BigDecimal(x[2]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x2.clear();};} 
    
    public void x3tc(){
        try{
        x[3] = Double.valueOf(x3.getText());
        x[3]=new BigDecimal(x[3]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x3.clear();};}
    
    public void x4tc(){
        try{
        x[4] = Double.valueOf(x4.getText());
        x[4]=new BigDecimal(x[4]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x4.clear();};}
    
    public void x5tc(){
        try{
        x[5] = Double.valueOf(x5.getText());
        x[5]=new BigDecimal(x[5]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x5.clear();};}
    
    public void x6tc(){
        try{
        x[6] = Double.valueOf(x6.getText());
        x[6]=new BigDecimal(x[6]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x6.clear();};}
    
    public void x7tc(){
        try{
        x[7] = Double.valueOf(x7.getText());
        x[7]=new BigDecimal(x[7]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x7.clear();};}
    
    public void x8tc(){
        try{
        x[8] = Double.valueOf(x8.getText());
        x[8]=new BigDecimal(x[8]).setScale(6, ROUND_HALF_UP).doubleValue();
        }
        catch(Exception e){x8.clear();};}
    
    public void p1tc(){ 
        try{
        g = Double.parseDouble(p1.getText());
            p[1]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[1]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p1.clear();};}
    
    public void p2tc(){ 
        try{
        g = Double.parseDouble(p2.getText());
            p[2]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[2]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p2.clear();};}
    
    public void p3tc(){ 
        try{
        g = Double.parseDouble(p3.getText());
            p[3]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[3]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p3.clear();};}
    
    public void p4tc(){ 
        try{
        g = Double.parseDouble(p4.getText());
            p[4]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[4]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p4.clear();};}
    
    public void p5tc(){ 
        try{
        g = Double.parseDouble(p5.getText());
            p[5]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[5]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p5.clear();};}
    
    public void p6tc(){ 
        try{
        g = Double.parseDouble(p6.getText());
            p[6]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
         if (p[6]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p6.clear();};}
    
    public void p7tc(){ 
        try{
        g = Double.parseDouble(p7.getText());
            p[7]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
        if (p[7]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p7.clear();};}
    
    public void p8tc(){ 
        try{
        g = Double.parseDouble(p8.getText());
            p[8]=new BigDecimal(g).setScale(6, ROUND_HALF_UP).doubleValue();
        if (p[8]<0)
            throw new Exception("P отрицательная");
        }
        catch(Exception e){p8.clear();};}
    
    public void rastc() throws IOException{
        File file = new File("file.txt");
        if(file.createNewFile()){
        System.out.println("file.txt файл создан в корневой директории проекта");
        }else System.out.println("file.txt файл уже существует в корневой директории проекта");
        
        double Mx=0;
        double Dx=0;
        double o=0;
        double A=0;
        double E=0;
        double m[]={0, 0, 0, 0, 0};
        double q=0;
        
        for (i=1;i<9;i++)
        {q=q+p[i];}
        if ((q>0.9999999999999)&&(q<1))q=1;
        if (q==1){
        for (i=1;i<9;i++)
        {Mx=Mx+x[i]*p[i];}
        Mx=new BigDecimal(Mx).setScale(6, ROUND_HALF_UP).doubleValue();
        math.setText(Double.toString(Mx));
        
        for (int n=1;n<5;n++){
        for (i=1;i<9;i++)
        m[n]=m[n]+pov((x[i]-Mx),n)*p[i];}
        
        Dx=m[2];
        Dx=new BigDecimal(Dx).setScale(6, ROUND_HALF_UP).doubleValue();
        disp.setText(Double.toString(Dx));
        
        o=sqrt(Dx);
        o=new BigDecimal(o).setScale(6, ROUND_HALF_UP).doubleValue();
        otkl.setText(Double.toString(o));
        
        try{
        A=m[3]/pov(o,3);
        A=new BigDecimal(A).setScale(6, ROUND_HALF_UP).doubleValue();
        assim.setText(Double.toString(A));
        if(pov(o,3)==0)
            throw new Exception("Дление на ноль");}
        catch (Exception e){
        assim.setText("σ равна нулю");}
        
        try{
        E=m[4]/pov(o,4)-3;
        E=new BigDecimal(E).setScale(6, ROUND_HALF_UP).doubleValue();
        eksc.setText(Double.toString(E));
        if(pov(o,3)==0)
            throw new Exception("Дление на ноль");}
        catch (Exception e){
        eksc.setText("σ равна нулю");}
        
}
        
        else {
        x1.clear();
        x2.clear();
        x3.clear();
        x4.clear();
        x5.clear();
        x6.clear();
        x7.clear();
        x8.clear();
        p1.clear();
        p2.clear();
        p3.clear();
        p4.clear();
        p5.clear();
        p6.clear();
        p7.clear();
        p8.clear();
        math.setText("Сумма Р не равна 1");
        disp.setText("Сумма Р не равна 1");
        otkl.setText("Сумма Р не равна 1");
        assim.setText("Сумма Р не равна 1");
        eksc.setText("Сумма Р не равна 1");
        for (i=1;i<9;i++)
        {p[i]=0;x[i]=0;}}
         try (FileWriter writer = new FileWriter(file.getAbsolutePath(),false)) {
                writer.write(Double.toString(Mx)
                        +"\r\n"+Double.toString(Dx)
                        +"\r\n"+Double.toString(o)
                        +"\r\n"+Double.toString(A)
                        +"\r\n"+Double.toString(E));
            writer.close();}
}
    public void clct(){
        x1.clear();
        x2.clear();
        x3.clear();
        x4.clear();
        x5.clear();
        x6.clear();
        x7.clear();
        x8.clear();
        p1.clear();
        p2.clear();
        p3.clear();
        p4.clear();
        p5.clear();
        p6.clear();
        p7.clear();
        p8.clear();
        math.clear();
        disp.clear();
        otkl.clear();
        assim.clear();
        eksc.clear();
    for (i=1;i<9;i++)
        {p[i]=0;x[i]=0;}}

    private double pov(double d, int b) {
        double k=1;
        for(int j=1;j<b+1;j++){
        k=k*d;}
        return k;
    }
}