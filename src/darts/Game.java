package darts;
import java.util.Scanner;

/**
 *
 * @author jeczm
 */
public class Game {
    Scanner in=new Scanner(System.in);
    int s;
    int l;
    public Game(){
       s= howManySets();
       l= howManyLegs();
    }
    public int howManySets(){
       int c;
       System.out.println("How many sets?");
       c=in.nextInt();
       return c;
    }
    
    public int howManyLegs(){
       int c;
       System.out.println("How many legs?");
       c=in.nextInt();
       return c;
    }
    
     // Stage ending functions
    
    public boolean endLeg(Player p1, Player p2){
        if(p1.finLeg()){    
            p1.rstScore();
            p2.rstScore();
            p1.legCounter();
            System.out.println(p1.name+" wins this leg");
            p1.showScore();
            p2.showScore();
            return true;
        }
        else if(p2.finLeg()){    
            p1.rstScore();
            p2.rstScore();
            p2.legCounter();
            System.out.println(p2.name+" wins this leg");
            p1.showScore();
            p2.showScore();
            return true;
        }
        else {
        p1.showScore();
        p2.showScore();
        return false;
        }
    }
    public boolean endSet(Player p1, Player p2){
        int leg1=p1.showLegs();
        int leg2=p2.showLegs();
            if(Math.abs(leg1-leg2)>1){
                if(p1.finSet()&&leg1>leg2){
                    p1.rstLegs();
                    p2.rstLegs();
                    p1.setCounter();
                    System.out.println(p1.name+" wins this set");
                    p1.showScore();
                    p2.showScore();
                    return true;
                }
                else if(p2.finSet()&&leg2>leg1){
                    p1.rstLegs();
                    p2.rstLegs();
                    p2.setCounter();
                    System.out.println(p2.name+" wins this set");
                    p1.showScore();
                    p2.showScore();
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
    }
    public boolean endGame(Player p1, Player p2){
        if(p1.finGame()){
            System.out.println(p1.name+" WINS THE MATCH");
            p1.showScore();
            p2.showScore();
            return true;
        }
        else if(p2.finGame()){
            System.out.println(p2.name+" WINS THE MATCH");
            p1.showScore();
            p2.showScore();
            return true;
        }
        else
            return false;
    }
    
    //function of one stage
    
    public void leg(Player p1, Player p2){
        for(;;){
            p1.threeDarts();
            if(endLeg(p1,p2))
                break;
            p2.threeDarts();
            if(endLeg(p1,p2))
                break;
        }
    }
    public void reverseLeg(Player p1, Player p2){
        for(;;){
            p2.threeDarts();
            if(endLeg(p1,p2))
                break;
            p1.threeDarts();
            if(endLeg(p1,p2))
                break;
        }
    }
    public void set(Player p1, Player p2){
        for(;;){
            leg(p1,p2);
            if(endSet(p1,p2))
                break;
            reverseLeg(p1,p2);
            if(endSet(p1,p2))
                break;
        }
    }
    public void reverseSet(Player p1, Player p2){
        for(;;){
            reverseLeg(p1,p2);
            if(endSet(p1,p2))
                break;
            leg(p1,p2);
            if(endSet(p1,p2))
                break;
        }
    }
    public void match(Player p1, Player p2){
        for(;;){
            set(p1,p2);
            if(endGame(p1,p2))
                break;
            reverseSet(p1,p2);
            if(endGame(p1,p2))
                break;
        }
    }
    public void play(){
       Player p1=new Player(this.s,this.l);
       Player p2=new Player(this.s,this.l);
       p1.showScore();
       p2.showScore();
           match(p1,p2);
    }
  
}
