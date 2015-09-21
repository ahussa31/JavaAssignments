//Aemen Hussain

package exam;
/*
 * Coding problem 1:  Write the changeKey method of the PQ class
 *
 * The PQ class below implements a priority queue.
 *
 * In this version, entries in the queue are
 * stored in a list that represents a heap.
 * Therefore, the position of the item with
 * highest priority is always at position 0,
 * which represents the root of the heap.
 *
 * Using a heap, the complexity of add is Theta(log n)
 * and remove is Theta(log n).
 */

import java.util.ArrayList;
import java.util.List;

public class PQ<K extends Comparable<K>,V> {
	private static class Entry<K,V> {
		K key;
		V val;

		Entry(K key, V val) {
			this.key = key;
			this.val = val;
		}

		public String toString() {
			return "(" + key + "," + val + ")";
		}
	}

	public List<Entry<K,V>> data = new ArrayList<Entry<K,V>>();

	public String toString() {
		StringBuilder s = new StringBuilder("[");
		for (int i=0; i<data.size()-1; i++)
			s.append(data.get(i) + ",");
		if (data.size() > 0)
			s.append(data.get(data.size()-1));
		return s.append("]").toString();
	}

	public static int parent(int c) {
		return (c-1)/2;
	}

	public static int leftChild(int p) {
		return p*2+1;
	}

	public static int rightChild(int p) {
		return p*2+2;
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void add(K key, V val) {
		data.add(new Entry<K,V>(key,val));
		swim(data.size()-1);
	}

	private void swim(int c) {
		int p = parent(c);
		// compare parent and child keys.  If they're
		// in the wrong order, swap the entries
		if (p >= 0 && data.get(p).key.compareTo(data.get(c).key) > 0) {
			Entry<K,V> temp = data.get(p);
			data.set(p, data.get(c));
			data.set(c, temp);
			swim(p);
		}
	}

	public Entry<K,V> remove() {
		Entry<K,V> answer = data.get(0);
		// replace root with rightmost of the deepest leafs
		data.set(0,data.get(data.size()-1));
		data.remove(data.size()-1);
		sink(0);
		return answer;
	}

	private void sink(int p) {
		int c;
		int l = leftChild(p);
		int r = rightChild(p);
		if (l > data.size()-1)
			return;
		if (r > data.size()-1 || data.get(l).key.compareTo(data.get(r).key) < 0)
			c = l;
		else c = r;
		if (data.get(p).key.compareTo(data.get(c).key) > 0) {
			Entry<K,V> temp = data.get(p);
			data.set(p, data.get(c));
			data.set(c, temp);
			sink(c);

		}
	}

	public void changeKey(V val, K newKey) {


		for(int i=0; i<data.size(); i++){
			if(data.get(i).val.equals(val)){
				data.get(i).key=newKey;
				sink(i);
				swim(i);
			}
		}	
	}

	public static void main(String[ ] args) {
		int[] keys = {2,8,7,6,5,1,10,3,11};
		String[] values = {"a","b","c","d","e","f","g","h","i"};
		PQ<Integer,String> q = new PQ<Integer,String>();
		for (int i=0; i<keys.length; i++) {
			q.add(keys[i], values[i]);
		}
		System.out.println(q);
		q.changeKey("a", 9);
		q.changeKey("g", 4);
		System.out.println(q);
	}
}
