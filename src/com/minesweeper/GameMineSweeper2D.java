package com.minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameMineSweeper2D {
	static Logger log = LogManager.getLogger("GameMineSweeper2D");

	public static void main(String... args) {
		Map<String, String> mineSweeperMap = new TreeMap<String, String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		log.error("\n\n\t\t Welcome to MineSweeper***\n\tPlease provide count of row, it will generate a "
				+ "square matrix\n\t of size and you will then \n\tbe prompted to make your mine by providing "
				+ "'N' for no mine and \n\t 'M' for mine in left to right and top to bottom");
		Integer mapRowValue = null;
		try {
			mapRowValue = Integer.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int row = 0; row < mapRowValue; row++) {
			for (int column = 0; column < mapRowValue; column++) {
				String key = String.valueOf(row) + String.valueOf(column);
				log.error(key + ":[");
				String mineFlag;
				try {
					mineFlag = br.readLine();
					mineSweeperMap.put(key, mineFlag);
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		log.error("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\tLets Play");
		log.error("\n\n\n\n\t\tEnter row and column value as 'rc' value");
		Integer score = 0;
		for (int i = 0; i < mapRowValue * mapRowValue; i++) {
			try {
				String selection = br.readLine();
				String selectionValue = mineSweeperMap.get(selection);
				if (selectionValue != null) {
					if (!selectionValue.equalsIgnoreCase("X")) {
						if (selectionValue.equalsIgnoreCase("M")) {
							log.error("Mine!!! You are out");
							break;
						} else {
							score = score + 1;
							log.error("Great! Your score is :[" + score);
							mineSweeperMap.put(selection, "X");
						}
					} else {
						log.error("You have already made this selection, make new selection -|>");
						i--;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.error("Your cumulative score is : [" + score);

	}
}
