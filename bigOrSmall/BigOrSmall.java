package practical13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BigOrSmall {
	private String answer(int num1, int num2) {
		String ans;
		if (num1 < num2) {
			ans = "Big";
		} else if (num1 > num2) {
			ans = "Small";
		} else {
			ans = "Draw";
		}
		return ans;
	}
	
	private String playerAnswer(int num) {
		String playerAns = "";
		switch (num) {
			case 0:
				playerAns = "Big";
				break;
			case 1:
				playerAns = "Small";
				break;
		}
		return playerAns;
	}
	
	private void addScore(Player player) {
		if (player.getBonus() == 1) {
			player.setScore(player.getScore(), 100);
		} else {
			
			int bonusPoint = (player.getBonus() - 1) * 100;
			player.setScore(player.getScore(), bonusPoint);
			System.out.println("bp" + (bonusPoint - 100));
		}
	}
	
	private String getResult(Player player, int currentNum, int nextNum, int playerSelect) {
		String result = "";
		if (nextNum == currentNum) {
			result = "Draw!";
		} else if (nextNum > currentNum && playerSelect == 0 || nextNum < currentNum && playerSelect == 1) {
			// 引き分け以外はデクリメントする
			player.setPlayCount(player.getPlayCount() - 1);
			player.setBonus(player.getBonus() + 1);
			addScore(player);
			result = "当たり！";
		} else {
			// 引き分け以外はデクリメントする
			player.setPlayCount(player.getPlayCount() - 1);
			player.setBonus(0);
			result = "はずれ！";
		}
		return result;
	}
	
	public void play() {
		int playerSelect = 0;
		
		Player player = new Player();
		System.out.println("Big or Small をプレイします。");
		Scanner scanner = new Scanner(System.in);

		// ゲーム繰り返し
		while (player.getPlayCount() > 0) {
			System.out.println("残りプレイ回数：" + " " + player.getPlayCount());
			System.out.println("スコア：" + " " + player.getScore());
			
			// 数値の生成
			player.setCurrentNumber(RandomNumberGenerator.createCurrntNumber());
			player.setNextNumber(RandomNumberGenerator.createCurrntNumber());
			System.out.println("現在の数値： " + player.getCurrentNumber());
			
			// 不正な入力は再入力
			while (true) {
				try {
					System.out.println("次の数値は Big or Small?(Big: 0 Small: 1)");
					playerSelect = Integer.parseInt(scanner.nextLine().trim());
					if (!(playerSelect == 0 || playerSelect == 1)) {
						System.out.println("0または1で入力してください。");
						continue;
					}
				} catch (NumberFormatException e) {
				    System.out.println("不正な入力です。");
				    continue;
				}
				break;
			}
			
			System.out.println("あなたの答え：" + " " + playerAnswer(playerSelect));
			System.out.print(answer(player.getCurrentNumber(), player.getNextNumber()) + " "); 
			System.out.print("現在の数値：" + " " + player.getCurrentNumber() + " "); 
			System.out.println("次の数値：" + " " + player.getNextNumber());
//			System.out.println(getResult(player, player.getCurrentNumber(), player.getNextNumber(), playerSelect));
			System.out.println(getResult(player, 1, 2, 0));
			System.out.println(player.getBonus());
			System.out.println();
		}
		
		// プレイ結果出力
		LocalDateTime localDateTime = LocalDateTime.now();
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String day_data = dateTimeFormatter.format(localDateTime);
		System.out.print("スコア：" + " " + player.getScore() + " ");
		System.out.println(day_data);
	}
}
