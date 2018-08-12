/**
 * 均摊时间复杂度
 * @author youyusong
 * @date 2018/8/12
 */
public class MyVector<Item> {

    private Item[] data;

    /**
     * 存储数组中的元素个数
     */
    private int size;

    /**
     * 存储数组中可以容纳的最大的元素个数
     */
    private int capacity;

    public MyVector(){
        data = (Item[])new Object[100];
        size = 0;
        capacity = 100;
    }

    /**
     * 平均复杂度为 O(1)
     * @param e
     */
    public void push_back(Item e){

        if (size == capacity) {
            resize(2 * capacity);
        }

        data[size++] = e;
    }

    /**
     * 平均复杂度为 O(1)
     * @return
     */
    public Item pop_back(){

        if (size <= 0) {
            throw new IllegalArgumentException("can not pop back for empty vector.");
        }

        size --;
        return data[size];
    }

    /**
     * 复杂度为 O(n)
     * @param newCapacity
     */
    private void resize(int newCapacity){

        assert newCapacity >= size;
        Item[] newData = (Item[])new Object[newCapacity];
        for (int i = 0 ; i < size ; i ++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }

}
