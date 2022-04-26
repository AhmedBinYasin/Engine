package Games.Wave;

import java.util.Random;

public class LevelCacheSpawn {
	private ComponentHandler handler;
	private HUD hud;
	private Random random=new Random();
	public static int enemyKilled;
	private boolean spawnStatius1=false;
	private boolean spawnStatius2=false;
	private boolean spawnStatius3=false;
	private boolean spawnStatius4=false;
	private boolean spawnStatius5=false;
	private boolean spawnStatius6=false;
	private boolean spawnStatius7=false;
	private boolean spawnStatius8=false;
	private boolean spawnStatius9=false;
	private boolean spawnStatius10=false;
	private boolean spawnStatius11=false;
	private boolean spawnStatius12=false;
	private boolean spawnStatius13=false;
	private boolean spawnStatius14=false;
	private boolean spawnStatius15=false;
	private boolean spawnStatius16=false;
	private boolean spawnStatius17=false;
	private boolean spawnStatius18=false;
	private boolean spawnStatius19=false;
	private boolean spawnStatius20=false;
	private boolean spawnStatius21=false;
	private boolean spawnStatius22=false;
	private boolean spawnStatius23=false;
	private boolean spawnStatius24=false;
	private boolean spawnStatius25=false;
	private boolean spawnStatius26=false;
	private boolean spawnStatius27=false;
	private boolean spawnStatius28=false;
	private boolean spawnStatius29=false;
	private boolean spawnStatius30=false;
	private boolean spawnStatius31=false;
	public static int chankCache=1;
	public int levelCache=0;
	public LevelCacheSpawn(ComponentHandler handler,HUD hud) {
		this.handler=handler;
		this.hud=hud;
	}
	public void tick() {
		if (enemyKilled==10) {
			HUD.level++;
			enemyKilled=0;
		}
		if (HUD.level==2&&spawnStatius1==false) {
			for (int i = 0; i <= 10; i++) {
				handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
			}
			handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
			spawnStatius1=true;
			hud.wave++;
		}
		if (HUD.level==3&&spawnStatius2==false) {
			EnemyMedium.health=10;
			EnemyHard.health=50;
			for (int i = 0; i < 10; i++) {
				handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
			}
			for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
			}
			handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
			spawnStatius2=true;
			hud.wave++;
		}
		if (HUD.level==4&&spawnStatius3==false) {
			handler.addObject(new EnemyEpicBoss((Main.width/2-32)-48,-90, IDs.EnemyEpicBoss,handler));
			spawnStatius3=true;
			hud.wave++;
		}
		if (chankCache==2) {
			if (spawnStatius4==false) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				spawnStatius4=true;
				hud.wave++;
			}
			if (HUD.level==5&&spawnStatius5==false) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				spawnStatius5=true;
				hud.wave++;
			}
			if (HUD.level==6&&spawnStatius6==false) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius6=true;
				hud.wave++;
			}
			if (spawnStatius7==false&&HUD.level==7) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius7=true;
				hud.wave++;
			}
			if (spawnStatius8==false&&HUD.level==8) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius8=true;
				hud.wave++;
			}
			if (spawnStatius9==false&&HUD.level==9) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius9=true;
				hud.wave++;
			}
			if (HUD.level==10&&spawnStatius10==false) {
				handler.addObject(new EnemyEpicBoss((Main.width/2-32)-48,-90, IDs.EnemyEpicBoss,handler));
				spawnStatius10=true;
				hud.wave++;
			}
		}
		else if (chankCache==3) {
			if (spawnStatius11==false) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius11=true;
				hud.wave++;
			}
			if (spawnStatius12==false&&HUD.level==12) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius12=true;
				hud.wave++;
			}
			if (spawnStatius13==false&&HUD.level==14) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius13=true;
				hud.wave++;
			}
			if (spawnStatius14==false&&HUD.level==15) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius14=true;
				hud.wave++;
			}
			if (spawnStatius15==false&&HUD.level==16) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius15=true;
				hud.wave++;
			}
			if (spawnStatius16==false&&HUD.level==17) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius16=true;
				hud.wave++;
			}
			if (spawnStatius17==false&&HUD.level==19) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius17=true;
				hud.wave++;
			}
			if (spawnStatius18==false&&HUD.level==20) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 1; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 4; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius18=true;
				hud.wave++;
			}
			if (spawnStatius19==false&&HUD.level==22) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				spawnStatius19=true;
				hud.wave++;	
			}
			if (HUD.level==24&&spawnStatius20==false) {
				handler.addObject(new EnemyEpicBoss((Main.width/2-32)-48,-90, IDs.EnemyEpicBoss,handler));
				spawnStatius20=true;
				hud.wave++;
			}
			
		}
		else if (chankCache==4) {
			if (spawnStatius21==false&&HUD.level==26) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius21=true;
				hud.wave++;	
			}
			if (spawnStatius22==false&&HUD.level==28) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius22=true;
				hud.wave++;	
			}
			if (spawnStatius23==false&&HUD.level==31) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius23=true;
				hud.wave++;	
			}
			if (spawnStatius24==false&&HUD.level==34) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius24=true;
				hud.wave++;	
			}
			if (spawnStatius25==false&&HUD.level==38) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 2; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius25=true;
				hud.wave++;	
			}
			if (spawnStatius26==false&&HUD.level==42) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 3; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius26=true;
				hud.wave++;	
			}
			if (spawnStatius27==false&&HUD.level==47) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 3; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius27=true;
				hud.wave++;	
			}
			if (spawnStatius28==false&&HUD.level==52) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 15; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 4; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius28=true;
				hud.wave++;	
			}
			if (spawnStatius29==false&&HUD.level==58) {
				EnemyMedium.health=10;
				EnemyHard.health=50;
				EnemyBoss.health=200;
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(1000),random.nextInt(448), IDs.EnemyBasic));
				}
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyMedium(random.nextInt(1000),random.nextInt(448), IDs.EnemyMedium));
				}
				for (int i = 0; i < 20; i++) {
					handler.addObject(new EnemyHard(random.nextInt(1000),random.nextInt(448), IDs.EnemyHard,handler));
				}
				for (int i = 0; i < 5; i++) {
				handler.addObject(new EnemyBoss(random.nextInt(1000),random.nextInt(448), IDs.EnemyBoss,handler));
				}
				spawnStatius29=true;
				hud.wave++;	
			}
			if (HUD.level==65&&spawnStatius30==false) {
				handler.addObject(new EnemyEpicBoss((Main.width/2-32)-48,-90, IDs.EnemyEpicBoss,handler));
				spawnStatius10=true;
				hud.wave++;
			}
		}
		if (chankCache==5) {
			if (HUD.level==65&&spawnStatius31==false) {
				handler.addObject(new EnemyEpicBoss((Main.width/2-32)-48,-90, IDs.EnemyEpicBoss,handler));
				EnemyEpicBoss.life=2000;
				EnemyEpicBoss.time=20000000;
				spawnStatius10=true;
			}
		}
	}
}
