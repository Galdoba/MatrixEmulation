import java.util.ArrayList;
import java.util.Random;

public class Host extends MatrixEmulation {
	
	private static int hostRating;
	private static int hostAttack;
	private static int hostSleaze;
	private static int hostDataProcessing;
	private static int hostFirewall;
	
	private static String hostGrid;
	
	private int hostType;
	
	public static boolean yellowAlert = false;
	public static boolean redAlert = false;
	
	public static int patrolScanCounter = 0;
	
	static ArrayList<String> icList = new ArrayList<String>();
	static ArrayList<String> activeICList = new ArrayList<String>();
	static ArrayList<String> loadedICList = new ArrayList<String>();
	static String nextIC = null;
	static ArrayList<Integer> hostAtributeArray = new ArrayList<Integer>();
	
	public Host(int hostRating, String hostGrid) {
		super();
		Host.hostRating = hostRating;
		Host.hostGrid = hostGrid;
	}
	
	public void initiateHost(){
		generateICMasterList();
		pickRandomHostRating();
		CreateAttributeArray();
		pickICForHost();
		MatrixEmulation.createHost();
	}
	
	
	private void CreateAttributeArray() {
		hostAtributeArray.add(hostRating);
		hostAtributeArray.add(hostRating+1);
		hostAtributeArray.add(hostRating+2);
		hostAtributeArray.add(hostRating+3);
		int index = 0;
		while (hostAtributeArray.size() > 0) {
			//attack
			index = new Random().nextInt(hostAtributeArray.size());
			setHostAttack(hostAtributeArray.get(index));
			System.out.println("Host Attack is = " + getHostAttack());
			hostAtributeArray.remove(index);
			//sleaze
			index = new Random().nextInt(hostAtributeArray.size());
			setHostSleaze(hostAtributeArray.get(index));
			System.out.println("Host Sleaze is = " + getHostSleaze());
			hostAtributeArray.remove(index);
			//dataProc
			index = new Random().nextInt(hostAtributeArray.size());
			setHostDataProcessing(hostAtributeArray.get(index));
			System.out.println("Host DataProcessing is = " + getHostDataProcessing());
			hostAtributeArray.remove(index);
			//Firewall
			index = new Random().nextInt(hostAtributeArray.size());
			setHostFirewall(hostAtributeArray.get(index));
			System.out.println("Host Firewall is = " + getHostFirewall());
			hostAtributeArray.remove(index);
			//setHostAttack(2);
		}
		
		
		
		
	}

	private void pickRandomHostRating() {
		Random generator = new Random(); 
		int n = generator.nextInt(78 - 1 + 1)+1; //random.nextInt(max - min + 1) + min
		int temp1 = 0;
		if (n>0 && n<13) { temp1 = 1;}
		if (n>12 && n<24) { temp1 = 2; }
		if (n>23 && n<34) { temp1 = 3; }
		if (n>33 && n<43) { temp1 = 4; }
		if (n>42 && n<51) { temp1 = 5; }
		if (n>50 && n<58) { temp1 = 6; }
		if (n>57 && n<64) { temp1 = 7; }
		if (n>63 && n<69) { temp1 = 8; }
		if (n>68 && n<73) { temp1 = 9; }
		if (n>72 && n<76) { temp1 = 10; }
		if (n>75 && n<78) { temp1 = 11; }
		if (n>77 && n<79) { temp1 = 12; }
		//Making Host always Rating 3
		temp1 = 3;
		//////////////////////////////////////////////////
		switch (temp1) {
		case 1:  hostRating = 1;
		break;
		case 2:  hostRating = 2;
		break;
		case 3:  hostRating = 3;
		break;
		case 4:  hostRating = 4;
		break;
		case 5:  hostRating = 5;
		break;
		case 6:  hostRating = 6;
		break;
		case 7:  hostRating = 7;
		break;
		case 8:  hostRating = 8;
		break;
		case 9:  hostRating = 9;
		break;
		case 10:  hostRating = 10;
		break;
		case 11:  hostRating = 11;
		break;
		case 12:  hostRating = 12;
		break;
		default: System.out.println("Ошибка рандомайзера хоста");
		}
		System.out.println(hostRating);
		//return hostRating;
	}
	
	public void generateICMasterList() {
		icList.clear();
		icList.add("Acid IC");
		icList.add("Binder IC");
		icList.add("Black IC");
		icList.add("Blaster IC");
		icList.add("Bloodhound IC");
		icList.add("Catapult IC");
		icList.add("Crash IC");
		icList.add("Jammer IC");
		icList.add("Killer IC");
		icList.add("Marker IC");
		icList.add("Probe IC");
		icList.add("Scramble IC");
		icList.add("Shocker IC");
		icList.add("Sparky IC");
		icList.add("Tar Baby IC");
		icList.add("Track IC");
	}
	
	static void pickICForHost() {
		String[] pickIC = new String[icList.size()];
		activeICList.clear();
		int hRtng = getHostRating();
		activeICList.add("Patrol IC");
		//loadedICList.add("Patrol IC");
		System.out.println("Patrol IC");
		for (int a=1; a < hRtng; a++) {
			if (icList.size() > 0) {
				int index = new Random().nextInt(icList.size());
				pickIC[index] = icList.get(index);
				activeICList.add(pickIC[index]);
				icList.remove(index);
				System.out.println(pickIC[index]);
			}
		}	
	}
	
	public static void actionHost() {
		if (loadedICList.size() < activeICList.size()) {
			chooseNextIC();
			//loadedICList.add(nextIC);
		} else if ((loadedICList.size() >= activeICList.size())) {
			nextIC = "Null IC";
		}
		patrolScanCounter = patrolScanCounter - 1;
		if (patrolScanCounter < 1) {
			switch (hostRating) {
			case 1:  patrolScanCounter = 1;
			break;
			case 2:  patrolScanCounter = 1;
			break;
			case 3:  patrolScanCounter = Dice.dotsqty(1);
			break;
			case 4:  patrolScanCounter = Dice.dotsqty(1);
			break;
			case 5:  patrolScanCounter = Dice.dotsqty(1) + 2;
			break;
			case 6:  patrolScanCounter = Dice.dotsqty(1) + 2;
			break;
			case 7:  patrolScanCounter = Dice.dotsqty(2);
			break;
			case 8:  patrolScanCounter = Dice.dotsqty(2);
			break;
			case 9:  patrolScanCounter = Dice.dotsqty(2) + 2;
			break;
			case 10:  patrolScanCounter = Dice.dotsqty(2) + 2;
			break;
			case 11:  patrolScanCounter = Dice.dotsqty(3);
			break;
			case 12:  patrolScanCounter = Dice.dotsqty(3);
			break;
			
			
			
			}
			
			
		}
	}
	
	public static String chooseNextIC() {
		if (loadedICList.contains("Patrol IC") == false) {
			nextIC = "Patrol IC";
			return nextIC;
		}
		boolean icTry = true;
		while (icTry == true && loadedICList.size() < activeICList.size() && redAlert == true) {
		int pick = new Random().nextInt(activeICList.size());
		System.out.println(pick);	
			if (loadedICList.contains(activeICList.get(pick)) == false)  {
				nextIC = activeICList.get(pick);
				icTry = false;
				return nextIC;
			}
		}
		nextIC = "Null IC";
		return nextIC;
	}
	
	
	
////////////GETTER&SETTERS///////////////////	

	public static int getHostRating() {
		return hostRating;
	}

	public static void setHostRating(int hostRating) {
		Host.hostRating = hostRating;
	}

	public static int getHostAttack() {
		return hostAttack;
	}

	public static void setHostAttack(int hostAttack) {
		Host.hostAttack = hostAttack;
	}

	public static int getHostSleaze() {
		return hostSleaze;
	}

	public static void setHostSleaze(int hostSleaze) {
		Host.hostSleaze = hostSleaze;
	}

	public static int getHostDataProcessing() {
		return hostDataProcessing;
	}

	public static void setHostDataProcessing(int hostDataProcessing) {
		Host.hostDataProcessing = hostDataProcessing;
	}

	public static int getHostFirewall() {
		return hostFirewall;
	}

	public static void setHostFirewall(int hostFirewall) {
		Host.hostFirewall = hostFirewall;
	}

	public static String getHostGrid() {
		return hostGrid;
	}

	public static void setHostGrid(String hostGrid) {
		Host.hostGrid = hostGrid;
	}

	public int getHostType() {
		return hostType;
	}

	public void setHostType(int hostType) {
		this.hostType = hostType;
	}

	public static ArrayList<String> getIcList() {
		return icList;
	}

	public static void setIcList(ArrayList<String> icList) {
		Host.icList = icList;
	}
	
	

}
