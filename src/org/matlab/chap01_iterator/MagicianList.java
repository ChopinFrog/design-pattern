package org.matlab.chap01_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
 * 01. Iterator 패턴
 * 
 * 프로그래밍을 하다 보면, Array, List, Set, Map과 같은 것을 많이 쓴다.
 * 이것들의 특징은 어떤 데이터들의 집합체라는 것이다.
 * 원래 집합체란 것은 속에 무엇이 들었는냐가 중요하다.
 * 따라서 집합체를 다룰 때에는 집합체가 가지고 있는 개별 원소에 대해서 이런 저런 작업들을 하게 된다.
 * 
 * iterator를 쓰게 되면, 집합체와 개별 원소들간을 분리시켜 생각할 수가 있다.
 * 심지어는 그 집합체가 어떤 클래스의 인스턴스인지조차 신경쓸 필요가 없다.
 *   
 */


public class MagicianList implements Iterable<String>{
	
	private List<String> list = new ArrayList<>();
	
	public void add(String name) {
		list.add(name);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int seq = 0;
			
			public boolean hasNext() {
				return seq < list.size();
			}
			
			public String next() {
				return list.get(seq++);
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] arg) {
		MagicianList magicians = new MagicianList();
		magicians.add("이은결");
		magicians.add("Kevin parker");
		magicians.add("David Blaine");
		
		Iterator<String> iterator = magicians.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);;
		}
	}
	
	/*
	 * 먼저, main 함수의 출력부분을 보면, magicians의 원소들을 뽑아내는데, magicians라는 변수를
	 * 전혀 쓰지 않고 있다. 내부적으로 iterator라는 변수가 magicians와 관계를 유지해주고 있긴 하지만, 일단
	 * iterator를 가지고 온 후에는 데이터 집합체가 뭐냐에 신경을 쓸 필요가 없어진 것이다. iterator만 가져오면, 걍
	 * hasNext(), next()만 가지고 반복하면서 원소들에 대해서 처리를 하면 된다.
	 * 
	 */
}
