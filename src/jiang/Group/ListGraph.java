package jiang.Group;

import java.util.*;

public class ListGraph<V,E> extends Graph<V,E> {

    public ListGraph() {}
    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();
        Vertex(V value) {
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>)obj).value);
        }
        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        PathInfo.EdgeInfo<V, E> info() {
            return new PathInfo.EdgeInfo<>(from.value, to.value, weight);
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }
        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }
    }

    @Override
    public int edgesSize() {
        return 0;
    }

    @Override
    public int verticesSize() {
        return 0;
    }

    @Override
    public void addVertex(V v) {

    }

    @Override
    public void addEdge(V from, V to) {

    }

    @Override
    public void addEdge(V from, V to, E weight) {

    }

    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V from, V to) {

    }

    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {

    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {

    }

    @Override
    public Set<PathInfo.EdgeInfo<V, E>> mst() {
        return null;
    }

    @Override
    public List<V> topologicalSort() {
        return null;
    }

    @Override
    public Map<V, PathInfo<V, E>> shortestPath(V begin) {
        return null;
    }

    @Override
    public Map<V, Map<V, PathInfo<V, E>>> shortestPath() {
        return null;
    }
}
