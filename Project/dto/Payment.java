package Project.dto;

import java.util.Date;

public class Payment {
     private String payment_id ;
    private String invoice_id   ;
     private double paid_amount;
    private Date paid_at ;
     private  String method ;
     public Payment() {
     }
     public Payment(String payment_id, String invoice_id, double paid_amount, Date paid_at, String method) {
        this.payment_id = payment_id;
        this.invoice_id = invoice_id;
        this.paid_amount = paid_amount;
        this.paid_at = paid_at;
        this.method = method;
     }
     public String getPayment_id() {
         return payment_id;
     }
     public void setPayment_id(String payment_id) {
         this.payment_id = payment_id;
     }
     public String getInvoice_id() {
         return invoice_id;
     }
     public void setInvoice_id(String invoice_id) {
         this.invoice_id = invoice_id;
     }
     public double getPaid_amount() {
         return paid_amount;
     }
     public void setPaid_amount(double paid_amount) {
         this.paid_amount = paid_amount;
     }
     public Date getPaid_at() {
         return paid_at;
     }
     public void setPaid_at(Date paid_at) {
         this.paid_at = paid_at;
     }
     public String getMethod() {
         return method;
     }
     public void setMethod(String method) {
         this.method = method;
     } 

     
}
