import java.util.*;

public class DNA_to_RNA {
    public static void main(String[] args) {
        System.out.println(dnaToRna("AGCTGGGAAACGTAGGCCTA"));
        System.out.println(dnaToRna("TTTTTTTTTTGGCGCG"));
        System.out.println(dnaToRna("CTTTGGGACTAGTAACCCATTTCGGCT"));
    }

    public static String dnaToRna(String dnaSequence) {
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < dnaSequence.length(); i++) {
            char c = dnaSequence.charAt(i);
            if (c == 'T') {
                queue.add('U');
            } else if (c == 'A' || c == 'C' || c == 'G') {
                queue.add(c);
            } else {
                throw new IllegalArgumentException("Invalid character in DNA sequence: " + c);
            }
        }

        String rnaSequence = "";
        while (!queue.isEmpty()) {
            rnaSequence += queue.remove();
        }

        return rnaSequence;
    }
}
