package customArrayList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CustomArrayList<T> implements List<T> {
	private Object[] array;
	int currentIterator = 0;

	public CustomArrayList() {
		array = new Object[0];
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (array.length > 0) {
			for (Object i : array) {
				if (i == o || (o != null && o.equals(i)))
					return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomArrayListIterator<>();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, array.length);
	}

	@Override
	public <T> T[] toArray(T[] a) {

		if (a == null)
			throw new NullPointerException();
		if (a.length < size())
			return (T[]) Arrays.copyOf(array, array.length, a.getClass());
		else {
			System.arraycopy(array, 0, a, 0, size());
			if (a.length > size())
				a[size()] = null;
			return a;
		}
	}

	@Override
	public boolean add(T e) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (array.length > 0) {
			int index = indexOf(o);
			if (index != -1) {
				remove(index);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		for (Object o : c) {
			if (!contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T o : c)
			add(o);
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		Object[] helper;
		T[] added = (T[]) c.toArray();
		checkRange(index);

		if (index == size())
			addAll(c);

		else {
			helper = Arrays.copyOfRange(array, index, size());
			for (int i = 0; i < c.size(); i++) {
				if (size() > index + i)
					set(index + i, added[i]);
				else
					add(added[i]);
			}
			for (Object o : helper)
				add((T) o);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object o : c)
			for (int i = 0; i < size(); i++)
				if (array[i] == o || (o != null && o.equals(array[i]))) {
					remove(i);
					i--;
				}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		List<T> removed = new ArrayList<>();
		for (Object o : c)
			for (int i = 0; i < size(); i++)
				if (array[i] == o || (o != null && o.equals(array[i]))) {
					removed.add(remove(i));
					i--;
				}
		array = removed.toArray();
		return true;
	}

	@Override
	public void clear() {
		array = new Object[0];
	}

	@Override
	public T get(int index) {
		checkRange(index);
		return (T) array[index];
	}

	@Override
	public T set(int index, T item) {
		checkRange(index);
		T replaced = (T) array[index];
		array[index] = item;
		return replaced;
	}

	@Override
	public void add(int index, T element) {
		checkRange(index);
		array = Arrays.copyOf(array, array.length + 1);
		for (int i = array.length - 1; i > index; i--)
			array[i] = array[i - 1];
		array[index] = element;
	}

	@Override
	public T remove(int index) {
		checkRange(index);
		T removed = (T) array[index];
		for (int j = index; j < array.length - 1; j++) {
			array[j] = array[j + 1];
		}
		array = Arrays.copyOf(array, array.length - 1);
		return removed;
	}

	@Override
	public int indexOf(Object o) {
		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == o || (o != null && o.equals(array[i])))
					return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (array.length > 0) {
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] == o || (o != null && o.equals(array[i])))
					return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		return new CustomArrayListListIterator<>();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return new CustomArrayListListIterator<>(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
			throw new IndexOutOfBoundsException();
		return new CustomSubList<>(fromIndex, toIndex);
	}

	private void checkRange(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
	}

	private class CustomArrayListIterator<E> implements Iterator<E> {
		int cursor = 0;

		@Override
		public boolean hasNext() {
			return (cursor + 1 <= size());
		}

		@Override
		public E next() {
			if (hasNext()) {
				E returned = (E) array[cursor];
				++cursor;
				return returned;
			} else
				throw new NoSuchElementException();
		}
	}

	private class CustomArrayListListIterator<E> implements ListIterator<E> {
		int cursor = 0;
		boolean isBlocked = true;

		public CustomArrayListListIterator() {
			cursor = 0;
		}

		public CustomArrayListListIterator(int index) {
			cursor = index;
		}

		@Override
		public boolean hasNext() {
			return (cursor + 1 <= size());
		}

		@Override
		public E next() {
			if (hasNext()) {
				cursor++;
				E returned = (E) array[cursor];

				isBlocked = false;
				return returned;
			} else
				throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			return (cursor - 1 >= 0);
		}

		@Override
		public E previous() {
			if (hasPrevious()) {
				cursor--;
				E returned = (E) array[cursor];

				isBlocked = false;
				return returned;
			} else
				throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			if (cursor + 1 >= size())
				return size();
			return cursor + 1;
		}

		@Override
		public int previousIndex() {
			if (cursor - 1 < 0)
				return -1;
			return cursor - 1;
		}

		@Override
		public void remove() {
			if (!isBlocked) {
				isBlocked = true;
				CustomArrayList.this.remove(cursor);
			} else
				throw new IllegalStateException();
		}

		@Override
		public void set(E e) {
			if (!isBlocked)
				CustomArrayList.this.set(cursor, (T) e);
			else
				throw new IllegalStateException();
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
		}
	}

	private class CustomSubList<E> extends AbstractList<E> {

		int fromIndex = 0;
		int toIndex = 0;

		public CustomSubList(int fromIndex, int toIndex) {
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;
		}

		@Override
		public int size() {
			return toIndex - fromIndex;
		}

		@Override
		public E get(int idx) {
			return (E) CustomArrayList.this.get(idx + fromIndex);
		}

		@Override
		public boolean add(E elem) {
			CustomArrayList.this.add(toIndex++, (T) elem);
			return true;
		}
	}
}
