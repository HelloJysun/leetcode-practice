package com.jysun.practice.practice;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author jysun
 * @since 2022/2/13
 */
public class HeapSort {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.shiftUp(3);
        heap.shiftUp(6);
        heap.shiftUp(5);
        heap.shiftUp(2);
        heap.shiftUp(4);
        heap.shiftUp(3);
        heap.shiftUp(1);
        heap.print();
        // 6 5 4 3 3 2 1
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
        System.out.println(heap.shiftDown());
    }

    /**
     * heap
     * 堆是一颗完全二叉树，堆中某个节点值总是不大于/不小于其父节点值
     * 数组下标0处不放置元素
     * 某个节点下标：i
     * 其父节点下标：i / 2
     * 左子节点下标：i * 2
     * 右子节点下标：i * 2 + 1
     */
    static class Heap {
        private final int[] data;
        private int capacity;
        private int size;
        public Heap(int capacity) {
            this.data = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size != 0;
        }

        public void print() {
            System.out.println(Arrays.toString(data));
        }

        /**
         * 如果向堆中添加一个元素时，需要触发堆化操作，确保堆的特性不被改变
         * 新添加的元素位于完全二叉树的最右边，需要不断与父节点比较大小交换，这被称为shift up
         */
        public void shiftUp(int num) {
            assert size + 1 <= capacity;
            // 1、当前位置填充待插入元素，并将size自增
            int i = ++size;
            data[i] = num;
            // 2、不断与父节点比较交换
            while (i > 1 && data[i / 2] < num) {
                swap(i / 2, i);
                // 3、当前元素已被挪至父节点处
                i /= 2;
            }
        }

        private void swap(int l, int r) {
            int tmp = data[l];
            data[l] = data[r];
            data[r] = tmp;
        }

        /**
         * 如果从堆顶移除元素时，如果是大顶堆，说明移除了最大的元素，则需要从数组最后拿取元素填充
         * 但拿取的元素是小于其父节点的元素，所以需要将该元素下沉到适当位置，这被称为shift down
         */
        public int shiftDown() {
            // 1、取出堆顶元素，将最后位元素挪至堆顶，size递减
            int res = data[1];
            data[1] = data[size];
            data[size--] = 0;
            // 2、不断比较左右子节点交换较大值
            int i = 1;
            while (2 * i <= size) {
                // 左子节点下标
                int j = 2 * i;
                // 右子节点较大
                if (j + 1 <= size && data[j + 1] > data[j]) {
                    j++;
                }
                if (data[j] > data[i]) {
                    swap(i, j);
                    i = j;
                }
            }
            return res;
        }
    }
}
