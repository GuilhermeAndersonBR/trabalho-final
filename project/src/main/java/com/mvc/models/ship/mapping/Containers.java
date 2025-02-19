package com.mvc.models.ship.mapping;

import java.util.ArrayList;
import java.util.Optional;

import com.constants.Messages;
import com.errors.CannotBeNullException;
import com.errors.InvalidIndexException;
import com.errors.OutOfRangeException;
import com.mvc.models.ship.classes.Container;

public class Containers {
    
    private final ArrayList<Container> containers = new ArrayList<>();
    private float totalContainersWeight = 0.0f;
    private float maxLoad;

    public Containers() {}
    public Containers(float maxLoad) throws OutOfRangeException {

        this.setMaxLoad(maxLoad);

    }

    public void add(Container container) throws CannotBeNullException, OutOfRangeException {

        Optional<Container> verifiedContainer = Optional.ofNullable(container);

        if(!verifiedContainer.isPresent()) throw new CannotBeNullException(
            String.format(Messages.CannotBeNull.getMessage(), "contêiners", "Contêiners")
        );

        if(this.totalContainersWeight + container.getWeight() > this.maxLoad) throw new OutOfRangeException(
            String.format(
                Messages.MaxValueExceeded.getMessage(), 
                "contêiner", 
                "contêiners"
            )
        );

        this.containers.add(container);

        this.totalContainersWeight += container.getWeight();

        System.out.println(this.totalContainersWeight);

    }

    public Optional<Container> get(int index) throws InvalidIndexException {

        if(index < 0 || index > this.containers.size() - 1) throw new InvalidIndexException(
            String.format(Messages.InvalidIndexError.getMessage(), "receber um contêiner", "Contêiners")
        );

        return Optional.ofNullable(this.containers.get(index));

    }

    public void remove(int index) throws InvalidIndexException {

        if(index < 0 || index > this.containers.size() - 1) throw new InvalidIndexException(
            String.format(Messages.InvalidIndexError.getMessage(), "remover um contêiner", "Contêiners")
        );

        this.containers.remove(index);
        
    }

    public ArrayList<Container> all() {

        return this.containers;

    }

    public void reset() {

        this.containers.clear();

        this.totalContainersWeight = 0.0f;

    }

    public float getMaxLoad() {

        return this.maxLoad;

    }

    public final void setMaxLoad(float newMaxLoad) throws OutOfRangeException {

        if(newMaxLoad < 0) throw new OutOfRangeException(
            String.format(
                Messages.OutOfRangeError.getMessage(), 
                "capacidade máxima", 
                "Contêiners"
            )
        );

        this.maxLoad = newMaxLoad;

    }

    public float getTotalContainersWeight() {

        return this.totalContainersWeight;

    }

}
