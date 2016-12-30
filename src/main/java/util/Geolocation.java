package util;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AccountDao;
import dao.EstablishmentDao;
import formatter.GenerateJSON;
import model.Account;
import model.Address;
import model.Establishment;

public class Geolocation {

	public static int Distance(double lat1, double lon1, double lat2, double lon2){
		
		final int R = 6371; // Radius of the earth
		Double latDistance = Deg2rad(lat2 - lat1);
		Double lonDistance = Deg2rad(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Deg2rad(lat1)) * Math.cos(Deg2rad(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters
		
		Long distanceLong = Math.round(distance);
		return distanceLong.intValue();

	}
	
	private static double Deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	public static JSONObject GetEstablishmentsJSON (Address accountAddress){
		
		List<Address> addresses = EstablishmentDao.GetEstablishmentsAddressesByLocation(accountAddress);
		JSONArray jsonArrayEstablishment = new JSONArray();
		JSONObject jsonMain = null;
		
		try {

			for(Address a : addresses){

				Establishment establishment = EstablishmentDao.GetEstablishmentsById(a.getEstablishmentId());
				JSONObject jsonEstablishment = new JSONObject();
				
				// establishment
				jsonEstablishment.put("id",establishment.getId());
				jsonEstablishment.put("name",establishment.getName());
				jsonEstablishment.put("alias",establishment.getAlias());
				jsonEstablishment.put("registerNumber",establishment.getRegisterNumber());
				jsonEstablishment.put("address", GenerateJSON.GetAddressJSON(a));
				jsonArrayEstablishment.put(jsonEstablishment);

			}

			JSONObject jsonEstablishments = new JSONObject();
			jsonEstablishments.put("establishment", jsonArrayEstablishment);

			jsonMain = new JSONObject();
			jsonMain.put("establishments", jsonEstablishments);


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonMain;

	}

	
	public static JSONObject GetAccountsJSON (Address establishmentAddress){
		
		List<Address> addresses = AccountDao.GetAccountsAddressesByLocation(establishmentAddress);
		JSONArray jsonArrayAccount = new JSONArray();
		JSONObject jsonMain = null;
		
		try {

			for(Address a : addresses){

				Account account = AccountDao.GetAccountsById(a.getAccountId());
				JSONObject jsonAccount = new JSONObject();
				
				// establishment
				jsonAccount.put("id",account.getId());
				jsonAccount.put("name",account.getName());
				jsonAccount.put("email",account.getEmail());				
				jsonAccount.put("address", GenerateJSON.GetAddressJSON(a));
				jsonArrayAccount.put(jsonAccount);

			}

			JSONObject jsonAccounts = new JSONObject();
			jsonAccounts.put("account", jsonArrayAccount);

			jsonMain = new JSONObject();
			jsonMain.put("accounts", jsonAccounts);


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonMain;

	}
	
}
