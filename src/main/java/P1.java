import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1 {
    public void availableFlight(int size, char[] inbounds, char[] outbounds) {
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.map.put(i, new Vertex(i));
        }
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = i; j > 0; j--) {
                if (outbounds[j] == 'Y' && inbounds[j-1] == 'Y') {
                    sb.append("Y");
                } break;
            }

            for (int j = i + 1; j < size - 1; j++) {
                if (outbounds[j] == 'Y' && inbounds[j+1] == 'Y') {
                    sb.append("Y");
                }
            }
        }
    }

    class Vertex {
        public Vertex(Integer label) {
            this.label = label;
            this.next = new ArrayList<>();
        }
        Integer label;
        List<Vertex> next;
    }

    class Graph {
        Map<Integer, Vertex> map = new HashMap<>();
    }
}
