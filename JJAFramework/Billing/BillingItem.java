package Billing;

public interface BillingItem {
	public void accept(Visitor visitor);
}
