/**
 * <h3>Binary Visited, 이진 방문 배열</h3>
 * <p>자유롭게 사용 가능하나, 사용 시 저자를 명시해주세요.</p>
 * @author jihogrammer@gmail.com
 */
public class BinaryVisited {

    private static final int BIT = 5;
    private static final int MASK = 31;

    private int[] visited;

    public BinaryVisited() {
        visited = new int[32];
    }

    public BinaryVisited(int size) {
        visited = new int[(size >> BIT) + 1];
    }

    void visitInNode(int node) {
        visited[node >> BIT] |= 1 << (node & MASK);
    }

    boolean isVisited(int node) {
        return ((visited[node >> BIT] >> (node & MASK)) & 1) == 1;
    }

}