
public class Icon {

	private int iconID;
	private String type;
	private String currentGrid;
	private int mcm;
	private int initiative;
	private int willpower;
	private int logic;
	private int intuition;
	private int deviceRating;
	private boolean player;
	private int hacking;
	private int cybercombat;
	private String name;
	private int attack;
	private int sleaze;
	private int dataProcessing;
	private int firewall;
	private boolean locatedInHost;
	

	public Icon(int iconID, String type, String currentGrid, int mcm ,int initiative, int willpower, int logic, int intuition,  int deviceRating, boolean player, int hacking,
			int cybercombat, String name, int attack, int sleaze, int dataProcessing, int firewall, boolean locatedInHost) {
		super();
		this.currentGrid = currentGrid;
		this.iconID = iconID;
		this.mcm = mcm;
		this.initiative = initiative;
		this.willpower = willpower;
		this.logic = logic;
		this.intuition = intuition;
		this.deviceRating = deviceRating;
		this.player = player;
		this.hacking = hacking;
		this.cybercombat = cybercombat;
		this.name = name;
		this.attack = attack;
		this.sleaze = sleaze;
		this.dataProcessing = dataProcessing;
		this.firewall = firewall;
		this.locatedInHost = locatedInHost;
	}


	public int getIconID() {
		return iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCurrentGrid() {
		return currentGrid;
	}


	public void setCurrentGrid(String currentGrid) {
		this.currentGrid = currentGrid;
	}


	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getWillpower() {
		return willpower;
	}


	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}


	public int getLogic() {
		return logic;
	}


	public void setLogic(int logic) {
		this.logic = logic;
	}


	public int getIntuition() {
		return intuition;
	}

	public void setIntuition(int intuition) {
		this.intuition = intuition;
	}
	
	public int getDeviceRating() {
		return deviceRating;
	}

	public void setDeviceRating(int deviceRating) {
		this.deviceRating = deviceRating;
	}
	
	public boolean getPlayer() {
		return player;
	}

	public void setPlayer(boolean player) {
		this.player = player;
	}
	
	public boolean getLocatedInHost() {
		return locatedInHost;
	}

	
	
	
	
	
	public int getHacking() {
		return hacking;
	}


	public void setHacking(int hacking) {
		this.hacking = hacking;
	}


	public int getCybercombat() {
		return cybercombat;
	}


	public void setCybercombat(int cybercombat) {
		this.cybercombat = cybercombat;
	}


	public void setLocatedInHost(boolean locatedInHost) {
		this.locatedInHost = locatedInHost;
	}


	public int rollInitiative (int intuition) {
		int curInitiative = (intuition * 2) + Dice.dotsqty(4);
		return curInitiative;
	}
	
	
	public Icon toArray(Icon icon) {
		return null;
	}


	public int getMcm() {
		return mcm;
	}


	public void setMcm(int mcm) {
		this.mcm = mcm;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public int getSleaze() {
		return sleaze;
	}


	public void setSleaze(int sleaze) {
		this.sleaze = sleaze;
	}


	public int getDataProcessing() {
		return dataProcessing;
	}


	public void setDataProcessing(int dataProcessing) {
		this.dataProcessing = dataProcessing;
	}


	public int getFirewall() {
		return firewall;
	}


	public void setFirewall(int firewall) {
		this.firewall = firewall;
	}
	
	
	
	
}