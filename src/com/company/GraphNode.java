package com.company;

import java.util.ArrayList;
import java.util.List;

// Узел графа
public class GraphNode {
	// Значение узла
	public String data;
	// Исходящие дуги
	public List<GraphEdge> nodeList;
	// Конструктор класса
	public GraphNode(String data) {
		this.data = data;
		nodeList = new ArrayList<>();
	}
}
