package com.group8.controller.bid;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.group8.service.auditing.InvestmentService;
import com.group8.service.bid.BidService;

import com.group8.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:BidController
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:12
 */
@Controller
@RequestMapping("/bidcon")
public class BidController {
	@Autowired
	private BidService bidService;
	@Autowired
	private InvestmentService investmentService;

	/**
	 * 列表分页
	 *
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(@RequestParam Map map, Model model, HttpServletRequest request, HttpSession session) {
		map.put("pageSize", 7);
		int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
		int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize") + "");
		//计算分页的开始值和结束值
		map.put("start", (pageNo - 1) * pageSize);
		map.put("end", pageNo * pageSize + 1);

		String stringPage = new PageUtil(pageNo, 5, bidService.getPageCount(map), request).getStringPage();


		session.setAttribute("sessionValue", session);
		List<Map> selects = bidService.selects(map);
		List<Map> selectu = bidService.selectu(map);
		model.addAttribute("selectu", selectu);
		model.addAttribute("selecta", selects);
		model.addAttribute("stringPage", stringPage);
		model.addAttribute("bidList", bidService.getPage(map));
		return "bid/bid";
	}

	/**
	 * 执行修改方法
	 *
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(@RequestBody Map map) {
		int i = bidService.update(map);
		return i;
	}


	public Object jsjsons(@RequestBody Integer tendId) {
		int i = investmentService.hasCurrentlyVoted(tendId);
		return i;
	}

	@ResponseBody
	@RequestMapping("/add")
	public Object add(@RequestBody Map map) {

		int i = bidService.add(map);
		return i;
	}

	/**
	 * 执行修改方法
	 *
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateb")
	public Object updateb(@RequestBody Map map) {
		int i = bidService.updateb(map);

		return i;
	}

	/**
	 * 执行修改方法
	 *
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updaterr")
	public Object updaterr(@RequestBody Map map) {
		int i = bidService.updaterr(map);
		return i;
	}

	@ResponseBody
	@RequestMapping("getAllCountTend")
	public Object getAllCountTend(@RequestBody Map map){
		Map data = new HashMap();

		data.put("total",bidService.countAllTend());
		data.put("data",bidService.getAllTend(map));
		System.out.println(data);
		return data;
	}

}
