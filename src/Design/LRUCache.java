package Design;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCode_J
 * @description: �����������յ����ݽṹ����ƺ�ʵ��һ�� LRU (�������ʹ��) ������� ��
 *  LRUCache(int capacity) ����������Ϊ���� capacity ��ʼ�� LRU ����
 *  int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 *  void put(int key, int value) ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ��
 * ��ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 * @author: huangrui
 * @create: 2020-11-18 10:34
 **/

public class LRUCache {

    private class CacheNode {
        int val;
        CacheNode next;
        CacheNode pre;

        CacheNode(int val) {
            this.val = val;
        }
    }

    private CacheNode[] data;
    private CacheNode usedLinkHead;
    private CacheNode usedLinkEnd;
    private int[] index;
    private ArrayList<Integer> available;

    public LRUCache(int capacity) {

        this.data = new CacheNode[capacity];
        this.usedLinkHead = new CacheNode(-1);
        this.usedLinkEnd = new CacheNode(-1);
        this.usedLinkHead.pre = null;
        this.usedLinkHead.next = this.usedLinkEnd;
        this.usedLinkEnd.pre = this.usedLinkHead;
        this.usedLinkEnd.next = null;
        index = new int[3000];
        Arrays.fill(index, -1);
        available = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            available.add(i);
        }
    }

    public int get(int key) {
        if (this.index[key] == -1) {
            //��������û�ж�Ӧ����
            return -1;
        } else {
            //���������ж�Ӧ����,�Ƚ����������еĶ�ӦԪ���Ƶ���ͷ
            int in = this.index[key];
            moveToHead(in);
            return this.data[in].val;
        }

    }

    public void put(int key, int value) {
        if (this.index[key] != -1) {
            //����Ԫ���Ѵ���,����ֵ
            this.data[this.index[key]].val = value;
            moveToHead(this.index[key]);
        } else {
            //��������,����ֵ
            if (this.available.size() != 0) {
                //����δ��,ȡ����ɾ����һ��Ԫ��,inΪ���뻺��������±�
                int in = this.available.get(0);
                this.available.remove(0);
                //�����µĽڵ�,nextָ��ָ�������ڵ�,�����ڵ������������ͷ
                CacheNode cacheNode = new CacheNode(value);
                CacheNode useNode = new CacheNode(in);
                cacheNode.next = useNode;
                addToHead(useNode);
                this.data[in] = cacheNode;
                this.index[key] = in;
            } else {
                //��������,ɾ��������δʹ�õ�Ԫ��
                CacheNode toRemove = this.usedLinkEnd.pre;
                this.usedLinkEnd.pre  = toRemove.pre;
                toRemove.pre.next = this.usedLinkEnd;
                //��ȡҪɾ��Ԫ�ص��±�
                int in = toRemove.val;
                //��ȡ��index�����е��±�
                int dataIndex = searchIndex(in);
                //ɾ��index�����ж�ӦԪ��
                this.index[dataIndex] = -1;
                //index��Ӧ�±�Ϊkey��Ԫ�ر����Ӧvalue��data�����е��±�
                this.index[key] = in;
                //��data�����ж�ӦԪ���±����
                data[in].val = value;
                //����Ԫ���ƶ�����������ͷ��
                moveToHead(in);
            }

        }
    }

    private void moveToHead(int i) {
        CacheNode usedIndex = this.data[i].next;
        usedIndex.pre.next = usedIndex.next;
        usedIndex.next.pre = usedIndex.pre;
        usedIndex.next = usedLinkHead.next;
        usedIndex.pre = usedLinkHead;
        this.usedLinkHead.next.pre = usedIndex;
        this.usedLinkHead.next = usedIndex;
    }

    private void addToHead(CacheNode node) {
        node.next = usedLinkHead.next;
        usedLinkHead.next.pre = node;
        node.pre = usedLinkHead;
        usedLinkHead.next = node;
    }

    private int searchIndex(int in) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] == in) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
