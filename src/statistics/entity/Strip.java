package statistics.entity;

//�ɰ�
public class Strip {

private int order = 0;//˳��
	
	//���������
	private String dailyPlan = null;
	private String dailyFact = null;
	
	//���������
	private String monthPlan = null;
	private String monthFact = null;
	
	//���������
	private String yearPlan = null;
	private String yearFact = null;
	
	private String remark;//��ע
	
	private String name;//����
	

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
