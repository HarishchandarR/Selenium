package week4.class1;

import org.testng.annotations.Test;

public class Dependency3 {
	@Test(dependsOnMethods= {"week4.class1.Dependency3.Test3"})
	public void Test1() {
		System.out.println("Test1");

	}
	@Test
	public void Test2() {
		System.out.println("Test2");

	}
	@Test(dependsOnMethods= {"week4.class1.Dependency3.Test4"})
	public void Test3() {
		System.out.println("Test3");

	}
	@Test
	public void Test4() {
		System.out.println("Test4");

	}
}
