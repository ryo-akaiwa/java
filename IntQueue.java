package algo;
//@author RYO
public class IntQueue {
    private int max;  //キューの容量
    private int front;  //先頭要素のカーソル
    private int rear;  //末尾要素のカーソル
    private int num;  //現在のデータ数
    private int[] que;  //キューの本体
    
    //例外：キューが空
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){ }
    }
    //例外：キューが満杯
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){ }
    }
    
    //コンストラクタ
    public IntQueue(int capacity){
        num=front=rear=0;
        max=capacity;
        try{
            que=new int[max];
        }catch (OutOfMemoryError e){
            max=0;
        }
    }
    
    //キューにデータを入れる
    public int enque(int x) throws OverflowIntQueueException{
        if(num>=max)
            throw new OverflowIntQueueException();
        que[rear]=x;
        rear++;
        num++;
        if(rear==max)
            rear=0;
        return x;
    }
    
    //キューからデータを出す
    public int deque() throws EmptyIntQueueException{
        if(num<=0)
            throw new EmptyIntQueueException();
        int x=que[front];
        front++;
        num--;
        if(front==max)
            front=0;
        return x;
    }
    
    //キューからデータをピーク
    public int quepeek() throws EmptyIntQueueException{
        if(num<=0)
            throw new EmptyIntQueueException();
        return que[front];
    }
    
    //キューからデータを探索
    public int queindexOf(int x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max;
            if(que[idx]==x)
                return idx;
        }
        return -1;
    }
    
    //キューを空にする
    public void queclear(){
        num=front=rear=0;
    }
    
    //キューの容量の返却
    public int quecapacity(){
        return max;
    }
    
    //キューにあるデータ数の返却
    public int quesize(){
        return num;
    }
    
    //キューのデータを表示
    public void quedump(){
        if(num<=0)
            System.out.println("キューは空です。");
        else{
            for(int i=0;i<num;i++)
                System.out.print(que[(i+front)%max]+" ");
            System.out.println();
        }
    }
}
