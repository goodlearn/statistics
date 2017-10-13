package statistics.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class DailyEntity {
	
	private String name;
	
	private String date;
	
	//采剥
	private Map<Integer,Strip> strips = new LinkedHashMap<Integer,Strip>();

	//煤储量
	private Map<Integer,Repository> repositorys = new LinkedHashMap<Integer,Repository>();

	//煤质化验 
	private Map<Integer,CoalQualityAnalysis> coalQualityAnalysiss = new LinkedHashMap<Integer,CoalQualityAnalysis>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<Integer, Strip> getStrips() {
		return strips;
	}

	public void setStrips(Map<Integer, Strip> strips) {
		this.strips = strips;
	}

	public Map<Integer, Repository> getRepositorys() {
		return repositorys;
	}

	public void setRepositorys(Map<Integer, Repository> repositorys) {
		this.repositorys = repositorys;
	}

	public Map<Integer, CoalQualityAnalysis> getCoalQualityAnalysiss() {
		return coalQualityAnalysiss;
	}

	public void setCoalQualityAnalysiss(Map<Integer, CoalQualityAnalysis> coalQualityAnalysiss) {
		this.coalQualityAnalysiss = coalQualityAnalysiss;
	}

	
}
