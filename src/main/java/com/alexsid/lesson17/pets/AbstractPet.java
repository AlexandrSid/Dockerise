package com.alexsid.lesson17.pets;

import com.alexsid.lesson17.Person;

import java.util.Objects;

public abstract class AbstractPet implements Pet {
    protected long id;
    protected Person owner;
    protected PetType type;
    protected String name;
    protected double weight;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public PetType getType() {
        return type;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    public AbstractPet(long id, String name, Person owner, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.owner = owner;
    }

    @Override
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPet)) return false;
        AbstractPet that = (AbstractPet) o;
        return Double.compare(that.getWeight(), getWeight()) == 0 &&
//                Objects.equals(getOwner(), that.getOwner()) &&
                getType() == that.getType() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getType(), getName(), getWeight());
    }

    @Override
    public String toString() {
        return "AbstractPet{" +
                "id=" + getId() +
                ", owner=" + getOwner() +
                ", type=" + getType() +
                ", name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }

    public String toString(String petType) {
        return petType + "\n{" +
                "id=" + getId() +
                ", owner=" + getOwner() +
                ", type=" + getType() +
                ", name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
