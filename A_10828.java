
/*
    STACK 구현하기
*/

import java.util.Scanner;

public class A_10828 {
    public static int[] arr;
    public static int stackPointer=0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N+1];

        for(int i=0; i<N; i++){
            String ch = in.next();
            
            // try{
                
            // }catch(Exception e){
            //     System.out.println(e.getMessage());
            // }
            
            switch(ch){
                case "push":
                    int X = in.nextInt();
                    push(X);
                    break;
                case "pop":
                    sb.append(pop()+"\n");
                    break;
                case "size":
                    sb.append(size()+"\n");
                    break;
                case "empty":
                    sb.append(empty()+"\n");
                    break;
                case "top":
                    sb.append(top()+"\n");
                    break;
            }
        }
        System.out.println(sb);

    }

    public static void push(int X){
        arr[stackPointer] = X;
        stackPointer++;
    }
    public static int pop(){
        if(stackPointer<1){
            return -1;
        }else{
            stackPointer--;
            return arr[stackPointer];
        }
        
    }
    public static int size(){
        return stackPointer;
    }
    public static int empty(){
        
        if(stackPointer<=0){
            
            return 1;
        }else{
            
            return 0;
        }
    }
    public static int top(){
        if(stackPointer<=0){
            return -1;
        }else{
            return arr[stackPointer-1];
        }
        
        
    }
}
