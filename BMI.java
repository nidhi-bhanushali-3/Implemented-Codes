import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMI {
    public static void main(String agrs[]){
        //bmi bmi1=new bmi();
        _bmi_ bmiObject =new _bmi_();
    }
}
class _bmi_ extends JFrame implements ActionListener{
    /**
     *
     */
    public static final long serialVersionUID = 1L;

    double weigth,heigth,bmi;
    JTextField w,h;
    JButton calculate;
    JLabel lbmi,lw,lh,lshow;
    JPanel panel;

    public _bmi_()
    {
        panel=new JPanel();
        this.add(panel);
        lbmi=new JLabel("");
        lh=new JLabel("HEIGTH (in m) = ");
        lw=new JLabel("WEIGTH (in kg) = ");
        lshow=new JLabel(" ");
        w=new JTextField(15);
        h=new JTextField(15);
        calculate=new JButton(" CALCULATE  BMI ");

        lh.setBounds(150, 50, 275, 30);
        h.setBounds(150,100, 275, 30);
        lw.setBounds(150,150, 275, 30);
        w.setBounds(150,200, 275, 30);
        calculate.setBounds(150, 250, 275, 30);
        lbmi.setBounds(150,300, 300, 30);
        lshow.setBounds(162, 350, 321, 33);

        panel.add(lw);
        panel.add(w);
        panel.add(lh);
        panel.add(h);
        panel.add(calculate);
        panel.add(lbmi);
        panel.add(lshow);
        calculate.addActionListener(this);
        
        panel.setLayout(null);
        //this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setSize(570,570);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        weigth=Double.parseDouble(w.getText());
        heigth=Double.parseDouble(h.getText());
        bmi=(weigth/Math.pow(heigth, 2));

        //lh.setText("HEIGTH = "+h.getText()+" m");
        //lw.setText("WEIGTH = "+w.getText()+" kg");
        lbmi.setText("YOUR BMI = "+Double.toString(bmi)+ "  (kg / (m ^ 2))");

        if(bmi<18.5)
        {
            lshow.setText("You are  Under-weight".toUpperCase());
        }
        else if(bmi>=18.5 && bmi<25.0)
        {
            lshow.setText("You have  Normal-weight".toUpperCase());
        }
        else if(bmi>=25.0 && bmi<30.0)
        {
            lshow.setText("You are  Over-weight".toUpperCase());
        }
        else if(bmi>=30.0)
        {
            lshow.setText("You are  Obese".toUpperCase());
        }
    }
}
/*
BMI Categories:
Underweight = <18.5
Normal weight = 18.5–24.9
Overweight = 25–29.9
Obesity = BMI of 30 or greater
*/