package com.qainfotech.tap.training.resourceio.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.qainfotech.tap.training.resourceio.TeamsJsonReader;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class Team {

	private final String name;
	private final Integer id;
	private final List<Individual> members;

	public Team(Map<String, Object> teamMap) throws FileNotFoundException, IOException {
		
	  	
	    Map<String, Object> myMap = teamMap;
	    	
	    name = myMap.get("name").toString();
	    id =Integer.parseInt(myMap.get("id").toString());
	    this.members=new ArrayList<Individual>();
	    List<Individual> arrayOfIndividuals=(new TeamsJsonReader()).getListOfIndividuals();
	    		    JSONArray memberArray=(JSONArray) teamMap.get("members");
	    		    Iterator<Individual> itr=arrayOfIndividuals.iterator();
	    		    while(itr.hasNext()){
	    		    Individual individual=itr.next();
	    		    for(int i=0;i<memberArray.size();i++){
	    		    if(individual.getId()==Integer.parseInt(memberArray.get(i).toString())){
	    		    this.members.add(individual);
	    
	    		    }
		//throw new UnsupportedOperationException("Not implemented.");
	}}}

	/**
	 * get team name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * get team id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	
	List<Individual> membersInTeam = new ArrayList<Individual>();
	JSONParser parser = new JSONParser();
	/**
	 * get list of individuals that are members of this team
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public List<Individual> getMembers() throws FileNotFoundException, IOException 
	 {
        return members;
}


	/**
	 * get a list of individuals that are members of this team and are also
	 * active
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */


	/**
	 * get a list of individuals that are members of this team but are inactive
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
public List<Individual> getActiveMembers(){
    	List<Individual> activemembers= new ArrayList<Individual>();
    	Iterator<Individual> itr =this.members.iterator();
    	while(itr.hasNext()){
    		Individual individual=(Individual)itr.next();
    		if(individual.isActive()){
    			activemembers.add(individual);
    		}
    	}
    	return activemembers;
        //throw new UnsupportedOperationException("Not implemented.");
    }
        
    /**
     * get a list of individuals that are members of this team but are inactive
     * 
     * @return 
     */
	    public List<Individual> getInactiveMembers(){
    	List<Individual> inactivemembers= new ArrayList<Individual>();
    	Iterator<Individual> itr =this.members.iterator();
    	while(itr.hasNext()){
    		Individual individual=(Individual)itr.next();
    		if(!(individual.isActive())){
    			inactivemembers.add(individual);
    		}
    	}
    	return inactivemembers;
       // throw new UnsupportedOperationException("Not implemented.");
}
	
}