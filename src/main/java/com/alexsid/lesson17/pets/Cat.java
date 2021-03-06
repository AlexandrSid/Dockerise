package com.alexsid.lesson17.pets;

import com.alexsid.lesson17.Person;

import java.util.Objects;

public class Cat extends AbstractPet {
    private final PetType type = PetType.CAT;

    protected Cat(long id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
    }

    @Override
    public PetType getType() {
        return type;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getType(), getId(), getOwner(), getWeight());
    }

    @Override
    public String toString() {
        return super.toString("Cat");
    }
}
