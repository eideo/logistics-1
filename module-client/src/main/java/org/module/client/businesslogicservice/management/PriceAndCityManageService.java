package org.module.client.businesslogicservice.management;

import java.util.ArrayList;

import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;

public interface PriceAndCityManageService {

	/**
	 * 前置：进入价格与城市管理
	 * 后置：显示所有城市
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<CityVO> showAllCity();

	/**
	 * 前置：选择增加城市，并输入
	 * 后置：默认新城市与其他城市间距离都是0；更新
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public boolean addCity(CityVO vo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCity(String id);
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public boolean modifyCity(CityVO vo);
	
	/**
	 * 前置：选择城市，并输入城市间距离
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.add 增加一个PO
	 * @param old
	 * @param direction
	 * @return
	 */
	public boolean setDiretionAndPrice(PriceAndCityVO priceAndcity);
	
	
	/**
	 * 
	 * @param cityA
	 * @param cityB
	 * @return
	 */
	public PriceAndCityVO getDiretionAndPrice(String cityA, String cityB) ;
}