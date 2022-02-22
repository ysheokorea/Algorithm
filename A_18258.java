/*
    큐(Queue) 구현하기
*/

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class A_18258 {

    // 전역 변수
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int queuePointerFront=0;
    public static int queuePointerRear=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        arr=new int[X];
        StringTokenizer st;

        for(int i=0; i<X; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    if(queuePointerFront==queuePointerRear) queuePointerRear=queuePointerFront;
                    else queuePointerRear++;
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int N){
        arr[queuePointerFront]=N;
        queuePointerFront++;
    }
    public static void pop(){
        if(queuePointerFront==queuePointerRear){
            sb.append(-1+"\n");
        }else{
            sb.append(arr[queuePointerRear]+"\n");
        }
        
        
    }
    public static void size(){
        if(queuePointerRear>=queuePointerFront) sb.append(0+"\n");
        else sb.append(queuePointerFront-queuePointerRear+"\n");
    }
    public static void empty(){
        if(queuePointerFront==queuePointerRear) sb.append(1+"\n");
        else sb.append(0+"\n");
    }
    public static void front(){
        if(queuePointerFront==queuePointerRear) sb.append(-1+"\n");
        else sb.append(arr[queuePointerRear]+"\n");
    }
    public static void back(){
        if(queuePointerFront==queuePointerRear) sb.append(-1+"\n");
        else sb.append(arr[queuePointerFront-1]+"\n");
        
    }
}

