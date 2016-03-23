package RPS.view;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import RPS.controller.RPSController;

import java.awt.Color;
import java.awt.event.*;


public class RPSPanel extends JPanel
{
	public int RPC;
	public int RANDOMRPC;
	public boolean MODE;
	public int LOSES;
	public int WINS;
	private RPSController baseController;
	private JButton ROCK;
	private JButton PAPER;
	private JButton SCISSORS;
	private JButton ROCKP2;
	private JButton PAPERP2;
	private JButton SCISSORSP2;
	private JButton PlayerModeComputer;
	private JButton PlayerModePVP;
	private JTextField Result;
	private JTextField WVL;
	private SpringLayout baseLayout;
	
	

	
	
	
	public RPSPanel (RPSController baseController)
	{
		
		WINS=0;
		LOSES=0;
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		ROCK = new JButton("ROCK");
		PAPER = new JButton("PAPER");
		SCISSORS = new JButton("SCISSORS");
		ROCKP2 = new JButton("ROCK P2");
		PAPERP2 = new JButton("PAPER P2");
		SCISSORSP2 = new JButton("SCISSORS P2");
		PlayerModePVP = new JButton("Change to PVP");
		PlayerModeComputer = new JButton("Change to Computer");
		Result = new JTextField ("     ");
		WVL = new JTextField ("WIN:" + WINS + " LOSES:" + LOSES);
		baseLayout.putConstraint(SpringLayout.SOUTH, WVL, -6, SpringLayout.NORTH, Result);
		baseLayout.putConstraint(SpringLayout.EAST, WVL, 0, SpringLayout.EAST, PAPERP2);
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	private void setupPanel()
		{
		
			this.add(WVL);
			this.add(ROCK);
			this.add(PAPER);
			this.add(SCISSORS);
			this.add(ROCKP2);
			this.add(PAPERP2);
			this.add(SCISSORSP2);
			
			this.add(PlayerModePVP);
			this.add(PlayerModeComputer);
			
			this.add(Result);
			this.setLayout(baseLayout);
		
			
		}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, ROCK, 0, SpringLayout.NORTH, PAPER);
		baseLayout.putConstraint(SpringLayout.NORTH, PAPER, 149, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, PAPER, 135, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, SCISSORS, 0, SpringLayout.NORTH, ROCK);
		baseLayout.putConstraint(SpringLayout.WEST, SCISSORS, 61, SpringLayout.EAST, PAPER);
		baseLayout.putConstraint(SpringLayout.EAST, ROCKP2, 0, SpringLayout.EAST, ROCK);
		baseLayout.putConstraint(SpringLayout.NORTH, PAPERP2, 0, SpringLayout.NORTH, ROCKP2);
		baseLayout.putConstraint(SpringLayout.EAST, PAPERP2, -24, SpringLayout.WEST, SCISSORSP2);
		baseLayout.putConstraint(SpringLayout.NORTH, ROCKP2, 0, SpringLayout.NORTH, SCISSORSP2);
		baseLayout.putConstraint(SpringLayout.NORTH, SCISSORSP2, 13, SpringLayout.SOUTH, SCISSORS);
		baseLayout.putConstraint(SpringLayout.EAST, SCISSORSP2, 0, SpringLayout.EAST, SCISSORS);
		baseLayout.putConstraint(SpringLayout.WEST, ROCK, 0, SpringLayout.WEST, PlayerModePVP);
		baseLayout.putConstraint(SpringLayout.NORTH, PlayerModePVP, 241, SpringLayout.NORTH, this);
		
		baseLayout.putConstraint(SpringLayout.WEST, PlayerModePVP, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, PlayerModeComputer, 0, SpringLayout.NORTH, PlayerModePVP);
		baseLayout.putConstraint(SpringLayout.WEST, PlayerModeComputer, 46, SpringLayout.EAST, PlayerModePVP);
		baseLayout.putConstraint(SpringLayout.NORTH, Result, 52, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, Result, 109, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, Result, 0, SpringLayout.EAST, PAPER);
				
	}

	private void setupListeners()
	{
		PlayerModePVP.addActionListener(new ActionListener()
		{
			

			public void actionPerformed(ActionEvent click)
			{
				MODE = false;
			}
			
		});
		PlayerModeComputer.addActionListener(new ActionListener()
		{
			

			public void actionPerformed(ActionEvent click)
			{
				MODE = true;
			}
			
		});
		ROCK.addActionListener(new ActionListener()
		{
			
			
				public void actionPerformed(ActionEvent click)
				{
					if (MODE)
					{
						computerRANDOMNUMBER();
						RPC = 0;
						if (RANDOMRPC == RPC)
						{
							Result.setText("IT'S A TIE");
						}
						else if (RANDOMRPC == 1)
						{
							Result.setText("YOU LOSE");
							LOSES ++;
							WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
						}
						else
						{
							Result.setText("YOU WIN");
							WINS ++;
							WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
						}
					}
					else
					{
						RPC = 0;
					}
				
			}
			
		});
		
		PAPER.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				if (MODE)
				{
					computerRANDOMNUMBER();
					RPC = 1;
					if (RANDOMRPC == RPC)
					{
						Result.setText("IT'S A TIE");
					}
					else if (RANDOMRPC == 2)
					{
						Result.setText ("YOU LOSE");
						LOSES ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
					else
					{
						Result.setText ("YOU WIN");
						WINS ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
				}
				else
				{
					RPC = 1;
				
				}
			}
			
		});
		
		SCISSORS.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				if (MODE)
				{
					
				
					computerRANDOMNUMBER();
					RPC = 2;
					if (RANDOMRPC == RPC)
					{
						Result.setText("IT'S A TIE");
					}
					else if (RANDOMRPC == 0)
					{
						Result.setText ("YOU LOSE");
						LOSES ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
					else
					{
						Result.setText("YOU WIN");
						WINS ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
				}
				else
				{
					RPC = 2;
				
				}
			
			
			}
			
		});
		ROCKP2.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				if (MODE)
				{
					
				}
				else
				{
					RANDOMRPC =0;
					
					if (RPC == RANDOMRPC)
					{
						Result.setText("IT'S A TIE");
					}
					else if (RPC == 1)
					{
						Result.setText("P2: YOU LOSE");
						WINS ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
					else
					{
						Result.setText("P2: YOU WIN");
						LOSES ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
				}
			}
			
		});
		
		PAPERP2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				if (MODE)
				{
					
				}
				else
				{
					RANDOMRPC = 1;
					if (RPC == RANDOMRPC)
					{
						Result.setText("IT'S A TIE");
					}
					else if (RPC == 2)
					{
						Result.setText ("P2: YOU LOSE");
						WINS ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
					else
					{
						Result.setText ("P2: YOU WIN");
						LOSES ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
				}
			}
			
		});
		
		SCISSORSP2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				if (MODE)
				{
					
				}
				else
				{
					RANDOMRPC = 2;
					if (RPC == RANDOMRPC)
					{
						Result.setText("IT'S A TIE");
					}
					else if (RANDOMRPC == 0)
					{
						Result.setText ("P2: YOU LOSE");
						WINS ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
					else
					{
						Result.setText("P2: YOU WIN");
						LOSES ++;
						WVL.setText ("WIN:" + WINS + " LOSES:" + LOSES);
					}
				}
			}
			
		});
		this .addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				
					
				// NEVER USE THIS
				//changeRandomColor();
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				changeRandomColor();
			}
			
		});
	}

	
	
	///////////////////EXTRA////////////////////////
	private void changeRandomColor()
	{
		int red,green,blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red,green,blue));
				
	}
	private void computerRANDOMNUMBER()
	{
		RANDOMRPC = (int) (Math.random() * 3);
	}
}

