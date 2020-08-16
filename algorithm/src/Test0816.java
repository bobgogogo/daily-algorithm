import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test0816 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] offsetIndex = {{0,1},{1,0},{0,-1},{-1,0}};
        LinkedList<int[]> processList = new LinkedList<>();
        int[] init = new int[]{sr,sc};

        processList.offer(init);
        int oldColor = image[sr][sc];
        image[sr][sc]=newColor;
        if (oldColor==newColor||image[0].length==0) {
            return image;
        }
        while (processList.peek()!=null) {
            int[] poll = processList.poll();
            for (int[] index : offsetIndex) {
                int x = poll[0]+index[0];
                int y = poll[1]+index[1];
                if (x>=0 && y>=0 && x<image.length && y<image[0].length && image[x][y]==oldColor) {
                    processList.offer(new int[]{x,y});
                    image[x][y]=newColor;
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
            new int[]{0,0,0},
                new int[]{0,1,0}
        };
        Test0816 test0816 = new Test0816();
        int[][] ints = test0816.floodFill(a, 1, 1, 2);
        System.out.println(Arrays.toString(ints));

    }


}
