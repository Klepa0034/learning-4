package org.example.array.impl;

import org.example.annatation.Component;
import org.example.array.CustomArray;
import org.example.entity.Employee;
@Component
public class CustomArrayImpl<T> implements CustomArray<T> {

    private Object[] array;
    private int currentSize;

    public CustomArrayImpl(){
        this.currentSize=0;
        this.array = new Employee[16];
    }
    @Override
    public void addElement(T value) {
        if(currentSize==array.length) resize();
        array[currentSize]=value;
        currentSize++;

    }
    private void resize(){
        Object[] tempArray=new Employee[array.length*2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i]=array[i];
        }
        array=tempArray;
    }
    private void reBuild(int index){
        for (int i = index; i < currentSize; i++) {
            array[i] = array[i+1];
            array[i+1]=null;
        }
    }
    public void updateElement(int index, T newValue) {
        if (index < 0 || index >= currentSize) {
        }
        array[index] = newValue;
    }

    @Override
    public void deleteElement(int index) {
        if(currentSize<=index){throw new RuntimeException();}
        array[index]=null;
        reBuild(index);
        currentSize--;
    }
    public void insertElement(int index, T value) {
        if (index < 0 || index > currentSize) {
        }
        if (currentSize == array.length) {
            resize();
        }
        for (int i = currentSize; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        currentSize++;
    }

    @Override
    public void print() {
        for (int i = 0; i <currentSize ; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
}
