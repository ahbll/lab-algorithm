package top.bhappy.nk.huawei;


public class Main5 {

    public static void main(String[] args) {
        //System.out.println(getResult(6));
        System.out.println(getResult(64577));
    }

    public static String getResult(long ulDataInput) {
        long num = ulDataInput;
        int i = 2;
        StringBuffer sb = new StringBuffer();
        while (num != 1) {
            if (num % i == 0) {
                num = num / i;
                sb.append(i + " ");
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}