package com.tkach.loan.facade;

import com.tkach.loan.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Service
public abstract class AbstractFacade<Entity extends AbstractEntity> {
    @PersistenceContext
    protected EntityManager em;

    protected Class<Entity> entityClass;

    public AbstractFacade(Class<Entity> entityClass){
        this.entityClass = entityClass;
    }

    @Transactional
    public Entity create(Entity e){
        em.persist(e);
        return e;
    }

    @Transactional
    public void remove(Entity e){
        em.remove(em.merge(e));
    }

    @Transactional
    public Entity edit(Entity e){
        em.merge(e);
        return e;
    }

    @Transactional
    public Entity find(UUID id){
        return em.find(entityClass, id);
    }

    @Transactional
    public void remove(UUID id){
        Entity e = em.find(entityClass, id);
        em.remove(e);
    }
}
