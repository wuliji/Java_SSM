package com.wuliji.springmvc.contrcller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wuliji.springmvc.pojo.Items;
import com.wuliji.springmvc.pojo.QueryVo;
import com.wuliji.springmvc.service.ItemService;


/**
 * ��Ʒ����
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {
	
	

	@Autowired
	private ItemService itemService;
	//���ų��� ��һ   ���� + ��� + ������
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		//��Mysql�в�ѯ
		List<Items> list = itemService.selectItemsList();
		
		ModelAndView mav = new ModelAndView();
		//����
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	//ȥ�޸�ҳ�� ��� id
	@RequestMapping(value = "/itemEdit.action")
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer idaaq,
	public ModelAndView toEdit(Integer id,
			HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model){
		
		//Servletʱ������
//		String id = request.getParameter("id");
		
		//��ѯһ����Ʒ
//		Items items = itemService.selectItemsById(Integer.parseInt(id));
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		//����
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
		
	}
	//�ύ�޸�ҳ�� ���  Ϊ Items����  
	@RequestMapping(value = "/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public ModelAndView updateitem(QueryVo vo){

		//�޸�
		itemService.updateItemsById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	
}
