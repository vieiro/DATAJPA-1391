package com.example.datajpa1391.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 */
public class EntityABPK implements Serializable {

    private long a;
    private long b;

    public EntityABPK() {
    }

    public EntityABPK(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.a ^ (this.a >>> 32));
        hash = 67 * hash + (int) (this.b ^ (this.b >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntityABPK other = (EntityABPK) obj;
        if (this.a != other.a) {
            return false;
        }
        return this.b == other.b;
    }

}
