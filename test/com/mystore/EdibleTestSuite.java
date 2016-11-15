package com.mystore;

import org.junit.AssumptionViolatedException;
import org.junit.ClassRule;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.model.Statement;

@RunWith(Suite.class)
@SuiteClasses({TestSoda.class, TestSoup.class})
public class EdibleTestSuite {
	@ClassRule
	public static TemporaryFolder f = new TemporaryFolder();
	public static TestWatcher watcher = new TestWatcher() {

		@Override
		public Statement apply(Statement base, Description description) {
//			System.out.println(base.evaluate());
			try {
				base.evaluate();
			} catch (Throwable e) {
				
			}
			return super.apply(base, description);
		}

		@Override
		protected void failed(Throwable e, Description description) {
			// TODO Auto-generated method stub
			super.failed(e, description);
		}

		@Override
		protected void finished(Description description) {
			// TODO Auto-generated method stub
			super.finished(description);
		}

		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			// TODO Auto-generated method stub
			super.skipped(e, description);
		}

		@Override
		protected void starting(Description description) {
			// TODO Auto-generated method stub
			super.starting(description);
		}

		@Override
		protected void succeeded(Description description) {
			// TODO Auto-generated method stub
			super.succeeded(description);
		}
		
	};
 
}
