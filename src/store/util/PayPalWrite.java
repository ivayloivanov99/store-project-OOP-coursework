package store.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class PayPalWrite {

	private static final String ITEMS_FILE_EXTENSION = ".file";
	private static final String ITEMS_FILE_NAME = "paypalorders";
	private static final String FILE_PATH = "src/store/files/";
	private static final String FULL_PATH = FILE_PATH + ITEMS_FILE_NAME + ITEMS_FILE_EXTENSION;

	public static ArrayList<PayPalModel> itemList = new ArrayList<>();

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

	public static void writeItems(PayPalModel item) {

		Writer writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(FULL_PATH, true)); // enable append

			writer.append(item.getBuyer() + "\t");
			writer.append(item.getPayPal() + "\t");
			writer.append(item.getTotalPrice() + "\t");
			writer.append(item.getItems() + "\t");

			writer.append("\n");

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
