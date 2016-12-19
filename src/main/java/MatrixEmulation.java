import java.util.ArrayList;
import java.util.List;

public class MatrixEmulation extends RunStart {
	public static String info = "Action:";
	String iconName = "Icon";
	//Grid attributes
	//private String name;
	//private int rating;
	//private int overwatchScore; //Возможно это характеристика Иконы
	
	int turn = 0;
	int initiative;
	//Icon attributes
	//private int idNumber = 0;
	private int iconID = 1;
	//private int type;
	//private int rating;        ---- уже выделена память в атрибутах сетей.
	//private int attack;
	//private int sleaze;
	//private int dataProcessing;
	//private int firewall;
	public static int playerMCM = 1;
	
	//static String nextIC = null;
	
	
	//ЧТО ДЕЛАЕТ ЭТА ХРЕНЬ?
	static ArrayList<Icon> iconList = new ArrayList<Icon>();
	static Icon iconNull = new Icon(0, "Template","Public Grid",0,0,0,0,false, null, 0, 0, 0, 0);
	static Icon iconAttack = new Icon(0, "Icon","Public Grid",0,0,0,0,false, null, 0, 0, 0, 0);
	static Icon iconDefence = new Icon(0, "Icon","Public Grid",0,0,0,0,true, null, 0, 0, 0, 0);
	static Icon persona = new Icon(0, "Persona","Public Grid", 1, 0, 0, 4, true, "Persona0", 5, 4, 3, 2);
	
	public static List <Marks> markList = new ArrayList<Marks>();
	static Marks mARK = new Marks (0, 0, 4);
	
	public static List <PerceiptionStatus> percStatusList = new ArrayList<PerceiptionStatus>();
	static PerceiptionStatus pStatus0 = new PerceiptionStatus (0, 0, true, true, true, true, true, true, true, true, true, true);
	
	//markList.add(mARK);
	//СОРТИРОВЩИК
	public static void BubbleSort( int [ ] num )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable
	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      } 
	} 
	
	//СОЗДАНИЕ ИГРОКА
	public static void persona () {
		//Icon persona = new Icon (0, 1, 0, 0, 4, true);
		iconList.add(persona);
		persona.setMcm(((persona.getDeviceRating()/2)+1000)); //ПРИСВАЕВАЕМ ТОЛЬКО ЧТО СОЗДАННОЙ ПЕРСОНЕ МСМ=(DR/2)+8
		playerMCM = persona.getMcm();
		//System.out.println("ListSize=" + iconList.size());
		}
	

	//СОЗДАНИЕ ИКОНЫ
	public void createIcon () {
		iconName = iconName + iconID;
		Icon xx = new Icon(iconID, "Icon","Public Grid", 1, 0, 0, 2, false, iconName, 2, 0, 2, 2);
		iconName = "Icon";
		iconID++;
		//iconList.add(xx);
		xx.setMcm(((xx.getDeviceRating()/2)+8)); //ПРИСВАЕВАЕМ ТОЛЬКО ЧТО СОЗДАННОЙ ИКОНЕ МСМ=(DR/2)+8
		iconList.add(xx);
		}
	
	public void createIC () {
		//(int iconID, String currentGrid, int mcm ,int initiative, int intuition,  int deviceRating, boolean player, 
		//String name, int attack, int sleaze, int dataProcessing, int firewall)
		iconName = Host.chooseNextIC ();
			if (iconName.equals("Null IC") == false) {
				Icon xx = new Icon(iconID, "IC",Host.getHostGrid(), 1, 0, Host.getHostRating(), Host.getHostRating(), false, iconName, Host.getHostAttack(), Host.getHostSleaze(), 
						Host.getHostDataProcessing(), Host.getHostFirewall());
				Host.loadedICList.add(iconName);
				System.out.println("Host loaded new IC...");
				iconName = "Icon";
				iconID++;
				//iconList.add(xx);
				xx.setMcm(((xx.getDeviceRating()/2)+8)); //ПРИСВАЕВАЕМ ТОЛЬКО ЧТО СОЗДАННОЙ ИКОНЕ МСМ=(DR/2)+8
				iconList.add(xx);
			}
		iconName = "Icon";	
		}
	
	public static void createHost () {
		//iconName = iconName + iconID;
		Icon xx = new Icon(-1, "Host","Public Grid", 1, 0, 0, 2, false, "Host", 2, 0, 2, 2);
		xx.setMcm(9999); //ПРИСВАЕВАЕМ хосту неибическое значение Хитпойтов чтобы его не грохнуть. Он нужен как икона чтобы манипулировать с марками.
		xx.setAttack(Host.getHostAttack());
		xx.setSleaze(Host.getHostSleaze());
		xx.setDataProcessing(Host.getHostDataProcessing());
		xx.setFirewall(Host.getHostFirewall());
		// присваеваем сети.
		//iconName = "Icon";
		//iconID++;
		//iconList.add(xx);
		iconList.add(xx);
		}
	
	public static void destroyIcon () {
		for (int destcounter = 0; destcounter < iconList.size(); destcounter++) {
			if (iconList.get(destcounter).getMcm() < 1) {
				iconList.get(destcounter).setInitiative(-100);
				System.out.println((iconList.get(destcounter).getName()) + " destroyed");
				String dIconName = iconList.get(destcounter).getName();
				iconList.remove(destcounter);
				if (Host.loadedICList.contains(dIconName)) {
					System.out.println("Сейчас уничтожат " + dIconName);
					Host.loadedICList.remove(dIconName);
				}
			}
			
			
			
			
		}
	}
	
	
	public void calculateInitiative () {
		//ArrayList<Icon> initiativeList = new ArrayList<Icon>();
		
		System.out.println("Iconlist.arrayToString = " + iconList.toString() );
		
	}
	
	public void startPass () {
		Marks.initiateMARKs();
		PerceiptionStatus.initiatePerceiptionSt();
		//НАЧИНАЕМ ХОД --> СТРОИМ СПИСОК ДОСТУПНЫХ ИКОН, СОРТИРУЕМ, ВЫБИРАЕМ МАКСИМАЛЬНУЮ 
		// тут должно стоять действия хоста
		
		System.out.println("turn = " + turn);
		int[] order = new int[iconList.size()];
		for (int i = 0; i < iconList.size(); i++) {
			if (iconList.get(i).getName() == "Host") {
				iconList.get(i).setInitiative(-100);
			}
			order [i] = iconList.get(i).getInitiative();
			System.out.print(order[i] + "//" );
		}
		BubbleSort(order);
		if (order[0] < 0) { 		//УСЛОВИЕ ПРИ КОТОРОМ МЫ ВООБЩЕ ИЩЕМ НАИВЫСШУЮ ИНИЦИАТИВУ БОЛЬШЕ 0, ЕСЛИ НЕ ИМЕЕМ ТО ЭТО КОНЕЦ ХОДА.
				this.endTurn();
				for (int i = 0; i < iconList.size(); i++) { //ЦИКЛ ГДЕ ВСЕ ИКОНЫ В СПИСКЕ ОБНОВЛЯЮТ ИНИЦИАТИВЫ ЕСЛИ МАКСИМАЛЬНАЯ ИНИЦИАТИВА МЕНЬШЕ 1
					int initroll = iconList.get(i).rollInitiative(iconList.get(i).getIntuition());
					iconList.get(i).setInitiative(initroll);
				}
		}
		for (int i = 0; i < iconList.size(); i++) { //в этом цикле мы берем иниативу из списка всех икон и сравниваем с order[0], если совпадает то эта наша атакующая икона.
			if (iconList.get(i).getInitiative() == order[0]) {
				int ini1 = iconList.get(i).getInitiative();
				//iconAttack = iconList.toArray(new Icon[iconList.size()]);
				iconAttack = iconList.get(i);
				if (iconAttack.getName()=="Host") {
					iconAttack.setInitiative(-100);
					iconList.get(i).setInitiative(-100);
				}
				System.out.println("наивысшая инициатива=" + ini1 + " у " + iconAttack.getName());
				System.out.println("MCM Player=" + iconList.get(0).getMcm());
				//if (iconList.get(i).getInitiative() > 0) {
					MatrixAction.action();
				//}
				System.out.println(" уменьшенная инициатива: " + iconAttack.getInitiative());
			}
		} 
		checkplay();
	}			
		
		
		
		
	
	
	
	
	
	
	
	
	private void checkplay() {
		playerMCM = persona.getMcm();
		
	}

	public void endTurn () {
		Host.actionHost();
		createIC();
		System.out.println("Turn " + turn + " end");
		turn++;
		//createIcon();
		if (turn == 500) {
			System.exit(0);
		}
		
	}
	
	
	public void log_in () {
		//Region[] reg = new Region [11];
		Grid[] grid = new Grid[12]; 
		grid[0] = new Grid ("Public Grid", 3, 0);
		grid[1] = new Grid ("Emerald Grid", 4, 0);
		grid[2] = new Grid ("Ares Global Grid", 5, 0);
		grid[3] = new Grid ("AzGrid", 5, 0);
		grid[4] = new Grid ("Eternal Horizon", 5, 0);
		grid[5] = new Grid ("EvoGrid", 5, 0);
		grid[6] = new Grid ("MCT GlobeNet", 5, 0);
		grid[7] = new Grid ("NeoNetWork", 5, 0);
		grid[8] = new Grid ("Renraku Okoku", 5, 0);
		grid[9] = new Grid ("Saeder-Krupp Uberwelt", 5, 0);
		grid[10] = new Grid ("Shiawase Central", 5, 0);
		grid[11] = new Grid ("Wuxing Worldwide", 5, 0);
	}
	
	public void startTime () {
	turn = 1;
		for (int i = 0; i < iconID; i++) {
			//icon[1];
			//icon[i].setFirewall((icon[i].getRating() * 2) + icon[i].Dice.initiative(4));
		}
	}
	
	
}

