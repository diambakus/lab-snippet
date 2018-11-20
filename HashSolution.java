public class HashSolution {

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("jaquil");
        for (int i = 0; i < string.length(); i++)
            for(int j = i+1; j <= string.length(); j++)
                System.out.printf("%s ", string.substring(i, j));
        System.out.println();
    }


}