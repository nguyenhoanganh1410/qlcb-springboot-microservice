package com.fit.se.ChuyenBayService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fit.se.ChuyenBayService.model.ChuyenBay;
import com.fit.se.ChuyenBayService.sẻvice.ChuyenBayService;

@RestController
@RequestMapping("/api/v1/chuyenbay")
public class ChuyenBayController {
	
	private ChuyenBayService chuyenBayDao;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@Autowired
	public ChuyenBayController( ChuyenBayService employeeDao) {
		super();
		this.chuyenBayDao = employeeDao;
	}

	
	@RequestMapping(value = "/gaDen/{gaDen:.+}", method = RequestMethod.GET)
	public List<ChuyenBay> findById(@PathVariable(name = "gaDen", value = "gaDen") String gaDen) {
		System.out.println(gaDen);
		return chuyenBayDao.getChuyenBayByDiemDen(gaDen);
		
	}
	@GetMapping("/doDai")
	public List<ChuyenBay> getChuyenBayByDoDai (@RequestParam int startDoDai,
																@RequestParam int endDoDai) {
		System.out.println(startDoDai);
		System.out.println(endDoDai);
		return chuyenBayDao.findByDoDaiBetween(startDoDai, endDoDai);
	}
	
	@GetMapping("/cb")
	public List<ChuyenBay> getChuyenBayGaDiAndGaDen (@RequestParam String gaDi,
																@RequestParam String gaDen) {
		System.out.println(gaDi);
		System.out.println(gaDen);
		return chuyenBayDao.findByGaDiAndGaDen(gaDi, gaDen);
	}
	
	


}
