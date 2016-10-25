/*     */ package com.sgyfb.pagination.impl;
/*     */ 
/*     */

import java.util.ArrayList;
import java.util.List;

/*     */

/*     */
/*     */ public class Pagination extends SimplePage
/*     */ {
/*     */   private List<?> list;
/*     */   private List<String> pageView;
/*     */ 
/*     */   public Pagination()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Pagination(int pageNo, int pageSize, int totalCount)
/*     */   {
/*  25 */     super(pageNo, pageSize, totalCount);
/*     */   }
/*     */ 
/*     */   public Pagination(int pageNo, int pageSize, int totalCount, List<?> list)
/*     */   {
/*  42 */     super(pageNo, pageSize, totalCount);
/*  43 */     this.list = list;
/*     */   }
/*     */ 
/*     */   public int getFirstResult()
/*     */   {
/*  52 */     return (this.pageNo - 1) * this.pageSize;
/*     */   }
/*     */ 
/*     */   public List<?> getList()
/*     */   {
/*  71 */     return this.list;
/*     */   }
/*     */ 
/*     */   public void setList(List list)
/*     */   {
/*  81 */     this.list = list;
/*     */   }
/*     */ 
/*     */   public List<String> getPageView()
/*     */   {
/*  89 */     return this.pageView;
/*     */   }
/*     */ 
/*     */   public void setPageView(List<String> pageView)
/*     */   {
/*  97 */     this.pageView = pageView;
/*     */   }
/*     */ 
/*     */   public void pageView(String url, String params)
/*     */   {
/* 106 */     this.pageView = new ArrayList();
/*     */ 			this.pageView.add("<ul class='paginList'>");
/* 108 */     if (this.pageNo != 1) {
/* 109 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=1'\">首页</a></li>");
/* 110 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 1) + "'\">上页</a></li>");
/*     */     } else {
/* 112 */       this.pageView.add("<li class='paginItem current'><a href='javascript:;'>首页</a></li>");
/* 113 */       this.pageView.add("<li class='paginItem current'><a href='javascript:;'>上页</a></li>");
/*     */     }
/*     */ 
/* 116 */     if (getTotalPage() <= 10) {
/* 117 */       for (int i = 0; i < getTotalPage(); i++) {
/* 118 */         if (i + 1 == this.pageNo) {
/* 119 */           this.pageView.add("<li class='paginItem current'><a href='javascript:;'>" + this.pageNo + "</a></li>");
/* 120 */           i++;
/* 121 */           if (this.pageNo == getTotalPage()) break;
/*     */         }
/* 123 */         this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a></li>");
/*     */       }
/* 125 */     } else if (getTotalPage() <= 20)
/*     */     {
/* 127 */       int l = 0;
/* 128 */       int r = 0;
/* 129 */       if (this.pageNo < 5) {
/* 130 */         l = this.pageNo - 1;
/* 131 */         r = 10 - l - 1;
/* 132 */       } else if (getTotalPage() - this.pageNo < 5) {
/* 133 */         r = getTotalPage() - this.pageNo;
/* 134 */         l = 9 - r;
/*     */       } else {
/* 136 */         l = 4;
/* 137 */         r = 5;
/*     */       }
/* 139 */       int tmp = this.pageNo - l;
/* 140 */       for (int i = tmp; i < tmp + 10; i++) {
/* 141 */         if (i == this.pageNo) {
/* 142 */           this.pageView.add("<li class='paginItem current'><a href='javascript:;'>" + this.pageNo + "</a></li>");
/* 143 */           i++;
/* 144 */           if (this.pageNo == getTotalPage()) break;
/*     */         }
/* 146 */         this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + i + "'\">" + i + "</a></li>");
/*     */       }
/*     */     }
/* 149 */     else if (this.pageNo < 7) {
/* 150 */       for (int i = 0; i < 8; i++) {
/* 151 */         if (i + 1 == this.pageNo) {
/* 152 */           this.pageView.add("<li class='paginItem current'>" + this.pageNo + "</li>");
/* 153 */           i++;
/*     */         }
/* 155 */         this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a></li>");
/*     */       }
/* 157 */       this.pageView.add("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
/* 158 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (getTotalPage() - 1) + "'\">" + (getTotalPage() - 1) + "</a></li>");
/* 159 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\">" + getTotalPage() + "</a></li>");
/* 160 */     } else if (this.pageNo > getTotalPage() - 6) {
/* 161 */       this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 1 + "'\">" + 1 + "</a>");
/* 162 */       this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 2 + "'\">" + 2 + "</a>");
/* 163 */       this.pageView.add("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
/* 164 */       for (int i = getTotalPage() - 8; i < getTotalPage(); i++) {
/* 165 */         if (i + 1 == this.pageNo) {
/* 166 */           this.pageView.add("<li class='paginItem current'>" + this.pageNo + "</li>");
/* 167 */           i++;
/* 168 */           if (this.pageNo == getTotalPage()) break;
/*     */         }
/* 170 */         this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a></li>");
/*     */       }
/*     */     } else {
/* 173 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 1 + "'\">" + 1 + "</a></li>");
/* 174 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 2 + "'\">" + 2 + "</a></li>");
/* 175 */       this.pageView.add("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
/*     */ 
/* 177 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 2) + "'\">" + (this.pageNo - 2) + "</a></li>");
/* 178 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 1) + "'\">" + (this.pageNo - 1) + "</a></li>");
/* 179 */       this.pageView.add("<li class='paginItem current'>" + this.pageNo + "</li>");
/* 180 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 1) + "'\">" + (this.pageNo + 1) + "</a></li>");
/* 181 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 2) + "'\">" + (this.pageNo + 2) + "</a></li>");
/*     */ 
/* 183 */       this.pageView.add("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
/* 184 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (getTotalPage() - 1) + "'\">" + (getTotalPage() - 1) + "</a></li>");
/* 185 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\">" + getTotalPage() + "</a></li>");
/*     */     }
/* 187 */     if (this.pageNo != getTotalPage()) {
/* 188 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 1) + "'\"><font size=2>下页</font></a></li>");
/* 189 */       this.pageView.add("<li class='paginItem'><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\"><font size=2>尾页</font></a></li>");
/*     */     } else {
/* 191 */       this.pageView.add("<li class='paginItem current'><a href='javascript:;'>下页</a></li>");
/* 192 */       this.pageView.add("<li class='paginItem current'><a href='javascript:;'>尾页</a></li>");
/*     */     }

				this.pageView.add("</ul>");
/* 194 */     this.pageView.add("<div class='message'>共<i class='blue'>" + getTotalPage() + "</i>页 到第<input type='text' id='PAGENO'  size='3' />页 <input type='button' id='skip' class='hand btn60x20' value='确定' onclick=\"javascript:window.location.href = '" + url + "?" + params + "&pageNo=' + $('#PAGENO').val() \"/></div>");
/*     */   }
/*     */ }

/* Location:           D:\Maven\repository\cn\itcast\page\1.0\page-1.0.jar
 * Qualified Name:     cn.itcast.common.page.Pagination
 * JD-Core Version:    0.6.2
 */