//チェイン法
package algo;
//@author RYO
public class ChainHash<K,V> {
    //ハッシュの構成
    class Node<K,V>{
        private K key; //キー値
        private V data; //データ
        private Node<K,V> next; //後続ノード
        
        //コンストラクタ
        Node(K key,V data,Node<K,V> next){
            this.key=key;
            this.data=data;
            this.next=next;
        }
        //キー値の返却
        K getKey(){
            return key;
        }
        //データの返却
        V getValue(){
            return data;
        }
        //キーのハッシュの返却
        public int hashCode(){
            return key.hashCode();
        }
    }
    
    private int size; //ハッシュ表の大きさ
    private Node<K,V>[] table; //ハッシュ表
    
    //コンストラクタ
    public ChainHash(int capacity){
        try{
            table=new Node[capacity];
            this.size=capacity;
        }catch(OutOfMemoryError e){
            this.size=0;
        }
    }
    
    //ハッシュ値を求める
    public int hashValue(Object key){
        return key.hashCode()%size;
    }
    
    //キー値を持つデータの探索
    public V search(K key){
        int hash=hashValue(key);
        Node<K,V> p=table[hash];
        
        while(p !=null){//ハッシュ値が0以外
            if(p.getKey().equals(key))
                return p.getValue(); //探索成功
            p=p.next;
        }
        return null; //探索失敗
        }
    
    //キー値、データの追加
    public int add(K key,V data){
        int hash=hashValue(key);
        Node<K,V> p=table[hash];
        
        while(p != null){
            if(p.getKey().equals(key))
                return 1;
            p=p.next;
        }
        Node<K,V> temp=new Node<K,V>(key,data,table[hash]);
        table[hash]=temp; //ノードを挿入
        return 0;
    }
    
    //ノードの削除
    public int remove(K key){
        int hash=hashValue(key); //削除するデータのハッシュ値
        Node<K,V> p=table[hash]; //着目ノード
        Node<K,V> pp=null; //前回の着目ノード
        
        while(p != null){
            if(p.getKey().equals(key)){
                if(pp==null)
                    table[hash]=p.next;
                else
                    pp.next=p.next;
                return 0;
            }
            pp=p;
            p=p.next;
        }
        return 1;
    }
    
    //ハッシュ表のダンプ
    public void dump(){
        for(int i=0;i<size;i++){
            Node<K,V> p=table[i];
            System.out.printf("%02d　",i);
            while(p !=null){
                System.out.printf("→%s (%s)　",p.getKey(),p.getValue());
                p=p.next;
            }
            System.out.println();
        }
    }
}
