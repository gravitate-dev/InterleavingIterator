# Two Way IterleavingIterator

## Infographic
I wanted to solve iterating across multiple iterators with a round-robin fashion.
<p align="center">
    <image src="https://raw.githubusercontent.com/robert-irribarren/InterleavingIterator/master/design.png"/>
</p>

## Features
- Iterating with `next()` 
- Iterating with `prev()`
- Check prev with `hasPrev()`
- Check next with `hasNext()`

## Usage

```
List<Integer> foo = new ArrayList<>();
foo.add(1);

List<Integer> bar = new ArrayList<>();
bar.add(2);

List<Integer> baz = new ArrayList<>();
baz.add(3);
baz.add(4);
baz.add(5);

List<Iterator<Integer>> myIters = new ArrayList<>();
myIters.add(foo.listIterator());
myIters.add(bar.listIterator());
myIters.add(baz.listIterator());

InterleavingIterator<Integer> ill = new InterleavingIterator(myIters);
while(ill.hasNext()) {
    System.out.println(ill.next());
}
while(ill.hasPrev()) {
    System.out.println(ill.prev());
}
```

would produce

```
1
2
3
4
5
5
4
3
2
1
```
