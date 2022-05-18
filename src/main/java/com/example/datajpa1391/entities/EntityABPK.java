package com.example.datajpa1391.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 */
public class EntityABPK implements Serializable {

    private EntityA a;
    private EntityB b;

    public EntityABPK() {
    }

    public EntityABPK(EntityA a, EntityB b) {
        this.a = a;
        this.b = b;
    }

    public EntityA getA() {
        return a;
    }

    public void setA(EntityA a) {
        this.a = a;
    }

    public EntityB getB() {
        return b;
    }

    public void setB(EntityB b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.a);
        hash = 29 * hash + Objects.hashCode(this.b);
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
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        return Objects.equals(this.b, other.b);
    }
    
}
