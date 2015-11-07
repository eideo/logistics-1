package org.module.client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.userBLservice.UserBLservice;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;


public class UserBLImpl implements UserBLservice {
	UserDataService user = new RmiClient().getUserDataService();

	public boolean login(UserVO u) {
		try {
			
			UserPO po = user.find(u.getId());
			if(po==null) return false;
			if(po.getPassword().equals(u.getPassword()) &&  po.getRole().equals(u.getRole()))
				return true;
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean deleteUser(UserVO u) {
		try {
			return user.delete(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addUser(UserVO u) {
		try {
			return user.add(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserVO u) {
		try {
			return user.update(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<UserVO> allUsers() {
		try {
			ArrayList<UserPO> pos = user.allUsers();
			ArrayList<UserVO> re = new ArrayList<UserVO>();
			for (UserPO u : pos) {
				re.add(new UserVO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
			}
			return re;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

}
