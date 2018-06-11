package darts;
import java.util.Scanner;


/**
 * @author jeczm
 */
public class Player{
    private int numSets;
    private int numLegs;
    private boolean lostDarts;
    private int sets;
    private int legs;
    private int score;
    public String name;
    Scanner in=new Scanner(System.in);
    
    // interface functions
    
     public void showScore(){
        System.out.println("name: "+this.name);
        System.out.println("Sets:  Legs:  Score");
        System.out.println(this.sets+"       "+this.legs+"       "+this.score);
    }    
    public void setName(){
       System.out.println("Enter name:");
       this.name=in.nextLine();
    }
    public void greetings(){
        System.out.println("Hello "+this.name );
    }
    public int getScore(){
        System.out.println("What was the score?");
        int sc;
        sc=in.nextInt();
        return sc;
    }
    public int showLegs(){
        return this.legs;
    }  
    public int showSets(){
        return this.sets;
    }
    //reseting functions
    
    public void rstScore(){
        this.score=501;
    }
    public void rstLegs(){
        this.legs=0;
    }
    public void rstSets(){
        this.sets=0;
    }
    
    //counters
    
    public void scoreCounter(int sc){
        if (this.score>=sc){
            if((this.score-sc)!=1){
                this.score=this.score-sc;
            }
            else{
                System.out.println("LOST DARTS");
                this.lostDarts=true;
            }
        }
        else{
            System.out.println("LOST DARTS");
            this.lostDarts=true;
        }
    }
    public void legCounter(){
            this.legs=this.legs+1;  
    } 
    public void setCounter(){
            this.sets=this.sets+1;
    }
    
    // One sequence darts fuction
    
    public void threeDarts(){
        int sc;
        System.out.println("It's "+this.name+"'s turn");
            for(int i=0;i<3;i++){
               sc=this.getScore();
               this.scoreCounter(sc);
               if(this.lostDarts)
                   break;
               if(this.finLeg())
                   break;
            }
    }
    
    // flags for ending game stage
    
    public boolean finGame(){
        return this.sets == this.numSets;
    }
    public boolean finSet(){
        return this.legs >= this.numLegs;
    }
    public boolean finLeg(){
        return this.score == 0;
    }

    //Player constructor

    public Player(int sets, int legs){
        this.numLegs=legs;
        this.numSets=sets;
        this.setName();
        this.greetings();
        this.rstScore();
        this.rstLegs();
        this.rstSets();
    }  
}