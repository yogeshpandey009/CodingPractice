package code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Element implements Comparable<Element> {

    int val;
    int freq;

    Element(int val, int freq) {
	this.val = val;
	this.freq = freq;
    }

    public int compareTo(Element obj) {
	return this.freq - obj.freq;
    }

}

public class TopKFreqElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
	Map<Integer, Integer> freq = new LinkedHashMap<>();
	List<Integer> result = new ArrayList<>();
	for (int a : nums) {
	    if (freq.containsKey(a)) {
		freq.put(a, freq.get(a) + 1);
	    } else {
		freq.put(a, 1);
	    }
	}
	PriorityQueue<Element> heap = new PriorityQueue<>(k);
	int i = 0;
	for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
	    if (i < k) {
		heap.add(new Element(entry.getKey(), entry.getValue()));
	    } else {
		Element top = heap.peek();
		if (top.freq < entry.getValue()) {
		    heap.poll();
		    heap.add(new Element(entry.getKey(), entry.getValue()));
		}
	    }
	    i++;
	}
	for (Element elm : heap) {
	    result.add(elm.val);
	}
	return result;
    }

}
