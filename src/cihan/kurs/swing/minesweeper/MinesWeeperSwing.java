package cihan.kurs.swing.minesweeper;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.event.*;
import net.miginfocom.swing.MigLayout;


public class MinesWeeperSwing  extends JFrame implements MouseListener,ActionListener {
	
	public static JButton[][] buttons=new JButton[Runner.SIZE][Runner.SIZE];
	private int[][] bombsArray=new int[Runner.SIZE][Runner.SIZE];
	public JButton btnStart = new JButton("");
	private String btnNumber;
	private int summ;
	private int recor=0;
	
	BombsArray b = new BombsArray();
	
	JPanel anaPanel = new JPanel();
	JPanel mPanel   = new JPanel();
	JPanel sPanel   = new JPanel();
	Container c     = getContentPane();
	boolean pressed;
	private final JTextField txt1 = new JTextField();
	private final JTextField txt2 = new JTextField();
	private final JLabel lbl1 = new JLabel("B");
	private final JLabel lbl2 = new JLabel("T");
		
	public MinesWeeperSwing() {
		
//		int speed = 1000;
//		Timer timer = new Timer(speed, this);
//		//timer.setInitialDelay(pause);
//		timer.start(); 
		
		txt2.setFont(new Font("Arial", Font.BOLD, 20));
        txt2.setForeground(Color.RED);
		txt2.setBackground(Color.BLACK);
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setEditable(false);
		txt2.setColumns(5);
//		txt2.addActionListener((ActionListener) this);
//		txt2.setText(String.valueOf(timer)); 
//		
		
		txt1.setBackground(Color.BLACK);
		txt1.setFont(new Font("Arial", Font.PLAIN, 20));
		txt1.setForeground(Color.RED);
	    txt1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txt1.setSize(new Dimension(10, 10));
		txt1.setText(String.valueOf(Runner.BOMBCOUNT-recor));
		txt1.setEditable(false);
		txt1.setColumns(5);
		txt1.setHorizontalAlignment(JTextField.CENTER);
				
		b.setBombsArray();
		
		anaPanel.setLayout(new BorderLayout());
	    c.add(anaPanel);
	 
		mPanel.setLayout(new GridLayout(Runner.SIZE,Runner.SIZE));
    	mPanel.setSize(500,500);
		anaPanel.add(mPanel,BorderLayout.CENTER);
        sPanel.setForeground(Color.LIGHT_GRAY);
        sPanel.setBackground(Color.LIGHT_GRAY);
        
      
        btnStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         		MinesWeeperSwing mws = new MinesWeeperSwing();		
        	}
        });
        
        btnStart.setForeground(Color.LIGHT_GRAY);
        btnStart.setBackground(Color.LIGHT_GRAY);
        btnStart.setBounds(0, 0, 10, 10);
	    btnStart.setIcon(new ImageIcon(MinesWeeperSwing.class.getResource("/resources/emoji.jpg")));
	    
        sPanel.setSize(100,100);
        
        sPanel.add(txt1);
        lbl1.setFont(new Font("Arial", Font.BOLD, 20));
        
        sPanel.add(lbl1);
        sPanel.add(btnStart,sPanel.CENTER_ALIGNMENT);
	    sPanel.setVisible(true);
	    anaPanel.add(sPanel, BorderLayout.NORTH);
	    lbl2.setFont(new Font("Arial", Font.BOLD, 20));
	    
	    sPanel.add(lbl2);
	    
	    sPanel.add(txt2);
	    	   
		for(int i=0;i<Runner.SIZE;i++)
		{
			for(int j=0;j<Runner.SIZE;j++)
			{
			    buttons[i][j] = new JButton("");
			    buttons[i][j].setActionCommand("S0" +i +j);
			    buttons[i][j].addActionListener((ActionListener) this);
			    buttons[i][j].addMouseListener((MouseListener) this);
			    mPanel.add(buttons[i][j]);
			   			   
			}

	     }
		
		       
         setTitle("Mayın Tarlası");
         setSize(700,700);
         setLocation(300,100);
         setVisible(true);
     	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btnNumber=e.getActionCommand();
		int selectInt=Integer.parseInt((btnNumber.substring(1,4)));
		int[] ijBomb=Runner.findNumberfromIJ(selectInt);
		int i=ijBomb[0];
		int j=ijBomb[1];
		   
		b.setSightBombsArray(btnNumber,i,j);	
		bombsArray=b.getBombsArray();
		
		 if(bombsArray[i][j]==Runner.BSIZE  &&  btnNumber.substring(0,1).equals("S") ) 
	  	 {   
			 
			 for (int k = 0; k < Runner.SIZE; k++) {
			    for (int l = 0; l < Runner.SIZE; l++) {
				if(bombsArray[k][l]==Runner.SIZE*Runner.SIZE) {
					
					buttons[k][l].setIcon(new ImageIcon(Runner.class.getResource("/resources/bomb_w.png")));
				}
				}
			}
			 buttons[i][j].setIcon(new ImageIcon(Runner.class.getResource("/resources/bomb_r.png")));
		     JOptionPane.showMessageDialog(new JFrame(), "YANDINIZ", "Dialog",JOptionPane.ERROR_MESSAGE);
	   		 //System.exit(0);
	   	 }
		 
	    if(bombsArray[i][j]==0)
	    {
	    	buttons[i][j].setText(" ");
	    }
	    else
	    {   buttons[i][j].setIcon(null);
	    	buttons[i][j].setText(String.valueOf(bombsArray[i][j]));
	    }
	   
	    buttons[i][j].getText();
	    buttons[i][j].setEnabled(false);
	    buttons[i][j].setBackground(Color.LIGHT_GRAY);
	    
	    summ=b.getBombsControlArraySum();	 
	   
	  	 if(summ== (Runner.BSIZE))  {
			JOptionPane.showMessageDialog(new JFrame(), "Tebrikler Kazandınız !!", "Dialog",JOptionPane.ERROR_MESSAGE);
			//System.exit(0);
		 }
		 		
						
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
	   JButton event = (JButton) e.getSource();
	   int i = 0;
	   int j = 0;
	   buttons[i][j] = event;
	   btnNumber=buttons[i][j].getActionCommand() ;
	   summ=b.getBombsControlArraySum();	
	   pressed = true;
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
	    if (pressed) {
            if (SwingUtilities.isRightMouseButton(e)) {
            
              	int selectInt=Integer.parseInt((btnNumber.substring(1,4)));
        		int[] ijBomb=Runner.findNumberfromIJ(selectInt);
        		int i=ijBomb[0];
        		int j=ijBomb[1];
        		b.setSightBombsArray(btnNumber,i,j);
        		buttons[i][j].setIcon(new ImageIcon(Runner.class.getResource("/resources/flag.png")));
        		buttons[i][j].setActionCommand("S0" +i +j);
        		recor++;	
        		txt1.setText(String.valueOf(Runner.BOMBCOUNT-recor));  
    		    if(summ== (Runner.BSIZE))  {
    				JOptionPane.showMessageDialog(new JFrame(), "Tebrikler Kazandınız !!", "Dialog",JOptionPane.ERROR_MESSAGE);
    				//System.exit(0);
    			 }
    		    
            }
            else {
            	
            }
        }
        
	    pressed = false;

    }


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
