package com.ryang.leetcode_202107;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 105
// 最多调用 2 * 105 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表


import java.util.HashMap;

/**
 *
 */
public class Case_146_2 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    static class LRUCache {

        class Node {
            /** 这里存key是为了在移除尾部node后，能拿到key，再去map中通过key进行remove */
            private int key;
            private int value;
            private Node pre;
            private Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }

        private int capacity;
        private HashMap<Integer, Node> map = new HashMap<>();
        // 虚拟头、尾节点
        private Node head, tail;

        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("长度不能小于1");
            }
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            // 移动该节点到链表头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                // 已存在，重新赋值
                node.value = value;
                // 移动到链表头部
                moveToHead(node);
            }else {
                // key不存在
                Node node1 = new Node(key, value);
                map.put(key, node1);
                // 放到链表头部
                addToHead(node1);
                if (map.size() > capacity) {
                    // 超出容量范围，移除尾部节点
                    Node node2 = removeTail();
                    map.remove(node2.key);
                }

            }
        }

        /**
         * 将指定node移动到链表头部
         *
         * @param node
         */
        private void moveToHead(Node node) {
            // 从原位置移除
            node.next.pre = node.pre;
            node.pre.next = node.next;

            // 放到链表头部
            addToHead(node);
        }

        /**
         * 将node放到链表头部
         *
         * @param node
         */
        private void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        /**
         * 移除尾部node
         *
         */
        private Node removeTail() {
            Node node = tail.pre;
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            return node;
        }
    }


}
