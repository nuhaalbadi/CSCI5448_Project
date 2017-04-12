package com.Library;
/**
 * Created by Nuha Albadi on 4/11/2017.
 */
public class ReturnRequest {

	    private int returnRequestNo;
	    private String returnDate;
	    private String returnDetails;
	    
		public int getReturnRequestNo() {
			return returnRequestNo;
		}
		public void setReturnRequestNo(int returnRequestNo) {
			this.returnRequestNo = returnRequestNo;
		}
		public String getReturnDate() {
			return returnDate;
		}
		public void setReturnDate(String returnDate) {
			this.returnDate = returnDate;
		}
		public String getReturnDetails() {
			return returnDetails;
		}
		public void setReturnDetails(String returnDetails) {
			this.returnDetails = returnDetails;
		}
		
		public int createReturnRequest() {
			return 0 ;
		}
		
		public void processRefund(int returnRequestNo) {
			
		}

}
