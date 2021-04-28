package riddle_home_work;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;


public class ColorFrame extends JFrame {
    public ColorFrame(int counter) throws HeadlessException {
        JButton button = new JButton("click to print counter");
        AtomicReference value = new AtomicReference(counter);

        button.addActionListener(e -> {
            value.getAndSet((int)value.get() + 1 );
            System.out.println(value);

            //todo counter++ should work, but it will never work in java.
            //todo you need to make some work around
        });

        getContentPane().add(button);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorFrame(777);
        new ColorFrame(73);
    }
}
