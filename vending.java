package vending;

import java.util.Scanner;

public class vending {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int VALUE[] = {130, 130, 110, 100, 110, 120, 150};

		String NAME[] = {"Cola", "Cola", "GreenTea", "Water", "Coffee", "EnergyDrink", "Yagult1000"};
		
		int MONEY[] = {1000, 500, 100, 50, 10};
		int NUM[] = {30, 30, 30, 30, 5};


		System.out.println("投入金額を入力してください");
		System.out.print(">");
		Scanner inmn = new Scanner(System.in);
		int money = inmn.nextInt();

		//各商品ごとのお釣りの金額
		int rest[] = {0, 0, 0, 0, 0, 0, 0};


		//各商品の値段に対するお釣り合計
		for(int i = 0;i < VALUE.length;i++){
			rest[i] = money - VALUE[i];
		}
		//硬貨・紙幣が４枚以下ならtrue
		boolean b[] = {false, false, false, false, false};


		for(int l = 0;l < 5;l++){
			if(NUM[l] < 5){
				b[l] = true;
			}
		}
		//お釣り計算後の必要な硬貨・紙幣の、枚数
		//int COUNT[] = {0, 0, 0, 0, 0};
		
		//boolean f = false;
		//購入可能なら表示を行う
		boolean CanPrint[] = {false, false, false, false, false, false, false};

		for(int m = 0;m < VALUE.length;m++){
			int j = 0;
			//釣り切れ判断
			do{
				if(rest[m] >= MONEY[j] && b[j] == false && NUM[j] > 0){
					//COUNT[j]++;
					//NUM[j]--;
					rest[m] -= MONEY[j];

				}else{
					j++;
				}

				if(rest[m] == 0){
					break;
				}

				if(j == 5){
					CanPrint[m] = true;
					//f = true;
					break;
				}

			}while(true);


//			if(f){
//				System.out.println("購入不可能です。");
//
//			}else{
//				for(int k = 0;k < 5;k++){
//					System.out.println(MONEY[k] + "円：" + COUNT[k] + "枚");
//				}
//			}
		}

		System.out.printf("%-12s：%4s：%7s：\n", "商品名", "値段", "ボタン番号");

		for(int s = 0;s < VALUE.length;s++){
			if(!CanPrint[s]){
				//System.out.println(NAME[s] + "\t\t：" + VALUE[s] + "：\t" + (s + 1) + "：\t");
				//System.out.format("%-12s：%5s：%8s：\n", NAME[s], VALUE[s], s+1);
				System.out.printf("%-15s：\t%d：\t\t\t%d：\t\n", NAME[s], VALUE[s], s + 1);
			}
		}


		System.out.println("ボタン番号を入力してください");
		System.out.print(">");
		Scanner inbt = new Scanner(System.in);
		int button = inbt.nextInt();

		return;
	}
}
