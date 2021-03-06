package net.pizey;

import java.util.List;

/**
 * A Linked List with forwards and backwards links.
 * Node values may be null and can be duplicate.
 */
public class LinkedList<T> {

  private Node<T> first;
  private int count;

  public LinkedList(List<T> them) {
    for (T i : them) {
      this.append(i);
    }
  }

  public void append(T i) {
    count++;
    if (first == null) {
      first = new Node<T>(null, i);
    } else {
      Node<T> l = first.last();
      l.next = new Node<T>(l, i);
    }
  }

  public Node<T> first() {
    return first;
  }

  public Node<T> last() {
    return first == null ? null : first.last();
  }

  public int size() {
    return count;
  }

  public Node<T> findFirst(T v) {
    Node<T> currentNode = first;
    while (currentNode != null) {
      if (currentNode.value == null) {
        if (v == null) {
          break;
        }
      } else {
        if (currentNode.value.equals(v)) {
          break;
        }
      }
      currentNode = currentNode.next;
    }
    return currentNode;
  }

  /**
   * If the value is not found nothing is done.
   */
  public LinkedList<T> removeFirstOccurrence(T value) {
    Node found = findFirst(value);
    if (found != null) {
      count--;
      Node previous = found.previous;
      if (found.next != null) {
        found.next.previous = previous;
      }
      if (previous == null) {
        first = found.next;
      } else {
        previous.next = found.next;
      }
    }
    return this;
  }

  public String toString() {
    return "[" + (first == null ? "" : first.toString()) + "]";
  }

  public class Node<T> {
    Node(Node<T> p, T v) {
      this.previous = p;
      this.value = v;
    }

    public T value;
    public Node<T> next;
    public Node<T> previous;

    public Node<T> last() {
      if (this.next == null) {
        return this;
      } else {
        return next.last();
      }
    }

    public String toString() {
      String it = "";
      if (previous != null) {
        it += ",";
      }
      if (value == null) {
        it += "null";
      } else {
        it += value.toString();
      }
      if (next != null) {
        it += next.toString();
      }
      return it;
    }
  }

}
