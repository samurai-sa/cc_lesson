import java.util.Random;
import java.util.Scanner;

public class BigOrSmall {
	// result を返す
	public static String getResult(int comNum, int userNum, int userPredictNum) {
		String result = "";
		if(comNum == userNum) {
			result = "Drow";
		} else if (comNum > userNum && userPredictNum == 0 || comNum < userNum && userPredictNum == 1) {
			result = "Win!!!";
		} else {
			result = "Lose.....";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		int playNum = 0;

		// ゲーム繰り返し
		while(isContinue) {
			Random random = new Random();

			// 出た数字
			int comRandomNum = random.nextInt(8) + 1;
			System.out.println("出た数字：" + comRandomNum);

			// あなたの選択
			System.out.print("あなたの選択は?(0: Small, 1: Big)：");
			int userPredictNum = scanner.nextInt();

			// あなたの数字
			int userRandomNum = random.nextInt(6) + 2;
			System.out.println("あなたの数字：" + userRandomNum);

			// 0 か 1 以外の入力はエラーにする
			if (!(userPredictNum == 0 || userPredictNum == 1)) {
				System.out.println("******** エラー **********");
				System.out.println("0か1のみを入力してください");
				System.out.println("**************************");
				break;
			}

			// 結果出力
			System.out.println(getResult(comRandomNum, userRandomNum, userPredictNum));
			playNum++;

			// 3回連続は強制終了
			if (playNum >= 3) {
				isContinue = false;
				break;
			}

			// プレイ確認
			System.out.print("もう一度プレイしますか？ （0:No, 1:Yes）:");
			int continueNum = scanner.nextInt();
			if (continueNum != 1) {
				isContinue = false;
			}
		}
		System.out.println("プレイを終了します");
		scanner.close();
	}
}
