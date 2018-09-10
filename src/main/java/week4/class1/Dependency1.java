package week4.class1;

import org.testng.annotations.Test;

public class Dependency1 {
	@Test(dependsOnMethods= {"week4.class1.Dependency1.Test4"})
	public void Test1() {
		System.out.println("Test1");

	}
	@Test
	public void Test2() {
		System.out.println("Test2");

	}
	@Test
	public void Test3() {
		System.out.println("Test3");

	}
	@Test
	public void Test4() {
		System.out.println("Test4");

	}

}
