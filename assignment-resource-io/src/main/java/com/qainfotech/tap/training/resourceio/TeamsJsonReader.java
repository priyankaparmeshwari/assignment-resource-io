package com.qainfotech.tap.training.resourceio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader {
	List<Individual> myObjList = new ArrayList<Individual>();
	List<Individual> inactiveMembersList = new ArrayList<Individual>();
	List<Individual> activeMembersList = new ArrayList<Individual>();
	List<Team> listofteam = new ArrayList<Team>();
	
	/**
	 * get a list of individual objects from db json file
	 * 
	 * @return
	 */

	// throw new UnsupportedOperationException("Not implemented.");
	public List<Individual> getListOfIndividuals() throws FileNotFoundException, IOException {
		// throw new UnsupportedOperationException("Not implemented.");
		JSONParser parser = new JSONParser();
		myObjList.clear();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\priyankaparmeshwari\\Desktop\\io 1\\assignment-resource-io\\src\\main\\resources\\db.json"));
		} catch (org.json.simple.parser.ParseException e) {
		}

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			Map<String, Object> individualMap = new HashMap<String, Object>();
			individualMap.put("name", myobj.get("name").toString().trim());
			individualMap.put("id", myobj.get("id").toString().trim());
			individualMap.put("active", myobj.get("active").toString().trim());
			obj1 = new Individual(individualMap);
			myObjList.add(obj1);
			
		}
return myObjList;
	}

	/**
	 * get individual object by id
	 * 
	 * @param id
	 *            individual id
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualById(Integer id) throws IOException,ObjectNotFoundException 
	{myObjList = this.getListOfIndividuals();
		for (int i = 0; i < myObjList.size(); i++) {
			if(myObjList.get(i).getId()==(int)id)
			{
				return myObjList.get(i);
				}
			}	
		throw new ObjectNotFoundException("object not found", "Id", id.toString());
	}

	/**
	 * get individual object by name
	 * 
	 * @param name
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualByName(String name) throws ObjectNotFoundException,IOException {
		myObjList = this.getListOfIndividuals();
		for (int i = 0; i < myObjList.size(); i++) {
			if(myObjList.get(i).getName().equals(name))
			{
				return myObjList.get(i);
			}
		}
		throw new ObjectNotFoundException("object not found", "Id", name);
	}

	/**
	 * get a list of individual objects who are not active
	 * 
	 * @return List of inactive individuals object
	 */
	public List<Individual> getListOfInactiveIndividuals() throws FileNotFoundException, IOException {

	//	if (inactiveMembersList.isEmpty()) {
			myObjList = this.getListOfIndividuals();
		//}

		inactiveMembersList.clear();
		Individual obj1;

		for (int i = 0; i < myObjList.size(); i++) {

			if (!myObjList.get(i).isActive()) {

				Map<String, Object> individualMap = new HashMap<String, Object>();

				individualMap.put("name", myObjList.get(i).getName());
				individualMap.put("id", myObjList.get(i).getId());
				individualMap.put("active", myObjList.get(i).isActive());

				obj1 = new Individual(individualMap);

				inactiveMembersList.add(obj1);
			}
		}

		return inactiveMembersList;

	}

	/**

	/**
	 * get a list of individual objects who are active
	 * 
	 * @return List of active individuals object
	 */
	public List<Individual> getListOfActiveIndividuals() throws FileNotFoundException, IOException {

		//if (activeMembersList.isEmpty()) 
		{
			myObjList = this.getListOfIndividuals();
		}

		activeMembersList.clear();

		Individual obj1;

		for (int i = 0; i < myObjList.size(); i++) {

			if (myObjList.get(i).isActive()) {
				Map<String, Object> individualMap = new HashMap();

				individualMap.put("name", myObjList.get(i).getName());
				individualMap.put("id", myObjList.get(i).getId());
				individualMap.put("active", myObjList.get(i).isActive());

				obj1 = new Individual(individualMap);

				 activeMembersList.add(obj1);
			}
		}

		return  activeMembersList;

	}



	/**
	 * get a list of team objects from db json
	 * 
	 * @return
	 */
	public List<Team> getListOfTeams(){
		JSONParser parser=new JSONParser();
		JSONObject jsonObj;
		List<Team> teamList=null;
		try {			
			
			parser = new JSONParser();
			Object obj = parser.parse(new FileReader(new File("C:\\Users\\priyankaparmeshwari\\Desktop\\io 1\\assignment-resource-io\\src\\main\\resources\\db.json")));
			jsonObj = (JSONObject) obj;
			teamList=new ArrayList<>();
			Team team=null;
			JSONArray teamArray=(JSONArray)jsonObj.get("teams");
			for(int i=0;i<teamArray.size();i++){
				JSONObject object=(JSONObject) teamArray.get(i);
				Map<String, Object> map=(Map<String, Object>)object.clone();    	 
				team=new Team(map);
				teamList.add(team);
				//System.out.println(team);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamList;

}
		
	}
		
	