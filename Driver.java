
/**
 * Driver to start simulation
 * 
 * @author MayurM
 * @version 0.3
 */
import java.util.*;
import java.io.*;

public class Driver
{
    public static void main(String [] args){
        // check if there are enough arguments
        
        if(args.length != 2){
            String usage = "Usage: java Driver [num of peers] [total messages to send] \n";
            System.out.println(usage);
            return;
        }
        
        //start simulation
        System.out.println("running...");
        
        //initialize new netowork
        Network network = new Network();
        
        //create list for peers
        ArrayList<Peer> test = new ArrayList<Peer>();
        
        
        int numOfPeers = Integer.parseInt(args[0]);
        int numOfMessages = Integer.parseInt(args[1]);
        
        //create all peers
        for(int i = 0; i < numOfPeers; i++){
            Peer p = new Peer(i);
            test.add(p);            
        }
        
        //add each newly created peers to network
        network.addPeers(test);
        
        //used to send messages from a random peer to a random peer
        Random rand = new Random();
        
        //represents size of all messages in network
        //each new connecting peer will have to decrypt all messages to determine if there is a new message
        int messageTotal = 0;
        //stores log of each sent message
        String log = "";
        
        for(int i = 0; i < numOfMessages; i++){
            int to = rand.nextInt(test.size());
            int from = rand.nextInt(test.size());
            
            //sets message size randomly from 1 to 128kB
            int messageSize = rand.nextInt(128) + 1;
            
            //compute total size of messages in network
            messageTotal = messageTotal + messageSize;
            while(from == to){
                //make sure that no peer can send a message to itself
                from = rand.nextInt(test.size());
            }
            
            //send out message
            test.get(from).sendMessage(messageSize, to);
            
            //log the sent message
            log = log + "peer " + from + " sent message of size " + messageSize 
                      + " KB to peer " + to + "\n";
            //System.out.println(messageTotal);
        }
        
        //holds the stats of each peer
        String stat = "";
       
        for(Peer p : network.peers){
            
            //creates the stat string
            stat = stat + p.getState() + "\n";
            
        }
        
        //appends the total message sum to end of stat
        stat = stat + "Total messages size in network: " + messageTotal + " KB \n";
        System.out.println("writing results to file...");
        
        //write stat to file 
        toFile(stat, "stat.txt");
        System.out.println("writing log to file...");
        
        //write log to file
        toFile(log, "log.txt");
        System.out.println("done");
    }
    
    public static void toFile(String s, String name ){
        try{
            File f = new File(name);
            // make the file if its not there 
            
            if (!f.exists()){
                f.createNewFile();
            }

            FileWriter w = new FileWriter(f.getAbsoluteFile());
            BufferedWriter b = new BufferedWriter(w);
            b.write(s);
            b.close();
            //finished writing
        }
        catch(IOException e)
        {
            System.out.println("exception: " + e);
            e.printStackTrace( );
        }
    } 
    
    
}
