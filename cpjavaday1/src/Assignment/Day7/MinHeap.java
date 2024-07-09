package Assignment.Day7;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity + 1]; // +1 for 1-based indexing
        size = 0;
    }

    public void insert(int element) {
        if (size == heap.length - 1) {
            System.out.println("Heap is full. Cannot insert " + element);
            return;
        }

        heap[++size] = element;
        int index = size;
        while (index > 1 && heap[index / 2] > heap[index]) {
            swap(index, index / 2);
            index = index / 2;
        }
        System.out.println("Inserted " + element + ". Heap: " + Arrays.toString(heap));
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1;
        }

        int min = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);
        System.out.println("Deleted " + min + ". Heap: " + Arrays.toString(heap));
        return min;
    }

    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        return heap[1];
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

        public static void main(String[] args) {
            MinHeap heap = new MinHeap(5);

            System.out.println("Initial Heap: " + Arrays.toString(heap.heap));

            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            heap.insert(1);
            heap.insert(2);

            System.out.println("Minimum element: " + heap.getMin());

            heap.deleteMin();
            heap.deleteMin();

            System.out.println("Minimum element: " + heap.getMin());
        }
    }
