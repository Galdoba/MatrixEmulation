
public class RunStart {

	public static void main(String[] args) {
		System.out.println("START");
		
		
		
		Frame.initialize();
		Frame.addLog("Start");
		Frame.userInput();
		MatrixEmulation Matrix = new MatrixEmulation ();
		Matrix.log_in();
		MatrixEmulation.persona();
		Host host = new Host(10, "AzGrid"); //òåáÿ ìû êèíåì â ìàòðèêñ ñåð÷
		//host.generateICMasterList();
		//Host.pickICForHost();
		//Matrix.createIcon();
		//Matrix.createIcon();
		host.initiateHost();
		Matrix.createIC();
		//Time turn = new Time ();
		//turn.deside();
		//Matrix.sortOrder();
		//Matrix.calculateInitiative();
		//persona.getMCM;
		while (MatrixEmulation.playerMCM > 0) {
			Matrix.startPass();
			
			
			
		}
		System.out.println("CONNECTION TERMINATED");
		//Matrix.log_in();
		//Matrix.createIcon();
		//System.out.println("end");
		//if (Matrix.turn == 300) {
		//	System.exit(0);
		//}
		
		

	}

}