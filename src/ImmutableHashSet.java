import java.util.*;

public class ImmutableHashSet<E> implements Set<E> {
    private Set<E> trueData = new HashSet<>();

    public ImmutableHashSet() {
    }

    public ImmutableHashSet(ImmutableHashSet<E> emptySquares) {
        trueData = new HashSet<>(emptySquares);
    }

    @Override
    public int size() {
        return trueData.size();
    }

    @Override
    public boolean isEmpty() {
        return trueData.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return trueData.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return trueData.iterator();
    }

    @Override
    public Object[] toArray() {
       return trueData.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return trueData.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return trueData.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return trueData.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return trueData.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return trueData.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return trueData.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return trueData.removeAll(c);
    }

    @Override
    public void clear() {
        trueData.clear();
    }

    public void makeImmutable() {
        trueData = Collections.unmodifiableSet(trueData);
    }
}
