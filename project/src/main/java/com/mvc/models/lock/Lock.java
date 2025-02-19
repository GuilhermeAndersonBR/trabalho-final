package com.mvc.models.lock;

import com.constants.Messages;
import com.errors.OutOfRangeException;
import com.utils.Range;
import com.utils.Size2;

public class Lock {
    
    private Size2 size;

    private final Range capacity = new Range();

    private float flow;

    private float value;

    private final Ships ships = new Ships();
 
    public Lock() {}
    public Lock(Size2 size, float flow) throws OutOfRangeException {

        this.setSize(size);
        this.setFlow(flow);

    }

    public float getFlow() {

        return this.flow;

    }

    public final void setFlow(float newFlow) throws OutOfRangeException {

        if(newFlow < 0) throw new OutOfRangeException(
            String.format(Messages.OutOfRangeError.getMessage(), "fluxo", "eclusa")
        );

        this.flow = newFlow;

    }

    public Size2 getSize() {

        return this.size;

    }

    public final void setSize(Size2 newSize) {

        this.size = newSize;

    }

    public Range getCapacity() {
        
        return this.capacity;

    }

    public Ships getShips() {

        return this.ships;

    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

}
