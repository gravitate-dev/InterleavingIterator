import java.util.*;

/**
 * A bi-directional interleaved iterator.
 * Allows for both previous and next iteration of a collection of iterators
 * It supports bidirectional iteration
 * a b c
 * 1 2 3
 * 4   5
 *     6
 * the order would be 1,2,3,4,5,6
 * going backwards we would produce 6,5,4,3,2,1
 * @param <E> the type of elements in this list
 */
public class InterleavingIterator<E> {
    List<ListIterator<E>> mData;
    List<Integer> mIterLevels;
    int mLevel = 0, mIndex = -1, mSteps = 0, maxSteps = 0;

    public InterleavingIterator(List<ListIterator<E>> data){
        mData = new ArrayList<>();
        mIterLevels = new ArrayList();
        for (int i=0;i<data.size();i++)
            mIterLevels.add(0);
        mData.addAll(data);
    }

    public boolean hasPrev(){
        // O(1) time
        return mSteps!=0;
    }

    public boolean hasNext(){
        // we can cache this to speed up to O(1)
        if (maxSteps>mSteps)
            return true;

        // O(n) have to iterate the whole list
        Iterator<ListIterator<E>> iter = mData.iterator();
        while(iter.hasNext()){
            ListIterator<E> next = iter.next();
            if (next.hasNext())return true;
        }
        return false;
    }

    public E next(){
        int size = mData.size();
        while(size-->0){
            mIndex = (mIndex+1);
            int index = mIndex%mData.size();
            ListIterator<E> iter = mData.get(index);
            if (iter.hasNext()){
                E result = iter.next();
                mSteps++;
                maxSteps = Math.max(maxSteps,mSteps);
                mIterLevels.set(index,mIterLevels.get(index)+1);
                if (mIndex>=mData.size()){
                    mLevel++;
                    mIndex=0;
                }
                return result;
            }
        }
        return null;
    }

    public E prev(){
        if (!hasPrev()) return null;
        while (mLevel>=0) {
            // read backwards from the current index wrapping around each time we hit mIndex 0
            // decrement mLevel

            int level =mIterLevels.get(mIndex);
            // System.out.println("Looking at index:"+mIndex+" and level "+level);
            if (level>=mLevel){
                ListIterator<E> iter = mData.get(mIndex);
                if (iter.hasPrevious()) {
                    mSteps--;
                    mIterLevels.set(mIndex, level - 1);
                    return iter.previous();
                }
            }
            if (mIndex==0){
                mLevel--;
                mIndex=mData.size()-1;
            } else {
                mIndex = (mIndex - 1) % mData.size();
            }
        }
        mSteps=0;
        return null;
    }

}
