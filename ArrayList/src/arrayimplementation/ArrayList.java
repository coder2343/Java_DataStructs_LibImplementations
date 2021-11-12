package arrayimplementation;
import java.util.AbstractCollection;
import java.util.Iterator;
public class ArrayList<T, AnyType> {


	

	public class TaskArrayList extends AbstractCollection<T> {
		private static final int DEFAULT_CAP = 10;

		private int capacity;
		private Object [] taskArr;
		private int index;// size

		public TaskArrayList() {
			taskArr = new Object [DEFAULT_CAP];
			capacity = DEFAULT_CAP;
			index = 0;
		}

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean add(T task) {
			if (index == capacity) {
				T[] temp = taskArr;
				taskArr = new T[3 * capacity + 1];
				for (int i = 0; i < capacity; i++) {
					taskArr[i] = temp[i];
				}
			}
			taskArr[index++] = task;
			return true;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return index;
		}

		private Integer getTaskByID(int id) {
			Integer indx = null;
			for (int i = 0; i < index; i++) {
				if (taskArr[i].getId() == id) {
					indx = i;
					break;
				}
			}
			if (indx == null) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return indx;

		}

		public Object  removeByID(int id) {
			int spot = getTaskByID(id);
			Object removedItem = taskArr[spot];
			for (int i = spot; i < index - 1; i++) {
				taskArr[i] = taskArr[i + 1];
			}
			index--;
			return removedItem;

		}
		
		public String toString() {
			String str = "TaskArray: \n";
			for (int i = 0; i < index; i++) {
				str += taskArr[i].toString() + "\n";
			}
			return str;
		}

	}

}
