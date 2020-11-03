import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JPanel {
    public JButton consume=new JButton("consume");
   SleepingBarber producerConsumer=new SleepingBarber();
    public CustomButton(){
        consume.addActionListener(new Listener());
        add(consume);
        setPreferredSize(new Dimension(200,290));
    }


    private class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<25;i++)
                producerConsumer.custome();
        }
    }



}

