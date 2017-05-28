package com.nuchina.forum.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.ibm.db2.jcc.a.c;
import com.nuchina.common.base.BaseAction;
import com.nuchina.common.util.DateUtil;
import com.nuchina.common.util.FileUtil;
import com.nuchina.forum.dao.IForumPersonalDetailDAO;
import com.nuchina.forum.dao.IForumPraiseDAO;
import com.nuchina.forum.dao.IForumPublishDAO;
import com.nuchina.forum.dao.IForumRelationDAO;
import com.nuchina.forum.dao.IForumReplyDAO;
import com.nuchina.forum.dao.IForumWillAttachDAO;
import com.nuchina.forum.model.ForumPersonalDetail;
import com.nuchina.forum.model.ForumPersonalDetailExample;
import com.nuchina.forum.model.ForumPraise;
import com.nuchina.forum.model.ForumPraiseExample;
import com.nuchina.forum.model.ForumPublish;
import com.nuchina.forum.model.ForumPublishExample;
import com.nuchina.forum.model.ForumPublishExample.Criteria;
import com.nuchina.forum.model.ForumRelation;
import com.nuchina.forum.model.ForumRelationExample;
import com.nuchina.forum.model.ForumReply;
import com.nuchina.forum.model.ForumReplyExample;
import com.nuchina.forum.model.ForumWillAttach;
import com.nuchina.forum.model.ForumWillAttachExample;
import com.nuchina.system.model.SysUserInfo;
import com.primeton.xfire.client.Client;

public class ForumDetailAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private ForumPersonalDetail person;
	private File file;
	private String fileFileName;
	private ForumPublish record;
	private String content;
	private ForumPraise praise;
	//点击详情会用到
	private String isTopic;
	private List<ForumPublish> forumJobs;
	private List<ForumPublish> forumBests;
	private List<ForumPublish> forumLives;
	private List<ForumPublish> forumBest;
	private List<ForumReply> replyList;
	private ForumReply reply;
	private String replyPublicity;
	//FORUMMORE详情用到
	private String begintime;
	private String endtime;
	private String title;
	private String condition;
	
	private String orderJob;
	private String orderLive;
	
	private String attachPath;
	private String attachName;
	//判断是否为拟稿人，在查看详细内容时，如果是则显示编辑功能，如果不是则不显示
	private String flag;
	
	//管理员查看某人信息有用到
	private String personId;
	
	
	private String nickNa;
	
	@Resource
	private IForumPersonalDetailDAO forumPersonalDetailDAO;
	
	@Resource
	private IForumPublishDAO forumPublishDAO;
	
	@Resource
	private IForumWillAttachDAO forumWillAttachDAO;
	
	@Resource
	private IForumReplyDAO forumReplyDAO;
	
	@Resource
	private IForumPraiseDAO forumPraiseDAO;
	
	@Resource
	private IForumRelationDAO forumRelationDAO;
	
	
	public String subModuleTop(){
		SysUserInfo user = getCurrUser();
		//获取昵称
		String nickName = "";
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(user.getUserid());
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(example);
		if(persons.size()!=0 && persons!=null){
			nickName = persons.get(0).getNickName();
		}else{
			nickName = user.getUserid();
		}
		this.getRequest().setAttribute("nickName", nickName);
		return "subModuleTop";
	}
	
	/**
	 * 屏蔽功能	
	 * @return
	 * @throws IOException 
	 */
	public void shield() throws IOException{
		String id = this.getRequest().getParameter("id");
		String name = this.getRequest().getParameter("name");//标识是否是屏蔽还是解除
		ForumReply forumReply = forumReplyDAO.selectByPrimaryKey(Integer.parseInt(id));
		
		if(name.indexOf("pingbi")!=-1){
			forumReply.setShieldStatus(1);
			this.getResponse().getWriter().print("pingbi");
		}else{
			forumReply.setShieldStatus(0);
			String replyContent = forumReply.getReplyContent();
			this.getResponse().setCharacterEncoding("utf-8");
			this.getResponse().getWriter().print(replyContent);
		}
		forumReplyDAO.updateByPrimaryKey(forumReply);
	}
	
	/**
	 * 更多我的消息	
	 * @return
	 */
	public String myNews(){
		SysUserInfo currUser = this.getCurrUser();
		
		//获取未读跟已读消息的数量
		ForumRelationExample example2 = new ForumRelationExample();
		example2.createCriteria().andMyUserIdEqualTo(currUser.getUserid());
		int count = forumRelationDAO.countByExample(example2);
		getPage().setTotalRecord(count);
		
		//获取未读跟已读消息
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("start", this.getPage().getStartRow());
		map.put("count", this.getPage().getPageSize());
		map.put("userId", currUser.getUserid());
		List<ForumRelation> relations = forumRelationDAO.selectByUserId(map);
		this.getRequest().setAttribute("relations", relations);
		return "myNews";
	}
	
	
	/**
	 * 管理员查看某人页面
	 * @return
	 */
	public String managerCheck(){
		
		
		//得到某人论坛信息
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(personId);
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(example);
		
		//某人的发帖
		ForumPublishExample ex = new ForumPublishExample();
		ex.createCriteria().andUserIdEqualTo(personId);
		int  myComment= forumPublishDAO.countByExample(ex);
		person = persons.get(0);
		person.setMyComment(myComment);
		
		//某人的已读消息
		ForumRelationExample fre = new ForumRelationExample();
		fre.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeEqualTo("1");
		int myPost = forumRelationDAO.countByExample(fre);
		person.setMyPost(myPost);
		
		//与某人未读消息
		ForumRelationExample relation = new ForumRelationExample();
		relation.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeIsNull();
		int myRelation = forumRelationDAO.countByExample(relation);
		person.setExtend1(myRelation+"");
		
		
		
		//获取帖子信息
		List<ForumPublish> list1 = null;
		ForumPublishExample example1 = new ForumPublishExample();
		example1.setOrderByClause("draft_time DESC");
		example1.createCriteria().andUserIdEqualTo(personId);
		list1 = forumPublishDAO.selectByExample(example1);
		this.getRequest().setAttribute("resultList", list1);
		
		//获取未读消息
		//评论
		ForumRelationExample example4 = new ForumRelationExample();
		example4.setOrderByClause("relation_time Desc");
		example4.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeIsNull().andExtendEqualTo("评论");
		List<ForumRelation> list4 = forumRelationDAO.selectByExample(example4);
		
		//回复
		ForumRelationExample example5 = new ForumRelationExample();
		example5.setOrderByClause("relation_time Desc");
		example5.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeIsNull().andExtendEqualTo("回复");
		List<ForumRelation> list5 = forumRelationDAO.selectByExample(example5);
		
		list4.addAll(list5);
		
		//获取我的消息
		//评论
		ForumRelationExample example2 = new ForumRelationExample();
		example2.setOrderByClause("relation_time Desc");
		example2.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeEqualTo("1").andExtendEqualTo("评论");
		List<ForumRelation> list = forumRelationDAO.selectByExample(example2);
		
		//回复
		ForumRelationExample example3 = new ForumRelationExample();
		example3.setOrderByClause("relation_time Desc");
		example3.createCriteria().andMyUserIdEqualTo(personId).andAlrealyseeEqualTo("1").andExtendEqualTo("回复");
		List<ForumRelation> list2 = forumRelationDAO.selectByExample(example3);
		
		list4.addAll(list);
		list4.addAll(list2);
		this.getRequest().setAttribute("relations", list4);
		
		return "managerCheck";
	}
	
	
	
	/**
	 * 个人信息
	 * @return
	 */
	public String personPage(){
		SysUserInfo currUser = this.getCurrUser();
		
		//得到当前人论坛信息
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(example);
		
		//一开始用论坛时，无个人信息，显示为空
		if(persons.size()==0){
			person =new ForumPersonalDetail();
			person.setUserId(currUser.getUserid());
			person.setUserName(currUser.getUserfallname());
			person.setNickName(currUser.getUserid());
			person.setMyComment(0);
			person.setMyPost(0);
			person.setExtend1("0");
			forumPersonalDetailDAO.insert(person);
			
		}else{
			//我的帖子
			ForumPublishExample ex = new ForumPublishExample();
			ex.createCriteria().andUserIdEqualTo(currUser.getUserid());
			int  myComment= forumPublishDAO.countByExample(ex);
			person = persons.get(0);
			person.setMyComment(myComment);
			
			//我的消息
			ForumRelationExample fre = new ForumRelationExample();
			fre.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1");
			int myPost = forumRelationDAO.countByExample(fre);
			person.setMyPost(myPost);
			
			//与我相关
			ForumRelationExample relation = new ForumRelationExample();
			relation.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull();
			int myRelation = forumRelationDAO.countByExample(relation);
			person.setExtend1(myRelation+"");
			
		}
		
		//获取帖子信息
		List<ForumPublish> list1 = null;
		ForumPublishExample example1 = new ForumPublishExample();
		example1.setOrderByClause("draft_time DESC");
		example1.createCriteria().andUserIdEqualTo(currUser.getUserid());
		list1 = forumPublishDAO.selectByExample(example1);
		this.getRequest().setAttribute("resultList", list1);
		
		//获取未读消息
		//评论
		ForumRelationExample example4 = new ForumRelationExample();
		example4.setOrderByClause("relation_time Desc");
		example4.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull().andExtendEqualTo("评论");
		List<ForumRelation> list4 = forumRelationDAO.selectByExample(example4);
		
		//回复
		ForumRelationExample example5 = new ForumRelationExample();
		example5.setOrderByClause("relation_time Desc");
		example5.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull().andExtendEqualTo("回复");
		List<ForumRelation> list5 = forumRelationDAO.selectByExample(example5);
		
		list4.addAll(list5);
		
		//获取我的消息
		//评论
		ForumRelationExample example2 = new ForumRelationExample();
		example2.setOrderByClause("relation_time Desc");
		example2.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1").andExtendEqualTo("评论");
		List<ForumRelation> list = forumRelationDAO.selectByExample(example2);
		
		//回复
		ForumRelationExample example3 = new ForumRelationExample();
		example3.setOrderByClause("relation_time Desc");
		example3.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1").andExtendEqualTo("回复");
		List<ForumRelation> list2 = forumRelationDAO.selectByExample(example3);
		
		list4.addAll(list);
		list4.addAll(list2);
		this.getRequest().setAttribute("relations", list4);
		return "personPage";
	}
	
	
	/**
	 * 分页中的发表评论
	 * @return
	 */
	public String pageReply(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			SysUserInfo user = getCurrUser();
			int infoId = record.getId();
			reply.setInfoId(infoId);
			reply.setReplyTime(sdf.parse(sdf.format(new Date())));
			reply.setReplyId(user.getUserid());
			reply.setReplyName(user.getUserfallname());
			
			//为回复表赋值NICKNAME
			ForumPersonalDetailExample ex = new ForumPersonalDetailExample();
			ex.createCriteria().andUserIdEqualTo(user.getUserid());
			List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(ex);
			person = persons.get(0);
			reply.setNickName(person.getNickName());
			
			forumReplyDAO.insertSelective(reply);
			this.setTipMessage("comment");
			
			//每插入一条回复，回复量加1,回复状态设置为1（已回复）
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			long replyNum = record.getReplyNum()+1;
			record.setReplyNum(replyNum);
			record.setReplyStatus(1l);
			forumPublishDAO.updateByPrimaryKeySelective(record);

			//相关数据加一
			ForumRelation relation = new ForumRelation();
			relation.setHerUserId(user.getUserid());
			relation.setHerNickName(person.getNickName());
			relation.setTitle(record.getTitle());
			relation.setPublishId(record.getId());
			relation.setMyUserId(record.getUserId());
			relation.setMyNickName(record.getNickName());
			relation.setRelationTime(new Date());
			relation.setExtend("评论");
			forumRelationDAO.insert(relation);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "format";
	}
	

	/**
	 * 更多评论
	 * 
	 */
	public String moreReply(){
		
		//查询出回复列表
		ForumReplyExample example = new ForumReplyExample();
		example.setOrderByClause("reply_time ASC");
		example.createCriteria().andInfoIdEqualTo(record.getId());
		int count = forumReplyDAO.countByExample(example);
		
		//分页
		this.getPage().setTotalRecord(count);
		if (count > 0) {
			example.setMysqlOffset(this.getPage().getStartRow());
			example.setMysqlLength(this.getPage().getPageSize());
			replyList = forumReplyDAO.selectByExample(example);
		}
		
		
		//为每个人填充图像
		if(replyList.size()>0){
		ForumPersonalDetail detail = null;
		ForumPersonalDetailExample exx =new ForumPersonalDetailExample();
		for(int i=0;i<replyList.size();i++){
			exx.clear();
			exx.createCriteria().andUserIdEqualTo(replyList.get(i).getReplyId());
			detail = forumPersonalDetailDAO.selectByExample(exx).get(0);
			replyList.get(i).setExtend1(detail.getPicture());
		}
		}
		return "moreReply";
	}
	
	
	/**
	 * 背景图片的上传
	 * 
	 */
	public String update(){
		
		return "picture";
	}
	
	/**
	 * 人力论坛我的相关信息
	 * 
	 */
	public String relation(){
		
		
		try {
			SysUserInfo user = getCurrUser();
			record = forumPublishDAO.selectByPrimaryKey(record.getId());

			//用户点击进入详情页面，访问量加1
			long viewNum = record.getViewNum()+1;
			record.setViewNum(viewNum);
			forumPublishDAO.updateByPrimaryKeySelective(record);
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			content = this.getFckContent(record.getContent());
			
			//个人图像
			ForumPersonalDetailExample exa = new ForumPersonalDetailExample();
			exa.createCriteria().andUserIdEqualTo(record.getUserId());
			person = forumPersonalDetailDAO.selectByExample(exa).get(0);
			
			//如果当前用户为拟稿人，flag为true
			if (record.getUserId().equals(user.getUserid())) {
				setFlag("true");
			}else {
				setFlag("false");
			}
			
			//看看查看者是否已经点赞，已点赞图片变化
			ForumPraiseExample example2 = new ForumPraiseExample();
			ForumPraiseExample.Criteria pcri = example2.createCriteria();
			int infoId = record.getId();
			pcri.andInfoIdEqualTo(infoId);
			pcri.andPraiseIdEqualTo(getCurrUser().getUserid());
			int count = forumPraiseDAO.countByExample(example2);
			if(count>0){
				this.getRequest().setAttribute("praise", "yes");
			}else{
				this.getRequest().setAttribute("praise", "no");
			}
			
			//附件的回显
			ForumWillAttachExample ex = new ForumWillAttachExample();
			ex.createCriteria().andApplyidEqualTo((long)infoId);
			int cou= forumWillAttachDAO.countByExample(ex);
			if(cou>0){
				ForumWillAttach attach = forumWillAttachDAO.selectByExample(ex).get(0);
				attachPath = attach.getAttachpath();
				attachName = attach.getAttachname();
			}
			
			//查询出回复列表
			ForumReplyExample example = new ForumReplyExample();
			example.setOrderByClause("reply_time ASC");
			example.createCriteria().andInfoIdEqualTo(record.getId());
			replyList = forumReplyDAO.selectByExample(example);
			
			//为每个人填充图像
			if(replyList.size()>0){
			ForumPersonalDetail detail = null;
			ForumPersonalDetailExample exx =new ForumPersonalDetailExample();
			for(int i=0;i<replyList.size();i++){
				exx.clear();
				exx.createCriteria().andUserIdEqualTo(replyList.get(i).getReplyId());
				detail = forumPersonalDetailDAO.selectByExample(exx).get(0);
				replyList.get(i).setExtend1(detail.getPicture());
			}
			}
			
			//相关数据减多个
			ForumRelationExample ex1 = new ForumRelationExample();
			ex1.createCriteria().andPublishIdEqualTo(record.getId()).andAlrealyseeIsNull().andMyUserIdEqualTo(user.getUserid());
			List<ForumRelation> relations = forumRelationDAO.selectByExample(ex1);
			for(int i=0;i<relations.size();i++){
				relations.get(i).setAlrealysee("1");
				forumRelationDAO.updateByPrimaryKey(relations.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "publish";
		
	}
	
	/**
	 * 人力论坛我的相关信息
	 * 
	 */
	public String myRelation(){
		//获取个人的相关信息
		
		//评论
		SysUserInfo currUser = getCurrUser();
		ForumRelationExample example = new ForumRelationExample();
		example.setOrderByClause("relation_time Desc");
		example.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull().andExtendEqualTo("评论");
		List<ForumRelation> list = forumRelationDAO.selectByExample(example);
		
		//回复
		ForumRelationExample example2 = new ForumRelationExample();
		example2.setOrderByClause("relation_time Desc");
		example2.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull().andExtendEqualTo("回复");
		List<ForumRelation> list2 = forumRelationDAO.selectByExample(example2);
		
		list.addAll(list2);
		if(list.size()>0){
			this.getRequest().setAttribute("relations", list);
		}
		return "myRelation";
	}
	
	/**
	 * 人力论坛我的已经相关信息
	 * 
	 */
	public String alreadyRelation(){
		//获取个人的相关信息
		
		//评论
		SysUserInfo currUser = getCurrUser();
		ForumRelationExample example = new ForumRelationExample();
		example.setOrderByClause("relation_time Desc");
		example.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1").andExtendEqualTo("评论");
		List<ForumRelation> list = forumRelationDAO.selectByExample(example);
		
		//回复
		ForumRelationExample example2 = new ForumRelationExample();
		example2.setOrderByClause("relation_time Desc");
		example2.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1").andExtendEqualTo("回复");
		List<ForumRelation> list2 = forumRelationDAO.selectByExample(example2);
		
		list.addAll(list2);
		if(list.size()>0){
			this.getRequest().setAttribute("relations", list);
		}
		return "myRelation";
	}
	
	/**
	 * 人力论坛首页右边的搜寻功能
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	public String search() throws UnsupportedEncodingException {
		List<ForumPublish> list1 = null;
		Map<String,Object> map = new HashMap<String,Object>();
		//标题
		condition = URLDecoder.decode(condition, "utf-8");
		if(StringUtils.isNotEmpty(condition)){
			int mysqlLength = getPage().getPageSize();
			int mysqlOffset = getPage().getStartRow();
			map.put("condition", condition);
			map.put("mysqlOffset", mysqlOffset);
			map.put("mysqlLength", mysqlLength);
			int count = forumPublishDAO.countByCondition(condition);
			getPage().setTotalRecord(count);
			if(count>0){
				list1 = forumPublishDAO.selectByCondition(map);
			}
			
		}else{
			//标题
			ForumPublishExample example = new ForumPublishExample();
			example.setOrderByClause("draft_time DESC");
			example.setMysqlLength(getPage().getPageSize());
			example.setMysqlOffset(getPage().getStartRow());
			int count = forumPublishDAO.countByExample(example);
			getPage().setTotalRecord(count);
			if(count>0){
				list1 = forumPublishDAO.selectByExample(example);
			}
		}
		this.getRequest().setAttribute("resultList", list1);
		return "doneList";
	}
	
	/**
	 * 人力论坛首页右边的我的帖子搜寻功能
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	public String searchComment() throws UnsupportedEncodingException {
		List<ForumPublish> list1 = null;
		SysUserInfo currUser = getCurrUser();
		ForumPublishExample example = new ForumPublishExample();
		example.setOrderByClause("draft_time DESC");
		example.setMysqlLength(getPage().getPageSize());
		example.setMysqlOffset(getPage().getStartRow());
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		int count = forumPublishDAO.countByExample(example);
		getPage().setTotalRecord(count);
		if(count>0){
			list1 = forumPublishDAO.selectByExample(example);
		}
		this.getRequest().setAttribute("resultList", list1);
		return "mycomments";
	}
	
	/**
	 * 精品事项详情
	 * @return
	 */
	public String bestItems(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("best", "是");
		
		//三个查询条件
		if(StringUtils.isNotEmpty(title)){
			map.put("title", title);
		}
		
		if (StringUtils.isNotEmpty(begintime)) {
			map.put("begintime", begintime);
		}
		
		if (StringUtils.isNotEmpty(endtime)) {
			SimpleDateFormat simple = new  SimpleDateFormat("yyyy-MM-dd");
			String time = simple.format(DateUtil.addDay(DateUtil.parse(endtime,"yyyy-MM-dd"), 1));
			map.put("endtime", time);
		}
		
		int count = forumPublishDAO.orderReplyTimeCount(map);
		
		getPage().setTotalRecord(count);
		
//		按：发帖时间,点赞数,浏览量,评论时间
		if (StringUtils.isNotEmpty(orderLive) && "发帖时间".equals(orderLive)) {
			map.put("condition", "draft_time");
		}else if (StringUtils.isNotEmpty(orderLive) && "回复数".equals(orderLive)) {
			map.put("condition", "reply_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "浏览量".equals(orderLive)) {
			map.put("condition", "view_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "评论时间".equals(orderLive)){
			map.put("condition", "reply_time");
		}else{
			map.put("condition", "best_time");
		}
		
		//页大小
		map.put("length", getPage().getPageSize());
		map.put("offset", getPage().getStartRow());
		
		List<Map<String, Object>> forumBests = forumPublishDAO.orderReplyTime(map);
		this.getRequest().setAttribute("forumBests", forumBests);
		
		return "moreBestForum";
	}
	
	/**
	 * 工作事项详情
	 * @return
	 */
	public String jobItems(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("postSort", "分享工作");
		
		//三个查询条件
		if(StringUtils.isNotEmpty(title)){
			map.put("title", title);
		}
		
		if (StringUtils.isNotEmpty(begintime)) {
			map.put("begintime", begintime);
		}
		
		if (StringUtils.isNotEmpty(endtime)) {
			SimpleDateFormat simple = new  SimpleDateFormat("yyyy-MM-dd");
			String time = simple.format(DateUtil.addDay(DateUtil.parse(endtime,"yyyy-MM-dd"), 1));
			map.put("endtime", time);
		}
		
		int count = forumPublishDAO.orderReplyTimeCount(map);
		
		getPage().setTotalRecord(count);
		
//		按：发帖时间,点赞数,浏览量,评论时间
		if (StringUtils.isNotEmpty(orderLive) && "发帖时间".equals(orderLive)) {
			map.put("condition", "draft_time");
		}else if (StringUtils.isNotEmpty(orderLive) && "回复数".equals(orderLive)) {
			map.put("condition", "reply_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "浏览量".equals(orderLive)) {
			map.put("condition", "view_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "评论时间".equals(orderLive)) {
			map.put("condition", "reply_time");
		}
		else {
			map.put("condition", "");
		}
		
		//页大小
		map.put("length", getPage().getPageSize());
		map.put("offset", getPage().getStartRow());
		List<Map<String, Object>> forumJobs = forumPublishDAO.orderReplyTime(map);
		this.getRequest().setAttribute("forumJobs",forumJobs);
		
		return "moreJobForum";
	}
	
	/**
	 * 生活事项详情
	 * @return
	 */
	public String liveItems(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("postSort", "分享生活");
		
		//三个查询条件
		if(StringUtils.isNotEmpty(title)){
			map.put("title", title);
		}
		
		if (StringUtils.isNotEmpty(begintime)) {
			map.put("begintime", begintime);
		}
		
		if (StringUtils.isNotEmpty(endtime)) {
			SimpleDateFormat simple = new  SimpleDateFormat("yyyy-MM-dd");
			String time = simple.format(DateUtil.addDay(DateUtil.parse(endtime,"yyyy-MM-dd"), 1));
			map.put("endtime", time);
		}
		
		int count = forumPublishDAO.orderReplyTimeCount(map);
		
		getPage().setTotalRecord(count);
		
//		按：发帖时间,点赞数,浏览量,评论时间
		if (StringUtils.isNotEmpty(orderLive) && "发帖时间".equals(orderLive)) {
			map.put("condition", "draft_time");
		}else if (StringUtils.isNotEmpty(orderLive) && "回复数".equals(orderLive)) {
			map.put("condition", "reply_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "浏览量".equals(orderLive)) {
			map.put("condition", "view_num");
		}else if (StringUtils.isNotEmpty(orderLive) && "评论时间".equals(orderLive)) {
			map.put("condition", "reply_time");
		}
		else {
			map.put("condition", "");
		}
		
		//页大小
		map.put("length", getPage().getPageSize());
		map.put("offset", getPage().getStartRow());
		
		List<Map<String,Object>> forumLives = forumPublishDAO.orderReplyTime(map);
		this.getRequest().setAttribute("forumLives", forumLives);
		
		return "moreLiveForum";
	}
	
	/**
	 * 回复某人的某人
	 * @return
	 * @throws Exception 
	 */
	public void alreadyReplyPerson() throws Exception{
		//插入评论
		SysUserInfo user = getCurrUser();
		reply.setReplyTime(DateUtil.now());
		reply.setReplyId(user.getUserid());
		reply.setReplyName(user.getUserfallname());
		
		//为回复表赋值NICKNAME
		ForumPersonalDetailExample ex = new ForumPersonalDetailExample();
		ex.createCriteria().andUserIdEqualTo(user.getUserid());
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(ex);
		person = persons.get(0);
		reply.setNickName(person.getNickName());
		forumReplyDAO.insert(reply);
		
		
		//每插入一条回复，回复量加1,回复状态设置为1（已回复）
		record = forumPublishDAO.selectByPrimaryKey(reply.getInfoId());
		long replyNum = record.getReplyNum()+1;
		record.setReplyNum(replyNum);
		record.setReplyStatus(1l);
		forumPublishDAO.updateByPrimaryKeySelective(record);
		
		//相关数据加一
		ForumRelation relation = new ForumRelation();
		relation.setHerUserId(user.getUserid());
		relation.setHerNickName(person.getNickName());
		relation.setTitle(record.getTitle());
		relation.setPublishId(record.getId());
		relation.setRelationTime(new Date());
		relation.setExtend("回复");
		//为相关表赋值MYUSERID与MYNICKNSME
		ForumReply self = forumReplyDAO.selectByPrimaryKey(reply.getSelfId());
		relation.setMyUserId(self.getReplyId());
		//通过USERID得到昵称
		ForumPersonalDetailExample exam = new ForumPersonalDetailExample();
		exam.createCriteria().andUserIdEqualTo(self.getReplyId());
		ForumPersonalDetail  User= forumPersonalDetailDAO.selectByExample(exam).get(0);
		relation.setMyNickName(User.getNickName());
		forumRelationDAO.insert(relation);
		
	}
	
	
	/**
	 * 回复某人
	 * @return
	 */
	public String replyPerson(){
		String id = this.getRequest().getParameter("id");
		String build = this.getRequest().getParameter("bu");
		String sign = this.getRequest().getParameter("sign");
		this.getRequest().setAttribute("sign",sign);
		reply = new  ForumReply();
		reply.setSelfId(Integer.parseInt(id));
		reply.setInfoId(record.getId());
		reply.setReplyPublicity(Long.parseLong(build));
		return "replyPerson";
	}
	
	
	
	
	/**
	 * 发表评论
	 * @return
	 */
	public String reply(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			SysUserInfo user = getCurrUser();
			int infoId = record.getId();
			reply.setInfoId(infoId);
			reply.setReplyTime(sdf.parse(sdf.format(new Date())));
			reply.setReplyId(user.getUserid());
			reply.setReplyName(user.getUserfallname());
			
			//为回复表赋值NICKNAME
			ForumPersonalDetailExample ex = new ForumPersonalDetailExample();
			ex.createCriteria().andUserIdEqualTo(user.getUserid());
			List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(ex);
			person = persons.get(0);
			reply.setNickName(person.getNickName());
			
			forumReplyDAO.insertSelective(reply);
			this.setTipMessage("comment");
			
			//每插入一条回复，回复量加1,回复状态设置为1（已回复）
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			long replyNum = record.getReplyNum()+1;
			record.setReplyNum(replyNum);
			record.setReplyStatus(1l);
			forumPublishDAO.updateByPrimaryKeySelective(record);
			
			//跳转到详情页面
			content = this.getFckContent(record.getContent());
			
			//查询出回复列表
			ForumReplyExample example = new ForumReplyExample();
			example.setOrderByClause("reply_time ASC");
			example.createCriteria().andInfoIdEqualTo(record.getId());
			replyList = forumReplyDAO.selectByExample(example);
			
			//为每个人填充图像
			if(replyList.size()>0){
			ForumPersonalDetail detail = null;
			ForumPersonalDetailExample exx =new ForumPersonalDetailExample();
			for(int i=0;i<replyList.size();i++){
				exx.clear();
				exx.createCriteria().andUserIdEqualTo(replyList.get(i).getReplyId());
				detail = forumPersonalDetailDAO.selectByExample(exx).get(0);
				replyList.get(i).setExtend1(detail.getPicture());
			}
			}
			
			//相关数据加一
			ForumRelation relation = new ForumRelation();
			relation.setHerUserId(user.getUserid());
			relation.setHerNickName(person.getNickName());
			relation.setTitle(record.getTitle());
			relation.setPublishId(record.getId());
			relation.setMyUserId(record.getUserId());
			relation.setMyNickName(record.getNickName());
			relation.setRelationTime(new Date());
			relation.setExtend("评论");
			forumRelationDAO.insert(relation);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "reply";
	}
	
	/**
	 * 增加点赞数
	 * @return
	 * @throws IOException 
	 */
	public void addPraise() throws IOException{	
		ForumPraiseExample example2 = new ForumPraiseExample();
		ForumPraiseExample.Criteria pcri = example2.createCriteria();
		ForumReplyExample example1 = new ForumReplyExample();
		example1.createCriteria().andInfoIdEqualTo(record.getId());
		int infoId = record.getId();
		pcri.andInfoIdEqualTo(infoId);
		pcri.andPraiseIdEqualTo(getCurrUser().getUserid());
		int count = forumPraiseDAO.countByExample(example2);
		if(count!=0){
			this.getResponse().getWriter().print("{\"solution\":\"false\"}");
		}else{
			praise = new ForumPraise();
			praise.setInfoId(infoId);
			praise.setPraiseId(getCurrUser().getUserid());
			praise.setPraiseName(getCurrUser().getUserfallname());
			forumPraiseDAO.insertSelective(praise);
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			long praiseNum = record.getPraiseNum()+1;
			record.setPraiseNum(praiseNum);
			forumPublishDAO.updateByPrimaryKeySelective(record);
			this.getResponse().getWriter().print("{\"praiseNum\":\""+praiseNum+"\",\"solution\":\"true\"}");
		}
		
	}
	
	
	/**
	 * 点击编辑
	 * 
	 */
	public String detailManage(){
		try {
			SysUserInfo user = getCurrUser();
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			content = this.getFckContent(record.getContent());
			//如果当前用户为拟稿人，flag为true
			if (record.getUserId().equals(user.getUserid())) {
				setFlag("true");
			}else {
				setFlag("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detailManage";
	}
	
	/**
	 * 预览
	 * @return
	 * @throws Exception 
	 */
	public String review() throws Exception {
		SysUserInfo currUser = this.getCurrUser();
		
		//个人图像
		ForumPersonalDetailExample exa = new ForumPersonalDetailExample();
		exa.createCriteria().andUserIdEqualTo(currUser.getUserid());
		person = forumPersonalDetailDAO.selectByExample(exa).get(0);
		
		//附件的回显
		ForumWillAttachExample ex = new ForumWillAttachExample();
		ex.createCriteria().andApplyidEqualTo((long)record.getId());
		int cou= forumWillAttachDAO.countByExample(ex);
		if(cou>0){
			ForumWillAttach attach = forumWillAttachDAO.selectByExample(ex).get(0);
			attachPath = attach.getAttachpath();
			attachName = attach.getAttachname();
		}
		
		//看看查看者是否已经点赞，已点赞图片变化
		ForumPraiseExample example2 = new ForumPraiseExample();
		ForumPraiseExample.Criteria pcri = example2.createCriteria();
		int infoId = record.getId();
		pcri.andInfoIdEqualTo(infoId);
		pcri.andPraiseIdEqualTo(getCurrUser().getUserid());
		int count = forumPraiseDAO.countByExample(example2);
		if(count>0){
			this.getRequest().setAttribute("praise", "yes");
		}else{
			this.getRequest().setAttribute("praise", "no");
		}
		
		
		return "review";
	}
	
	/**
	 * 点击详情
	 * 
	 */
	public String detail(){
		try {
			SysUserInfo user = getCurrUser();
			record = forumPublishDAO.selectByPrimaryKey(record.getId());

			//用户点击进入详情页面，访问量加1
			long viewNum = record.getViewNum()+1;
			record.setViewNum(viewNum);
			forumPublishDAO.updateByPrimaryKeySelective(record);
			record = forumPublishDAO.selectByPrimaryKey(record.getId());
			content = this.getFckContent(record.getContent());
			
			//检查是否被编辑过
			if(record.getUserPhone()!=null && !record.getUserPhone().equals("")){
				ForumPersonalDetailExample fpd = new ForumPersonalDetailExample();
				fpd.createCriteria().andUserIdEqualTo(record.getUserPhone());
				List<ForumPersonalDetail> list = forumPersonalDetailDAO.selectByExample(fpd);
				if(list.size()!=0 && list!=null){
					ForumPersonalDetail detail = list.get(0);
					nickNa = detail.getNickName();
				}
			}
			
			
			//个人图像
			ForumPersonalDetailExample exa = new ForumPersonalDetailExample();
			exa.createCriteria().andUserIdEqualTo(record.getUserId());
			person = forumPersonalDetailDAO.selectByExample(exa).get(0);
			
			//如果当前用户为拟稿人，flag为true
			if (record.getUserId().equals(user.getUserid())) {
				setFlag("true");
			}else {
				setFlag("false");
			}
			
			//看看查看者是否已经点赞，已点赞图片变化
			ForumPraiseExample example2 = new ForumPraiseExample();
			ForumPraiseExample.Criteria pcri = example2.createCriteria();
			int infoId = record.getId();
			pcri.andInfoIdEqualTo(infoId);
			pcri.andPraiseIdEqualTo(getCurrUser().getUserid());
			int count = forumPraiseDAO.countByExample(example2);
			if(count>0){
				this.getRequest().setAttribute("praise", "yes");
			}else{
				this.getRequest().setAttribute("praise", "no");
			}
			
			//附件的回显
			ForumWillAttachExample ex = new ForumWillAttachExample();
			ex.createCriteria().andApplyidEqualTo((long)infoId);
			int cou= forumWillAttachDAO.countByExample(ex);
			if(cou>0){
				ForumWillAttach attach = forumWillAttachDAO.selectByExample(ex).get(0);
				attachPath = attach.getAttachpath();
				attachName = attach.getAttachname();
			}
			
			//查询出回复列表
			ForumReplyExample example = new ForumReplyExample();
			example.setOrderByClause("reply_time ASC");
			example.createCriteria().andInfoIdEqualTo(record.getId());
			replyList = forumReplyDAO.selectByExample(example);
			
			//为每个人填充图像
			if(replyList.size()>0){
			ForumPersonalDetail detail = null;
			ForumPersonalDetailExample exx =new ForumPersonalDetailExample();
			for(int i=0;i<replyList.size();i++){
				exx.clear();
				exx.createCriteria().andUserIdEqualTo(replyList.get(i).getReplyId());
				detail = forumPersonalDetailDAO.selectByExample(exx).get(0);
				replyList.get(i).setExtend1(detail.getPicture());
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "publish";
	}
	
	/**
	 * 人力论坛  首页中间跳转
	 * 
	 */
	public String center(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("postSort", "分享工作");
		List<Map<String, Object>> forumJobs = forumPublishDAO.orderReplyTime(map);
		this.getRequest().setAttribute("forumJobs", forumJobs);
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("postSort", "分享生活");
		List<Map<String, Object>> forumLives = forumPublishDAO.orderReplyTime(map1);
		this.getRequest().setAttribute("forumlives", forumLives);
		
		
		return "center";
	}
	
	/**
	 * 人力论坛  首页中间跳转生活排序
	 * @throws IOException 
	 * 
	 */
	public void centerLiveOrder() throws IOException{
		String condition = (String) this.getRequest().getAttribute("condition");
		ForumPublishExample example = new ForumPublishExample();
		if(condition.equals("发帖时间") ){
			example.setOrderByClause("draft_time DESC");
			example.createCriteria().andPostSortEqualTo("分享生活");
		}else if(condition.equals("点赞数")) {
			example.setOrderByClause("praise_num DESC");
			example.createCriteria().andPostSortEqualTo("分享生活");
		}else{
			example.setOrderByClause("view_num DESC");
			example.createCriteria().andPostSortEqualTo("分享生活");
		}
		forumLives = forumPublishDAO.selectByExample(example);
		String list = JSONArray.fromObject(forumLives).toString();
		this.getResponse().setCharacterEncoding("UTF-8");
		this.getResponse().getWriter().print(list);
	}
	
	/**
	 * 人力论坛  首页中间跳转工作排序
	 * @throws IOException 
	 * 
	 */
	public void centerJobOrder() throws IOException{
		String condition = this.getRequest().getParameter("condition");
		ForumPublishExample example = new ForumPublishExample();
		if(condition.equals("发帖时间") ){
			example.setOrderByClause("draft_time DESC");
			example.createCriteria().andPostSortEqualTo("分享工作");
		}else if(condition.equals("点赞数")) {
			example.setOrderByClause("praise_num DESC");
			example.createCriteria().andPostSortEqualTo("分享工作");
			
		}else{
			example.setOrderByClause("view_num DESC");
			example.createCriteria().andPostSortEqualTo("分享工作");
		}
		forumJobs = forumPublishDAO.selectByExample(example);
		String list = JSONArray.fromObject(forumJobs).toString();
		this.getResponse().setCharacterEncoding("UTF-8");
		this.getResponse().getWriter().print(list);
	}
	
	
	/**
	 * 发布论坛
	 * @throws Exception 
	 * 
	 */
	public String publishPost() throws Exception {
		SysUserInfo currUser = this.getCurrUser();
		String contentURL = this.saveFckContent(content, null);
		record.setContent(contentURL);
		record.setUserId(currUser.getUserid());
		record.setBestTopic("否");
		Integer id = record.getId();
		record.setId(null);
		forumPublishDAO.insertSelective(record);
		
		//将附件表中的数据更新招聘主表id
		ForumWillAttachExample aExample = new ForumWillAttachExample();
		ForumWillAttachExample.Criteria acri = aExample.createCriteria();
		acri.andApplyidEqualTo(Long.valueOf(id));
		ForumWillAttach ra = new ForumWillAttach();
		ra.setApplyid(Long.valueOf(record.getId()));
		forumWillAttachDAO.updateByExampleSelective(ra, aExample);
		
		/******************* 调用企业生活接口 *********************/
		try {
			String basepath = getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath()+"/";
			Client client = new Client(new URL("http://10.175.39.185/bpm/services/elife?wsdl"));
			Object[] result = client.invoke("infoPublishForElife", new Object[]{
					record.getTitle(),
					"分享精彩",
//					"http://10.176.237.12:8080/"+record.getPicture(),
					"http://10.175.39.185:8080/"+record.getPicture(),
					record.getUserId(),
					record.getUserName(),
					"-1",
					"",
					"",
					"",
					basepath+"forum/forumAction!detail.action?record.id="+record.getId(),
					null,
					null,
					0l,
					0l,
					Long.valueOf(record.getId())
			});
			System.out.println("fenxiangjingcai  qysh:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "homePost";
	}
	
	/**
	 * 管理员发表论坛
	 * @throws Exception 
	 * 
	 */
	public String change() throws Exception {

		String bTopic = this.getRequest().getParameter("bTopic");
		String iStick = this.getRequest().getParameter("iStick");
		SysUserInfo currUser = this.getCurrUser();
		String contentURL = this.saveFckContent(content, null);
		record.setContent(contentURL);
//		record.setUserId(currUser.getUserid());
		//置顶
		if(iStick.equals("0")) {
			if(record.getIsStick()==1l){
				record.setStickTime(new Date());
			}
		}else {
			if(record.getIsStick()==0l){
				record.setStickTime(null);
			}else{
				record.setStickTime(new Date());
			}
		}
		//精华
		if (bTopic.equals("否")) {
			if(record.getBestTopic().equals("是")){
				record.setBestTime(new Date());
			}
		}else {
			if(record.getBestTopic().equals("否")){
				record.setBestTime(null);
			}else{
				record.setBestTime(new Date());
			}
		}
		//获取修改管理员的id
		record.setUserPhone(currUser.getUserid());
		
		
		
		//修改操作
		forumPublishDAO.updateByPrimaryKey(record);
		
		/******************* 调用企业生活接口 *********************/
		try {
			String basepath = getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath()+"/";
			Client client = new Client(new URL("http://10.175.39.185/bpm/services/elife?wsdl"));
			Object[] result = client.invoke("infoPublishForElife", new Object[]{
					record.getTitle(),
					"分享精彩",
					"http://10.175.39.185:8080/"+record.getPicture(),
					record.getUserId(),
					record.getUserName(),
					"-1",
					"",
					"",
					"",
					basepath+"forum/forumAction!detail.action?record.id="+record.getId(),
					null,
					null,
					0l,
					0l,
					Long.valueOf(record.getId())
			});
			System.out.println("fenxiangjingcai  qysh:"+result);
			System.out.println(record.getPicture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "change";
	}
	
	/**
	 * 管理员废弃论坛
	 * @throws Exception 
	 * 
	 */
	public String destroy() throws Exception {
		
		//主表废弃操作
		forumPublishDAO.deleteByPrimaryKey(record.getId());
		
		//点赞表删除操作
		ForumPraiseExample fpe = new ForumPraiseExample();
		fpe.createCriteria().andInfoIdEqualTo(record.getId());
		forumPraiseDAO.deleteByExample(fpe);
		
		//评论表删除操作
		ForumReplyExample fre = new ForumReplyExample();
		fre.createCriteria().andInfoIdEqualTo(record.getId());
		forumReplyDAO.deleteByExample(fre);
		
		//表删除操作
		ForumWillAttachExample fae = new ForumWillAttachExample();
		fae.createCriteria().andApplyidEqualTo((long)record.getId());
		forumWillAttachDAO.deleteByExample(fae);
		
		//相关表删除操作
		ForumRelationExample relation = new ForumRelationExample();
		relation.createCriteria().andPublishIdEqualTo(record.getId());
		forumRelationDAO.deleteByExample(relation);
		
		
		return "home";
	}
	
	
	/**
	 * 人力论坛  首页跳转
	 * 
	 */
	public String home() {
		SysUserInfo currUser = this.getCurrUser();
		
		//得到当前人论坛信息
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(example);
		
		//一开始用论坛时，无个人信息，显示为空
		if(persons.size()==0){
			person =new ForumPersonalDetail();
			person.setUserId(currUser.getUserid());
			person.setUserName(currUser.getUserfallname());
			person.setNickName(currUser.getUserid());
			person.setMyComment(0);
			person.setMyPost(0);
			person.setExtend1("0");
			forumPersonalDetailDAO.insert(person);
			
		}
		
		return "home";
	}
	
	/**
	 * 人力论坛  首页右边跳转
	 * 
	 */
	public String right(){
		SysUserInfo currUser = this.getCurrUser();
		
		//得到当前人论坛信息
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPersonalDetail> persons = forumPersonalDetailDAO.selectByExample(example);
		
		//一开始用论坛时，无个人信息，显示为空
		if(persons.size()==0){
			person =new ForumPersonalDetail();
			person.setUserId(currUser.getUserid());
			person.setNickName(currUser.getUserid());
			person.setMyComment(0);
			person.setMyPost(0);
			person.setExtend1("0");
			forumPersonalDetailDAO.insert(person);
			
		}else{
			//我的帖子
			ForumPublishExample ex = new ForumPublishExample();
			ex.createCriteria().andUserIdEqualTo(currUser.getUserid());
			int  myComment= forumPublishDAO.countByExample(ex);
			person = persons.get(0);
			person.setMyComment(myComment);
			
			//我的消息
			ForumRelationExample fre = new ForumRelationExample();
			fre.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1");
			int myPost = forumRelationDAO.countByExample(fre);
			person.setMyPost(myPost);
			
			//与我相关
			ForumRelationExample relation = new ForumRelationExample();
			relation.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull();
			int myRelation = forumRelationDAO.countByExample(relation);
			person.setExtend1(myRelation+"");
			
		}
		
		
		
		return "right";
	}
	
	/**
	 * 人力论坛  首页右边时时刷新相关数据
	 * @throws IOException 
	 * @throws Exception 
	 * 
	 */
	public void timeRefresh() throws IOException{
		//与我相关
		SysUserInfo currUser = this.getCurrUser();
		ForumRelationExample relation = new ForumRelationExample();
		relation.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeIsNull();
		int myRelation = forumRelationDAO.countByExample(relation);
		
		//我的消息
		ForumRelationExample fe = new ForumRelationExample();
		fe.createCriteria().andMyUserIdEqualTo(currUser.getUserid()).andAlrealyseeEqualTo("1");
		int myNews = forumRelationDAO.countByExample(fe);
		
		this.getResponse().getWriter().print("{\"myRelation\":\""+myRelation+"\",\"myNews\":\""+myNews+"\"}");
		
	}
	
	
	/**
	 * 人力论坛  首页左边跳转
	 * @throws Exception 
	 * 
	 */
	
	public String left() throws Exception{
		ForumPublishExample example = new ForumPublishExample();
		example.setOrderByClause("best_time DESC");
		example.createCriteria().andBestTopicEqualTo("是");
		forumBest = forumPublishDAO.selectByExample(example);
		String content2;
		for(int i=0;i<forumBest.size();i++){
			content2 = forumBest.get(i).getContent();
			content = getFckContent(content2);
			Pattern pattern=Pattern.compile("<.+?>", Pattern.DOTALL); 
			Matcher matcher=pattern.matcher(content);
			content = matcher.replaceAll("");
			content = content.replace("&nbsp;","");
			content = content.replace(" ", "");
			forumBest.get(i).setContent(content);
		}
		return "left";
	}
	
	/**
	 * 新建人力论坛
	 * 
	 */
	public String draft(){
		person = forumPersonalDetailDAO.selectByPrimaryKey(person.getId());
		record = new ForumPublish();
		long millis = System.currentTimeMillis();
		if(millis>0){
			millis=-millis;
		}
		record.setId((int)millis);
		record.setUserId(person.getUserId());
		record.setNickName(person.getNickName());
		record.setDraftTime(DateUtil.now());
		return "detail";
	}
	
	/**
	 * 新建人力论坛生活
	 * 
	 */
	public String draftLive(){
		SysUserInfo currUser = this.getCurrUser();
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPersonalDetail> fpd = forumPersonalDetailDAO.selectByExample(example);
		person = fpd.get(0);
		record = new ForumPublish();
		long millis = System.currentTimeMillis();
		if(millis>0){
			millis=-millis;
		}
		record.setId((int)millis);
		record.setUserId(person.getUserId());
		record.setNickName(person.getNickName());
		record.setPostSort("分享生活");
		record.setDraftTime(DateUtil.now());
		return "detail";
	}
	
	/**
	 * 新建人力论坛工作
	 * 
	 */
	public String draftJob(){
		SysUserInfo currUser = this.getCurrUser();
		ForumPersonalDetailExample example = new ForumPersonalDetailExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPersonalDetail> fpd = forumPersonalDetailDAO.selectByExample(example);
		person = fpd.get(0);
		person = forumPersonalDetailDAO.selectByPrimaryKey(person.getId());
		record = new ForumPublish();
		long millis = System.currentTimeMillis();
		if(millis>0){
			millis=-millis;
		}
		record.setId((int)millis);
		record.setUserId(person.getUserId());
		record.setNickName(person.getNickName());
		record.setDraftTime(DateUtil.now());
		record.setPostSort("分享工作");
		return "detail";
	}
	
	/**
	 * 个人信息修改
	 * @throws Exception 
	 * 
	 */
	public String alterInformation() throws Exception{
		String id = this.getRequest().getParameter("id");
		person = forumPersonalDetailDAO.selectByPrimaryKey(Integer.parseInt(id));
		return "personalDetail";
	}
	
	/**
	 * 个人信息上传图片
	 * @throws Exception 
	 * 
	 */
	public void updateImg() throws Exception{
		//连接FTP服务器并且上传图片
		final String path = "information/"+DateUtil.format(DateUtil.now(), "yyyy/MM/dd");
		final String name = "information_"+System.currentTimeMillis()+FileUtil.getExtention(fileFileName);
		FTPClient ftp = new FTPClient();
		FileUtil.connect(ftp, path);
		FileUtil.UploadFtpFile(ftp, file, name);
		
		this.printHtml(path+"/"+name);
		
	}
	
	/**
	 * 个人信息删除图片
	 * @throws Exception 
	 * 
	 */
	public void deleteImg() throws Exception{
		String filePath = this.getRequest().getParameter("filePath");
		FTPClient ftp = FileUtil.connectSimple(filePath.substring(0, filePath.lastIndexOf("/")));
		FileUtil.delFile(ftp, filePath.substring(filePath.lastIndexOf("/")+1));
		
	}
	
	/**
	 * 个人信息保存功能
	 * 
	 */
	public void itemUpdate(){
		SysUserInfo currUser = getCurrUser();
		
		//有修改昵称吗
		String have = this.getRequest().getParameter("have");
		if(have.equals("true")){
			if ("".equals(person.getExtend4()) || person.getExtend4()==null) {
				person.setExtend4("1");
			}else if("1".equals(person.getExtend4())){
				person.setExtend4("2");
			}
		}
		String name = person.getNickName();
		forumPersonalDetailDAO.updateByPrimaryKeySelective(person);
		
		//修改帖子昵称
		ForumPublishExample example = new ForumPublishExample();
		example.createCriteria().andUserIdEqualTo(currUser.getUserid());
		List<ForumPublish> publishs = forumPublishDAO.selectByExample(example);
		for(int i=0;i<publishs.size();i++){
			publishs.get(i).setNickName(name);
			forumPublishDAO.updateByPrimaryKey(publishs.get(i));
		}
		
		//修改回复表昵称
		ForumReplyExample example2 =new ForumReplyExample();
		example2.createCriteria().andReplyIdEqualTo(currUser.getUserid());
		List<ForumReply> replys = forumReplyDAO.selectByExample(example2);
		for(int i=0;i<replys.size();i++){
			replys.get(i).setNickName(name);
			forumReplyDAO.updateByPrimaryKey(replys.get(i));
		}
		
		//修改点赞表昵称
		ForumPraiseExample example3 =new ForumPraiseExample();
		example3.createCriteria().andPraiseIdEqualTo(currUser.getUserid());
		List<ForumPraise> praises = forumPraiseDAO.selectByExample(example3);
		for(int i=0;i<praises.size();i++){
			praises.get(i).setNickName(name);
			forumPraiseDAO.updateByPrimaryKey(praises.get(i));
		}
		
	}
	public ForumPersonalDetail getPerson() {
		return person;
	}

	public void setPerson(ForumPersonalDetail person) {
		this.person = person;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public ForumPublish getRecord() {
		return record;
	}

	public void setRecord(ForumPublish record) {
		this.record = record;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}


	public List<ForumPublish> getForumJobs() {
		return forumJobs;
	}


	public void setForumJobs(List<ForumPublish> forumJobs) {
		this.forumJobs = forumJobs;
	}


	public List<ForumPublish> getForumLives() {
		return forumLives;
	}


	public void setForumLives(List<ForumPublish> forumLives) {
		this.forumLives = forumLives;
	}

	public void setIsTopic(String isTopic) {
		this.isTopic = isTopic;
	}

	public String getIsTopic() {
		return isTopic;
	}

	public List<ForumReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ForumReply> replyList) {
		this.replyList = replyList;
	}

	public ForumPraise getPraise() {
		return praise;
	}

	public void setPraise(ForumPraise praise) {
		this.praise = praise;
	}

	public ForumReply getReply() {
		return reply;
	}

	public void setReply(ForumReply reply) {
		this.reply = reply;
	}


	public void setReplyPublicity(String replyPublicity) {
		this.replyPublicity = replyPublicity;
	}


	public String getReplyPublicity() {
		return replyPublicity;
	}


	public void setForumBest(List<ForumPublish> forumBest) {
		this.forumBest = forumBest;
	}


	public List<ForumPublish> getForumBest() {
		return forumBest;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	public void setForumBests(List<ForumPublish> forumBests) {
		this.forumBests = forumBests;
	}

	public List<ForumPublish> getForumBests() {
		return forumBests;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setOrderJob(String orderJob) {
		this.orderJob = orderJob;
	}

	public String getOrderJob() {
		return orderJob;
	}

	public void setOrderLive(String orderLive) {
		this.orderLive = orderLive;
	}

	public String getOrderLive() {
		return orderLive;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setNickNa(String nickNa) {
		this.nickNa = nickNa;
	}

	public String getNickNa() {
		return nickNa;
	}

	
	
}
