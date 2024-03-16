import java.util.*;

class Mates {
    private String v1;
    private int votes;

    public Mates(String var) {
        this.v1 = var;
        this.votes = 0;
    }
    public String get() {
        return v1;
    }
    public int getVo() {
        return votes;
    }
    public void vote() {
        votes++;
    }
}

public class Main {
    private List<Mates> candidates;

    public Main() {
        candidates = new ArrayList<>();
    }

    public void addCandidate(String var) {
        candidates.add(new Mates(var));
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).get());
        }
    }

    public void voteEm(int candidateIndex) {
        if (candidateIndex >= 1 && candidateIndex <= candidates.size()) {
            candidates.get(candidateIndex - 1).vote();
            System.out.println("Your vote has been casted");
        } else {
            System.out.println("Invalid candidate selection");
        }
    }

    public void displayResults() {
        System.out.println("Final Results:");
        for (Mates candidate : candidates) {
            System.out.println(candidate.get() + ": " + candidate.getVo() + " votes");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Main voteSys = new Main();

        voteSys.addCandidate("Tharun 1");
        voteSys.addCandidate("Varun 2");
        voteSys.addCandidate("Saran 3");

        while (true) {
            voteSys.displayCandidates();
            System.out.print("Enter the number of the candidate to vote : ");
            int let=sc.nextInt();
            if (let == 0)
            {
                break;
            }
            voteSys.voteEm(let);
        }

        voteSys.displayResults();
        sc.close();
    }
}