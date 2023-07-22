//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P11 Assignment Planner
// Course:   CS 300 Fall 2021
//
// Author:   Luke Erickson
// Email:    lerickson7@wisc.edu
// Lecturer: Hobbes
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Assignments. Guarantees the
 * min-heap invariant, so that the Assignment at the root should have the earliest due date, and
 * children always have a due date after or at the same time as their parent. The root of a
 * non-empty queue is always at index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
  private Assignment[] queue; // array min-heap of assignments representing this priority queue
  private int size; // size of this priority queue


  /**
   * Creates a new empty AssignmentQueue with the given capacity
   * 
   * @param capacity Capacity of this AssignmentQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public AssignmentQueue(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("invalid capacity");
    queue = new Assignment[capacity];
    size = 0; // how many elements are actually in the priority queue
  }

  /**
   * Checks whether this AssignmentQueue is empty
   * 
   * @return {@code true} if this AssignmentQueue is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the size of this AssignmentQueue
   * 
   * @return the size of this AssignmentQueue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the capacity of this AssignmentQueue
   * 
   * @return the capacity of this AssignmentQueue
   */
  public int capacity() {
    return queue.length;
  }


  /**
   * Removes all elements from this AssignmentQueue
   */
  @Override
  public void clear() {
    for (int i = 0; i < capacity(); i++)
      queue[i] = null;
    size = 0;
  }

  /**
   * Returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment with the
   * earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException if this AssignmentQueue is empty
   */
  @Override
  public Assignment peek() {
    if (isEmpty())
      throw new NoSuchElementException("AssignmentQueue is empty");
    return queue[0];
  }


  /**
   * Adds the given Assignment to this AssignmentQueue at the correct position based on the min-heap
   * ordering. This queue should maintain the min-heap invariant, so that the Assignment at each
   * index has an earlier or equivalent due-date than the Assignments in its child nodes.
   * Assignments should be compared using the Assignment.compareTo() method.
   * 
   * @param e Assignment to add to this AssignmentQueue
   * @throws NullPointerException  if the given Assignment is null
   * @throws IllegalStateException with a descriptive error message if this AssignmentQueue is full
   */
  @Override
  public void enqueue(Assignment e) {
    if (e == null)
      throw new NullPointerException("Assignment is null");
    if (size == capacity())
      throw new IllegalStateException("Priority queue is full");
    queue[size] = e;
    size++;
    // no need to percolate if new item is the only item in the queue
    if (size == 1)
      return;
    // otherwise, percolate up
    percolateUp(size - 1);

  }

  /**
   * Removes and returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment
   * with the earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException with a descriptive error message if this AssignmentQueue is
   *                                empty
   */
  @Override
  public Assignment dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty");

    Assignment root = queue[0];

    // if size > 1, replace root w/ last leaf and percolate down
    if (size > 1) {
      queue[0] = queue[size - 1];
      queue[size - 1] = null;
      size--;
      percolateDown(0);
      return root;
    }
    // otherwise, simply remove the root
    else {
      queue[0] = null;
      size--;
      return root;
    }
  }

  /**
   * Recursive implementation of percolateDown() method. Restores the min-heap invariant of a given
   * subtree by percolating its root down the tree. If the element at the given index does not
   * violate the min-heap invariant (it is due before its children), then this method does not
   * modify the heap. Otherwise, if there is a heap violation, then swap the element with the
   * correct child and continue percolating the element down the heap.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int i) {
    // Time complexity: O(log N)
    // Reasoning: a heap has logN levels. In its worst case, percolateDown will need to traverse
    // thru
    // an index on each level of the heap. Therefore, percolateDown will run logN times.

    int parent = i;
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;

    // if left child is less than or equal to right child and
    // parent is greater than left child, swap parent and left child
    // recurse until "parent" is at correct position
    if (queue[leftChild] != null) {
      // scenario 1 - if right child is null, then go ahead and compare left child to parent
      if (queue[rightChild] == null && queue[parent].compareTo(queue[leftChild]) > 0) {
        swap(parent, leftChild);
        percolateDown(parent);
        return;
      }
      // scenario 2 - only compare left child to parent if left child is less than or equal
      // to right child and right child is not null
      // this prevents a comparison with null & ensures that the min-heap property is followed
      if (queue[rightChild] != null) {
        if (queue[leftChild].compareTo(queue[rightChild]) <= 0
            && queue[parent].compareTo(queue[leftChild]) > 0) {
          swap(parent, leftChild);
          percolateDown(parent);
        }
      }

    }

    // if right child is less than left child and
    // parent is greater than right child, swap parent and right child
    // recurse until "parent" is at correct position
    if (queue[rightChild] != null) {
      // scenario 1 - if left child is null, then go ahead and compare right child to parent
      if (queue[leftChild] == null && queue[parent].compareTo(queue[rightChild]) > 0) {
        swap(parent, rightChild);
        percolateDown(parent);
        return;
      }
      // scenario 2 - only compare right child to parent if right child is less than left
      // child and left child is not null
      // this prevents a comparison with null & ensures that the min-heap property is followed
      if (queue[leftChild] != null) {
        if (queue[rightChild].compareTo(queue[leftChild]) < 0
            && queue[parent].compareTo(queue[rightChild]) > 0) {
          swap(parent, rightChild);
          percolateDown(parent);
        }
      }
    }
  }

  /**
   * Recursive implementation of percolateUp() method. Restores the min-heap invariant of the tree
   * by percolating a leaf up the tree. If the element at the given index does not violate the
   * min-heap invariant (it occurs after its parent), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int i) {
    // Time complexity: O(log N)
    // Reasoning: a heap has logN levels. In its worst case, percolateUp will need to traverse thru
    // an index on each level of the heap. Therefore, percolateUp will run logN times.
    int child = i;
    int parent = (child - 1) / 2;

    // if parent is greater than child, swap parent and child
    // recurse until "child" is at correct position
    if (queue[parent].compareTo(queue[child]) > 0) {
      swap(parent, child);
      percolateUp(child);
    }

  }

  /**
   * private helper method, swaps 2 elements in the queue
   * 
   * @param index1 1st index to be swapped
   * @param index2 2nd index to be swapped
   */
  private void swap(int index1, int index2) {
    Assignment temp = queue[index1];
    queue[index1] = queue[index2];
    queue[index2] = temp;
  }

  /**
   * Returns a deep copy of this AssignmentQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate
   * assignments. Only the instance of the heap (including the array and its size) will be
   * duplicated.
   * 
   * @return a deep copy of this AssignmentQueue. The returned new assignment queue has the same
   *         length and size as this queue.
   */
  public AssignmentQueue deepCopy() {
    AssignmentQueue copy = new AssignmentQueue(capacity());
    // take every element from the original array and enqueue it into the new array
    // the enqueue() method will update size
    for (int i = 0; i < size(); i++)
      copy.enqueue(queue[i]);
    return copy;
  }

  /**
   * Returns a String representing this AssignmentQueue, where each element (assignment) of the
   * queue is listed on a separate line, in order from earliest to latest.
   * 
   * @see Assignment#toString()
   * @see AssignmentIterator
   * @return a String representing this AssignmentQueue
   */
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Assignment a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this AssignmentQueue which proceeds from the earliest to the latest
   * Assignment in the queue.
   * 
   * @see AssignmentIterator
   * @return an Iterator for this AssignmentQueue
   */
  @Override
  public Iterator<Assignment> iterator() {
    return new AssignmentIterator(this);
  }
}
