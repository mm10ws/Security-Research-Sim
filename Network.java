
/**
 * This class represents the state of the network. 
 * Keep track of each peer in the network.
 * 
 * @author MayurM
 * @version 0.3
 * 
 */

import java.util.*;
public class Network
{
    ArrayList<Peer> peers; //list of peers currently in network
    int numOfPeers;

    public Network(){
        this.peers = new ArrayList<Peer> ();
        this.numOfPeers = 0;

    }

    public void setPeerList(ArrayList<Peer> peers){
        this.peers = peers; 
        this.numOfPeers = peers.size();
    }

    public void setNumOfPeers(int numOfPeers){
        this.numOfPeers = numOfPeers;        
    }
    
    public ArrayList<Peer> getPeerList(){
        return this.peers;
        
    }
    
    public int getNumOfPeers (){
        return this.numOfPeers;
        
    }
    
    public boolean empty(){//checks if there are no peers in network
        
        if(this.getNumOfPeers() == 0){
            return true;
            
        }
        
        else{
            return false;
        }
        
    }
    
    public Peer getPeer(int index){//returns peer in network based on index
        if (index >= 0 && index <= this.peers.size()){
            return peers.get(index);
        }
        else{
            
            return null;
        }
    }
    
    public void addPeer(Peer peer){//add single peer
        
        //      try {
        //          peer.server.join();
        //          //peer.connection.join();
        //      //  peer2.server.join();
        //          //peer2.connection.join();
        //      } catch (InterruptedException e) {
            //          // TODO Auto-generated catch block
            //          e.printStackTrace();
            //      }
        
        if(!this.empty()){
            for(Peer p: this.peers){//add current peers to new peers peer list
                peer.add(p);                
            }
            for(Peer p: this.peers){// add new peer to every existing peers peer list
                p.add(peer);                
            }
        }
        
        
        this.peers.add(peer);
        this.numOfPeers++;//increment number of peers
        
    }
    
    public void addPeers(ArrayList<Peer> peers){//add multiple peers
        for (Peer p : peers){
            this.addPeer(p);
            
        }
    }

}
