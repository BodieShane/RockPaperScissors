package RPS.view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import RPS.controller.RPSController;
import RPS.view.RPSPanel;

public class RPSFrame extends JFrame
{
	private RPSController baseController;
	private RPSPanel basePanel;
	
	public RPSFrame(RPSController baseController)
	{
		this.baseController = baseController;
		basePanel = new RPSPanel (baseController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setTitle("Rock Paper Scissors");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public RPSController getBaseController()
	{
		return baseController;
	}
}
