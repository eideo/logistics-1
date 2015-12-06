package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterLoadingService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.dataservice.orderdataservice.TranCenterLoadingListService;
import org.module.common.po.TranCenterLoadingListPO;

public class TranCenterLoading implements TranCenterLoadingService {
	private TranCenterLoadingListService tranCenterLoadingData ;
	public TranCenterLoading() {
		tranCenterLoadingData =  new RmiClient().get(TranCenterLoadingListService.class);
	}

	public boolean creat(TranCenterLoadingListVO o) {
		TranCenterLoadingListPO newPO = new TranCenterLoadingListPO(o.getLoadingDate(),o.getOfficeId()
				,o.getTrucksId(),o.getCity(),o.getLocation(),o.getCarId(),o.getSupervision(),o.getEscort()
				,o.getShippingId(),o.getPrice(),o.getState()); 
		try {
			return tranCenterLoadingData.add(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TranCenterLoadingListVO> getAll() {
		ArrayList<TranCenterLoadingListVO> newVOs = new ArrayList<TranCenterLoadingListVO>();
		ArrayList<TranCenterLoadingListPO> POs = null;
		try {
			 POs = tranCenterLoadingData.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new TranCenterLoadingListVO(POs.get(i).getLoadingDate(),POs.get(i).getOfficeId()
					,POs.get(i).getTrucksId(),POs.get(i).getCity(),POs.get(i).getLocation(),POs.get(i).getCarId(),POs.get(i).getSupervision(),POs.get(i).getEscort()
					,POs.get(i).getShippingId(),POs.get(i).getPrice(),POs.get(i).getState()));
		}
		return newVOs;
		
	}

	public boolean update(TranCenterLoadingListVO o) {
		TranCenterLoadingListPO newPO = new TranCenterLoadingListPO(o.getLoadingDate(),o.getOfficeId()
				,o.getTrucksId(),o.getCity(),o.getLocation(),o.getCarId(),o.getSupervision(),o.getEscort()
				,o.getShippingId(),o.getPrice(),o.getState()); 
		try {
			return tranCenterLoadingData.update(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

}
