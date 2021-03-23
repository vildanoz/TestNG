package package1;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before test");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After method");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After class");
	}
	@AfterTest 
	public void AfterTest() {
		System.out.println("After Test");
	}
	//if write enables=false it makes your test comment dont run
	@Test(priority=1,description="This is the first TestCase",enabled =true,groups= {"G1"})
	public void t1() {
		//System.out.println("First test case");
		//System.out.println(1/0);
		
		//Assertion -> 
		
		Assert.assertTrue(true);
		System.out.println("T1");
	}
	@Test(priority=2,groups= {"G2"})
	public void t3() {
		
		
		Assert.assertTrue(true);
		System.out.println("T3");
	}
	@Test(priority=2, groups= {"G1"})
	public void t2() {
		
		
		Assert.assertTrue(true);
		System.out.println("T2");
	}
	

}
