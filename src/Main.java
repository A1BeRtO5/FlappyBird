import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
public class  Main extends JFrame { //  main тепер вікно
    int[] bird = {300, -20}, wall = {500, 300};//параметри пташки
    {
        add(new JButton() {
            public void paint(Graphics g){
                g.fillOval(30, bird[0], 30, 30);
                g.fillRect(wall[0], 0, 60, 600-wall[1]);
                g.fillRect(wall[0], 600, 60, -wall[1]+200);
                addActionListener(e -> bird[1] = -10);
            }});
        new Timer(1000/60,e->{
            bird[0]+=bird[1]++;
            if (wall[0]> -60) {
                wall[0] -=10;
            } else {
                wall = new int[]{600,(int)(Math.random()*400)+200};
            }
            if (bird[0]>570 || bird[0]<0 || wall[0]<60 && (bird[0]<600-wall[1] || bird[0]>600-wall[1]+200)){
                System.exit(0);
            }
            repaint();
        }).start();
        setVisible(true);
        setSize(600,600);
    }
    public static void main(String[] args) {
        new Main();// викликаємо метод main
    }
}
 