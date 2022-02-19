import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException{
        try{

            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            
            String line="";
            for(int i=1; (line=br.readLine())!=null; i++){
                if(line.indexOf(";") != -1)
                    System.out.println(i+":"+line);
            }
            br.close();


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
