class Solution {
    class UnionFind {
private int[] parent;
private int[] rank;

public UnionFind(int n) {
	parent = new int[n+1];
	rank = new int[n+1];
	for (int i = 0; i < n; i++) {
		parent[i] = i;
}
}

private int find(int x) {
	if (parent[x] != x) {
		parent[x] = find(parent[x]);

}
return parent[x];
}

private boolean union(int x1, int x2) {
    int p1 = find(x1);
    int p2 = find(x2);
    if (p1 == p2) return false;
    else if (p1 < p2) {
    parent[p1] = p2;
    return true;
    } else {
    parent[p2] = p1;
    return true;
}
}
}
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind un = new UnionFind(edges.length);
        for (int[] ed : edges) {
            if (un.union(ed[0],ed[1]) == false) return new int[]{ed[0], ed[1]};
        }
        return new int[]{};
    }
}
