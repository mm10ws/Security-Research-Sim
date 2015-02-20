
/**
 * Models the state of a peer
 * @author MayurM
 * @version 0.3
 */

import java.util.*;
public class Peer
{
    //public InputStream input;
	//public Logger log;
	//public OutputStream output;
	//public PeerDriver peerDriver;
	//public peerInfo thisPeer;
    int id; //unique idenifier for each peer
    //list of connected peers. for simplicity this will be every other peer in the network
    ArrayList<Peer> connectedPeers;
    
    //collection of messages intended for this peer
    ArrayList<Message> inbox;
    
    //messages sent from this peer
    ArrayList<Message> sent;  
    
    //the amount of computation time for proof of work. avg 4 min per message
    int PowTime;
    
    int numConnectedPeers;
    /**
    public PeerDriver(int peerID) {
		// TODO Auto-generated constructor stub
		this.peerID = peerID;
		
		this.server= new ServerConnection(this.peerID, this);
		this.nieghbors= new ArrayList<Peer>();
		this.done= false;
	}
	public void startPeer(){
		

		startServer();
		

		startClients();
	

	}
    **/
    public Peer(){
        this.id = 0;
        this.connectedPeers = new ArrayList<Peer>();
        this.inbox = new ArrayList<Message>();
        this.sent = new ArrayList<Message>();
        this.PowTime = 0;
        this.numConnectedPeers = 0; 
        
    }
    
    public Peer(int id){
        this.id = id;
        this.connectedPeers = new ArrayList<Peer>();
        this.inbox = new ArrayList<Message>();
        this.sent = new ArrayList<Message>();
        this.PowTime = 0;
        this.numConnectedPeers = 0; 
        
    }
    
    public int getId(){
        return this.id;
        
    }
    
    public void setId(int id){
        this.id = id;
        
    }
    
    public int getPowTime(){
        return this.PowTime;
        
    }
    
    public void setPowTime(int PowTime){
        this.PowTime = PowTime;
        
    }
    
    public int getInboxSize(){
        int total = 0;
        for(Message m : this.inbox){//add up message size for all received messages
            total = total + m.getSize();
        }
        return total;
    }
    
    public int getSentSize(){
        int total = 0;
        for(Message m : this.sent){//add up message size for all sent messages
            total = total + m.getSize();
        }
        return total;
    }
    
    
    
    public void add(Peer peer){//new peer connectss to this peer        
        this.connectedPeers.add(peer);
        this.numConnectedPeers++;
        
        
    }
    
    public void sendMessage(int size, int toId){
        //send message of given size
        Message m = new Message(size, this.getId(), toId); //create message
        this.sent.add(m); //add this message to this peers sent list
        
        //for all connected peers add this message to the inbox
        //this is done in one step for simplicity
        for(Peer p : this.connectedPeers){
            p.receiveMessage(m);
        }
        
        
    }
    
    public void receiveMessage(Message m){
        //add the input message to this peers inbox
        this.inbox.add(m);
        
        //update the received status of message 
        if(m.getTo() == this.getId()){//acknowledgement
            m.setReceived(true);
        }
    }
    
    public String getState(){ //represents the current state of peer
        
        String s = "Peer ID: " + this.id + "\n";
        s = s + "Received: " + this.inbox.size() + " messages totaling " + this.getInboxSize() + " KB \n";
        s = s + "Sent: " + this.sent.size() + " messages totaling " + this.getSentSize() + " KB \n";
        s = s + "POW time: " + this.totalPow() + " min(s) \n";
        return s;
    }
    
    public int totalPow(){
        return this.sent.size() * 4; //avg 4 min of pow per message
    }
    
    public String toString(){
        String s = "name: " + this.id + "\n";
        s = s + "connections: ";
        
        //print the id of all peers that are connected to this peer
        for (Peer p : this.connectedPeers){
            s = s + p.getId() + " "; 
            
        }
        
        return s;
    }
    
    
}
