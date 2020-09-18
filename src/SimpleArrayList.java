import java.util.List;

public class SimpleArrayList {

	public static String [] data;
    public static int size;
	
	public SimpleArrayList() {
		data = new String[1];
		data[0] = "";
		size = 0;
	}
	
	public SimpleArrayList(int initialCapacity) {
		if (initialCapacity == -1) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		data = new String[1];
		data[0] = "";
		size = 0;
	}
	
	public SimpleArrayList(List<String> list) {
		if (list == null) throw new NullPointerException();
        data = new String[list.size()]; 
        for (int x = 0; x < list.size(); x++) { 
            data[x] = list.get(x);
        } 
        size = data.length;
	}
	
	public static void main(String[] args) {
		
	}

	public void add(int index, String s) {
		int x = 0;
		String[] temp = new String[data.length+1];
		if (index < 0 || (data[x] != "" && index > data.length) || (data[x] == "" && index >= data.length)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
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
		size++;
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
		size++;
	}
	
	public void clear() {
		size = 0;
		data = new String[1];
		data[0] = "";
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
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
		}
		String x;
		return x = data[index];
	}
	
	public int indexOf(String s) {
		int x = 0;
		int location = -1;
		int lengthChecker = data.length;
		while (x < lengthChecker) {
			if (data[x] == s) {
				location = x;
				return location;
			} else {
				x++;
			}
		}
		return location;
	}
	
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}
	
	public String remove(int index) {
		int x = 0;
		
		if (index < 0 || (data[x] != "" && index > data.length) || (data[x] == "" && index >= data.length)) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
		}
		String[] temp = new String[data.length-1];
		String removed = "";
		
		while (x < temp.length) {
			if (x < index) {
				temp[x] = data[x];
			} else if (x == index) {
				removed = data[x];
				temp[x] = data[x+1];
			} else {
				temp[x] = data[x+1];
			}
			x++;
		}
		data = temp;
		size--;
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
				size--;
				return finished;
			} else {
				x++;
			}
		}
		
		return finished;
	}
	
	public String set(int index, String s) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
		}
		String oldValue = data[index];
		if (s == null) {
			s = "null";
		}
		data[index] = s;
		return oldValue;
	}
	
	public int size() {
		return size;
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

