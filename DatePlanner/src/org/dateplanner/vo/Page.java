package org.dateplanner.vo;

public class Page {
	
	private int start, current, end;
	private boolean next;
	private int total, contentCount, pageCount;
	
	public Page(int total, int contentCount, int pageCount, int current) {
		
		this(contentCount, pageCount, current);
		initTotal(total);
		
	} //Page();
	
	public Page(int contentCount, int pageCount, int current) {
		
		this.current = current;
		this.pageCount = pageCount;
		this.contentCount = contentCount;
		this.start = this.current - ((this.current - 1) % this.pageCount);
		
	} //Page();
	
	public Page initTotal(int total) {
		
		this.total = (total + (this.contentCount - 1)) / this.contentCount;
		this.end = Math.min(this.start + this.pageCount - 1, this.total);
		this.next = this.end < this.total;
		
		return this;
		
	} //initTotal();
	
	public int getStart() { return start; }
	public int getStartContent() { return (current - 1) * contentCount; }
	public int getCurrent() { return current; }
	public int getEnd() { return end; }
	public boolean isNext() { return next; }
	public int getTotal() { return total; }
	public int getContentCount() { return contentCount; }
	public int getPageCount() { return pageCount; }
	public void setStart(int start) { this.start = start; }
	public void setCurrent(int current) { this.current = current; }
	public void setEnd(int end) { this.end = end; }
	public void setNext(boolean next) { this.next = next; }
	public void setTotal(int total) { this.total = total; }
	public void setContentCount(int contentCount) { this.contentCount = contentCount; }
	public void setPageCount(int pageCount) { this.pageCount = pageCount; }
	
	@Override
	public String toString() {
		return "Page [start=" + start + ", current=" + current + ", end=" + end + ", next=" + next + ", total=" + total
				+ ", contentCount=" + contentCount + ", pageCount=" + pageCount + "]";
	} //toString();
	
} //class Page;
