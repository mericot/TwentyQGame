//---------------------------------------------------------------------------
// datastructure.MapEntry.java              by Dale/Joyce/Weems                   Chapter 8
//
// Provides key, value pairs for use with a Map.
// Keys are immutable.
//---------------------------------------------------------------------------
package datastructure;

import java.io.Serializable;
public class MapEntry<K, V> implements Serializable
{
  protected K key;
  protected V value;
  
  MapEntry(K k, V v)
  {
    key = k; value = v;
  }
  
  public K getKey()  {return key;}
  public V getValue(){return value;}
  public void setValue(V v){value = v;}

  @Override
  public String toString()
  // Returns a string representing this datastructure.MapEntry.
  {
    return "Key  : " + key + "\nValue: " + value;
  }
}
 