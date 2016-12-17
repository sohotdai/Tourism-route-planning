
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo extends JFrame implements ActionListener {
	/**
	 * serialize
	 */
	private static final long serialVersionUID = -169068472193786457L;

	/**
	 * master data
	 */
	private final double[] data = { 5, 3.2, 7.4, 6.7, 3.7, 5, 6, 1,
	           6, 6.4, 7.7, 4.7, 9.8, 10.4, 8.4, 10, 8.6, 11, 9, 8.4, 
	           5.4, 4.5, 11.4, 5.4, 8.5, 2.7, 5.5, 6.1, 5.4, 5.6 };
	/**
	 * panel elements
	 */
	private final JTextField field = new JTextField("Please enter the city");
	private final TextArea display = new TextArea("",10,100);
	private final JButton button = new JButton("Sure");
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		new Demo();
	}

	/**
	 * control panel of initialize
	 */
	public Demo() {
		super("Demo");
		JPanel panel = new JPanel();
		button.addActionListener(this);
		panel.add(field);
		panel.add(button);
		panel.add(display);
		//display.setBounds(100, 200, 20, 10);
		this.add(panel);
		this.setBounds(500, 200, 800, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == button){
			String str = field.getText();
			if(str.equals("Beijing")){
				double sum = 14.5;
				diguiSum(data,sum);
			}
		}
	}
	 public void diguiSum(double[] array,double sum) {
	        for (int i = 0; i < array.length; i++) {
	            double[] cache = new double[i + 1];
	            int ceng = -1;
	            int cengQuit = i;
	            int startPiont = 0;
	            cir(ceng, cengQuit, startPiont, array, cache, sum);
	        }
	 }
	    
	    // recursive result
	    public void cir(int ceng, int cengQuit, int startPiont, double[] array, double[] cache, double sum) {
	        ceng++;
	        for (int i = startPiont; i < array.length; i++) {
	            cache[ceng] = array[i];
	            if (ceng == cengQuit) {
	                if (getSum(cache) < sum) {
	                    printcache(cache);
	                }
	                if (getSum(cache) > sum) {
	                    break;
	                }
	            }
	            if (ceng < cengQuit) {
	                startPiont = i + 1;
	                cir(ceng, cengQuit, startPiont, array, cache,sum);
	            }
	        }
	    }
	    
	    // 获取组合数字之和
	    public double getSum(double[] cache) {
	        double sum = 0;
	        for (int i = 0; i < cache.length; i++) {
	            sum = sum + cache[i];
	        }
	        return sum;
	    }
	    // print possible combinations
	    public void printcache(double[] cache) {
	        for (int i = 0; i < cache.length; i++) {
	            System.out.print(cache[i] + ",");
	            display.append(cache[i] + ",");
	        }
	        System.out.println();
	        display.append("\r\n");
	    }
}
