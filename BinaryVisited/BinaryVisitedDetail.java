/**
 * <h3>Binary Visited, 이진 방문 배열</h3>
 * <p>자유롭게 사용 가능하나, 사용 시 저자를 명시해주세요.</p>
 * @author jihogrammer@gmail.com
 */
public class BinaryVisitedDetail {

    /* 
     * <용어 정리>
     * - BinaryVisited : 이진수를 활용한 방문 배열 구현체.
     * - Page          : 32개 노드 초과 시 배열로 관리하기 위한 구분.
     *                   int[] visited의 index에 해당한다.
     * 
     * <사용 방법>
     * - README 참고
     * - void    visitInNode(int node) : 해당 노드에 방문한다.
     * - boolean isVisited(int node)   : 새로 방문한 노드가 이미 방문했었다면 true,
     *                                   처음으로 방문한 노드라면 false를 반환한다.
     */

    /**
     * primitive int는 2^5의 비트로 구성된다.
     * 각 Node의 Page를 조정한다.
     */
    private static final int BIT = 5;

    /**
     * 이진수로 이루어진 Mask.
     * <p>0001 1111 (2)</p>
     * cf. 메르센 소수
     */
    private static final int MASK = 31;

    /**
     * 이 클래스의 핵심이 되는 객체입니다.
     * Page로 분할되어 각 Page는 32개의 boolean을 표현합니다.
     */
    private int[] visited;

    /**
     * 기본 생성자로 사용 시 최대 1024개의 노드를 방문 관리합니다.
     * 예외 처리를 하지 않았으므로, 런타임 시 다음 예외가 발생할 수 있습니다.
     * @see java.lang.ArrayIndexOutOfBoundsException
     */
    public BinaryVisitedDetail() {
        visited = new int[32];
    }

    /**
     * 생성 시 방문할 노드의 개수(size)를 명시해 사용합니다.
     * @param size
     */
    public BinaryVisitedDetail(int size) {
        visited = new int[(size >> BIT) + 1];
    }

    /**
     * 해당하는 노드의 비트를 0에서 1로 변환합니다.
     * 즉, 해당 노드를 방문했다는 표시를 합니다.
     * @param node
     */
    void visitInNode(int node) {
        visited[node >> BIT] |= 1 << (node & MASK);
    }

    /**
     * 해당 노드가 이미 방문한 노드인지 아닌지 판별합니다.
     * @param node
     * @return 방문했다면 true, 방문하지 않았다면 false
     */
    boolean isVisited(int node) {
        return ((visited[node >> BIT] >> (node & MASK)) & 1) == 1;
    }

}