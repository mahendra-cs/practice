package com.company.psds.graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void bfs(int s){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.println(" "+s);
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
