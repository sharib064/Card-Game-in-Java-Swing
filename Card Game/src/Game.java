import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
class list {
    Node head,tail;
    class Node{
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
        }
    }
    void add(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    } 
    void deleteNode(String key){
        Node temp = head, prev = null;
        if (temp != null && temp.data.equals(key)) {
            head = temp.next;
            return;
        }
        while (temp != null && !temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null){
            return;
        }
        prev.next = temp.next;
    }
}
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
/**
 *
 * @author S
 */
public  class Game extends javax.swing.JFrame {
    int num=1;
    Stack s;
    Stack deck;
    list p1=new list();
    list p2=new list();
    list p3=new list();
    list p4=new list();
    final boolean check(String s){
        if(s.equals("S2") || s.equals("H2") ||s.equals("D2") ||s.equals("C2") ||s.equals("S7") ||s.equals("D7") ||s.equals("H7") ||s.equals("C7") ||s.equals("SA") ||s.equals("DA") ||s.equals("HA") ||s.equals("CA") ||s.equals("S10") ||s.equals("D10") ||s.equals("H10") ||s.equals("C10")){
            return true;
        }
        return (number(s)>=number(deck.peek()));
    }
    final boolean check(list.Node currNode){
        while(currNode!=null){
            if((deck.peek().equals("S7") || deck.peek().equals("C7") || deck.peek().equals("D7") || deck.peek().equals("H7")) && number(currNode.data)<7){
                return false;
            }
            if(currNode.data.equals("S2") || currNode.data.equals("H2") ||currNode.data.equals("D2") ||currNode.data.equals("C2") ||currNode.data.equals("S7") ||currNode.data.equals("D7") ||currNode.data.equals("H7") ||currNode.data.equals("C7") ||currNode.data.equals("SA") ||currNode.data.equals("DA") ||currNode.data.equals("HA") ||currNode.data.equals("CA") ||currNode.data.equals("S10") ||currNode.data.equals("D10") ||currNode.data.equals("H10") ||currNode.data.equals("C10")){
                return false;
            }
            if(number(currNode.data)>=number(deck.peek())){
                return false;
            }
        }
        return true;
    }
    final int number(String d){
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
    final void Player(){
        winner();
        if(num%4==1){
            player2.setText("PLAYER  1");
            ins.setText("Choose one card");
            list.Node currNode=p1.head;
            for(int i=0;i<18;i++){
                if(currNode==null){
                    imageC("Sharib",i+1);
                }
                else{
                    imageC(currNode.data,i+1);
                    currNode=currNode.next;
                }
            }
            if(!deck.isEmpty()){
                if(check(p1.head)){
                    ins.setText("Don't have greater value card");
                    while(!deck.isEmpty()){
                        p1.add(deck.pop());
                    }
                    for(int i=0;i<1000;i++){

                    }
                    ins.setText("All cards added to your hand");
                }
            }
        }
        else if(num%4==2){
            player2.setText("PLAYER  2");
            ins.setText("Choose one card");
            list.Node currNode=p2.head;
            for(int i=0;i<18;i++){
                if(currNode==null){
                    imageC("Sharib",i+1);
                }
                else{
                    imageC(currNode.data,i+1);
                    currNode=currNode.next;
                }
            }
            if(!deck.isEmpty()){
                //imaged(deck.peek());
                if(check(p2.head)){
                    ins.setText("Don't have greater value card");
                    while(!deck.isEmpty()){
                        p2.add(deck.pop());
                    }
                    for(int i=0;i<1000;i++){

                    }
                    ins.setText("All cards added to your hand");
                }
            }
        }
        else if(num%4==3){
            player2.setText("PLAYER  3");
            ins.setText("Choose one card");
            list.Node currNode=p3.head;
            for(int i=0;i<18;i++){
                if(currNode==null){
                    imageC("Sharib",i+1);
                }
                else{
                    imageC(currNode.data,i+1);
                    currNode=currNode.next;
                }
            }
            if(!deck.isEmpty()){
                //imaged(deck.peek());
                if(check(p3.head)){
                    ins.setText("Don't have greater value card");
                    while(!deck.isEmpty()){
                        p3.add(deck.pop());
                    }
                    for(int i=0;i<1000;i++){

                    }
                    ins.setText("All cards added to your hand");
                }
            }
        }
        else if(num%4==0){
            player2.setText("PLAYER  4");
            ins.setText("Choose one card");
            list.Node currNode=p4.head;
            for(int i=0;i<18;i++){
                if(currNode==null){
                    imageC("Sharib",i+1);
                }
                else{
                    imageC(currNode.data,i+1);
                    currNode=currNode.next;
                }
            }
            if(!deck.isEmpty()){
                //imaged(deck.peek());
                if(check(p4.head)){
                    ins.setText("Don't have greater value card");
                    while(!deck.isEmpty()){
                        p4.add(deck.pop());
                    }
                    for(int i=0;i<1000;i++){

                    }
                    ins.setText("All cards added to your hand");
                }
            }
        }
    }
    final void winner(){
        if(p1.head==null){
            dispose();
            new Winner(1).show();
        }
        else if(p2.head==null){
            dispose();
            new Winner(2).show();
        }
        else if(p3.head==null){
            dispose();
            new Winner(3).show();
        }
        else if(p4.head==null){
            dispose();
            new Winner(4).show();
        }
    }
    final void imageC(String d,int i){
        if(d.equals("Sharib") && i==1){
            ImageIcon in = new ImageIcon("src//Pic");
            card1.setIcon(in);
            cdet1.setText("");
        }
        if(d.equals("Sharib") && i==2){
            ImageIcon in = new ImageIcon("src//Pic");
            card2.setIcon(in);
            cdet2.setText("");
        }
        if(d.equals("Sharib") && i==3){
            ImageIcon in = new ImageIcon("src//Pic");
            card3.setIcon(in);
            cdet3.setText("");
        }
        if(d.equals("Sharib") && i==4){
            ImageIcon in = new ImageIcon("src//Pic");
            card4.setIcon(in);
            cdet4.setText("");
        }
        if(d.equals("Sharib") && i==5){
            ImageIcon in = new ImageIcon("src//Pic");
            card5.setIcon(in);
            cdet5.setText("");
        }
        if(d.equals("Sharib") && i==6){
            ImageIcon in = new ImageIcon("src//Pic");
            card6.setIcon(in);
            cdet6.setText("");
        }
        if(d.equals("Sharib") && i==7){
            ImageIcon in = new ImageIcon("src//Pic");
            card7.setIcon(in);
            cdet7.setText("");
        }
        if(d.equals("Sharib") && i==8){
            ImageIcon in = new ImageIcon("src//Pic");
            card8.setIcon(in);
            cdet8.setText("");
        }
        if(d.equals("Sharib") && i==9){
            ImageIcon in = new ImageIcon("src//Pic");
            card9.setIcon(in);
            cdet9.setText("");
        }
        if(d.equals("Sharib") && i==10){
            ImageIcon in = new ImageIcon("src//Pic");
            card10.setIcon(in);
            cdet10.setText("");
        }
        if(d.equals("Sharib") && i==11){
            ImageIcon in = new ImageIcon("src//Pic");
            card11.setIcon(in);
            cdet11.setText("");
        }
        if(d.equals("Sharib") && i==12){
            ImageIcon in = new ImageIcon("src//Pic");
            card12.setIcon(in);
            cdet12.setText("");
        }
        if(d.equals("Sharib") && i==13){
            ImageIcon in = new ImageIcon("src//Pic");
            card13.setIcon(in);
            cdet13.setText("");
        }
        if(d.equals("Sharib") && i==14){
            ImageIcon in = new ImageIcon("src//Pic");
            card14.setIcon(in);
            cdet14.setText("");
        }
        if(d.equals("Sharib") && i==15){
            ImageIcon in = new ImageIcon("src//Pic");
            card15.setIcon(in);
            cdet15.setText("");
        }
        if(d.equals("Sharib") && i==16){
            ImageIcon in = new ImageIcon("src//Pic");
            card16.setIcon(in);
            cdet16.setText("");
        }
        if(d.equals("Sharib") && i==17){
            ImageIcon in = new ImageIcon("src//Pic");
            card17.setIcon(in);
            cdet17.setText("");
        }
        if(d.equals("Sharib") && i==18){
            ImageIcon in = new ImageIcon("src//Pic");
            card18.setIcon(in);
            cdet18.setText("");
        }
        if(i==1){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card1.setIcon(in);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//JA.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card1.setIcon(in);
                cdet1.setText(d);
            }
        }
        if(i==2){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card3.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card2.setIcon(in);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card2.setIcon(in);
                cdet2.setText(d);
            }
        }
        if(i==3){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card3.setIcon(in);cdet3.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card3.setIcon(in);cdet3.setText(d);
            }
        }
        if(i==4){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card4.setIcon(in);cdet4.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card4.setIcon(in);cdet4.setText(d);
            }
        }
        if(i==5){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card5.setIcon(in);cdet5.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card5.setIcon(in);cdet5.setText(d);
            }
        }
        if(i==6){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card6.setIcon(in);cdet6.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card6.setIcon(in);cdet6.setText(d);
            }
        }
        if(i==7){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card7.setIcon(in);cdet7.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card7.setIcon(in);cdet7.setText(d);
            }
        }
        if(i==8){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card8.setIcon(in);cdet8.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card8.setIcon(in);cdet8.setText(d);
            }
        }
        if(i==9){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card9.setIcon(in);cdet9.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card9.setIcon(in);cdet9.setText(d);
            }
        }
        if(i==10){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card10.setIcon(in);cdet10.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card10.setIcon(in);cdet10.setText(d);
            }
        }
        if(i==11){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card11.setIcon(in);cdet11.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card11.setIcon(in);cdet11.setText(d);
            }
        }
        if(i==18){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card18.setIcon(in);cdet18.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card18.setIcon(in);cdet18.setText(d);
            }
        }
        if(i==13){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card13.setIcon(in);cdet13.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card13.setIcon(in);cdet13.setText(d);
            }
        }
        if(i==14){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card14.setIcon(in);cdet14.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card14.setIcon(in);cdet14.setText(d);
            }
        }
        if(i==15){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card15.setIcon(in);cdet15.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card15.setIcon(in);cdet15.setText(d);
            }
        }
        if(i==16){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card16.setIcon(in);cdet16.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card16.setIcon(in);cdet16.setText(d);
            }
        }
        if(i==17){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card17.setIcon(in);cdet17.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card17.setIcon(in);cdet17.setText(d);
            }
        }
        if(i==12){
            if(d.equals("S2")){
                ImageIcon in = new ImageIcon("src//Pic//S2.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H2")){
                ImageIcon in = new ImageIcon("src//Pic//H2.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D2")){
                ImageIcon in = new ImageIcon("src//Pic//D2.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C2")){
                ImageIcon in = new ImageIcon("src//Pic//C2.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C3")){
                ImageIcon in = new ImageIcon("src//Pic//C3.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S3")){
                ImageIcon in = new ImageIcon("src//Pic//S3.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H3")){
                ImageIcon in = new ImageIcon("src//Pic//H3.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D3")){
                ImageIcon in = new ImageIcon("src//Pic//D3.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S4") ){
                ImageIcon in = new ImageIcon("src//Pic//S4.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H4")){
                ImageIcon in = new ImageIcon("src//Pic//H4.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D4")){
                ImageIcon in = new ImageIcon("src//Pic//D4.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C4")){
                ImageIcon in = new ImageIcon("src//Pic//C4.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S5")){
                ImageIcon in = new ImageIcon("src//Pic//S5.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H5")){
                ImageIcon in = new ImageIcon("src//Pic//H5.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D5")){
                ImageIcon in = new ImageIcon("src//Pic//D5.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C5")){
                ImageIcon in = new ImageIcon("src//Pic//C5.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S6")){
                ImageIcon in = new ImageIcon("src//Pic//S6.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H6")){
                ImageIcon in = new ImageIcon("src//Pic//H6.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D6")){
                ImageIcon in = new ImageIcon("src//Pic//D6.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C6")){
                ImageIcon in = new ImageIcon("src//Pic//C6.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S7")){
                ImageIcon in = new ImageIcon("src//Pic//S7.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H7")){
                ImageIcon in = new ImageIcon("src//Pic//H7.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D7")){
                ImageIcon in = new ImageIcon("src//Pic//D7.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C7")){
                ImageIcon in = new ImageIcon("src//Pic//C7.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S8")){
                ImageIcon in = new ImageIcon("src//Pic//S8.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H8")){
                ImageIcon in = new ImageIcon("src//Pic//H8.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D8")){
                ImageIcon in = new ImageIcon("src//Pic//D8.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C8")){
                ImageIcon in = new ImageIcon("src//Pic//C8.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S9")){
                ImageIcon in = new ImageIcon("src//Pic//S9.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H9")){
                ImageIcon in = new ImageIcon("src//Pic//H9.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D9")){
                ImageIcon in = new ImageIcon("src//Pic//D9.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C9")){
                ImageIcon in = new ImageIcon("src//Pic//C9.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("S10")){
                ImageIcon in = new ImageIcon("src//Pic//S10.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("H10")){
                ImageIcon in = new ImageIcon("src//Pic//H10.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("D10")){
                ImageIcon in = new ImageIcon("src//Pic//D10.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("C10")){
                ImageIcon in = new ImageIcon("src//Pic//C10.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("SJ")){
                ImageIcon in = new ImageIcon("src//Pic//SJ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("HJ")){
                ImageIcon in = new ImageIcon("src//Pic//HJ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("DJ")){
                ImageIcon in = new ImageIcon("src//Pic//DJ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("CJ")){
                ImageIcon in = new ImageIcon("src//Pic//CJ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("SQ")){
                ImageIcon in = new ImageIcon("src//Pic//SQ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("HQ")){
                ImageIcon in = new ImageIcon("src//Pic/HQ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("DQ")){
                ImageIcon in = new ImageIcon("src//Pic//DQ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("CQ")){
                ImageIcon in = new ImageIcon("src//Pic//CQ.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("SK")){
                ImageIcon in = new ImageIcon("src//Pic//SK.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("HK")){
                ImageIcon in = new ImageIcon("src//Pic//HK.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("DK")){
                ImageIcon in = new ImageIcon("src//Pic//DK.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("CK")){
                ImageIcon in = new ImageIcon("src//Pic//CK.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("SA")){
                ImageIcon in = new ImageIcon("src//Pic//SA.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("HA")){
                ImageIcon in = new ImageIcon("src//Pic//HA.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("DA")){
                ImageIcon in = new ImageIcon("src//Pic//DA.png");
                card12.setIcon(in);cdet12.setText(d);
            }
            if(d.equals("CA")){
                ImageIcon in = new ImageIcon("src//Pic//CA.png");
                card12.setIcon(in);cdet12.setText(d);
            }
        }
    }
    final void click(String d){
        if(num%4==1){
            if(deck.isEmpty()){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p1.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p1.add(s.pop());
                }
                return;
            }
            if(d.equals("S10") || d.equals("C10") || d.equals("D10") || d.equals("H10")){
                p1.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p1.add(s.pop());
                }
                while(!deck.isEmpty()){
                    deck.pop();
                }
                imaged("Sharib");
                deckd.setText("");
                return;
            }
            if((deck.peek().equals("S7") || deck.peek().equals("C7") || deck.peek().equals("D7") || deck.peek().equals("H7")) && number(d)<7){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p1.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p1.add(s.pop());
                }
                return;
            }
            if(check(d)){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p1.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p1.add(s.pop());
                }
                return;
            }
            ins.setText("Choose card that has greater value");
            
        }
        else if(num%4==2){
            if(deck.isEmpty()){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p2.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p2.add(s.pop());
                }
                return;
            }
            if(d.equals("S10") || d.equals("C10") || d.equals("D10") || d.equals("H10")){
                p2.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p2.add(s.pop());
                }
                while(!deck.isEmpty()){
                    deck.pop();
                }
                imaged("Sharib");
                deckd.setText("");
                return;
            }
            if((deck.peek().equals("S7") || deck.peek().equals("C7") || deck.peek().equals("D7") || deck.peek().equals("H7")) && number(d)<7){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p2.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p2.add(s.pop());
                }
                return;
            }
            if(check(d)){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p2.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p2.add(s.pop());
                }
                return;
            }
            ins.setText("Choose card that has greater value");
        }
        else if(num%4==3){
            if(deck.isEmpty()){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p3.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                return;
            }
            if(d.equals("S10") || d.equals("C10") || d.equals("D10") || d.equals("H10")){
                p3.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                while(!deck.isEmpty()){
                    deck.pop();
                }
                imaged("Sharib");
                deckd.setText("");
                return;
            }
            if((deck.peek().equals("S7") || deck.peek().equals("C7") || deck.peek().equals("D7") || deck.peek().equals("H7")) && number(d)<7){
                deck.push(d);imaged(d);
                deckd.setText(d);
                p3.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                return;
            }
            if(check(d)){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p3.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                return;
            }
            ins.setText("Choose card that has greater value");
        }
        else if(num%4==0){
            if(deck.isEmpty()){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p4.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p4.add(s.pop());
                }
                return;
            }
            else if(d.equals("S10") || d.equals("C10") || d.equals("D10") || d.equals("H10")){
                p4.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p4.add(s.pop());
                }
                while(!deck.isEmpty()){
                    deck.pop();
                }
                imaged("Sharib");
                deckd.setText("");
                return;
            }
            if((deck.peek().equals("S7") || deck.peek().equals("C7") || deck.peek().equals("D7") || deck.peek().equals("H7")) && number(d)<7){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p4.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                return;
            }
            if(check(d)){
                deck.push(d);
                imaged(d);
                deckd.setText(d);
                p4.deleteNode(d);
                num++;
                if(!s.isEmpty()){
                    p3.add(s.pop());
                }
                return;
            }
            ins.setText("Choose card that has greater value");
        }
    }
    final void imaged(String d){
        String str="src//Pic//";
        str+=d;
        str+=".png";
        ImageIcon in = new ImageIcon(str);
        deckC.setIcon(in);
        deckd.setText(d);
        /*if(d.equals("Sharib")){
            ImageIcon in = new ImageIcon("src//Pic//Sharib.png");
            deckC.setIcon(in);deckd.setText("");
        }
        if(d.equals("S2")){
            ImageIcon in = new ImageIcon("src//Pic//S2.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H2")){
            ImageIcon in = new ImageIcon("src//Pic//H2.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D2")){
            ImageIcon in = new ImageIcon("src//Pic//D2.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C2")){
            ImageIcon in = new ImageIcon("src//Pic//C2.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C3")){
            ImageIcon in = new ImageIcon("src//Pic//C3.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S3")){
            ImageIcon in = new ImageIcon("src//Pic//S3.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H3")){
            ImageIcon in = new ImageIcon("src//Pic//H3.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D3")){
            ImageIcon in = new ImageIcon("src//Pic//D3.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S4") ){
            ImageIcon in = new ImageIcon("src//Pic//S4.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H4")){
            ImageIcon in = new ImageIcon("src//Pic//H4.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D4")){
            ImageIcon in = new ImageIcon("src//Pic//D4.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C4")){
            ImageIcon in = new ImageIcon("src//Pic//C4.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S5")){
            ImageIcon in = new ImageIcon("src//Pic//S5.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H5")){
            ImageIcon in = new ImageIcon("src//Pic//H5.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D5")){
            ImageIcon in = new ImageIcon("src//Pic//D5.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C5")){
            ImageIcon in = new ImageIcon("src//Pic//C5.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S6")){
            ImageIcon in = new ImageIcon("src//Pic//S6.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H6")){
            ImageIcon in = new ImageIcon("src//Pic//H6.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D6")){
            ImageIcon in = new ImageIcon("src//Pic//D6.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C6")){
            ImageIcon in = new ImageIcon("src//Pic//C6.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S7")){
            ImageIcon in = new ImageIcon("src//Pic//S7.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H7")){
            ImageIcon in = new ImageIcon("src//Pic//H7.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D7")){
            ImageIcon in = new ImageIcon("src//Pic//D7.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C7")){
            ImageIcon in = new ImageIcon("src//Pic//C7.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S8")){
            ImageIcon in = new ImageIcon("src//Pic//S8.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H8")){
            ImageIcon in = new ImageIcon("src//Pic//H8.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D8")){
            ImageIcon in = new ImageIcon("src//Pic//D8.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C8")){
            ImageIcon in = new ImageIcon("src//Pic//C8.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S9")){
            ImageIcon in = new ImageIcon("src//Pic//S9.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H9")){
            ImageIcon in = new ImageIcon("src//Pic//H9.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D9")){
            ImageIcon in = new ImageIcon("src//Pic//D9.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C9")){
            ImageIcon in = new ImageIcon("src//Pic//C9.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("S10")){
            ImageIcon in = new ImageIcon("src//Pic//S10.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("H10")){
            ImageIcon in = new ImageIcon("src//Pic//H10.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("D10")){
            ImageIcon in = new ImageIcon("src//Pic//D10.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("C10")){
            ImageIcon in = new ImageIcon("src//Pic//C10.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("SJ")){
            ImageIcon in = new ImageIcon("src//Pic//SJ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("HJ")){
            ImageIcon in = new ImageIcon("src//Pic//HJ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("DJ")){
            ImageIcon in = new ImageIcon("src//Pic//DJ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("CJ")){
            ImageIcon in = new ImageIcon("src//Pic//CJ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("SQ")){
            ImageIcon in = new ImageIcon("src//Pic//SQ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("HQ")){
            ImageIcon in = new ImageIcon("src//Pic/HQ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("DQ")){
            ImageIcon in = new ImageIcon("src//Pic//DQ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("CQ")){
            ImageIcon in = new ImageIcon("src//Pic//CQ.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("SK")){
            ImageIcon in = new ImageIcon("src//Pic//SK.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("HK")){
            ImageIcon in = new ImageIcon("src//Pic//HK.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("DK")){
            ImageIcon in = new ImageIcon("src//Pic//DK.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("CK")){
            ImageIcon in = new ImageIcon("src//Pic//CK.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("SA")){
            ImageIcon in = new ImageIcon("src//Pic//SA.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("HA")){
            ImageIcon in = new ImageIcon("src//Pic//JA.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("DA")){
            ImageIcon in = new ImageIcon("src//Pic//DA.png");
            deckC.setIcon(in);deckd.setText(d);
        }
        if(d.equals("CA")){
            ImageIcon in = new ImageIcon("src//Pic//CA.png");
            deckC.setIcon(in);deckd.setText(d);
        }*/
    }
    final void init(){
        s=new Stack(52);
        deck=new Stack(52);
        String card[]={"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
                         "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
                         "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
                         "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"};
        ArrayList<Integer> n=new ArrayList<>();
        for(int i=0;i<52;i++){
            n.add(i);
        }
        Collections.shuffle(n);
        for(int i=0;i<52;i++){
            s.push(card[n.get(i)]);
        }
        for(int i=0;i<9;i++){
            p1.add(s.pop());
            p2.add(s.pop());
            p3.add(s.pop());
            p4.add(s.pop());
        }
        ins.setText("Choose one card");
        Player();
    }
    
    /**
     * Creates new form Game
     */
    public Game(){
        initComponents();
        init();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        player = new javax.swing.JLabel();
        ins = new javax.swing.JLabel();
        card18 = new javax.swing.JLabel();
        card8 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        card9 = new javax.swing.JLabel();
        card10 = new javax.swing.JLabel();
        card11 = new javax.swing.JLabel();
        card1 = new javax.swing.JLabel();
        card7 = new javax.swing.JLabel();
        card3 = new javax.swing.JLabel();
        card4 = new javax.swing.JLabel();
        deckC = new javax.swing.JLabel();
        card6 = new javax.swing.JLabel();
        card5 = new javax.swing.JLabel();
        card13 = new javax.swing.JLabel();
        card14 = new javax.swing.JLabel();
        card15 = new javax.swing.JLabel();
        card16 = new javax.swing.JLabel();
        card17 = new javax.swing.JLabel();
        card12 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        cdet2 = new javax.swing.JLabel();
        cdet3 = new javax.swing.JLabel();
        cdet4 = new javax.swing.JLabel();
        cdet5 = new javax.swing.JLabel();
        cdet6 = new javax.swing.JLabel();
        cdet7 = new javax.swing.JLabel();
        cdet8 = new javax.swing.JLabel();
        cdet9 = new javax.swing.JLabel();
        cdet10 = new javax.swing.JLabel();
        cdet11 = new javax.swing.JLabel();
        cdet12 = new javax.swing.JLabel();
        cdet13 = new javax.swing.JLabel();
        cdet14 = new javax.swing.JLabel();
        cdet15 = new javax.swing.JLabel();
        cdet16 = new javax.swing.JLabel();
        cdet17 = new javax.swing.JLabel();
        cdet18 = new javax.swing.JLabel();
        deckd = new javax.swing.JLabel();
        cdet1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\S\\Downloads\\card-game.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setText("X");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover1.setColorText(new java.awt.Color(0, 102, 0));
        rSButtonHover1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonHover1MouseClicked(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 30));

        player.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        player.setForeground(new java.awt.Color(255, 255, 255));
        player.setText("Deck Last Card:");
        jPanel1.add(player, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 140, 30));

        ins.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        ins.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ins, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 690, -1));

        card18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card18MouseClicked(evt);
            }
        });
        jPanel1.add(card18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        card8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card8MouseClicked(evt);
            }
        });
        jPanel1.add(card8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2MouseClicked(evt);
            }
        });
        jPanel1.add(card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        card9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card9MouseClicked(evt);
            }
        });
        jPanel1.add(card9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        card10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card10MouseClicked(evt);
            }
        });
        jPanel1.add(card10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, -1));

        card11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card11MouseClicked(evt);
            }
        });
        jPanel1.add(card11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });
        jPanel1.add(card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        card7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card7MouseClicked(evt);
            }
        });
        jPanel1.add(card7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card3MouseClicked(evt);
            }
        });
        jPanel1.add(card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card4MouseClicked(evt);
            }
        });
        jPanel1.add(card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));
        jPanel1.add(deckC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        card6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card6MouseClicked(evt);
            }
        });
        jPanel1.add(card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        card5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card5MouseClicked(evt);
            }
        });
        jPanel1.add(card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        card13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card13MouseClicked(evt);
            }
        });
        jPanel1.add(card13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        card14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card14MouseClicked(evt);
            }
        });
        jPanel1.add(card14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, -1, -1));

        card15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card15MouseClicked(evt);
            }
        });
        jPanel1.add(card15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, -1, -1));

        card16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card16MouseClicked(evt);
            }
        });
        jPanel1.add(card16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 650, -1, -1));

        card17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card17MouseClicked(evt);
            }
        });
        jPanel1.add(card17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, -1, -1));

        card12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card12MouseClicked(evt);
            }
        });
        jPanel1.add(card12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, -1, -1));

        player2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        player2.setForeground(new java.awt.Color(255, 255, 255));
        player2.setText("PLAYER  1");
        jPanel1.add(player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 100, -1));

        cdet2.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        cdet3.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        cdet4.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        cdet5.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        cdet6.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, -1, -1));

        cdet7.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        cdet8.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        cdet9.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        cdet10.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        cdet11.setForeground(new java.awt.Color(0, 102, 51));
        jPanel1.add(cdet11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, -1));

        cdet12.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 430, -1, -1));

        cdet13.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        cdet14.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 650, -1, -1));

        cdet15.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 650, -1, -1));

        cdet16.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 650, -1, -1));

        cdet17.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 650, -1, -1));

        cdet18.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 650, -1, -1));

        deckd.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(deckd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 0, 0));

        cdet1.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cdet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 850));

        setSize(new java.awt.Dimension(900, 850));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1MouseClicked

    private void card12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card12MouseClicked
        // TODO add your handling code here:
        click(cdet12.getText());
        Player();
    }//GEN-LAST:event_card12MouseClicked

    private void card17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card17MouseClicked
        // TODO add your handling code here:
        click(cdet17.getText());
        Player();
    }//GEN-LAST:event_card17MouseClicked

    private void card16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card16MouseClicked
        // TODO add your handling code here:
        click(cdet16.getText());
        Player();
    }//GEN-LAST:event_card16MouseClicked

    private void card15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card15MouseClicked
        // TODO add your handling code here:
        click(cdet15.getText());
        Player();
    }//GEN-LAST:event_card15MouseClicked

    private void card14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card14MouseClicked
        // TODO add your handling code here:
        click(cdet14.getText());
        Player();
    }//GEN-LAST:event_card14MouseClicked

    private void card13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card13MouseClicked
        // TODO add your handling code here:
        click(cdet13.getText());
        Player();
    }//GEN-LAST:event_card13MouseClicked

    private void card5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card5MouseClicked
        // TODO add your handling code here:
        click(cdet5.getText());
        Player();
    }//GEN-LAST:event_card5MouseClicked

    private void card6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card6MouseClicked
        // TODO add your handling code here:
        click(cdet6.getText());
        Player();
    }//GEN-LAST:event_card6MouseClicked

    private void card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card4MouseClicked
        // TODO add your handling code here:
        click(cdet4.getText());
        Player();
    }//GEN-LAST:event_card4MouseClicked

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        // TODO add your handling code here:
        click(cdet3.getText());
        Player();
    }//GEN-LAST:event_card3MouseClicked

    private void card7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card7MouseClicked
        // TODO add your handling code here:
        click(cdet7.getText());
        Player();
    }//GEN-LAST:event_card7MouseClicked

    private void card11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card11MouseClicked
        // TODO add your handling code here:
        click(cdet11.getText());
        Player();
    }//GEN-LAST:event_card11MouseClicked

    private void card10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card10MouseClicked
        // TODO add your handling code here:
        click(cdet10.getText());
        Player();
    }//GEN-LAST:event_card10MouseClicked

    private void card9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card9MouseClicked
        // TODO add your handling code here:
        click(cdet9.getText());
        Player();
    }//GEN-LAST:event_card9MouseClicked

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        // TODO add your handling code here:
        click(cdet2.getText());
        Player();
    }//GEN-LAST:event_card2MouseClicked

    private void card8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card8MouseClicked
        // TODO add your handling code here:
        click(cdet8.getText());
        Player();
    }//GEN-LAST:event_card8MouseClicked

    private void card18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card18MouseClicked
        // TODO add your handling code here:
        click(cdet18.getText());
        Player();
    }//GEN-LAST:event_card18MouseClicked

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
        click(cdet1.getText());
        Player();
    }//GEN-LAST:event_card1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card10;
    private javax.swing.JLabel card11;
    private javax.swing.JLabel card12;
    private javax.swing.JLabel card13;
    private javax.swing.JLabel card14;
    private javax.swing.JLabel card15;
    private javax.swing.JLabel card16;
    private javax.swing.JLabel card17;
    private javax.swing.JLabel card18;
    private javax.swing.JLabel card2;
    private javax.swing.JLabel card3;
    private javax.swing.JLabel card4;
    private javax.swing.JLabel card5;
    private javax.swing.JLabel card6;
    private javax.swing.JLabel card7;
    private javax.swing.JLabel card8;
    private javax.swing.JLabel card9;
    private javax.swing.JLabel cdet1;
    private javax.swing.JLabel cdet10;
    private javax.swing.JLabel cdet11;
    private javax.swing.JLabel cdet12;
    private javax.swing.JLabel cdet13;
    private javax.swing.JLabel cdet14;
    private javax.swing.JLabel cdet15;
    private javax.swing.JLabel cdet16;
    private javax.swing.JLabel cdet17;
    private javax.swing.JLabel cdet18;
    private javax.swing.JLabel cdet2;
    private javax.swing.JLabel cdet3;
    private javax.swing.JLabel cdet4;
    private javax.swing.JLabel cdet5;
    private javax.swing.JLabel cdet6;
    private javax.swing.JLabel cdet7;
    private javax.swing.JLabel cdet8;
    private javax.swing.JLabel cdet9;
    private javax.swing.JLabel deckC;
    private javax.swing.JLabel deckd;
    private javax.swing.JLabel ins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel player;
    private javax.swing.JLabel player2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    // End of variables declaration//GEN-END:variables

}
