package game.graphics.skins;

import game.Main;

public class Sprite {

	public final int[] pixels;
	public int x, y;
	public final int Width;
	public final int Height;
	public final int Size;
	public int col;
	public SpriteSheet sheet;
	//Tiles
	public static Sprite NULLSPRITE = new Sprite(Main.FLOORS, 1, 0, 8);

	public static Sprite MARBLE = new Sprite(Main.FLOORS, 0, 1, 8);
	public static Sprite wetMARBLE = new Sprite(Main.FLOORS, 2, 1, 8);
	public static Sprite TiantedMARBLE = new Sprite(Main.FLOORS, 0, 0, 8);
	public static Sprite boosterMarkMARBLE = new Sprite(Main.FLOORS, 4, 0, 8);

	public static Sprite BARRACADE = new Sprite(Main.FLOORS, 2, 0, 8);
	//Mobs
	public static Sprite Player = new Sprite(Main.PLAYER, 0, 0, 16);
	public static Sprite Stamina = new Sprite(2000000, 2, 1);
	public static Sprite Health = new Sprite(0xFFD4D4F, 2, 1);
	//Menus
	public static Sprite MainMenu = new Sprite(Main.MainMenus, 0, 0, Main.WIDTH,Main.HEIGHT);

	public Sprite(SpriteSheet sheet, int x, int y, int size) {
		this.x = x * size;
		this.y = y * size;
		Size = size;
		Width = size;
		Height = size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
	}

	public Sprite(SpriteSheet sheet, int x, int y, int width, int height) {
		this.x = x * width;
		this.y = y * height;
		Size = width;
		Width = width;
		Height = height;
		this.sheet = sheet;
		pixels = new int[width * height];
		loadWH();
	}

	public Sprite(int col, int width, int height) {
		this.x = x * width;
		this.y = y * height;
		this.col = col;
		Size = width;
		Width = width;
		Height = height;
		pixels = new int[width * height];
		loadCol();
	}

	private void loadWH() {
		for (int y = 0; y < Height; y++) {
			for (int x = 0; x < Width; x++) {
				pixels[x + y * Size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.Size];
			}

		}

	}
	
	private void load() {
		for (int y = 0; y < Size; y++) {
			for (int x = 0; x < Size; x++) {
				pixels[x + y * Size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.Size];
			}

		}

	}


	private void loadCol() {
		for (int y = 0; y < Height; y++) {
			for (int x = 0; x < Width; x++) {
				pixels[x + y * Width] = col;
			}

		}

	}

}
