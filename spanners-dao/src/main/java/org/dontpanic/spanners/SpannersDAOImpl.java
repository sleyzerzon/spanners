package org.dontpanic.spanners;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class SpannersDAOImpl implements SpannersDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Spanner get(int id) {
        return (Spanner)getSession().get(Spanner.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Spanner> getAll() {
        Criteria criteria = getSession().createCriteria(Spanner.class);
        criteria.addOrder(Order.asc(Spanner.PROP_ID));
        return criteria.list();
    }

    @Override
    public int create(Spanner spanner) {

    	if (spanner == null) {
    		throw new IllegalArgumentException
    			("Cannot save null spanner to database");
    	}

    	if (spanner.getSize() < 1) {
    		throw new IllegalArgumentException
    			("Cannot save spanner with non-positive size: " + spanner.getSize());
    	}

    	return (Integer)getSession().save(spanner);
    }

    @Override
    public void update(Spanner spanner) {
        getSession().saveOrUpdate(spanner);
    }

    @Override
    public void delete(Spanner spanner) {
        getSession().delete(spanner);
    }

}


