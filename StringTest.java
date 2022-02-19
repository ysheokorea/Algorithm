public class StringTest {
    public static void main(String[] args){
        StringBuilder sbd = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        // StringBuilder 초기 주소값
        System.out.println("StringBuilder 주소 : "+sbd.hashCode());

        sbd.append("test1");

        // StringBuilder 연산 후 주소값
        System.out.println("StringBuilder 주소 : "+sbd.hashCode());


        // StrinfBuffer 초기 주소값
        System.out.println("StringBuilder 주소 : "+sbf.hashCode());

        sbf.append("test1");

        // StrinfBuffer 연산 후 주소값
        System.out.println("StringBuilder 주소 : "+sbf.hashCode());
    }
}

