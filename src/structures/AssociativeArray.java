//START HERE, expand and find still need to be implemented

package structures;

import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Your Name Here
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K, V> ret = new AssociativeArray<K, V>();
    for (int i = 0; i < this.size; i++) {
      ret.pairs[i] = this.pairs[i];
    }
    return ret;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    if (this.size == 0) {
      return "{}";
    } // if the array is empty, without this the formatting would be incorrect ("{ }" not "{}")
    String[] strArray = new String[this.size + 2];
    strArray[0] = "{ ";
    for (int i = 1; i < this.size; i++) {
      strArray[i] = this.pairs[i].key.toString() + ": " + this.pairs[i].value.toString() + ", ";
    }
    strArray[this.size - 1] = "}";
    return strArray.toString(); 
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   */
  public void set(K key, V value) throws NullKeyException {
    if (key == null) {
      throw new NullKeyException();
    }
    int i = 0;
    while (!this.pairs[i].key.equals(key) || i == this.size) {
      i++;
    }
    this.pairs[i].key = key;
    this.pairs[i].value = value;

    if(i == this.size) {
      this.size++;
    }
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException
   *                              when the key is null or does not 
   *                              appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    if (!this.hasKey(key)) {
      throw new KeyNotFoundException();
    }
    int i = 0;
    while (!this.pairs[i].key.equals(key)) {
      i++;
    }
    return this.pairs[i].value;

  } // get(K)

  /**
   * Determine if key appears in the associative array. Should
   * return false for the null key.
   */
  public boolean hasKey(K key) {
    int i = 0;
    while (!this.pairs[i].key.equals(key) || i == this.size) {
      i++;
    }
    return i != this.size; // STUB
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    for(int i = 0; i < this.size; i++) {
      if (this.pairs[i].key.equals(key)) {
        this.pairs[i] = this.pairs[this.size - 1];
        this.pairs[this.size - 1] = null;
        this.size--;
        return;
      }
    }
  } // remove(K)

  /**
   * Determine how many key/value pairs are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    throw new KeyNotFoundException();   // STUB
  } // find(K)

} // class AssociativeArray
