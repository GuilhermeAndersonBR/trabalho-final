package com.data;

import com.mvc.models.lock.Lock;
import com.mvc.models.ocean.Ocean;
import com.mvc.models.river.River;

public class DataBase {
    
    private Ocean ocean;

    private River river;

    private Lock lock;

    public DataBase() {}

    public Ocean getOcean() {
        
        return this.ocean;

    }

    public void setOcean(Ocean newOcean) {

        this.ocean = newOcean;

    }

    public River getRiver() {

        return this.river;

    }

    public void setRiver(River newRiver) {

        this.river = newRiver;

    }

    public Lock getLock() {

        return this.lock;

    }

    public void setLock(Lock newLock) {

        this.lock = newLock;

    }

    public void reset() {

        this.setOcean(null);
        this.setLock(null);
        this.setRiver(null);

    }

}
