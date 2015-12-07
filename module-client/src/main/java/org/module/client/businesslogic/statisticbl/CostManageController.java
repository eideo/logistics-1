package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.CostService;
import org.module.client.businesslogicservice.statisticBLservice.CostManageBLService;
import org.module.client.vo.CostListVO;

public class CostManageController implements CostManageBLService {
	private CostService cost;
	public CostManageController(CostService cost) {
		super();
		this.cost = cost;
	}

	public CostManageController() {
		cost = new Cost();
	}

	public boolean add(CostListVO vo) {
		// TODO Auto-generated method stub
		return cost.creatCostList(vo);
	}

	public ArrayList<CostListVO> showAll(long startTime, long endTime) {
		// TODO Auto-generated method stub
		return cost.getAllCostList(startTime, endTime);
	}



}
