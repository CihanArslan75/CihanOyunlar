package cihan.kurs.swing.minesweeper;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.event.*;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

public class MinesWeeperSwing  extends JFrame implements MouseListener,ActionListener {
	
	public JButton[][] buttons=new JButton[Runner.SIZE][Runner.SIZE];
	public JButton btnStart = new JButton("");
	private String btnNumber;
	private int summ;
		
	BombsArray b ;
	
	JPanel anaPanel = new JPanel();
	JPanel mPanel   = new JPanel();
	JPanel sPanel   = new JPanel();
	Container c     = getContentPane();
	boolean pressed;
	private final JTextField txt1 = new JTextField();
	private final JTextField txt2 = new JTextField();
	private final JLabel lbl1 = new JLabel("B");
	private final JLabel lbl2 = new JLabel("T");
	Timer timer=null;
	
	public MinesWeeperSwing() {
	
	}
	
	public void MinesWeeperSwingStart() {
		b= new BombsArray();
		txt2.setFont(new Font("Arial", Font.BOLD, 20));
        txt2.setForeground(Color.RED);
		txt2.setBackground(Color.BLACK);
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setEditable(false);
		txt2.setColumns(5);
			
		txt1.setBackground(Color.BLACK);
		txt1.setFont(new Font("Arial", Font.PLAIN, 20));
		txt1.setForeground(Color.RED);
	    txt1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txt1.setSize(new Dimension(10, 10));
		txt1.setText(String.valueOf(Runner.BOMBCOUNT));
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
	    JButtonInitialize()	;
		       
        setTitle("Mayın Tarlası");
        setSize(700,700);
        setLocation(300,100);
        setVisible(true);
     	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	
     	 btnStart.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	txt1.setText(String.valueOf(Runner.BOMBCOUNT));
            	txt2.setText("");
            	mPanel.removeAll();
            	MinesWeeperSwingStart();	
              
          	}
         });

	}
	
	public void JButtonInitialize(){
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
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btnNumber=e.getActionCommand();
		int selectInt=Integer.parseInt((btnNumber.substring(1,4)));
		int[] ijBomb=Runner.findNumberfromIJ(selectInt);
		int i=ijBomb[0];
		int j=ijBomb[1];
		
		if(timer==null) {
			txt2.setText("1");	
		    timer= new Timer(1000,new ActionListener() {
		    int deger=1;
			@Override
			public void actionPerformed(ActionEvent e) {
				deger++;
				txt2.setText(toString().valueOf(deger));	
				}
			});	
		    timer.start();
			}
		
		setSightBombsArray(btnNumber,i,j);	
						
		 txt1.setText(String.valueOf(Runner.BOMBCOUNT-bombCount()));   
		 if(b.bombsArray[i][j]==Runner.BSIZE  &&  btnNumber.substring(0,1).equals("S") ) 
	  	 {   
			 
			 for (int k = 0; k < Runner.SIZE; k++) {
			    for (int l = 0; l < Runner.SIZE; l++) {
					if(b.bombsArray[k][l]==Runner.SIZE*Runner.SIZE) {
						buttons[k][l].setIcon(new ImageIcon(Runner.class.getResource("/resources/bomb_w.png")));
					}
				}
			}
			 buttons[i][j].setIcon(new ImageIcon(Runner.class.getResource("/resources/bomb_r.png")));
			 
			 timer.stop();	
		     JOptionPane.showMessageDialog(new JFrame(), "YANDINIZ", "Dialog",JOptionPane.ERROR_MESSAGE);
		     timer=null;
		      
		     for (int j2 = 0; j2 < Runner.SIZE ; j2++) {
		    	 for (int k2 = 0; k2 < Runner.SIZE; k2++) {
					buttons[j2][k2].setEnabled(false);; 
			}
				
			}
		    //System.exit(0);
	   	 }
		 
	    if(b.bombsArray[i][j]==0)
	    {
	    	buttons[i][j].setText(" ");
	    }
	    else if(b.bombsArray[i][j]!=Runner.BSIZE)
	    {   buttons[i][j].setIcon(null);
	    	buttons[i][j].setText(String.valueOf(b.bombsArray[i][j]));
	    	buttons[i][j].getText();
		    buttons[i][j].setEnabled(false);
		    buttons[i][j].setBackground(Color.LIGHT_GRAY);
	    }
	   
	    summ=b.getBombsControlArraySum();
	    int bs= bombCount();
	    if(summ == Runner.BSIZE && bs==Runner.BOMBCOUNT )  {
	    	timer.stop();
			JOptionPane.showMessageDialog(new JFrame(), "Tebrikler Kazandınız !!", "Dialog",JOptionPane.ERROR_MESSAGE);
			timer=null;	
			
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
        		
        		setSightBombsArray(btnNumber,i,j);
        		buttons[i][j].setIcon(new ImageIcon(Runner.class.getResource("/resources/flag.png")));
        		buttons[i][j].setActionCommand("S0" +i +j);
        	    txt1.setText(String.valueOf(Runner.BOMBCOUNT-bombCount())); 
        		int bs=bombCount();
    		    if(summ== (Runner.BSIZE-1) && bs==Runner.BOMBCOUNT)  {
    		    	timer.stop();	
    				JOptionPane.showMessageDialog(new JFrame(), "Tebrikler Kazandınız !!", "Dialog",JOptionPane.ERROR_MESSAGE);
    				timer=null;
    				
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
	
	public int bombCount() {
	int recor=0;	
	  for (int k = 0; k < Runner.SIZE; k++) {
		for (int l = 0; l < Runner.SIZE; l++) {
			if(buttons[k][l].getIcon()!=null && buttons[k][l].getActionCommand().equals("S0"+k+l)) {
				recor++;
		    }
	     }
	  }
   	return recor;
	}
	
	public void setSightBombsArray(String select,int row,int column) {
		NumberFormat formatter = new DecimalFormat("000");
		boolean exit=true;
        String selectFirst=select.substring(0,1).toUpperCase( );
/***************************************************************************************/
        if(b.bombsArray[row][column]!=Runner.BSIZE ) {//bomba olmayan kutular için set
    	  if(b.bombsArray[row][column]==0 )  
	      {   
    		  nearBoxOpen(row,column);
	      }
    	  else if(b.bombsArray[row][column]!=Runner.SIZE*Runner.SIZE ) 
    	  {
    		  buttons[row][column].setActionCommand(String.valueOf(b.bombsArray[row][column]));
    		  b.BombsControl[row][column]=1;
    		     		
          }	
    }
/***************************************************************************************/ 
    else   //  bomba olan  kutular için  flag  
	{  
    	if(buttons[row][column].getActionCommand().equals("B"+select.substring(1,4))) 
		{ 
		   buttons[row][column].setActionCommand("S"+select.substring(1,4));
		   b.BombsControl[row][column]=0;
		}
	    else
	    {
	       buttons[row][column].setActionCommand("B"+select.substring(1,4));
	       b.BombsControl[row][column]=1;
	    }
	  }
      }
	

	

   public  void nearBoxOpen(int row,int column) {
	       String[] nearB= b.nearBox(row,column)	;
 
		   int nearBSum=Integer.parseInt(nearB[9]);
		   for(int ii=0;ii<nearBSum;ii++)
		   { 
			  int[] injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
			  int in=injn[0];
			  int jn=injn[1];
			  if(b.BombsControl[in][jn]==1) {continue;}
			  b.BombsControl[in][jn]=1;
			  if(b.bombsArray[in][jn]==Runner.SIZE*Runner.SIZE) {}
			  else if(b.bombsArray[in][jn]!=0) 
			  {
				  buttons[in][jn].setText(String.valueOf(b.bombsArray[in][jn]));
				  buttons[in][jn].setEnabled(false);
				  buttons[in][jn].getText();
				  buttons[in][jn].setBackground(Color.LIGHT_GRAY);
			  }
			  else if(b.bombsArray[in][jn]==0)  	  
			  {    
				  buttons[in][jn].setText(" ");
				  buttons[in][jn].setEnabled(false);
				  buttons[in][jn].getText();
				  buttons[in][jn].setBackground(Color.LIGHT_GRAY);
				  nearBoxOpen(in,jn);
			  }
			}
    }
	
	
}
