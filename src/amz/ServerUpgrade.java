package amz;

import java.util.Arrays;
import java.util.Map;

/*

 */
public class ServerUpgrade {
    public static void main(String[] args) {
        int[] [] servers = new int[9][9];
        for (int[] row: servers) {
            Arrays.fill(row, 0);
        }
//        servers[4][4] = 1;
        System.out.println(upgradeServer(servers));
        print(servers);
    }

    public static class UpgradeResult {
        boolean serverUpgraded = false;
        int[][] servers;
    }

    private static int upgradeServer(int[][] servers) {
        if (!needToUpgrade(servers)) return -1;
        int day = 0;
        UpgradeResult result = new UpgradeResult();
        result.servers = servers;
        do {
            day++;
            result = upgradeRecursive(result.servers, day);
        } while (result.serverUpgraded);
        return day;
    }

    private static UpgradeResult upgradeRecursive(int[][] servers, int day) {
        int maxHeight = servers.length;
        int maxWidth = servers[0].length;
        UpgradeResult result = new UpgradeResult();
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (servers[i][j] == day) {
                    if (i > 0 && servers[i-1][j] == 0) {
                        servers[i-1][j] = day + 1;
                        result.serverUpgraded = true;
                    }
                    if (i < maxHeight - 1 && servers[i+1][j] == 0) {
                        servers[i+1][j] = day + 1;
                        result.serverUpgraded = true;
                    }
                    if (j > 0 && servers[i][j-1] == 0) {
                        servers[i][j-1] = day + 1;
                        result.serverUpgraded  = true;
                    }
                    if (j < maxWidth - 1 && servers[i][j+1] == 0) {
                        servers[i][j + 1] = day + 1;
                        result.serverUpgraded  = true;
                    }
                }
            }
        }
        result.servers = servers;
        return result;
    }

    private static boolean needToUpgrade(int[][] servers) {
        if (servers.length == 0) return false;
        for (int[] row : servers) {
            for (int server: row) {
                if (server == 1) return true;
            }
        }
        return false;
    }

    private static void print(int[][] servers) {
        for (int[] row: servers) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
