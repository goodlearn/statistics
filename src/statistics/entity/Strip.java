package statistics.entity;

//采剥
public class Strip {

private int order = 0;//顺序
	
	//日生产情况
	private String dailyPlan = null;
	private String dailyFact = null;
	
	//月生产情况
	private String monthPlan = null;
	private String monthFact = null;
	
	//年生产情况
	private String yearPlan = null;
	private String yearFact = null;
	
	private String remark;//备注
	
	private String name;//名称
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDailyPlan() {
		return dailyPlan;
	}

	public void setDailyPlan(String dailyPlan) {
		this.dailyPlan = dailyPlan;
	}

	public String getDailyFact() {
		return dailyFact;
	}

	public void setDailyFact(String dailyFact) {
		this.dailyFact = dailyFact;
	}

	public String getMonthPlan() {
		return monthPlan;
	}

	public void setMonthPlan(String monthPlan) {
		this.monthPlan = monthPlan;
	}

	public String getMonthFact() {
		return monthFact;
	}

	public void setMonthFact(String monthFact) {
		this.monthFact = monthFact;
	}

	public String getYearPlan() {
		return yearPlan;
	}

	public void setYearPlan(String yearPlan) {
		this.yearPlan = yearPlan;
	}

	public String getYearFact() {
		return yearFact;
	}

	public void setYearFact(String yearFact) {
		this.yearFact = yearFact;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
