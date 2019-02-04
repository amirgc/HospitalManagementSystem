package Billing;

import hospitalbilling.Miscellaneous;
import hospitalbilling.Service;
import hospitalbilling.Tax;

public interface Visitor {
	
	public void visit(Tax tax);
	
	public void visit(Miscellaneous misc);
	
	public void visit(Service service);
}
