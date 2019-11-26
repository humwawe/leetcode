package quad.tree.intersection;

import common.QuadNode;

public class QuadTreeIntersection {
    public QuadNode intersect(QuadNode quadTree1, QuadNode quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            }
            return quadTree2;
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return quadTree2;
            }
            return quadTree1;
        }

        QuadNode topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        QuadNode topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        QuadNode bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        QuadNode bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new QuadNode(topLeft.val, true, null, null, null, null);
        }
        return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
