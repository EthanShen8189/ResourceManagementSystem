package concordia.soen387.project.Services;

import concordia.soen387.project.Dao.MyReservationDao;
import concordia.soen387.project.Dao.ReservationDao;
import concordia.soen387.project.Dao.ReservationResourceDao;
import concordia.soen387.project.Dao.ResourceDao;
import concordia.soen387.project.Model.MyReservation;
import concordia.soen387.project.Model.Reservation;
import concordia.soen387.project.Model.ReservationResources;
import concordia.soen387.project.Model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethan Shen on 12/4/2016.
 */
public class ResService {
    static ApplicationContext context;

    @Autowired
    static ReservationDao reservationDao;
    @Autowired
    static ReservationResourceDao reservationResourceDao;
    @Autowired
    static ResourceDao resourceDao;
    @Autowired
    static MyReservationDao myReservationDao;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        }
        if(reservationDao == null || reservationResourceDao == null
                || resourceDao == null || myReservationDao == null){
            reservationDao = (ReservationDao) context.getBean("reservationDao");
            reservationResourceDao = (ReservationResourceDao) context.getBean("reservationResourceDao");
            resourceDao = (ResourceDao) context.getBean("resourceDao");
            myReservationDao = (MyReservationDao) context.getBean("myReservationDao");
        }
    }

    public Reservation getLastReservation(){
       return reservationDao.getLastIndexReservation();
    }

    public void insertReservation(Reservation reservation){
        reservationDao.addReservation(reservation);
    }

    public void insertReservationResource (ReservationResources reservationResources){
        reservationResourceDao.addReservationResource(reservationResources);
    }

    public List<Long> getAllReservationWithID(long l) {
        return reservationResourceDao.getAllreservationWithID(l);
    }

    public Reservation getReservationByID(Long reservationID) {
        return reservationDao.getReservationById(reservationID);
    }

    public List<MyReservation> getAllMyreservations(String username){
        return myReservationDao.getAllMyReservation(username);
    }
}
