package ksmart.mybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	//상품등록
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {	
		goodsService.addGoods(goods);		
		return "redirect:/goods/goodsList";
	}
	@GetMapping("/addGoods")
	public String addGoods() {
		return "goods/addGoods";
	}
	
	//상품목록조회
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		List<Goods> goodsList = goodsService.getGoodsList();
		
		model.addAttribute("goodsList", goodsList);
		
		log.info("goodsList:{}", goodsList);
		
		return "goods/goodsList";
	}
}
