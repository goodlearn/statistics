package statistics;

import statistics.dao.DBFactory;

public class Test {

		//���Է���
		public void run(int i) {
			switch(i){
				case 0:
					//��������
					createFrame();
					break;
				case 1:
					//���ݿ�����
					dbConnection();
					break;
			}
		}
		
		//��������
		private void createFrame() {
			MainFrame mainFrame = new MainFrame();
		}
		
		//���ݿ�����
		private void dbConnection() {
			try {
				DBFactory dbFactory = new DBFactory();
				dbFactory.queryAllDaily();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
