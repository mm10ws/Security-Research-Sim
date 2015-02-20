
/**
 * models the state of a single message
 * 
 * @author MayurM
 * @version 0.3
 */
public class Message
{
   //the size of message.max 128 kB
   int size;
   
   //represents the acknowledgement 
   boolean received;
   
   
   int fromId;
   int toId;
   
   public Message(){
       this.size = 10;
       this.received = false;
       
       //default is negative since peers start with 0
       this.fromId = -1;
       this.toId = -1;
       
    }
    
   public Message(int size, int fromId, int toId){
        this.size = size;
        this.fromId = fromId;
        this.toId = toId;
        
    }
    
   public void setSize(int size){
       this.size = size;
    }
    
   public void setReceived(boolean received){
       this.received = received;
    } 
    
   public void setFrom(int fromId){
       this.fromId = fromId;
    }  
    
   public void setTo(int toId){
       this.toId = toId;
    }  
    
   public int getSize(){
       return this.size;
       
    }
    
   public boolean getReceived(){
       return this.received;
       
    } 
    
   public int getFrom(){
       return this.fromId;
       
    } 
    
   public int getTo(){
       return this.toId;
       
    }  
    
   /** 
   // Gets 4-byte message length and returns a length integer
    public static int intepretLength(byte[] length) {
        int l = 0;
        for (int x = 0; x < 4; x++)
            l = (l << 8) | (length[x] & 0xFF);
        return l;
    }
    public static byte[] intTo4ByteArray(int i) {
        byte[] b = new byte[4];
        long n = i;
        b[0] = (byte) ((n >> 24) & 0xFF);
        b[1] = (byte) ((n >> 16) & 0xFF);
        b[2] = (byte) ((n >> 8) & 0xFF);
        b[3] = (byte) (n & 0xFF);
        return b;
    }

    public static int[] byteAtoIntA(byte[] b){
        IntBuffer intBuf =
                ByteBuffer.wrap(b)
                .order(ByteOrder.BIG_ENDIAN)
                .asIntBuffer();
        int[] array = new int[intBuf.remaining()];
        intBuf.get(array);
        return array;

    }
    **/
 
}
