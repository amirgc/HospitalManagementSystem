package helper;

import java.util.HashMap;

import Rules.RuleSet;
import controller.UserManagerController;

final public class RuleSetFactory {
	private RuleSetFactory() {
	}

	static HashMap<Class<?>, RuleSet> map = new HashMap<>();
	static {
		map.put(UserManagerController.class, new UserManagerControllerRuleSet());
	}

	public static RuleSet getRuleSet(Object c) {
		Class<? extends Object> cl = c.getClass();
		if (!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
