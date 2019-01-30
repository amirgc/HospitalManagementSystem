package helper;

import java.awt.Component;
import java.util.HashMap;

import controller.AddNewMemberController;
import controller.BookController;
import controller.BookCopyController;
import controller.CheckOutController;

final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<?>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddNewMemberController.class, new AddNewMemberControllerRuleSet());
		map.put(BookController.class, new BookControllerRuleSet());
		map.put(BookCopyController.class, new BookCopyControllerRuleSet());
		map.put(CheckOutController.class, new CheckOutControllerRuleSet());
	}
	
	public static RuleSet getRuleSet(Object c) {
		Class<? extends Object> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
