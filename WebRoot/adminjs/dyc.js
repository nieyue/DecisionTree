//封装官网mouseover、mouseout、click
var mainPage={
		//官网主
		creatDys:function(e1,e2,count){
			$(e1).find(e2)[count].style.backgroundColor="#584b46";
			$(e1).find(e2).each(function(i,e){
				$(e).on({
					mouseover:function(){
						$(e).css({"background-color":"#584b46"});
						$(e).find("a").css("color","white");
					},
					mouseout:function(){
						if(i==count){
							$(e).css({"background-color":"#584b46"});
							$(e).find("a").css("color","white");
							return;
						}
						$(e).css("background-color","");
						$(e).find("a").css("color","");
					},
					click:function(){
						var id=$(e).attr("id");
						if(id.indexOf("info1")!=-1){
							window.location.href="index.html";
						}
						if(id.indexOf("info2")!=-1){
							window.location.href="aboutUs.html";	
						}
						if(id.indexOf("info3")!=-1){
							//window.location.href="aboutUs.html";
							
							$("#up_p,#down_p").toggle();
							$(".hide_div").slideToggle();
						}
						if(id.indexOf("info4")!=-1){
							window.location.href="customerMessage.html";
						}
						if(id.indexOf("info5")!=-1){
							window.location.href="contactUs.html";
						}
						//底部
						if(id.indexOf("inf1")!=-1){
							window.location.href="index.html";
						}
						if(id.indexOf("inf2")!=-1){
							window.location.href="recruitingTalent.html";
						}
						if(id.indexOf("inf3")!=-1){
							window.location.href="advertising.html";
						}
						if(id.indexOf("inf4")!=-1){
							window.location.href="aboutUs.html";
						}
						if(id.indexOf("inf5")!=-1){
							window.location.href="contactUs.html";
						}
						if(id.indexOf("inf6")!=-1){
							window.location.href="http://www.miitbeian.gov.cn";
						}
						
					}
				});
			});
		},

		//新闻动态隐藏的div 添加点击事件 
		createHideDiv:function(){
			$(".hide_div").children(".hide_page").each(function(i,e){
				  $(e).on({
					  mouseover:function(){
						  $(".hide_div").css("display","block");
						  $("#info3").css("background-color","#584b46");
						  $("#info3").find("a").css("color","white");
						  $(e).css({"background-color":"white"});
					  },
					  mouseout:function(){
						  $(".hide_div").css("display","none");
						  $("#info3").css("background-color","");
						  $("#info3").find("a").css("color","");
						  $(e).css({"background-color":""});
					  },
					  click:function(){
						  if(i==0){
							  window.location.href="industry.html";
						  }
						  if(i==1){
							  window.location.href="company.html";
						  }
						  if(i==2){
							  window.location.href="service.html";
						  }
					  }
				  });
			});
		},
		
		//新闻动态三个页面#cebdbd
		createNewsDiv:function(num){
			$(".catalog_ml").children(".catalog_mln")[num].style.backgroundColor="#cebdbd";
			$(".catalog_ml").children(".catalog_mln").each(function(i,e){
				  $(e).on({
					  mouseover:function(){
						  $(e).css({"background-color":"#cebdbd"});
						  
					  },
					  mouseout:function(){
						  if(i==num){
							 return;  
						  }
						  $(e).css({"background-color":""});
					  },
					  click:function(){
						  if(i==0){
							  window.location.href="industry.html";
						  }
						  if(i==1){
							  window.location.href="company.html";
						  }
						  if(i==2){
							  window.location.href="service.html";
						  }
					  }
				  });
			});
		}
}