package algo;
//@author RYO
import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args){
        Scanner stdIn=new Scanner(System.in);
        IntQueue s=new IntQueue(64);
        
        while(true){
            System.out.println("現在のデータ数："+s.quesize()+"/"+s.quecapacity());
            System.out.print("(1)エンキュー (2)デキュー (3)ピーク (4)ダンプ (5)探索 (0)終了：");
            int menu=stdIn.nextInt();
            if(menu==0)
                break;
            
            int x;
            switch(menu){
                case 1:  //エンキュー
                    System.out.print("データ：");
                    x=stdIn.nextInt();
                    try{
                        s.enque(x);
                    }catch(IntQueue.OverflowIntQueueException e){
                        System.out.println("キューが満杯です。");
                    }
                    break;
                    
                case 2:  //デキュー
                    try{
                        x=s.deque();
                        System.out.println("デキューしたデータは"+x+"です。");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("キューが空です。");
                    }
                    break;
                    
                case 3:  //ピーク
                    try{
                        x=s.quepeek();
                        System.out.println("ピークしたデータは"+x+"です。");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("キューが空です。");
                    }
                    break;
                    
                case 4:  //ダンプ
                    s.quedump();
                    break;
                
                case 5:  //探索
                    int a=0;
                    System.out.print("探索したいデータ：");
                    x=stdIn.nextInt();
                    a=s.queindexOf(x);
                    if(a==-1)
                        System.out.println("そのデータはありません。");
                    else
                        System.out.println("データ"+x+"は、"+a+"にあります。");
                    break;
            }
        }
    }
}
