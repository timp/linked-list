package net.pizey;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by timp on 02/06/15.
 */
public class LinkedListTest extends TestCase {
  public void testRemove() {
    ArrayList<String> items = new ArrayList<String>();
    items.add("a");
    items.add("b");
    items.add("c");
    LinkedList<String> it = new LinkedList<String>(items);
    assertEquals("[a,b,c]", it.toString());
    assertEquals(3, it.size());
    assertEquals("a", it.first().value);
    assertEquals("c", it.last().value);

    it.removeFirstOccurrence("z");
    assertEquals("[a,b,c]", it.toString());
    assertEquals(3, it.size());
    assertEquals("a", it.first().value);
    assertEquals("c", it.last().value);

    it.removeFirstOccurrence(null);
    assertEquals("[a,b,c]", it.toString());
    assertEquals(3, it.size());
    assertEquals("a", it.first().value);
    assertEquals("c", it.last().value);

    it.removeFirstOccurrence("a");
    assertEquals("[b,c]", it.toString());
    assertEquals(2, it.size());
    assertEquals("b", it.first().value);
    assertEquals("c", it.last().value);

    it.removeFirstOccurrence("a");
    assertEquals("[b,c]", it.toString());
    assertEquals(2, it.size());
    assertEquals("b", it.first().value);
    assertEquals("c", it.last().value);

    it.removeFirstOccurrence("c");
    assertEquals("[b]", it.toString());
    assertEquals(1, it.size());
    assertEquals("b", it.first().value);
    assertEquals("b", it.last().value);

    it.removeFirstOccurrence("b");
    assertEquals("[]", it.toString());
    assertEquals(0, it.size());
    assertNull(it.first());
    assertNull(it.last());

  }

  public void testCanContainNull() {
    ArrayList<String> items = new ArrayList<String>();
    items.add(null);
    items.add("a");
    items.add("b");
    items.add(null);
    items.add("c");
    items.add(null);
    LinkedList<String> it = new LinkedList<String>(items);
    assertEquals("[null,a,b,null,c,null]", it.toString());
    assertEquals(6, it.size());
    assertNull(it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence("z");
    assertEquals("[null,a,b,null,c,null]", it.toString());
    assertEquals(6, it.size());
    assertNull(it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence(null);
    assertEquals("[a,b,null,c,null]", it.toString());
    assertEquals(5, it.size());
    assertEquals("a", it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence("a");
    assertEquals("[b,null,c,null]", it.toString());
    assertEquals(4, it.size());
    assertEquals("b", it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence("a");
    assertEquals("[b,null,c,null]", it.toString());
    assertEquals(4, it.size());
    assertEquals("b", it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence("c");
    assertEquals("[b,null,null]", it.toString());
    assertEquals(3, it.size());
    assertEquals("b", it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence("b");
    assertEquals("[null,null]", it.toString());
    assertEquals(2, it.size());
    assertNull(it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence(null);
    assertEquals("[null]", it.toString());
    assertEquals(1, it.size());
    assertNull(it.first().value);
    assertNull(it.last().value);

    it.removeFirstOccurrence(null);
    assertEquals("[]", it.toString());
    assertEquals(0, it.size());
    assertNull(it.first());
    assertNull(it.last());

  }


}
