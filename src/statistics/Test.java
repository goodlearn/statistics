package statistics;

import statistics.dao.DBFactory;

public class Test {

		//测试方法
		public void run(int i) {
			switch(i){
				case 0:
					//创建窗体
					createFrame();
					break;
				case 1:
					//数据库连接
					dbConnection();
					break;
			}
		}
		
		//创建窗体
		private void createFrame() {
			MainFrame mainFrame = new MainFrame();
		}
		
		//数据库连接
		private void dbConnection() {
			try {
				DBFactory dbFactory = new DBFactory();
				dbFactory.queryAllDaily();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
