package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.Reservation;
import concordia.soen387.project.Model.ReservationResources;
import concordia.soen387.project.Services.ResService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ethan Shen on 12/4/2016.
 */
@Controller
public class ReservationController {

    private ResService resService = new ResService();
    private ResViewController resViewController = ResViewController.getResViewController();

    @RequestMapping(value = "/reserveResource", method = RequestMethod.POST)
    public ModelAndView reserveResource(@RequestParam String resourceId, @RequestParam String username, @RequestParam String start_date,
                                        @RequestParam String start_time, @RequestParam String end_date, @RequestParam String end_time){
        if(!(start_date.equals("") || start_time.equals("")|| end_date.equals("") || end_time.equals(""))){
            Reservation reservation = resService.getLastReservation();
            ReservationResources reservationResources = new ReservationResources();
            if(reservation == null){
                reservation = new Reservation();
                reservation.setId(1);
            }else{
                reservation.setId(reservation.getId()+1);

            }
            reservation.setStart_date_time(start_date+" "+start_time+":00");
            reservation.setEnd_date_time(end_date+" "+end_time+":00");
            reservation.setUser_username(username);

            resService.insertReservation(reservation);

            reservationResources.setReservation_id(reservation.getId());
            reservationResources.setResource_id(Integer.parseInt(resourceId));

            resService.insertReservationResource(reservationResources);

            return resViewController.newReservationPage("Resource Reserved!","");

        }else{
            return resViewController.newReservationPage("","Please do not leave empty input.");
        }

    }

}
