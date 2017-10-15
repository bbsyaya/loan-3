package com.tkach.loan.facade;

import com.tkach.loan.model.AbstractEntity;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractFacadeTest<Entity extends AbstractEntity> {

    protected abstract AbstractFacade<Entity> getFacade();
    protected abstract Entity getEntity();

    @Test
    public void testCreate(){
        Entity e = getEntity();

        e = getFacade().create(e);

        Entity found = getFacade().find(e.getId());

        Assert.assertEquals(e, found);

        getFacade().remove(e);
    }
}
