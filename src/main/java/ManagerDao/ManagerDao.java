package ManagerDao;

import com.webprj.di.entity.Manager;

public interface ManagerDao {
	Manager getManager(int manno);
	int insertManager(Manager manager);
	int updateManager(Manager manager);
	int deleteManager(int manno);

}
