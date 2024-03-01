import java.util.*;

public class RNA_to_Protiens {
    public static void main(String[] args) {
        System.out.println(rnaToAminoAcids("AGCUGGGAAACGUAGGCCUA"));
        System.out.println(rnaToAminoAcids("UAAAGAGAAGCCAGC"));
    }

    public static String rnaToAminoAcids(String rnaSequence) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < rnaSequence.length(); i++) {
            queue.add(rnaSequence.charAt(i));
        }

        Stack<Character> stack = new Stack<>();
        while (!queue.isEmpty()) {
            String codon = "";
            for (int i = 0; i < 3 && !queue.isEmpty(); i++) {
                codon += queue.remove();
            }
            if (codon.length() < 3) {
                stack.push('.');
                break;
            }
            char aminoAcid;
            switch (codon) {
                case "UAA":
                case "UAG":
                case "UGA":
                    stack.push('.');
                    continue;
                case "UUU":
                case "UUC":
                    aminoAcid = 'F';
                    break;
                case "UUA":
                case "UUG":
                case "CUU":
                case "CUC":
                case "CUA":
                case "CUG":
                    aminoAcid = 'L';
                    break;
                case "UCU":
                case "UCC":
                case "UCA":
                case "UCG":
                case "AGU":
                case "AGC":
                    aminoAcid = 'S';
                    break;
                case "UAU":
                case "UAC":
                    aminoAcid = 'Y';
                    break;
                case "UGU":
                case "UGC":
                    aminoAcid = 'C';
                    break;
                case "UGG":
                    aminoAcid = 'W';
                    break;
                case "CCU":
                case "CCC":
                case "CCA":
                case "CCG":
                    aminoAcid = 'P';
                    break;
                case "CAU":
                case "CAC":
                    aminoAcid = 'H';
                    break;
                case "CAA":
                case "CAG":
                    aminoAcid = 'Q';
                    break;
                case "CGU":
                case "CGC":
                case "CGA":
                case "CGG":
                case "AGA":
                case "AGG":
                    aminoAcid = 'R';
                    break;
                case "AUU":
                case "AUC":
                case "AUA":
                    aminoAcid = 'I';
                    break;
                case "AUG":
                    aminoAcid = 'M';
                    break;
                case "ACU":
                case "ACC":
                case "ACA":
                case "ACG":
                    aminoAcid = 'T';
                    break;
                case "AAU":
                case "AAC":
                    aminoAcid = 'N';
                    break;
                case "AAA":
                case "AAG":
                    aminoAcid = 'K';
                    break;
                case "GUU":
                case "GUC":
                case "GUA":
                case "GUG":
                    aminoAcid = 'V';
                    break;
                case "GCU":
                case "GCC":
                case "GCA":
                case "GCG":
                    aminoAcid = 'A';
                    break;
                case "GAU":
                case "GAC":
                    aminoAcid = 'D';
                    break;
                case "GAA":
                case "GAG":
                    aminoAcid = 'E';
                    break;
                case "GGU":
                case "GGC":
                case "GGA":
                case "GGG":
                    aminoAcid = 'G';
                    break;
                default:
                    throw new IllegalArgumentException("Invalid codon in RNA sequence: " + codon);
            }
            stack.push(aminoAcid);
        }

        String aminoAcids = "";
        while (!stack.isEmpty()) {
            aminoAcids = stack.pop() + aminoAcids;
        }
        return aminoAcids;
    }
}