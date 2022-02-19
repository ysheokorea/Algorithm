import java.io.*;

public class BufferedTest2 {
    public static void main(String[] args) throws IOException{
        try{

           BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedWriter.txt"));
           bw.write("hellow \n");
           bw.flush();
           bw.close();


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
