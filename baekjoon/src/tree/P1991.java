package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1991 {
    static String[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        int len = (int) (Math.pow(2, 26)+2);

        tree = new String[len];
        Arrays.fill(tree, ".");
        tree[1] = "A";
        String[] inputs;
        int index = 0;
        for(int i=0; i<node; i++) {
            inputs = br.readLine().split(" ");
            for(int j=0; j<tree.length; j++) {
                if(tree[j].equals(inputs[0])) {
                    index = j;
                    break;
                }
            }

            if(index*2 <= tree.length && !inputs[1].equals(".")) {
                tree[index*2] = inputs[1];
            }
            if(index*2 <= tree.length && !inputs[2].equals(".")) {
                tree[index*2+1] = inputs[2];
            }
        }

        StringBuilder sb = new StringBuilder();
        preorder(1, sb);
        sb.append("\n");

        inorder(1, sb);
        sb.append("\n");

        postorder(1, sb);
        System.out.println(sb);
    }

    public static void preorder(int index, StringBuilder sb) {
        sb.append(tree[index]);

        if(index*2 <= tree.length && !tree[index*2].equals(".")) {
            preorder(index*2, sb);
        }
        if(index*2 <= tree.length && !tree[index*2+1].equals(".")) {
            preorder(index*2+1, sb);
        }
    }

    public static void inorder(int index, StringBuilder sb) {
        if(index*2 <= tree.length && !tree[index*2].equals(".")) {
            inorder(index*2, sb);
        }

        sb.append(tree[index]);

        if(index*2 <= tree.length && !tree[index*2+1].equals(".")) {
            inorder(index*2+1, sb);
        }
    }

    public static void postorder(int index, StringBuilder sb) {
        if(index*2 <= tree.length && !tree[index*2].equals(".")) {
            postorder(index*2, sb);
        }
        if(index*2 <= tree.length && !tree[index*2+1].equals(".")) {
            postorder(index*2+1, sb);
        }
        sb.append(tree[index]);
    }
}
