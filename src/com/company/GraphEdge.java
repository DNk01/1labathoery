package com.company;

// Дуга
public class GraphEdge {
	// Левая узел
	public final GraphNode leftNode;
	// Правый узел
	public final GraphNode rightNode;

	// вес дуги
	public final int weight;

	public GraphEdge(GraphNode leftNode, GraphNode rightNode, int weight) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.weight = weight;
	}
}
