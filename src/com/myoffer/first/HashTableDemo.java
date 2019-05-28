package com.myoffer.first;

import java.util.Map;

public class HashTableDemo<K, V>{
	// ���������������ͻ��ÿһ��Entry��һ������
	private transient Entry<?,?>[] table;// �����table����
	private transient int count;// �����м�ֵ��ʵ�ʸ���
	private int threshold;// ��ֵ
	@SuppressWarnings("unused")
	private float loadFactor;// ��������

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

	// hashTable��Entry�ڵ㣬������һ����������
	private static class Entry<K, V> implements Map.Entry<K, V> {
		int hash;// ��ϣֵ
		K key;// ��
		V value;// ֵ
		Entry<K, V> next;// ָ����һ���ڵ�
		// ���캯��

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
			// hashtable��ֵ������Ϊ��
			if (value == null)
				throw new IllegalArgumentException();
			V oldValue = this.value;
			this.value = value;
			return oldValue;

		}

		// ����equals�������ж�����Entry�Ƿ����
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
	
	//��ȡָ���ļ���ֵ
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
		//������ֵΪ��
		if (value==null) {
			throw new NullPointerException();
		}
		//���ȼ����key��hashֵ���ڼ�������ֵ 
		int hash=hash(key);
		int index=(hash&0x7FFFFFFF)%table.length;
		Entry<?,?>[] newTable=table;
		//ѭ��������ǰ����������
		for(@SuppressWarnings("unchecked")
		Entry<K, V> e=(Entry<K, V>) table[index];e!=null;e=e.next) {
			//�Ƚϵ�ǰ�ڵ��hashֵ�봫���key��hashֵ�����ұȽϼ�ֵ
			if (e.hash==hash && e.key.equals(key)) {
				V oldValue=e.getValue();
				e.setValue(value);
				return oldValue;
			}
			
			
		}
		//�����ǰ�������ڴ˼�ֵ��,����ͷ�巨
		//���µ�����С
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
