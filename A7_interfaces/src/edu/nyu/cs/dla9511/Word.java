package edu.nyu.cs.dla9511;

import java.util.ArrayList;

public class Word implements OrderedThing {
    private ArrayList<Character> characters = new ArrayList<>();
    private int position;

    public Word(String word, int position) {
        for (char c : word.toCharArray()) {
            characters.add(new Character(c));
        }
        this.position = position;
    }

    @Override
    public int getOrder() {
        return position;
    }

    @Override
    public OrderedThing getFirst() {
        return characters.get(0);
    }

    @Override
    public OrderedThing getLast() {
        return characters.get(characters.size() - 1);
    }

    @Override
    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> sequence = new ArrayList<>();
        for (Character character : characters) {
            sequence.add(character);
        }
        return sequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}
