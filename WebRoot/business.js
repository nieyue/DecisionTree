//定义业务根变量；
business={
	//私有对象放置地
	slef:{},
	//定义全局域名
	domainUrl:	myUtils.getDomain(),
	//全局登录账户id	
	sessionAccountId:null,
	//全局登录账户
	sessionPhone:"",
	//全局登录角色id
	sessionRoleId:null,
	//全局登录角色
	sessionRole:{},
	//全局所有角色
	roleList:[],
	//请求参数初始
	params:{
	      startNum:1,//初始化个数
	      currentPage:1,//当前页
	      pageNum:1,//获取的第几个开始
	      pageSize:10,//每页的个数
	      total:0//总数
	 },
	//验证是否已经登录 
	initIslogin:function(){
		$.ajax({
			url:business.domainUrl+"/account/islogin",
			type:"get",
			async:false,
			success:function(data){
				//console.log(data);
				if(data.code==200){
					business.sessionPhone=data.data.account.phone;
					business.sessionAccountId=data.data.account.accountId;
					business.sessionRoleId=data.data.account.roleId;
				$(".name_top a").html(business.sessionPhone);
				}else{
					location.replace(business.domainUrl+"/login.html");
				}
			}	
		});
	},
	//获取所有角色
	initRoleList:function(){
		$.ajax({
			url:business.domainUrl+"/role/list",
			type:"get",
			async:false,
			success:function(data){
				if(data.code==200){
					business.roleList=data.data.list;
				for(var i=0;i<business.roleList.length;i++){
					if(business.roleList[i].roleId==business.sessionRoleId){
						business.sessionRole=business.roleList[i];
					$(".role_name").text(business.sessionRole.name);
					}
				}
				}
			}	
		});
	},
	 //点击左边导航
	clickLeftMenu:function (item){
	 	$(".content_main").load(business.domainUrl+"/main/"+item+".html"); 
	 },
	 
	 //分页条信息
	showPage:function(params){
		 $(".page_font").empty();
			var totalPage=params.totalPage;
			var nowPage=params.currentPage;
			var pageSize=params.pageSize;
			var totalSize=params.total;
			var pagination=[];
			
			pagination=myUtils.myPaginationHandler().getShowPageNumber(totalPage,params.pageNum,5,nowPage)
			//显示分页文字信息 
			$(".page_font").append("总共"
					+totalPage+"页，当前第"
					+nowPage+"页，每页"
					+pageSize+"条数据，总共"
					+totalSize+"条数据");
			
		    //显示分页条信息	
		    $("#di ul").empty();
		    var firstPage=$("<li></li>").append("<a href='#' aria-label='Previous'><span aria-hidden='true'>首页</span>");
		    var lastPage=$("<li></li>").append("<a href='#' aria-label='Previous'><span aria-hidden='true'>尾页</span>");
		    
		    var previousPage=$("<li></li>").append("<a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span>");
			var nextPage=$("<li></li>").append("<a href='#' aria-label='Previous'><span aria-hidden='true'>&raquo;</span>");
			
			//添加首页、上一页 
			$("#di ul").append(firstPage)
	 		   		   .append(previousPage)
	 		//设置如果是第一页：那么首页和上一页不可点击，最后一页：那么尾页和下一页不可点击 	
	  		if(nowPage==1){
				firstPage.addClass("disabled");
				previousPage.addClass("disabled");
			}   

			if(nowPage==totalPage){
				nextPage.addClass("disabled");
				lastPage.addClass("disabled");
			}   		   
	 		//为首页，上一页，下一页，尾页 添加点击事件  
					firstPage.click(function(){
						if(nowPage!=1){
							business.toPage(1);
						}
					});
					previousPage.click(function(){
						if(nowPage-1>0){
							business.toPage(nowPage-1);
						}
					});
					nextPage.click(function(){
						if(nowPage+1<=totalPage){
							business.toPage(nowPage+1);
						}
					});
					lastPage.click(function(){
						if(nowPage!=totalPage){
							business.toPage(totalPage);
						}
					});
		    //获取每页显示的页码 
	 		$.each(pagination,function(i,e){
	 			var pages=$("<li></li>").append("<a href='#'>"+e+"</a>");
	 			$("#di ul").append(pages);
	 			if(nowPage==e){
	 				pages.addClass("active");
	 			}
	 			pages.click(function(){
	 				business.toPage(e);
				}); 
	 		});  
	 		   		   
	  		$("#di ul").append(nextPage)
			   		   .append(lastPage); 	
	 },
	 //初始化分页
	 initPage:function (params){
		params.totalPage=(params.total)%(params.pageSize)==0?(params.total)/(params.pageSize):parseInt((params.total)/(params.pageSize))+1,//总页数
		business.showPage(params);
	},
	//分页页面跳转
	toPage:function(currentPage){
		business.params.currentPage=currentPage;
		business.params.pageNum=(business.params.currentPage-1)*business.params.pageSize+business.params.startNum;
		business.showPage(business.params);
	},	
	 //退出 
	 loginout:function(){
		 $(".hid_div").css("display","block");
			$(".hid_main").css("display","block");
			$("#sure").click(function(){
				$.ajax({
					url:business.domainUrl+"/account/loginout",
					data:{"accountId":business.SessionAccountId},
					type:"get",
					success:function(result){
						if(result.code==200){
							location.replace(business.domainUrl+"/login.html");
						}	
					}
				});
			});
			$("#off").click(function(){
				$(".hid_div").css("display","none");
				$(".hid_main").css("display","none");
			});
	 },
	 /**
     * 获取列表
     * p.countUrl 数量url
     * p.listUrl 列表url
     * p.data 返回列表
     * params 请求参数
     * params.total 总数
     * p.success 成功回调
     */
	 getList:function(p,params){
		 $.ajax({
				url:p.countUrl,
				type:"post",
				data:params,
	            withCredentials: true,
				success:function(data){
				if(data.code==200){
					//console.log(data.data.total)
					params.total=data.data.total;
					if(params.total<=0 ){
						myUtils.myLoadingToast("暂无数据")
						//放入全局business
						var tableTbody="<div class='text-center'>暂无数据</div>";
						$("table").after(tableTbody);
		                return ;
		            }
					$.ajax({
						url:p.listUrl,
						data:params,
						withCredentials: true,
						type:"post",
						success:function(data){
							if(data.code==200){
								myUtils.myLoadingToast(data.msg);
								business[p.data]=data.data.list;
								  if(typeof p.success=='function'){
				                         p.success(business[p.data]);
				                        }
									}else{
										myUtils.myLoadingToast("暂无数据")
									}
						}	
					});
				}
				}
			});
	 },

	/**
     * 获取单个
     * p.url 列表url
     * p.data 返回列表
     * p.success 成功回调
     */
	 get:function (p) {
        //获取
    	$.ajax({
            method:"post",
            url:p.url,
            withCredentials: true,
            success: function(data){
            	if (data.code == 200) {
                    //console.log(data.data)
            		myUtils.myLoadingToast(data.msg);
                    //属性获取
                    for(var name in data.data){
                    	business[p.data]=name;
                    }
                    if(typeof p.success=='function'){
                        p.success(business[p.data]);
                    }
                } else {
                	myUtils.myLoadingToast("暂无数据")
                }
            }
            });
	   },
	   /**
	     * 增加
	     * p.addUrl 增加url
	     * p.requestObject 请求参数对象
	     * p.success 成功回调
	     */
	    add:function(p){
	    	$.ajax({
	              method:"post",
	              url:p.url,
	              data:business[p.requestObject],
	              withCredentials: true,
	              success:function(data){
	            	  if (data.code === 200) {
	            		  myUtils.myLoadingToast(data.msg);
	                      if(typeof p.success=='function'){
	                          p.success();
	                      }
	                } else {
	                	myUtils.myLoadingToast(data.msg)
	                }  
	              }
	              })
	    },
	    /**
	     * 修改
	     * p.url 修改url
	     * p.requestObject 请求参数对象
	     * p.success 成功回调
	     */
	    update:function(p){
	    	$.ajax({
                method:"post",
                url:p.url,
                data:business[p.requestObject],
                withCredentials: true,
                success:function(data){
            	 if (data.code === 200) {
            		 myUtils.myLoadingToast(data.msg);
                     if(typeof p.success=='function'){
                         p.success();
                     }
                }else{
                	myUtils.myLoadingToast(data.msg)
                }
            }});
	    },
	    /**
	     * 删除
	     * p.url 修改url
	     * p.requestObject 请求参数对象
	     * p.success 成功回调
	     */
	    delete:function(p){
	    	myUtils.myConfirm("确定删除吗？", function() {
	    		$.ajax({
					method:"post",
					url:p.url,
					data:business[p.requestObject],
					withCredentials: true,
					sucess:function(data){
						if (data.code === 200) {
							myUtils.myLoadingToast(data.msg);
							if(typeof p.success=='function'){
								p.success();
							}else{
								business.getList();
							}
						}else {
							myUtils.myLoadingToast(data.msg);
						}
					}
				})
			})
	 },
	//增加显示model
	 addClick:function(text,bodyElement){
		$("#mySellerModal").click();
		$("#mySellerModalLabel").text(text);
		$("#mySellerModalBody").html($(bodyElement))
		$(bodyElement).show();
	 }
};
 
	//初始化判断是否登陆
	business.initIslogin();
	//初始化所有角色
	business.initRoleList();
	//初始化左边导航
	$('#leftBar').metisMenu();
	//首页初始化
	business.clickLeftMenu('index');	
	
    