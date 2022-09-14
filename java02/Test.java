import java.util.Calendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("カレンダーの年を入力してください。：");
			int year = scanner.nextInt();
			if (year <= 1900 && year >= 2100) {
				throw new YearError("1900～2100の間で入力してください");
			}

			System.out.print("カレンダーの月を入力してください。： ");
			int month = scanner.nextInt();
			if (month < 0 && month >= 12) {
				throw new ToMannyCount("1～12の間で入力してください");
			}

			System.out.println("-----------------------------------");
			System.out.println(year + "年" + month + "月のカレンダー");
			System.out.println("-----------------------------------");

			// カレンダー作成
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
			cal.set(Calendar.DATE, 1);
			String Days[] = { "日", "月", "火", "水", "木", "金", "土" };

			// その月の最終日
			int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			// 1日の曜日
//			int start_index = cal.get(Calendar.DAY_OF_WEEK);
//			for (int i = 1; i < start_index; i++) {
//				System.out.printf("%3s", ""); //1週目の1日までを空白で埋める
//			}

			for (int i = 1; i <= max_day; i++) {
				System.out.printf("%3d", i);
				cal.set(Calendar.DATE, i);
				if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
					System.out.println("");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("数字を正しく入力してください");
		} catch (YearError e) {
			System.out.println(e.getMessage());
		} catch (ToMannyCount e) {
			System.out.println(e.getMessage());
		}
	}
}

