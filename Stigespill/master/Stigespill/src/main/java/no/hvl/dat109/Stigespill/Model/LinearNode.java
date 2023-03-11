package no.hvl.dat109.Stigespill.Model;

//Representerer en node.
//************************************************************
public class LinearNode<T> {
private LinearNode<T> neste;
private T element;
/**********************************************************
Oppretter en tom node
**********************************************************/
public LinearNode(){
neste = null;
element = null;
}
/**********************************************************
Oppretter en node med et element.
**********************************************************/
public LinearNode (T elem) {
neste = null;
element = elem;
}
/**********************************************************
Returnerer etterf�lger.
**********************************************************/
public LinearNode<T> getNeste() {
return neste;
}
/**********************************************************
Setter neste til node
**********************************************************/
public void setNeste (LinearNode<T> node) {
neste = node;
}
/**********************************************************
Returnerer elementet til denne noden
**********************************************************/
public T getElement(){
return element;
}
/**********************************************************
Setter nytt element til denne noden.
**********************************************************/
public void setElement (T elem) {
element = elem;
}
}//class