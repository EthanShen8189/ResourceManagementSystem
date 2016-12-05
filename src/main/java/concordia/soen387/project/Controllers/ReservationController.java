package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.Reservation;
import concordia.soen387.project.Model.ReservationResources;
import concordia.soen387.project.Model.Resource;
import concordia.soen387.project.Services.InvManagementService;
import concordia.soen387.project.Services.ResService;
import org.springframework.stereotype.Controller;
import org.springframework.util.comparator.BooleanComparator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ethan Shen on 12/4/2016.
 */
@Controller
public class ReservationController {

    private ResService resService = new ResService();
    private ResViewController resViewController = ResViewController.getResViewController();
    private InvManagementService invManagementService = new InvManagementService();

    @RequestMapping(value = "/reserveResource", method = RequestMethod.POST)
    public ModelAndView reserveResource(@RequestParam String resourceId, @RequestParam String username, @RequestParam String start_date,
                                        @RequestParam String start_time, @RequestParam String end_time){

        if(!(start_date.equals("") || start_time.equals("")|| end_time.equals(""))) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
            try {
                Date startTimefromClient = df.parse(start_date+" "+start_time+":00");
                Date endTimefromClient = df.parse(start_date+" "+end_time+":00");

                if(startTimefromClient.before(endTimefromClient)){

                    Reservation reservation = resService.getLastReservation();
                    ReservationResources reservationResources = new ReservationResources();

                    if(reservation == null){
                        reservation = new Reservation();
                        reservation.setId(1);
                    }else{
                        reservation.setId(reservation.getId()+1);

                    }
                    reservation.setStart_date_time(start_date+" "+start_time+":00");
                    reservation.setEnd_date_time(start_date+" "+end_time+":00");
                    reservation.setUser_username(username);

                    if(validateReservation(startTimefromClient,endTimefromClient,resourceId)) {
                        resService.insertReservation(reservation);

                        reservationResources.setReservation_id(reservation.getId());
                        reservationResources.setResource_id(Integer.parseInt(resourceId));


                        resService.insertReservationResource(reservationResources);

                        return resViewController.newReservationPage("Resource Reserved!", "");
                    }else{
                        return resViewController.newReservationPage("","Resource is not available at this selected time");
                    }
                }else{
                    return resViewController.newReservationPage("","Reserve failed, Start time must be before than end time.");
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            return resViewController.newReservationPage("", "Reserve failed, Please do not leave empty input.");
        }
        return resViewController.newReservationPage("", "Server encounter error, Please try again.");
    }

    private Boolean validateReservation(Date startTime, Date endTime, String resourceId){
        Date resStartFromdb;
        Date resEndFromdb;
        Date startTimefromClient;
        Date endTimefromClient;
        boolean flag = true;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

        List<Reservation> reservationList = new ArrayList<>();
        List<Long> allReservationWithIDs = resService.getAllReservationWithID(Long.parseLong(resourceId));
        for(Long reservationID: allReservationWithIDs){
            reservationList.add(resService.getReservationByID(reservationID));
        }

        try{

            for(Reservation reservation: reservationList){
                resStartFromdb = df.parse(reservation.getStart_date_time());
                resEndFromdb = df.parse(reservation.getEnd_date_time());

                flag =((startTime.after(resEndFromdb) && endTime.after(startTime)) ||
                        (startTime.before(endTime) && endTime.before(resStartFromdb)));

                if(!flag){
                    return false;
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return true;
    }


}
