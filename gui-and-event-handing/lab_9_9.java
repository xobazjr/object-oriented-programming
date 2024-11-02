import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ParticleCollision {
    private List<Integer> particles;
    private int totalEnergy;

    public ParticleCollision(List<Integer> particles) {
        this.particles = new ArrayList<>(particles);
        this.totalEnergy = 0;
    }

    public int calculateTotalEnergy() {
        while (particles.size() > 1) {
            int maxDiff = 0;
            int maxIndex = 0;

            for (int i = 0; i < particles.size() - 1; i++) {
                int diff = Math.abs(particles.get(i) - particles.get(i + 1));
                if (diff > maxDiff) {
                    maxDiff = diff;
                    maxIndex = i;
                }
            }

            totalEnergy += maxDiff;

            particles.remove(maxIndex + 1); 
            particles.remove(maxIndex);    
        }

        return totalEnergy;
    }
}

public class lab_9_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> particles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            particles.add(scanner.nextInt());
        }

        ParticleCollision collision = new ParticleCollision(particles);

        int result = collision.calculateTotalEnergy();
        System.out.println(result);

        scanner.close();
    }
}

