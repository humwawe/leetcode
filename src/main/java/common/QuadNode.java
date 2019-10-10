package common;

/**
 * @author hum
 */
public class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;

    public QuadNode() {
    }

    public QuadNode(boolean val, boolean isleaf, QuadNode topleft, QuadNode topright, QuadNode bottomleft, QuadNode bottomright) {
        this.val = val;
        this.isLeaf = isleaf;
        this.topLeft = topleft;
        this.topRight = topright;
        this.bottomLeft = bottomleft;
        this.bottomRight = bottomright;
    }
}
