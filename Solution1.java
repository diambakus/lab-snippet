
class Martian {
    static int MARTIAN_COUNT = 0;

    public Martian() {
        MARTIAN_COUNT++;
    }

    public String toString() {
        return new String(""+MARTIAN_COUNT);
    }
}
public class Solution1 {

    public static void main(String argv[])
    {
        Martian[] martians = new Martian[Integer.parseInt(argv[0])];

        for (int i = 0; i < martians.length; ++i) {
           martians[i] = new Martian();

           System.out.printf(martians[i].toString()+"\n");
        }

        System.out.println(Martian.MARTIAN_COUNT);
    }
    
}