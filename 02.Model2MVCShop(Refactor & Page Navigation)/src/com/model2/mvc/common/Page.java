package com.model2.mvc.common;


public class Page {
	
	///Field
	private int currentPage;		// 현재페이지
	private int totalCount;		// 총 게시물 수
	private int pageUnit;			// 하단 페이지 번호 화면에 보여지는 수
	private int pageSize;			// 한 페이지당 보여지는 게시물수
	private int maxPage;			// 최대 페이지 번호(전체 페이지)
	private int beginUnitPage;	// 화면에 보여지는 페이지 번호의 최소수
	private int endUnitPage;		// 화면에 보여지는 페이지 번호의 최대수
	
	///Constructor
	public Page() {
	}
	public Page( int currentPage, int totalCount,	int pageUnit, int pageSize ) { //생성자로 초기값 setting
		this.totalCount = totalCount;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		
		this.maxPage = (pageSize == 0) ? totalCount :  (totalCount-1)/pageSize +1; 
		// 생성자 parameter로 받은 인자값 계산 pageSize 가 0이면, maxPage는 totalCount이고, 0이 아니면, maxPage는 (totalCount-1)/pageSize + 1 이다
		// 최대 페이지 번호(전체 페이지) ==> (totalCount-1)/pageSize + 1 ==> ((총게시물 수 - 1)/한페이지당 보여지는 게시물 수) + 1
		this.currentPage = ( currentPage > maxPage) ? maxPage : currentPage;
		// 현재페이지가 최대페이지보다 크면, 현재페이지는 최대페이지이고 아니라면 그냥 현재페이지. ==> 이게 뭔 소리야?
		this.beginUnitPage = ( (currentPage-1) / pageUnit ) * pageUnit +1 ;
		// ????????????????????????????????????????
		if( maxPage <= pageUnit ){  // 만약 maxPage(최대페이지 번호) 가 pageUnit(하단 페이지 번호 화면에 보여지는 수??) 보다 작거나 같다면,
			this.endUnitPage = maxPage; // endUnitPage(화면에 보여지는 페이지 번호의 최대수??) = maxPage(최대페이지 번호 = 전체 페이지)
		}else{ // maxPage(최대페이지번호) 가 pageUnit(하단 페이지 번호 화면에 보여지는 수)보다 크다면,
			this.endUnitPage = beginUnitPage + (pageUnit -1);
			if( maxPage <= endUnitPage){ 
				// maxPage(최대페이지번호)가  pageUnit(하단 페이지 번호 화면에 보여지는 수)보다 크면서, 
				// maxPage가 endUnitPage(화면에 보여지는 페이지 번호의 최대수) 보다 작거나 같다면,
				this.endUnitPage = maxPage; // endUnitPage = maxPage
			}
		}
	}
	
	///Mehtod
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getBeginUnitPage() {
		return beginUnitPage;
	}
	public void setBeginUnitPage(int beginUnitPage) {
		this.beginUnitPage = beginUnitPage;
	}
	public int getEndUnitPage() {
		return endUnitPage;
	}
	public void setEndUnitPage(int endUnitPage) {
		this.endUnitPage = endUnitPage;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalCount=" + totalCount 
				+ "\n, pageUnit=" + pageUnit + ", pageSize=" + pageSize
				+ "\n, maxPage=" + maxPage + ", beginUnitPage=" + beginUnitPage + ", endUnitPage=" + endUnitPage + "]";
	}
}