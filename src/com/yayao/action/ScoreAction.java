package com.yayao.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.Score;
import com.yayao.service.ScoreService;


/**
 * 成绩
 * @author yy
 *
 */
public class ScoreAction extends BaseAction<Score,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ScoreService scoreService;
	private Score score=new Score();//成绩模型

	@Override
	public Score getModel() {
		return score;
	}
	/**
	 * 增加
	 */
	public String add()  {
		score.setUpdateDate(new Date());
		return super.add(score);
	}
	/**
	* 更新
	*/
	public String update()  {
		score.setUpdateDate(new Date());
		return super.update(score);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(score.getScoreId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(score.getScoreId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		return super.countAll(null, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, null, null, null, null, null, null, null, null);
	}

	
}