/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Linked queue implementation */
class LQueue<E> implements Queue<E> {
  private Link<E> front;    // Pointer to front queue node
  private Link<E> rear;     // Pointer to rear queuenode
  int size;		    // Number of elements in queue

  /** Constructors */
  public LQueue() { init(); }
  public LQueue(int size) { init(); } // Ignore size

  /** Initialize queue */
  private void init() {
    front = rear = new Link<E>(null);
    size = 0;
  }

  /** Reinitialize queue */
  public void clear() { init(); }
  
  /** Put element on rear */
  public void enqueue(E it) {
    rear.setNext(new Link<E>(it, null));
    rear = rear.next();
    size++;
  }

  /** Remove and return element from front */
  public E dequeue() {
    assert size != 0 : "Queue is empty";
    E it = front.next().element();  // Store dequeued value
    front.setNext(front.next().next());  // Advance front
    if (front.next() == null) rear = front; // Last Object
    size--;
    return it;                      // Return Object
  }

  /** @return Front element */
  public E frontValue() {
    assert size != 0 : "Queue is empty";
    return front.next().element();
  }

  /** @return Queue size */
  public int length() { return size; }

// Extra stuff not printed in the book.

  /**
   * Generate a human-readable representation of this queue's contents
   * that looks something like this: < 1 2 3 >.
   * This method uses toString() on the individual elements.
   * @return The string representation of this queue
   */
  public String toString()
  {
    StringBuffer out = new StringBuffer((length() + 1) * 4);
    out.append("< ");
    for (Link<E> i = front.next(); i != null; i = i.next()) {
      out.append(i.element());
      out.append(" ");
    }
    out.append(">");
    return out.toString();
  }
}
