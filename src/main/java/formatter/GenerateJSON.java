package formatter;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.Account;
import model.Address;
import model.Establishment;
import model.PriceList;
import model.Product;
import model.Schedule;

public class GenerateJSON {
	
	public static JSONObject GetAccountJSON (Account account){
		
		
		JSONObject jsonAccount = null;
				
		try {

			// account
			jsonAccount = new JSONObject();			
			jsonAccount.put("id",account.getId());
			jsonAccount.put("name",account.getName());
			jsonAccount.put("email",account.getEmail());
			jsonAccount.put("phone",account.getPhone());
			jsonAccount.put("created",account.getCreated());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonAccount;
	
	}
	
	public static JSONObject GetEstablishmentJSON (Establishment establishment){
		
		
		JSONObject jsonEstablishment = null;
				
		try {

			// establishment
			jsonEstablishment = new JSONObject();			
			jsonEstablishment.put("id",establishment.getId());
			jsonEstablishment.put("name",establishment.getName());
			jsonEstablishment.put("alias",establishment.getAlias());
			jsonEstablishment.put("email",establishment.getEmail());
			jsonEstablishment.put("registerNumber",establishment.getRegisterNumber());
			jsonEstablishment.put("phone",establishment.getPhone());
			jsonEstablishment.put("radius",establishment.getRadius());
			jsonEstablishment.put("responsibleName",establishment.getResponsibleName());
			jsonEstablishment.put("responsibleEmail",establishment.getResponsibleEmail());
			jsonEstablishment.put("responsiblePhone",establishment.getResponsiblePhone());
			jsonEstablishment.put("rate",establishment.getRate());
			jsonEstablishment.put("created",establishment.getCreated());
			

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonEstablishment;
	
	}
	
	public static JSONObject GetAddressJSON (Address address){
		
		JSONObject jsonAddress = null;
		
		try {

			// address
			jsonAddress = new JSONObject();
			jsonAddress.put("id",address.getId());
			jsonAddress.put("accountId",address.getAccountId());
			jsonAddress.put("establishmentId",address.getEstablishmentId());
			jsonAddress.put("zipCode",address.getZipCode());
			jsonAddress.put("street",address.getStreet());
			jsonAddress.put("city",address.getCity());
			jsonAddress.put("state",address.getState());
			jsonAddress.put("number;",address.getNumber()); 
			jsonAddress.put("premise",address.getPremise());
			jsonAddress.put("country",address.getCountry());
			jsonAddress.put("latitude",address.getLatitude());
			jsonAddress.put("longitude",address.getLongitude());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonAddress;
	
	}

	public static JSONObject GetPriceListJSON (PriceList priceList){
		
		
		JSONObject jsonPriceList = null;
				
		try {

			// priceList
			jsonPriceList = new JSONObject();			
			jsonPriceList.put("id",priceList.getId());
			jsonPriceList.put("establishmentId",priceList.getEstablishment().getId());
			jsonPriceList.put("productId",priceList.getProduct().getId());
			jsonPriceList.put("price",priceList.getPrice());
			jsonPriceList.put("unit",priceList.getUnit());

			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonPriceList;
	
	}

	public static JSONObject GetScheduleJSON (Schedule schedule){
		
		JSONObject jsonSchedule = null;
		
		try {

			// schedule
			jsonSchedule = new JSONObject();
			jsonSchedule.put("id",schedule.getId());
			jsonSchedule.put("establishmentId",schedule.getEstablishment().getId());
			jsonSchedule.put("dayWeek",schedule.getDayWeek());
			jsonSchedule.put("startTime",schedule.getStartTime());
			jsonSchedule.put("endTime",schedule.getEndTime());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonSchedule;
	
	}
	
	public static JSONArray GetListScheduleJSON (List<Schedule> schedules){
		
		// schedules
		JSONArray jsonSchedules = new JSONArray();
		for(Schedule schedule : schedules)
			jsonSchedules.put(GetScheduleJSON(schedule));

		return jsonSchedules;
	
	}

	public static JSONObject GetProductJSON (Product product){
		
		
		JSONObject jsonProduct = null;
				
		try {

			// account
			jsonProduct = new JSONObject();			
			jsonProduct.put("id",product.getId());
			jsonProduct.put("name",product.getName());
			jsonProduct.put("description",product.getDescription());
			jsonProduct.put("created",product.getCreated());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonProduct;
	
	}

	
}