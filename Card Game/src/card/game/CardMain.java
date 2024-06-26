
package card.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/*
class Stack{
    String[] data;
    int top=-1;
    int size;
    public Stack(int size) {
        this.size = size;
        data=new String[size];
    }
    boolean isFull(){
        return top==size;
    }
    boolean isEmpty(){
        return top==-1;
    }
    void push(String d){
        if(isFull()){
            System.out.println("Stack full");
            return;
        }
        data[++top]=d;
    }
    String pop(){
        if(isEmpty()){
            System.out.println("Stack empty");
        }
        String d=data[top];
        data[top]=null;
        top--;
        return d;
    }
    String peek(){
        return data[top];
    }
    
}
/*class Rule{
    void add(String existing){
        if(existing.charAt(existing.length()-1)==7){
            System.out.println("Add card which have less number than 7");
        }
        if(existing.charAt(existing.length()-1)==2){
            System.out.println("Add card which have greater number than 2");
        }
        if(existing.charAt(existing.length()-1)==10){
            System.out.println("All cards got vanish");
        }
        if(existing.charAt(existing.length()-1)=='A' ){
            System.out.println("Only add powers(7,2,10)");
        }
        if(existing.charAt(existing.length()-1)=='k'){
            System.out.println("Add greater than Jack or power 10");
        }
        if(existing.charAt(existing.length()-1)=='n' || existing.charAt(existing.length()-1)=='g'){
            System.out.println("Add greater than queen or power 10");
        }
        if(existing.charAt(existing.length()-1)=='g'){
            System.out.println("Add only power (10)");
        }
        System.out.println(existing.charAt(existing.length()-1));
    }
    boolean isTrue(String s1,String s2){
        if(s1.charAt(s1.length()-1)>s2.charAt(s2.length()-1)){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='2' && s2.charAt(s2.length()-1)<2){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='7' && s2.charAt(s2.length()-1)>7){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='A' && (s2.charAt(s2.length()-1)!=7 || s2.charAt(s2.length()-1)!=2 || s2.charAt(s2.length()-1)!='n' || s2.charAt(s2.length()-1)!='k' || s2.charAt(s2.length()-1)!='g')){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='k' && (s2.charAt(s2.length()-1)!=7 || s2.charAt(s2.length()-1)!=2 || s2.charAt(s2.length()-1)!='n' || s2.charAt(s2.length()-1)!='A' || s2.charAt(s2.length()-1)!='g')){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='n' && (s2.charAt(s2.length()-1)!=7 || s2.charAt(s2.length()-1)!=2 || s2.charAt(s2.length()-1)!='A' || s2.charAt(s2.length()-1)!='g')){
            return false;
        }
        if(s1.charAt(s1.length()-1)=='k' && (s2.charAt(s2.length()-1)!=7 || s2.charAt(s2.length()-1)!=2 || s2.charAt(s2.length()-1)!='A')){
            return false;
        }
        return true;
    }
}*/
/**
 *
 * @author S
 */
/*
public class CardMain {
    boolean check(Node P,String deck){
        while(P!=null){
            if(P.data.equals("S2") || P.data.equals("H2") ||P.data.equals("D2") ||P.data.equals("C2") ||P.data.equals("S7") ||P.data.equals("D7") ||P.data.equals("H7") ||P.data.equals("C7") ||P.data.equals("SA") ||P.data.equals("DA") ||P.data.equals("HA") ||P.data.equals("CA") ||P.data.equals("S10") ||P.data.equals("D10") ||P.data.equals("H10") ||P.data.equals("C10")){
                return false;
            }
            if((deck.equals("S7") || deck.equals("D7") || deck.equals("H7") || deck.equals("C7")) && number(P.data)<7){
                return false;
            }
            if(number(P.data)>=number(deck)){
                return false;
            }
            P=P.next;
        }
        return true;
    }
    static boolean check(String d,String deck){
        if((deck.equals("S7") || deck.equals("D7") || deck.equals("H7") || deck.equals("C7")) && number(d)>7){
            return true;
        }
        return (number(d)<number(deck));
    }
    static int number(String d){
        if(d.equals("S2") || d.equals("H2") || d.equals("D2") || d.equals("C2")){
            return 2;
        }
        if(d.equals("S3") || d.equals("H3") || d.equals("D3") || d.equals("C3")){
            return 3;
        }
        if(d.equals("S4") || d.equals("H4") || d.equals("D4") || d.equals("C4")){
            return 4;
        }
        if(d.equals("S5") || d.equals("H5") || d.equals("D5") || d.equals("C5")){
            return 5;
        }
        if(d.equals("S6") || d.equals("H6") || d.equals("D6") || d.equals("C6")){
            return 6;
        }
        if(d.equals("S7") || d.equals("H7") || d.equals("D7") || d.equals("C7")){
            return 7;
        }
        if(d.equals("S8") || d.equals("H8") || d.equals("D8") || d.equals("C8")){
            return 8;
        }
        if(d.equals("S9") || d.equals("H9") || d.equals("D9") || d.equals("C9")){
            return 9;
        }
        if(d.equals("S10") || d.equals("H10") || d.equals("D10") || d.equals("C10")){
            return 10;
        }
        if(d.equals("SJ") || d.equals("HJ") || d.equals("DJ") || d.equals("CJ")){
            return 20;
        }
        if(d.equals("SQ") || d.equals("HQ") || d.equals("DQ") || d.equals("CQ")){
            return 30;
        }
        if(d.equals("SK") || d.equals("HK") || d.equals("DK") || d.equals("CK")){
            return 40;
        }
        if(d.equals("SA") || d.equals("HA") || d.equals("DA") || d.equals("CA")){
            return 50;
        }
        return 0;
    }
    Node head;
    Node tail;
    class Node{
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        } 
    }
    void add(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        Node currNode=tail;
        currNode.next=newNode;
        tail=newNode;
    }
    String delete(String data){
        Node currNode=head;
        Node perNode =head;
        if(head.data.equals(data)){
            head=head.next;
            return currNode.data;
        }
        while(!currNode.data.equals(data)){
            perNode=currNode;
            currNode=currNode.next;
        }
        perNode.next=currNode.next;
        String d=currNode.data;
        return d;
    }
    void print(){
        Node currNode=head;
        while(currNode!=null){
            System.out.println(currNode.data);
            currNode=currNode.next;
        }
    }
    boolean search(String d){
        Node currNode=head;
        while(currNode!=null){
            if(currNode.data.equals(d)){
                return true;
            }
            currNode=currNode.next;
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
/*
    public static void main(String args[]) {
        // TODO code application logic here
        String card[]={"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
                         "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
                         "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
                         "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"};
        ArrayList num=new ArrayList();
        for(int i=0;i<52;i++){
            num.add(i);
        }
        Collections.shuffle(num);
        Stack stack=new Stack(52);
        for(int i=0;i<52;i++){
            stack.push(card[(int)num.get(i)]);
        }
        Stack deck=new Stack(52);
        ArrayList<String> Phidden1=new ArrayList();
        ArrayList<String> Phidden2=new ArrayList();
        ArrayList<String> Phidden3=new ArrayList();
        ArrayList<String> Phidden4=new ArrayList();
        ArrayList<String> Pd1=new ArrayList();
        ArrayList<String> Pd2=new ArrayList();
        ArrayList<String> Pd3=new ArrayList();
        ArrayList<String> Pd4=new ArrayList();
        CardMain P1=new CardMain();
        CardMain P2=new CardMain();
        CardMain P3=new CardMain();
        CardMain P4=new CardMain();
        for(int i=0;i<9;i++){
            if(i<3){
                Phidden1.add(stack.pop());
                Phidden2.add(stack.pop());
                Phidden3.add(stack.pop());
                Phidden4.add(stack.pop());
            }
            if(i>2 && i<6){
                Pd1.add(stack.pop());
                Pd2.add(stack.pop());
                Pd3.add(stack.pop());
                Pd4.add(stack.pop());
            }
            else{
                P1.add(stack.pop());
                P2.add(stack.pop());
                P3.add(stack.pop());
                P4.add(stack.pop());
            }
        }
        Scanner s=new Scanner(System.in);
        while(!deck.isEmpty()){
            deck.pop();
        }
        for(int count=1;count>0;count++){
            if(count%4==1){
                System.out.println("\t\t---PLAYER 1---");
                if(!deck.isEmpty()){
                    System.out.println("\tDeck last card "+deck.peek());
                }
                if(Pd1.isEmpty()){
                    System.out.println("Choose one hidden card:");
                    for(int i=0;i<Phidden1.size();i++){
                        System.out.println((i+1)+" card");
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Phidden1.get(i));
                        Phidden1.remove(i);
                    }
                    else if(check(Phidden1.get(i),deck.peek())){
                        deck.push(Phidden1.get(i));
                        while(!deck.isEmpty()){
                            P1.add(deck.pop());
                        }
                        Phidden1.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Phidden1.get(i).equals("S10") || Phidden1.get(i).equals("D10") || Phidden1.get(i).equals("H10") || Phidden1.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Phidden1.remove(i);
                        }
                        else if(Phidden1.get(i).equals("S2") || Phidden1.get(i).equals("D2") || Phidden1.get(i).equals("H2") || Phidden1.get(i).equals("C2") || Phidden1.get(i).equals("S7") || Phidden1.get(i).equals("H7") || Phidden1.get(i).equals("D7") || Phidden1.get(i).equals("C7") || Phidden1.get(i).equals("SA") || Phidden1.get(i).equals("HA") || Phidden1.get(i).equals("DA") || Phidden1.get(i).equals("CA")){
                            deck.push(Phidden1.get(i));
                            Phidden1.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Phidden1.get(i))<7){
                            deck.push(Phidden1.get(i));
                            Phidden1.remove(i);
                        }
                        else if(number(Phidden1.get(i))>=number(deck.peek())){
                            deck.push(Phidden1.get(i));
                            Phidden1.remove(i);
                        }
                    }
                    if(Phidden1.isEmpty()){
                        break;
                    }
                }
                else if(P1.head==null){
                    System.out.println("Choose one card:");
                    for(int i=0;i<Pd1.size();i++){
                        System.out.println((i+1)+Pd1.get(i));
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Pd1.get(i));
                        Pd1.remove(i);
                    }
                    else if(check(Pd1.get(i),deck.peek())){
                        deck.push(Pd1.get(i));
                        while(!deck.isEmpty()){
                            P1.add(deck.pop());
                        }
                        Pd1.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Pd1.get(i).equals("S10") || Pd1.get(i).equals("D10") || Pd1.get(i).equals("H10") || Pd1.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Pd1.remove(i);
                        }
                        else if(Pd1.get(i).equals("S2") || Pd1.get(i).equals("D2") || Pd1.get(i).equals("H2") || Pd1.get(i).equals("C2") || Pd1.get(i).equals("S7") || Pd1.get(i).equals("H7") || Pd1.get(i).equals("D7") || Pd1.get(i).equals("C7") || Pd1.get(i).equals("SA") || Pd1.get(i).equals("HA") || Pd1.get(i).equals("DA") || Pd1.get(i).equals("CA")){
                            deck.push(Pd1.get(i));
                            Pd1.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Pd1.get(i))<7){
                            deck.push(Pd1.get(i));
                            Pd1.remove(i);
                        }
                        else if(number(Pd1.get(i))>=number(deck.peek())){
                            deck.push(Pd1.get(i));
                            Pd1.remove(i);
                        }
                    }
                }
                else if(deck.isEmpty()){
                    System.out.println("Choose one card to add");
                    P1.print();
                    while(true){
                        String input=s.next();
                        if(P1.search(input)){
                            deck.push(P1.delete(input));
                            break;
                        }
                        System.out.println("Invalid card");
                    }
                    if(!stack.isEmpty()){
                        P1.add(stack.pop());
                    }
                }
                else if(P1.check(P1.head,deck.peek())){
                    while(!deck.isEmpty()){
                        P1.add(deck.pop());
                    }
                    System.out.println("All Card Added To Your Hand");
                }
                else{
                    System.out.println("Choose one card to add");
                    P1.print();
                    while(true){
                        String input=s.next();
                        if(P1.search(input)){
                            if(input.equals("S10") || input.equals("D10") || input.equals("H10") || input.equals("C10")){
                                while(!deck.isEmpty()){
                                    deck.pop();
                                }
                                P1.delete(input);
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(input.equals("S2") || input.equals("D2") || input.equals("H2") || input.equals("C2") || input.equals("S7") || input.equals("H7") || input.equals("D7") || input.equals("C7") || input.equals("SA") || input.equals("HA") || input.equals("DA") || input.equals("CA")){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(input)<7){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(number(input)>=number(deck.peek())){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                        }
                        System.out.println("Invalid card");
                    }
                }
            }
            else if(count%4==2){
                System.out.println("\t\t---PLAYER 2---");
                if(!deck.isEmpty()){
                    System.out.println("\tDeck last card "+deck.peek());
                }
                if(Pd2.isEmpty()){
                    System.out.println("Choose one hidden card:");
                    for(int i=0;i<Phidden2.size();i++){
                        System.out.println((i+1)+" card");
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Phidden2.get(i));
                        Phidden2.remove(i);
                    }
                    else if(check(Phidden2.get(i),deck.peek())){
                        deck.push(Phidden2.get(i));
                        while(!deck.isEmpty()){
                            P2.add(deck.pop());
                        }
                        Phidden2.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Phidden2.get(i).equals("S10") || Phidden2.get(i).equals("D10") || Phidden2.get(i).equals("H10") || Phidden2.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Phidden2.remove(i);
                        }
                        else if(Phidden2.get(i).equals("S2") || Phidden2.get(i).equals("D2") || Phidden2.get(i).equals("H2") || Phidden2.get(i).equals("C2") || Phidden2.get(i).equals("S7") || Phidden2.get(i).equals("H7") || Phidden2.get(i).equals("D7") || Phidden2.get(i).equals("C7") || Phidden2.get(i).equals("SA") || Phidden2.get(i).equals("HA") || Phidden2.get(i).equals("DA") || Phidden2.get(i).equals("CA")){
                            deck.push(Phidden2.get(i));
                            Phidden2.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Phidden2.get(i))<7){
                            deck.push(Phidden2.get(i));
                            Phidden2.remove(i);
                        }
                        else if(number(Phidden2.get(i))>=number(deck.peek())){
                            deck.push(Phidden2.get(i));
                            Phidden2.remove(i);
                        }
                    }
                    if(Phidden2.isEmpty()){
                        break;
                    }
                }
                else if(P2.head==null){
                    System.out.println("Choose one card:");
                    for(int i=0;i<Pd2.size();i++){
                        System.out.println((i+1)+Pd2.get(i));
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Pd2.get(i));
                        Pd2.remove(i);
                    }
                    else if(check(Pd2.get(i),deck.peek())){
                        deck.push(Pd2.get(i));
                        while(!deck.isEmpty()){
                            P2.add(deck.pop());
                        }
                        Pd2.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Pd2.get(i).equals("S10") || Pd2.get(i).equals("D10") || Pd2.get(i).equals("H10") || Pd2.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Pd2.remove(i);
                        }
                        else if(Pd2.get(i).equals("S2") || Pd2.get(i).equals("D2") || Pd2.get(i).equals("H2") || Pd2.get(i).equals("C2") || Pd2.get(i).equals("S7") || Pd2.get(i).equals("H7") || Pd2.get(i).equals("D7") || Pd2.get(i).equals("C7") || Pd2.get(i).equals("SA") || Pd2.get(i).equals("HA") || Pd2.get(i).equals("DA") || Pd2.get(i).equals("CA")){
                            deck.push(Pd2.get(i));
                            Pd2.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Pd2.get(i))<7){
                            deck.push(Pd2.get(i));
                            Pd2.remove(i);
                        }
                        else if(number(Pd2.get(i))>=number(deck.peek())){
                            deck.push(Pd2.get(i));
                            Pd2.remove(i);
                        }
                    }
                }
                else if(deck.isEmpty()){
                    System.out.println("Choose one card to add");
                    P2.print();
                    while(true){
                        String input=s.next();
                        if(P2.search(input)){
                            deck.push(P2.delete(input));
                            break;
                        }
                        System.out.println("Invalid card");
                    }
                    if(!stack.isEmpty()){
                        P1.add(stack.pop());
                    }
                }
                else if(P2.check(P2.head,deck.peek())){
                    while(!deck.isEmpty()){
                        P2.add(deck.pop());
                    }
                    System.out.println("All Card Added To Your Hand");
                }
                else{
                    System.out.println("Choose one card to add");
                    P2.print();
                    while(true){
                        String input=s.next();
                        if(P2.search(input)){
                            if(input.equals("S10") || input.equals("D10") || input.equals("H10") || input.equals("C10")){
                                while(!deck.isEmpty()){
                                    deck.pop();
                                }
                                P2.delete(input);
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(input.equals("S2") || input.equals("D2") || input.equals("H2") || input.equals("C2") || input.equals("S7") || input.equals("H7") || input.equals("D7") || input.equals("C7") || input.equals("SA") || input.equals("HA") || input.equals("DA") || input.equals("CA")){
                                deck.push(P2.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(input)<7){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(number(input)>=number(deck.peek())){
                                deck.push(P2.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                        }
                        System.out.println("Invalid card");
                    }
                }
            }
            else if(count%4==3){
                System.out.println("\t\t---PLAYER 3---");
                if(!deck.isEmpty()){
                    System.out.println("\tDeck last card "+deck.peek());
                }
                if(Pd3.isEmpty()){
                    System.out.println("Choose one hidden card:");
                    for(int i=0;i<Phidden3.size();i++){
                        System.out.println((i+1)+" card");
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Phidden3.get(i));
                        Phidden3.remove(i);
                    }
                    else if(check(Phidden3.get(i),deck.peek())){
                        deck.push(Phidden3.get(i));
                        while(!deck.isEmpty()){
                            P3.add(deck.pop());
                        }
                        Phidden3.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Phidden3.get(i).equals("S10") || Phidden3.get(i).equals("D10") || Phidden3.get(i).equals("H10") || Phidden3.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Phidden3.remove(i);
                        }
                        else if(Phidden3.get(i).equals("S2") || Phidden3.get(i).equals("D2") || Phidden3.get(i).equals("H2") || Phidden3.get(i).equals("C2") || Phidden3.get(i).equals("S7") || Phidden3.get(i).equals("H7") || Phidden3.get(i).equals("D7") || Phidden3.get(i).equals("C7") || Phidden3.get(i).equals("SA") || Phidden3.get(i).equals("HA") || Phidden3.get(i).equals("DA") || Phidden3.get(i).equals("CA")){
                            deck.push(Phidden3.get(i));
                            Phidden3.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Phidden3.get(i))<7){
                            deck.push(Phidden3.get(i));
                            Phidden3.remove(i);
                        }
                        else if(number(Phidden3.get(i))>=number(deck.peek())){
                            deck.push(Phidden3.get(i));
                            Phidden3.remove(i);
                        }
                    }
                    if(Phidden3.isEmpty()){
                        break;
                    }
                }
                else if(P3.head==null){
                    System.out.println("Choose one card:");
                    for(int i=0;i<Pd3.size();i++){
                        System.out.println((i+1)+Pd3.get(i));
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Pd3.get(i));
                        Pd3.remove(i);
                    }
                    else if(check(Pd3.get(i),deck.peek())){
                        deck.push(Pd3.get(i));
                        while(!deck.isEmpty()){
                            P3.add(deck.pop());
                        }
                        Pd3.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Pd3.get(i).equals("S10") || Pd3.get(i).equals("D10") || Pd3.get(i).equals("H10") || Pd3.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Pd3.remove(i);
                        }
                        else if(Pd3.get(i).equals("S2") || Pd3.get(i).equals("D2") || Pd3.get(i).equals("H2") || Pd3.get(i).equals("C2") || Pd3.get(i).equals("S7") || Pd3.get(i).equals("H7") || Pd3.get(i).equals("D7") || Pd3.get(i).equals("C7") || Pd3.get(i).equals("SA") || Pd3.get(i).equals("HA") || Pd3.get(i).equals("DA") || Pd3.get(i).equals("CA")){
                            deck.push(Pd3.get(i));
                            Pd3.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Pd3.get(i))<7){
                            deck.push(Pd3.get(i));
                            Pd3.remove(i);
                        }
                        else if(number(Pd3.get(i))>=number(deck.peek())){
                            deck.push(Pd3.get(i));
                            Pd3.remove(i);
                        }
                    }
                }
                else if(deck.isEmpty()){
                    System.out.println("Choose one card to add");
                    P3.print();
                    while(true){
                        String input=s.next();
                        if(P3.search(input)){
                            deck.push(P3.delete(input));
                            break;
                        }
                        System.out.println("Invalid card");
                    }
                    if(!stack.isEmpty()){
                        P1.add(stack.pop());
                    }   
                }
                else if(P3.check(P3.head,deck.peek())){
                    while(!deck.isEmpty()){
                        P3.add(deck.pop());
                    }
                    System.out.println("All Card Added To Your Hand");
                }
                else{
                    System.out.println("Choose one card to add");
                    P3.print();
                    while(true){
                        String input=s.next();
                        if(P3.search(input)){
                            if(input.equals("S10") || input.equals("D10") || input.equals("H10") || input.equals("C10")){
                                while(!deck.isEmpty()){
                                    deck.pop();
                                }
                                P3.delete(input);
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(input.equals("S2") || input.equals("D2") || input.equals("H2") || input.equals("C2") || input.equals("S7") || input.equals("H7") || input.equals("D7") || input.equals("C7") || input.equals("SA") || input.equals("HA") || input.equals("DA") || input.equals("CA")){
                                deck.push(P3.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(input)<7){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(number(input)>=number(deck.peek())){
                                deck.push(P3.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                        }
                        System.out.println("Invalid card");
                    }
                }
            }
            else if(count%4==0){
                System.out.println("\t\t---PLAYER 4---");
                if(!deck.isEmpty()){
                    System.out.println("\tDeck last card "+deck.peek());
                }
                if(Pd4.isEmpty()){
                    System.out.println("Choose one hidden card:");
                    for(int i=0;i<Phidden4.size();i++){
                        System.out.println((i+1)+" card");
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Phidden4.get(i));
                        Phidden4.remove(i);
                    }
                    else if(check(Phidden4.get(i),deck.peek())){
                        deck.push(Phidden4.get(i));
                        while(!deck.isEmpty()){
                            P4.add(deck.pop());
                        }
                        Phidden4.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Phidden4.get(i).equals("S10") || Phidden4.get(i).equals("D10") || Phidden4.get(i).equals("H10") || Phidden4.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Phidden4.remove(i);
                        }
                        else if(Phidden4.get(i).equals("S2") || Phidden4.get(i).equals("D2") || Phidden4.get(i).equals("H2") || Phidden4.get(i).equals("C2") || Phidden4.get(i).equals("S7") || Phidden4.get(i).equals("H7") || Phidden4.get(i).equals("D7") || Phidden4.get(i).equals("C7") || Phidden4.get(i).equals("SA") || Phidden4.get(i).equals("HA") || Phidden4.get(i).equals("DA") || Phidden4.get(i).equals("CA")){
                            deck.push(Phidden4.get(i));
                            Phidden4.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Phidden4.get(i))<7){
                            deck.push(Phidden4.get(i));
                            Phidden4.remove(i);
                        }
                        else if(number(Phidden4.get(i))>=number(deck.peek())){
                            deck.push(Phidden4.get(i));
                            Phidden4.remove(i);
                        }
                    }
                    if(Phidden4.isEmpty()){
                        break;
                    }
                }
                else if(P4.head==null){
                    System.out.println("Choose one card:");
                    for(int i=0;i<Pd4.size();i++){
                        System.out.println((i+1)+Pd4.get(i));
                    }
                    int i=s.nextInt()-1;
                    if(deck.isEmpty()){
                        deck.push(Pd4.get(i));
                        Pd4.remove(i);
                    }
                    else if(check(Pd4.get(i),deck.peek())){
                        deck.push(Pd4.get(i));
                        while(!deck.isEmpty()){
                            P4.add(deck.pop());
                        }
                        Pd4.remove(i);
                        System.out.println("All Card Added To Your Hand");
                    }
                    else{
                        if(Pd4.get(i).equals("S10") || Pd4.get(i).equals("D10") || Pd4.get(i).equals("H10") || Pd4.get(i).equals("C10")){
                            while(!deck.isEmpty()){
                                deck.pop();
                            }
                            Pd4.remove(i);
                        }
                        else if(Pd4.get(i).equals("S2") || Pd4.get(i).equals("D2") || Pd4.get(i).equals("H2") || Pd4.get(i).equals("C2") || Pd4.get(i).equals("S7") || Pd4.get(i).equals("H7") || Pd4.get(i).equals("D7") || Pd4.get(i).equals("C7") || Pd4.get(i).equals("SA") || Pd4.get(i).equals("HA") || Pd4.get(i).equals("DA") || Pd4.get(i).equals("CA")){
                            deck.push(Pd4.get(i));
                            Pd4.remove(i);
                        }
                        else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(Pd4.get(i))<7){
                            deck.push(Pd4.get(i));
                            Pd4.remove(i);
                        }
                        else if(number(Pd4.get(i))>=number(deck.peek())){
                            deck.push(Pd4.get(i));
                            Pd4.remove(i);
                        }
                    }
                }
                else if(deck.isEmpty()){
                    System.out.println("Choose one card to add");
                    P4.print();
                    while(true){
                        String input=s.next();
                        if(P4.search(input)){
                            deck.push(P4.delete(input));
                            break;
                        }
                        System.out.println("Invalid card");
                    }
                    if(!stack.isEmpty()){
                        P1.add(stack.pop());
                    }
                }
                else if(P4.check(P4.head,deck.peek())){
                    while(!deck.isEmpty()){
                        P4.add(deck.pop());
                    }
                    System.out.println("All Card Added To Your Hand");
                }
                else{
                    System.out.println("Choose one card to add");
                    P4.print();
                    while(true){
                        String input=s.next();
                        if(P4.search(input)){
                            if(input.equals("S10") || input.equals("D10") || input.equals("H10") || input.equals("C10")){
                                while(!deck.isEmpty()){
                                    deck.pop();
                                }
                                P4.delete(input);
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(input.equals("S2") || input.equals("D2") || input.equals("H2") || input.equals("C2") || input.equals("S7") || input.equals("H7") || input.equals("D7") || input.equals("C7") || input.equals("SA") || input.equals("HA") || input.equals("DA") || input.equals("CA")){
                                deck.push(P4.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if((deck.peek().equals("S7") || deck.peek().equals("H7") || deck.peek().equals("D7") || deck.peek().equals("C7")) && number(input)<7){
                                deck.push(P1.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                            else if(number(input)>=number(deck.peek())){
                                deck.push(P4.delete(input));
                                if(!stack.isEmpty()){
                                    P1.add(stack.pop());
                                }
                                break;
                            }
                        }
                        System.out.println("Invalid card");
                    }
                }
            }
        }
        if(Phidden1.isEmpty()){
            System.out.println("Player 1 Wins");
        }
        if(Phidden2.isEmpty()){
            System.out.println("Player 2 Wins");
        }
        if(Phidden3.isEmpty()){
            System.out.println("Player 3 Wins");
        }
        if(Phidden4.isEmpty()){
            System.out.println("Player 4 Wins");
        }
    }
}
*/