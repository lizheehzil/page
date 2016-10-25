/*     */ package com.sgyfb.pagination.impl;
/*     */ 
/*     */ import com.sgyfb.pagination.Paginable;

import java.io.Serializable;

/*     */
/*     */ public class SimplePage
/*     */   implements Serializable, Paginable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int DEF_COUNT = 20;
/* 123 */   protected int totalCount = 0;
/* 124 */   protected int pageSize = 20;
/* 125 */   protected int pageNo = 1;
/*     */ 
/*     */   public static int cpn(Integer pageNo)
/*     */   {
/*  18 */     return (pageNo == null) || (pageNo.intValue() < 1) ? 1 : pageNo.intValue();
/*     */   }
/*     */ 
/*     */   public SimplePage()
/*     */   {
/*     */   }
/*     */ 
/*     */   public SimplePage(int pageNo, int pageSize, int totalCount)
/*     */   {
/*  35 */     setTotalCount(totalCount);
/*  36 */     setPageSize(pageSize);
/*  37 */     setPageNo(pageNo);
/*  38 */     adjustPageNo();
/*     */   }
/*     */ 
/*     */   public void adjustPageNo()
/*     */   {
/*  46 */     if (this.pageNo == 1) {
/*  47 */       return;
/*     */     }
/*  49 */     int tp = getTotalPage();
/*  50 */     if (this.pageNo > tp)
/*  51 */       this.pageNo = tp;
/*     */   }
/*     */ 
/*     */   public int getPageNo()
/*     */   {
/*  59 */     return this.pageNo;
/*     */   }
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/*  66 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public int getTotalCount()
/*     */   {
/*  73 */     return this.totalCount;
/*     */   }
/*     */ 
/*     */   public int getTotalPage()
/*     */   {
/*  80 */     int totalPage = this.totalCount / this.pageSize;
/*  81 */     if ((totalPage == 0) || (this.totalCount % this.pageSize != 0)) {
/*  82 */       totalPage++;
/*     */     }
/*  84 */     return totalPage;
/*     */   }
/*     */ 
/*     */   public boolean isFirstPage()
/*     */   {
/*  91 */     return this.pageNo <= 1;
/*     */   }
/*     */ 
/*     */   public boolean isLastPage()
/*     */   {
/*  98 */     return this.pageNo >= getTotalPage();
/*     */   }
/*     */ 
/*     */   public int getNextPage()
/*     */   {
/* 105 */     if (isLastPage()) {
/* 106 */       return this.pageNo;
/*     */     }
/* 108 */     return this.pageNo + 1;
/*     */   }
/*     */ 
/*     */   public int getPrePage()
/*     */   {
/* 116 */     if (isFirstPage()) {
/* 117 */       return this.pageNo;
/*     */     }
/* 119 */     return this.pageNo - 1;
/*     */   }
/*     */ 
/*     */   public void setTotalCount(int totalCount)
/*     */   {
/* 133 */     if (totalCount < 0)
/* 134 */       this.totalCount = 0;
/*     */     else
/* 136 */       this.totalCount = totalCount;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 146 */     if (pageSize < 1)
/* 147 */       this.pageSize = 20;
/*     */     else
/* 149 */       this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageNo(int pageNo)
/*     */   {
/* 159 */     if (pageNo < 1)
/* 160 */       this.pageNo = 1;
/*     */     else
/* 162 */       this.pageNo = pageNo;
/*     */   }
/*     */ }

/* Location:           D:\Maven\repository\cn\itcast\page\1.0\page-1.0.jar
 * Qualified Name:     cn.itcast.common.page.SimplePage
 * JD-Core Version:    0.6.2
 */