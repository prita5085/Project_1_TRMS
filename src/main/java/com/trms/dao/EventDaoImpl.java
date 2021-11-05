package com.trms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.trms.models.Dept;
import com.trms.models.Event;
import com.trms.util.HibernateUtil;

public class EventDaoImpl implements EventDao {

	@Override
	public Event addEvent(Event event) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			session.beginTransaction();
			event.setEventId((int)session.save(event));
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	            	tx.rollback();
			return null;
		} finally {
			session.close();
		}
		return event;
	}

	@Override
	public Event getEventById(int id) {
		Session session = HibernateUtil.getSession();
        Event event = null;
        try {
            event = session.get(Event.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return event;
	}

	@Override
	public Event updateEvent(Event event) {
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(event);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return event;
	}

	@Override
	public Event deleteEvent(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Event event = null;
		try {
			tx = session.beginTransaction();
			event = session.get(Event.class, id);
			session.delete(event);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) 
				tx.rollback();
		} finally {
			session.close();
		}
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = HibernateUtil.getSession();
        List<Event> allEvents = null;

        try {
            allEvents = session.createQuery("FROM Event").list(); //HQL
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return allEvents;
	}

	@Override
    public Event getEventByName(String name) {
        Event event = null;
        Session session = HibernateUtil.getSession();
        try{
            Criteria crit = session.createCriteria(Event.class);
            crit.add(Restrictions.eq("eventTypes", name));
           event = (Event) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return event;
    }


}
