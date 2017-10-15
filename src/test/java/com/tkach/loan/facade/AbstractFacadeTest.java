package com.tkach.loan.facade;

import com.tkach.loan.model.AbstractEntity;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractFacadeTest<Entity extends AbstractEntity> {

    protected abstract AbstractFacade<Entity> getFacade();
    protected abstract Entity getEntity();
    protected abstract Entity updateEntity(Entity e);

    @Test
    public void testCreate(){
        Entity e = getEntity();

        e = getFacade().create(e);

        Entity found = getFacade().find(e.getId());

        Assert.assertEquals(e, found);

        getFacade().remove(e.getId());
    }

    @Test
    public void testEdit(){
        Entity e = getFacade().create(getEntity());

        e = updateEntity(e);

        getFacade().edit(e);

        Entity updated = getFacade().find(e.getId());

        Assert.assertEquals(e, updated);

        getFacade().remove(e.getId());
    }

    @Test
    public void testRemoveById(){
        Entity e = getEntity();

        e = getFacade().create(e);

        getFacade().remove(e.getId());

        Entity removed = getFacade().find(e.getId());

        Assert.assertNull(removed);
    }

    @Test
    public void testRemove(){
        Entity e = getEntity();

        e = getFacade().create(e);

        getFacade().remove(e);

        Entity removed = getFacade().find(e.getId());

        Assert.assertNull(removed);
    }
}
