package no.hvl.dat102.filmarkiv.impl;

public class LinearNode<T> {

    public T data;
    public LinearNode<T> neste;

    public LinearNode(T datadel) {
        this(datadel, null);
    }
    public LinearNode(T datadel, LinearNode<T> nestenode) {
        this.data = datadel;
        this.neste = nestenode;
    }
    T getData() {
        return data;
    }
    public void setData(T nydata) {
        this.data = nydata;
    }
    LinearNode<T> getNeste() {
        return neste;
    }
    void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }

}
