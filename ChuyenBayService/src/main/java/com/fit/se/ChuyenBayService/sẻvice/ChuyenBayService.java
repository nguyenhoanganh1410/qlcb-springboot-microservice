package com.fit.se.ChuyenBayService.sẻvice;

import java.util.List;

import com.fit.se.ChuyenBayService.model.ChuyenBay;



public interface ChuyenBayService {
	public List<ChuyenBay> getChuyenBayByDiemDen(String gaDen);
	public List<ChuyenBay> findByDoDaiBetween(int startDoDai, int endDoDai);
	List<ChuyenBay> findByGaDiAndGaDen(String gaDi,  String gaDen);
	
}
