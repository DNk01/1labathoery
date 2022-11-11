package com.company;

import java.util.*;

public class Main {
	static int sum = 0; //Сумма расстояний между дугами

	public static void main(String[] args) {
		List<GraphNode> nodesUnlinked = new ArrayList<>(); //Массив из несоедененных узлов
		List<GraphNode> nodesLinked = new ArrayList<>(); //Массив из соедененных узлов
		init(nodesUnlinked, nodesLinked); //Инициализация массивов
		prim(nodesLinked, nodesUnlinked); //Запуск алгоритма Прима
		System.out.println("Минимальная сумма равна: " + sum);
	}

	static void prim(List<GraphNode> nodesLinked, List<GraphNode> nodesUnlinked) {
		if (nodesUnlinked.isEmpty()) //Как только массив несоедененных узлов станет пустым
			return; //Мы выходим из подпрограммы
		int x = -1, y = -1, min = Integer.MAX_VALUE; // x - исходящий узел, y - входящий узел, min - минимальное расстояние
		for (int i = 0; i < nodesLinked.size(); i++) { // проходим по всем соедененным узлам
			List<GraphEdge> edges = nodesLinked.get(i).nodeList; //получаем все дуги для текущего узла
			for (int j = 0; j < edges.size(); j++) { //проходим по всем дугам текущего узла
				GraphEdge ge = edges.get(j); //получаем текущую дугу
				if (ge.weight <= min && nodesUnlinked.contains(ge.rightNode)) { //Если расстояние между дугами меньше текущего минимального расстояния и входящий узел входит в массив несоедененных узлов
					min = ge.weight; //расстояние между дугами становится минимальным
					x = i; //сохраняем исходящий узел
					y = j; //сохраняем входящий узел
				}
			}
		}
		GraphEdge ge = nodesLinked.get(x).nodeList.get(y); //получаем минимальную дугу
		System.out.println("(" + ge.leftNode.data + ":" + ge.rightNode.data + ")"); //вывод дуги
		sum += ge.weight; //увеличиваем сумму остовного дерева на расстояние между минимальной дугой
		nodesLinked.add(ge.rightNode); //добавляем в массив соедененных дуг входящую дугу
		nodesUnlinked.remove(ge.rightNode); //удаляем из массива несоедененных дуг входящую дугу
		prim(nodesLinked, nodesUnlinked); //еще раз вызываем метод алгоритма Прима
	}

	private static void init(List<GraphNode> nodesUnlinked, List<GraphNode> nodesLinked) {
		GraphNode G1 = new GraphNode("1"); //создаем все узлы
		GraphNode G2 = new GraphNode("2");
		GraphNode G3 = new GraphNode("3");
		GraphNode G4 = new GraphNode("4");
		GraphNode G5 = new GraphNode("5");
		GraphNode G6 = new GraphNode("6");
		GraphNode G7 = new GraphNode("7");
		GraphNode G8 = new GraphNode("8");
		GraphNode G9 = new GraphNode("9");
		GraphNode G10 = new GraphNode("10");
		GraphEdge G1G2 = new GraphEdge(G1, G2, 6); //создаем все дуги
		GraphEdge G1G3 = new GraphEdge(G1, G3, 10);
		GraphEdge G1G4 = new GraphEdge(G1, G4, 6);
		GraphEdge G1G5 = new GraphEdge(G1, G5, 4);
		GraphEdge G1G7 = new GraphEdge(G1, G7, 3);
		GraphEdge G1G10 = new GraphEdge(G1, G10, 6);
		G1.nodeList.add(G1G2);//добавляем все дуги к соответствующим узлам
		G1.nodeList.add(G1G3);
		G1.nodeList.add(G1G4);
		G1.nodeList.add(G1G5);
		G1.nodeList.add(G1G7);
		G1.nodeList.add(G1G10);

		GraphEdge G2G1 = new GraphEdge(G2, G1, 6);
		GraphEdge G2G3 = new GraphEdge(G2, G3, 4);
		GraphEdge G2G10 = new GraphEdge(G2, G10, 8);
		G2.nodeList.add(G2G1);
		G2.nodeList.add(G2G3);
		G2.nodeList.add(G2G10);

		GraphEdge G3G1 = new GraphEdge(G3, G1, 10);
		GraphEdge G3G2 = new GraphEdge(G3, G2, 4);
		GraphEdge G3G4 = new GraphEdge(G3, G4, 9);

		G3.nodeList.add(G3G1);
		G3.nodeList.add(G3G2);
		G3.nodeList.add(G3G4);

		GraphEdge G4G1 = new GraphEdge(G4, G1, 6);
		GraphEdge G4G3 = new GraphEdge(G4, G3, 9);
		GraphEdge G4G5 = new GraphEdge(G4, G5, 1);

		G4.nodeList.add(G4G1);
		G4.nodeList.add(G4G3);
		G4.nodeList.add(G4G5);

		GraphEdge G5G1 = new GraphEdge(G5, G1, 4);
		GraphEdge G5G4 = new GraphEdge(G5, G4, 1);
		GraphEdge G5G6 = new GraphEdge(G5, G6, 8);
		GraphEdge G5G7 = new GraphEdge(G5, G7, 5);

		G5.nodeList.add(G5G1);
		G5.nodeList.add(G5G4);
		G5.nodeList.add(G5G6);
		G5.nodeList.add(G5G7);

		GraphEdge G6G5 = new GraphEdge(G6, G5, 8);
		GraphEdge G6G7 = new GraphEdge(G6, G7, 10);
		GraphEdge G6G8 = new GraphEdge(G6, G8, 15);
		G6.nodeList.add(G6G5);
		G6.nodeList.add(G6G7);
		G6.nodeList.add(G6G8);

		GraphEdge G7G1 = new GraphEdge(G7, G1, 3);
		GraphEdge G7G5 = new GraphEdge(G7, G5, 5);
		GraphEdge G7G6 = new GraphEdge(G7, G6, 10);
		GraphEdge G7G8 = new GraphEdge(G7, G8, 8);
		GraphEdge G7G9 = new GraphEdge(G7, G9, 15);
		GraphEdge G7G10 = new GraphEdge(G7, G10, 9);
		G7.nodeList.add(G7G1);
		G7.nodeList.add(G7G5);
		G7.nodeList.add(G7G6);
		G7.nodeList.add(G7G8);
		G7.nodeList.add(G7G9);
		G7.nodeList.add(G7G10);

		GraphEdge G8G6 = new GraphEdge(G8, G6, 15);
		GraphEdge G8G7 = new GraphEdge(G8, G7, 8);
		GraphEdge G8G9 = new GraphEdge(G8, G9, 19);
		G8.nodeList.add(G8G6);
		G8.nodeList.add(G8G7);
		G8.nodeList.add(G8G9);

		GraphEdge G9G7 = new GraphEdge(G9, G7, 15);
		GraphEdge G9G8 = new GraphEdge(G9, G8, 19);
		GraphEdge G9G10 = new GraphEdge(G9, G10, 12);
		G9.nodeList.add(G9G7);
		G9.nodeList.add(G9G8);
		G9.nodeList.add(G9G10);

		GraphEdge G10G1 = new GraphEdge(G10, G1, 6);
		GraphEdge G10G2 = new GraphEdge(G10, G2, 8);
		GraphEdge G10G7 = new GraphEdge(G10, G7, 9);
		GraphEdge G10G9 = new GraphEdge(G10, G9, 12);

		G10.nodeList.add(G10G1);
		G10.nodeList.add(G10G2);
		G10.nodeList.add(G10G7);
		G10.nodeList.add(G10G9);

		nodesUnlinked.add(G2);//добавляем все узлы к несоедененным кроме первого
		nodesUnlinked.add(G3);
		nodesUnlinked.add(G4);
		nodesUnlinked.add(G5);
		nodesUnlinked.add(G6);
		nodesUnlinked.add(G7);
		nodesUnlinked.add(G8);
		nodesUnlinked.add(G9);
		nodesUnlinked.add(G10);

		nodesLinked.add(G1); //добавляем первый узел к соедененным
	}
}
