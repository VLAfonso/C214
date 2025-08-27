package br.inatel.cdg;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Fila<T> {
    private List<T> elementos = new ArrayList<T>();
    private int tamanho = 0;

    public int size() {
        return tamanho;
    }

    public boolean filaVazia() {
        return (tamanho == 0);
    }

    public void enfileirar(T elem) {
        elementos.add(elem);
        tamanho++;
    }

    public T removerFila() throws EmptyStackException {
        if (filaVazia())
            throw new EmptyStackException();

        T elem = elementos.removeFirst();
        tamanho--;
        return elem;
    }
}
