package array;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ONe {

	public static List<Integer> apiResponseParser(List<String> inputList, int size) {
		Gson gson = new Gson();
		Users[] users = null;
		List<Integer> result = new ArrayList<>();
		try {
			URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
			HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
			httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
			InputStreamReader reader = new InputStreamReader(httpcon.getInputStream());
			users = gson.fromJson(reader, Users[].class);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

//		inputList.add("address.city");
//		inputList.add("IN");
//		inputList.add("Mumbai,Kolkata");


		String vals1[] = inputList.get(0).split("\\.");
		String vals2[] = inputList.get(2).split(",");
		
		if (inputList.get(0).equals("name")) {
			for (Users u : users) {
				for (String v : vals2) {
					if (u.getName().equals(v)) {
						result.add(u.getId());
					}
				}
			}
			if(result.size() == 0) {
				result.add(-1);
			}
		}
		if (inputList.get(0).equals("username")) {
			for (Users u : users) {
				for (String v : vals2) {
					if (u.getUsername().equals(v)) {
						result.add(u.getId());
					}
				}
			}
			if(result.size() == 0) {
				result.add(-1);
			}
		}
		if (inputList.get(0).equals("email")) {
			for (Users u : users) {
				for (String v : vals2) {
					if (u.getEmail().equals(v)) {
						result.add(u.getId());
					}
				}
			}
			if(result.size() == 0) {
				result.add(-1);
			}
		}
		if (inputList.get(0).equals("website")) {
			for (Users u : users) {
				for (String v : vals2) {
					if (u.getWebsite().equals(v)) {
						result.add(u.getId());
					}
				}
			}
			if(result.size() == 0) {
				result.add(-1);
			}
		}


		if (vals1[0].equals("address")) {
			if (vals1[1].equals("geo")) {
				for (Users u : users) {
					Map<String, String> map = u.getAddress().getGeo();
					for (String v : vals2) {
						if (u.getAddress().getGeo().get("lat").equals(v) && u.getAddress().getGeo().get("lng").equals(v)) {
							result.add(u.getId());
						}
					}
				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
			if (vals1[1].equals("street")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getAddress().getStreet().equals(v)) {
							result.add(u.getId());
						}
					}
				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
			if (vals1[1].equals("suite")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getAddress().getSuite().equals(v)) {
							result.add(u.getId());
						}
					}
				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
			if (vals1[1].equals("city")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getAddress().getCity().equals(v)) {
							result.add(u.getId());
						}
					}

				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}

			if (vals1[1].equals("zipcode")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getAddress().getZipcode().equals(v)) {
							result.add(u.getId());
						}
					}

				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
		}
		if (vals1[0].equals("company")) {

			if (vals1[1].equals("name")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getCompany().getName().equals(v)) {
							result.add(u.getId());
						}
					}
				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
			if (vals1[1].equals("basename")) {
				for (Users u : users) {
					for (String v : vals2) {
						if (u.getCompany().getBasename().equals(v)) {
							result.add(u.getId());
						}
					}
				}
				if(result.size() == 0) {
					result.add(-1);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// "address.city", "IN", "Mumbai,Kolkata"
		List<String> inputList = new ArrayList<>();
		inputList.add("username");
		inputList.add("EQUALS");
		inputList.add("tom");
		List<Integer> result = apiResponseParser(inputList, 3);
		System.out.println(result);
	}
}

class Users {
	public int id;
	public String name;
	public String username;
	public String email;
	public Address address;
	public String website;
	public Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}

class Address {
	public String street;
	public String suite;
	public String city;
	public String zipcode;
	public Map<String, String> geo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Map<String, String> getGeo() {
		return geo;
	}

	public void setGeo(Map<String, String> geo) {
		this.geo = geo;
	}

}

class Company {
	public String name;
	public String basename;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasename() {
		return basename;
	}

	public void setBasename(String basename) {
		this.basename = basename;
	}

}
