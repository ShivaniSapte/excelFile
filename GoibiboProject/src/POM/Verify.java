package POM;

import FlightBooking.OneTrip;
import FlightBooking.RoundTrip;
import train.TrainBooking;

public class Verify {

	public static void main(String[] args) throws Exception {
		
		Browser.launchBrowser();
		System.out.println("Title of page --->"+Browser.driver.getTitle());
		//Thread.sleep(2000);
		//1 for one_way flight booking
		OneTrip one=new OneTrip(Browser.driver);
		//one.oneWayTrip();
		//Thread.sleep(2000);
		//one.Calendar();
		//one.searchButton();
		
		//2 for round trip flight booking
		RoundTrip round = new RoundTrip(Browser.driver);
		//Browser.driver.navigate().back();
		//round.twoWayTrip();
	//	round.Calendar();
	//	round.noOfTravellers();
	//	round.searchButton();
		
		//trains booking
		TrainBooking trn=new TrainBooking(Browser.driver);
		//trn.frame();
		trn.selectTrain();
		trn.enter_Source_destination();
		trn.calendar();
		trn.selectClass();
	//	trn.checkPNRstatus();
		trn.search();
		Browser.quit();

	}

}
