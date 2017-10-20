package algo;
//@author RYO
public class IntStack {
    private int max;  //スタックのmaxの容量
    private int ptr;  //スタックのポインタ
    private int[] stk;  //スタック本体の配列
    
    //例外処理：スタックが空
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() {}
    }
    //例外処理：スタックが満杯
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {}
    }
    public IntStack(int capacity){
        ptr=0;
        max=capacity;
        try{
            stk=new int[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }
    //スタックのプッシュ
    public int push(int x) throws OverflowIntStackException{
        int pu;
        if(ptr>=max)
            throw new OverflowIntStackException();
        stk[ptr]=x;
        ptr++;
        return stk[ptr];
    }
    //スタックのポップ
    public int pop() throws EmptyIntStackException{
        if(ptr<=0)
            throw new EmptyIntStackException();
        --ptr;
        return stk[ptr];
    }
    //スタックのピーク
    public int peek() throws EmptyIntStackException{
        if(ptr<=0)
            throw new EmptyIntStackException();
        return stk[ptr-1];
    }
    //スタックを空にする
    public void clear(){
        ptr=0;
    }
    //スタックの容量
    public int capacity(){
        return max;
    }
    //スタックのデータの数
    public int size(){
        return ptr;
    }
    //スタックのダンプ
    public void dump(){
        if(ptr<=0)
            System.out.println("スタックは空です。");
        else{
            for(int i=0;i<ptr;i++)
                System.out.print(stk[i]+" ");
            System.out.println();
        }
    }
}
