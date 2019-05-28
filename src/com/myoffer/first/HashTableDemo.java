package com.myoffer.first;

import java.util.Map;

public class HashTableDemo<K, V>{
	// 采用拉链法解决冲突，每一个Entry是一个链表
	private transient Entry<?,?>[] table;// 定义个table数组
	private transient int count;// 链表中键值对实际个数
	private int threshold;// 阈值
	@SuppressWarnings("unused")
	private float loadFactor;// 加载因子

	public HashTableDemo(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("error");
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("error");
		this.loadFactor = loadFactor;
		table = new Entry[initialCapacity];
		threshold = (int) (initialCapacity * loadFactor);
	}

	public HashTableDemo(int initialCapacity) {
		this(initialCapacity, 0.75f);

	}

	public HashTableDemo() {
		this(11, 0.75f);
	}

	// hashTable的Entry节点，本质是一个单向链表
	private static class Entry<K, V> implements Map.Entry<K, V> {
		int hash;// 哈希值
		K key;// 键
		V value;// 值
		Entry<K, V> next;// 指向下一个节点
		// 构造函数

		public Entry(int hash, K key, V value, Entry<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			// hashtable的值不可以为空
			if (value == null)
				throw new IllegalArgumentException();
			V oldValue = this.value;
			this.value = value;
			return oldValue;

		}

		// 覆盖equals方法，判断两个Entry是否相等
		public boolean equals(Object o) {
			if (!(o instanceof Map.Entry))
				return false;

			Map.Entry<?,?> entry=(Map.Entry<?,?>)o;
			return (key==null?entry.getKey()==null:key.equals(entry.getKey())&&
					(value==null?entry.getValue()==null:value.equals(entry.getValue())));	
		}

		public int hashCode() {
			return hash ^ (value == null ? 0 : value.hashCode());
		}
		
		public String toString() {
			return key.toString()+"="+value.toString();
		}
	}
	
	//获取指定的键的值
	public synchronized V get(K key) {
		
		if(key==null)
			throw new NullPointerException();
		
		int hash=hash(key);
		int index=(hash&0x7FFFFFFF)%table.length;
		for(@SuppressWarnings("unchecked")
		Entry<K, V> e=(Entry<K, V>) table[index];e!=null;e=e.next) {
			if (e.hash==hash && e.key.equals(key)) {
				return e.value;	
			}
		}
      return null; 
		
		
	}
	
	public synchronized V put(K key,V value) {
		//不允许值为空
		if (value==null) {
			throw new NullPointerException();
		}
		//首先计算出key的hash值，在计算索引值 
		int hash=hash(key);
		int index=(hash&0x7FFFFFFF)%table.length;
		Entry<?,?>[] newTable=table;
		//循环遍历当前索引的链表
		for(@SuppressWarnings("unchecked")
		Entry<K, V> e=(Entry<K, V>) table[index];e!=null;e=e.next) {
			//比较当前节点的hash值与传入的key的hash值，并且比较键值
			if (e.hash==hash && e.key.equals(key)) {
				V oldValue=e.getValue();
				e.setValue(value);
				return oldValue;
			}
			
			
		}
		//如果当前链表不存在此键值对,采用头插法
		//重新调整大小
		if (count>=threshold)
		{
		rehash();
		newTable=table;
		index=(hash & 0x7FFFFFFF)%newTable.length;
		}
		@SuppressWarnings("unchecked")
		Entry<K, V> e=(Entry<K, V>) table[index];
		newTable[index]=new Entry<K, V>(hash, key, value, e);
		count++;
		return null;
	
	}

	private void rehash() {
		
		
	}

	private int hash(K key) {
		
		return key.hashCode()^(key.hashCode()>>16);
	}

	public static void main(String[] args) {

	}

}
