import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Solution {

    public static void main(String []args) {
         
        SecureRandom secureRandom = new SecureRandom();
        int seed = Integer.parseInt(JOptionPane.showInputDialog("Digite um número."));

        while(true) {
           JOptionPane.showMessageDialog(null, secureRandom.nextInt(seed));
        }
    }
}