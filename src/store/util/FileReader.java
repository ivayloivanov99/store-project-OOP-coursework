package store.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;

public class FileReader {

	private static final String ITEMS_FILE_EXTENSION = ".file";
	private static final String ITEMS_FILE_NAME = "items";
	private static final String FILE_PATH = "src/store/files/";
	private static final String FULL_PATH = FILE_PATH + ITEMS_FILE_NAME + ITEMS_FILE_EXTENSION;

	public static ArrayList<ItemInfo> itemList = new ArrayList<>();

	public static void createItemFile() {
		File file = new File(FULL_PATH);
		file.getParentFile().mkdirs();

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Файлът не може да бъде създаден!");
			e.printStackTrace();
		}
	}

	public static boolean isFileExists() {
		File file = new File(FULL_PATH);
		return file.exists();
	}

	@SuppressWarnings("resource")
	public static ItemInfo[] readItems() {
		try {
			FileInputStream fileStream = new FileInputStream(FULL_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
			String stringLine;

			while ((stringLine = bufferedReader.readLine()) != null) {
				String[] data = stringLine.split("\t");
				addItem(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ItemInfo[] items = new ItemInfo[itemList.size()];
		return itemList.toArray(items);
	}

	private static void addItem(String[] data) {

		ItemInfo itemInfo = new ItemInfo(data[0], Integer.parseInt(data[1]), data[2]);
		itemList.add(itemInfo);

	}

	public static void writeItems(ItemInfo[] items) {
		Writer writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(FULL_PATH, true)); // enable append

			for (ItemInfo item : items) {
				writer.append(item.getName() + "\t");
				writer.append(item.getPrice() + "\t");
				writer.append(item.getImage() + "\t");
				writer.append("\n");
			}
		} catch (IOException e) {
			System.err.println("Записът не може да бъде добавен във файла!");
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("Записвачът не може да бъде затворен правилно!");
					e.printStackTrace();
				}
			}
		}
	}
}
