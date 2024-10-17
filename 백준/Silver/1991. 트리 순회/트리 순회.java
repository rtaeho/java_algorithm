/*
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

예제 입력 1
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
예제 출력 1
ABDCEFG
DBAECFG
DBEGFCA
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    static HashMap<Character, Node> tree = new HashMap<>();

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            tree.putIfAbsent(parent, new Node(parent)); // 부모 노드 생성
            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(parent).left = tree.get(left); // 왼쪽 자식 설정
            }
            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(parent).right = tree.get(right); // 오른쪽 자식 설정
            }
        }

        // 전위 순회, 중위 순회, 후위 순회 결과 출력
        preorder(tree.get('A'));
        System.out.println(); // 줄 바꿈
        inorder(tree.get('A'));
        System.out.println(); // 줄 바꿈
        postorder(tree.get('A'));
    }

    // 전위 순회
    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value); // 루트
        preorder(node.left); // 왼쪽 자식
        preorder(node.right); // 오른쪽 자식
    }

    // 중위 순회
    private static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left); // 왼쪽 자식
        System.out.print(node.value); // 루트
        inorder(node.right); // 오른쪽 자식
    }

    // 후위 순회
    private static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left); // 왼쪽 자식
        postorder(node.right); // 오른쪽 자식
        System.out.print(node.value); // 루트
    }
}