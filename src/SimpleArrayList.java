import java.util.List;

public class SimpleArrayList {

	public static String [] data;
    public static int elementsInArray;
	
	public SimpleArrayList() {
		data = new String[1];
		data[0] = "";
	}
	
	public SimpleArrayList(int initialCapacity) {
		data = new String[1];
		data[0] = "";
	}
	
	public SimpleArrayList(List<String> list) {
		if (list == null) throw new IllegalArgumentException();
        data = new String[list.size()]; 
        for (int x = 0; x < list.size(); x++) { 
            data[x] = list.get(x);
        } 
	}
	
	public static void main(String[] args) {
		SimpleArrayList list = new SimpleArrayList(15);
		list.add("John");
		list.add("Steve");
		list.add(3, "Author");
		System.out.print(list);
	}

	public void add(int index, String s) {
		int x = 0;
		String[] temp = new String[data.length+1];
		if (index < 0 || (data[x] != "" && index > data.length) || (data[x] == "" && index >= data.length)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + data.length);
		} else if (data[x] != "") {
				while (x < temp.length) {
					if (x < index) {
						temp[x] = data[x];
					} else if (x == index) {
						temp[x] = s;
					} else {
						temp[x] = data[x-1];
					}
					x++;
				}
				data = new String[temp.length];
				data = temp;
			} else {
				data[x] = s;
			}
	}
	
	public void add(String s) {
		int x = 0;
		String [] temp = new String[data.length+1];
		
		if (data[x] != "") { 
			while (x < temp.length) {
				if (x < temp.length-1) {
					temp[x] = data[x];
				} else {
					temp[x] = s;
				}
				x++;
			}
			data = new String[temp.length];
			data = temp;
		} else {
			data[0] = s;
		}
	}
	
	public void clear() {
		int x = 0;
		int lengthChecker = data.length;
		while (x < lengthChecker) {
			data[x] = null;
			x++;
		}
	}
	
	public boolean contains(String s) {
		int x = 0;
		int lengthChecker = data.length;
		boolean doesItContain = false;
		while (x < lengthChecker) {
			if (data[x] == s) { 
				doesItContain = true;
				x = data.length;
			} else {
				x++;
			}
		}
		return doesItContain;
	}
	
	public String get(int index) {
		String x;
		return x = data[index];
	}
	
	public int indexOf(String s) {
		int x = 0;
		int location = -1;
		int lengthChecker = data.length;
		while (x < lengthChecker) {
			if (data[x] == s) {
				return location;
			} else {
				x++;
			}
		}
		return location;
	}
	
	public boolean isEmpty() {
		boolean empty = true;
		int x = 0;
		int lengthChecker = data.length;
		while (x < lengthChecker) {
			if (data[x] == null) {
				x++;
			} else {
				empty = false;
			}
		}
		return empty;
	}
	
	public String remove(int index) {
		int x = 0;
		String[] temp = new String[data.length-1];
		String removed = "";
		
		while (x < temp.length) {
			if (x < index) {
				temp[x] = data[x];
			} else if (x == index) {
				removed = data[x];
			} else {
				temp[x] = data[x+1];
			}
			x++;
		}
		data = temp;
		return removed;
	}
	
	public boolean remove(String s) {
		int x = 0;
		boolean finished = false;
		int lengthChecker = data.length;
		while (x < lengthChecker) {
			if (data[x] == s) {
				data[x] = null;
				finished = true;
				return finished;
			} else {
				x++;
			}
		}
		return finished;
	}
	
	public String set(int index, String s) {
		String oldValue = data[index];
		data[index] = s;
		return oldValue;
	}
	
	public int size() {
		elementsInArray = 0;
		for (int x = 0; x < data.length; x++) {
			if (data[x] != null && data[x] != "") {
				elementsInArray++;
			}
		}
		return elementsInArray;
	}
		
	public void trimToSize() {
		int counter = data.length;
		int y = 0;
		String[] temp = new String[data.length];
		for (int x = 0; x < data.length; x++) {
			if(data[x] == null) {
				counter--;
			} else {
				temp[y] = data[x];
				y++;
			}
		}
		data = new String[counter];
		for (int x = 0; x < counter; x++) {
			data[x] = temp[x];
		}
	}
	
	public String toString() {
		String concat = "[";
		for (int x = 0; x < data.length; x++) {
			if (data[x] != null) {
				concat += data[x];
				concat += ", ";
			}
		}
		concat = concat.substring(0,concat.length()-2);
		return concat += "]";
	}
}

