/*****************************************************************
 ********   JUnit Test for StopWatch class
 *
 * 
 *
 * @author Nicole Dudas
 * @version Winter 2021
 */
package stopwatch;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStopWatch {

	/***************************************************************************************
     * Tests default Constructor
     ***************************************************************************************/
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	/***************************************************************************************
     * Tests Constructors 2, 5, and 6
     ***************************************************************************************/
	@Test
	public void testConstructor() {
		StopWatch s = new StopWatch(5,10,300);
		assertEquals(s.toString(),"5:10:300");

		s = new StopWatch(4);
		assertEquals(s.toString(),"0:00:004");

		s = new StopWatch(17);
		assertEquals(s.toString(),"0:00:017");

		s = new StopWatch(372);
		assertEquals(s.toString(),"0:00:372");

		s = new StopWatch(0);
		assertEquals(s.toString(),"0:00:000");

		s = new StopWatch(999);
		assertEquals(s.toString(),"0:00:999");

		s = new StopWatch(59, 7);
		assertEquals(s.toString(),"0:59:007");

		s = new StopWatch(17, 235);
		assertEquals(s.toString(),"0:17:235");

		s = new StopWatch("20:10:8");
		assertEquals(s.toString(),"20:10:008");

		s = new StopWatch("20:8");
		assertEquals(s.toString(),"0:20:008");

		s = new StopWatch("8");
		assertEquals(s.toString(),"0:00:008");
	}

	/***************************************************************************************
     * Tests Constructor 3
     ***************************************************************************************/
	@Test
	public void testConstructor3Parameters()
	{
		StopWatch s = new StopWatch(2,3,4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);

		StopWatch t = new StopWatch(0,00,000);
		assertTrue(t.getMinutes() == 0);
		assertTrue(t.getSeconds() == 0);
		assertTrue(t.getMilliseconds() == 0);

		StopWatch o = new StopWatch(55,32,789);
		assertTrue(o.getMinutes() == 55);
		assertTrue(o.getSeconds() == 32);
		assertTrue(o.getMilliseconds() == 789);

		StopWatch a = new StopWatch(111111,59,999);
		assertTrue(a.getMinutes() == 111111);
		assertTrue(a.getSeconds() == 59);
		assertTrue(a.getMilliseconds() == 999);
	}

	/***************************************************************************************
     * Tests Constructor 4
     ***************************************************************************************/
	@Test
	public void testConstructorStopWatchInput() {
		StopWatch s = new StopWatch(113, 14, 12);
		StopWatch q = new StopWatch(s);
		assertEquals(q.toString(),"113:14:012");

		s = new StopWatch(54, 456);
		q = new StopWatch(s);
		assertEquals(q.toString(), s.toString());
	}

	/***************************************************************************************
     * Tests constructor 3 with invalid seconds input negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX()
	{
		StopWatch s = new StopWatch(2,-3,4);
	}

	/***************************************************************************************
     * Tests Constructor 3 with invalid minutes input negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX2()
	{
		StopWatch s1 = new StopWatch(-2,3,4);
	}

	/***************************************************************************************
     * Tests Constructor 3 with invalid milliseconds input negative 
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX3()
	{
		StopWatch s1 = new StopWatch(2,3,-4);
	}


	/***************************************************************************************
     * Tests Constructor 3 with invalid milliseconds input value
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX4()
	{
		StopWatch s1 = new StopWatch(2,3,1000);
	}

	/***************************************************************************************
     * Tests Constructor 3 with invalid seconds value border case
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX5()
	{
		StopWatch s1 = new StopWatch(7,60,7);
	}

	/***************************************************************************************
     * Tests Constructor 3 with all invalid values negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX6()
	{
		StopWatch s1 = new StopWatch(-13,-6,-17);
	}

	/***************************************************************************************
     * Tests Constructor 3 with invalid seconds value
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3e2Parameters() {
		StopWatch s = new StopWatch(12,67,14);
	}

	/***************************************************************************************
     * Tests Constructor 6 with invalid value negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-2);
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid value negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegSingleInput23() {
		new StopWatch("-88");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid value 
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSingleInput() {
		new StopWatch("2008");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid value border case
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSingleInput2() {
		new StopWatch("1000");
	}

	/***************************************************************************************
     * Tests Constructor 5 with invalid values negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1InputX() {
		new StopWatch(-72, -987);
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid values both negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:-23");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid values one negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid values both  negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput2() {
		new StopWatch("-52:-17");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid values one negative
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput3() {
		new StopWatch("32:-12");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid value 
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidDouble2aInput() {
		new StopWatch("60:112");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvalidDouble2aInput2() {
		new StopWatch("0:5893");
	}

	/***************************************************************************************
     * Tests Constructor 2 with invalid value non-numeric
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	/***************************************************************************************
     * Tests the add using either StopWatches or milliseconds as parameter
     ***************************************************************************************/
	@Test
	public void testAddMethod () {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.add(2000);
		assertEquals (s1.toString(),"6:01:300");

		s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,300);
		s1.add(s2);
		assertEquals (s1.toString(),"8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		assertEquals (s1.toString(),"8:16:600");

		for (int i = 0; i < 900000; i++)
			s1.inc();
		assertEquals (s1.toString(),"23:16:600");

		s1 = new StopWatch(20,400);
		s2 = new StopWatch(12,57,500);
		s1.add(s2);
		assertEquals (s1.toString(),"13:17:900");

		s1 = new StopWatch(500);
		s1.add(5012);
		assertEquals (s1.toString(),"0:05:512");

		s1 = new StopWatch(500);
		s1.add(-5012);
		assertEquals (s1.toString(),"0:00:500");
	}

	/***************************************************************************************
     * Tests the subtract method using either StopWatch objects or millisecond values as parameters
     ***************************************************************************************/
	@Test
	public void testSubMethod () {
		StopWatch s1 = new StopWatch(6,1,300);
		s1.sub(2000);
		assertEquals (s1.toString(),"5:59:300");

		s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,400);
		s1.sub(s2);
		assertEquals (s1.toString(),"3:56:900");

		for (int i = 0; i < 15115; i++)
			s1.dec();
		assertEquals (s1.toString(),"3:41:785");

		for (int i = 0; i < 60000; i++)
			s1.dec();
		assertEquals (s1.toString(),"2:41:785");

		s1 = new StopWatch(20,400);
		s2 = new StopWatch(12,57,500);
		s1.sub(s2);
		assertEquals (s1.toString(),"0:00:000");

		s1 = new StopWatch(500);
		s1.sub(-5012);
		assertEquals (s1.toString(),"0:00:500");

		s1 = new StopWatch(14, 6, 500);
		s1.sub(7000);
		assertEquals (s1.toString(),"13:59:500");
	}

	/***************************************************************************************
     * Tests equality function for StopWatch objects
     ***************************************************************************************/
	@Test
	public void testEqual () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);
		Object s5 = new StopWatch(17, 54, 680);
		Object s6 = new StopWatch(5, 59, 300);
		Object s7 = new Object();

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s4));
		assertFalse(s1.equals(s3));
		assertFalse(s1.equals(s5));
		assertTrue(s1.equals(s6));
		assertFalse(s1.equals(s7));
	}

	/***************************************************************************************
     * Tests CompareTo function for comparing StopWatch objects
     ***************************************************************************************/
	@Test
	public void testCompareTo () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);

		StopWatch s5 = new StopWatch(42,40,998);
		StopWatch s6 = new StopWatch(42,40,999);
		StopWatch s7 = new StopWatch(42,40,997);
		StopWatch s8 = new StopWatch(42,41,998);
		StopWatch s9 = new StopWatch(42,39,998);
		StopWatch s10 = new StopWatch(43,40,998);
		StopWatch s11 = new StopWatch(41,40,998);
		StopWatch s12 = new StopWatch(42,40,998);

		StopWatch s13 = new StopWatch(40,998);
		StopWatch s14 = new StopWatch(40,999);
		StopWatch s15 = new StopWatch(40,997);
		StopWatch s16 = new StopWatch(40,998);

		StopWatch s17 = new StopWatch(998);
		StopWatch s18 = new StopWatch(999);
		StopWatch s19 = new StopWatch(997);
		StopWatch s20 = new StopWatch(998);

		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);

		assertTrue (s5.compareTo(s6) < 0);
		assertTrue (s5.compareTo(s7) > 0);
		assertTrue (s5.compareTo(s8) < 0);
		assertTrue (s5.compareTo(s9) > 0);
		assertTrue (s5.compareTo(s10) < 0);
		assertTrue (s5.compareTo(s11) > 0);
		assertTrue (s5.compareTo(s12) == 0);

		assertTrue (s5.compareTo(s13) > 0);
		assertTrue (s13.compareTo(s14) < 0);
		assertTrue (s13.compareTo(s15) > 0);
		assertTrue (s13.compareTo(s16) == 0);

		assertTrue (s5.compareTo(s17) > 0);
		assertTrue (s17.compareTo(s18) < 0);
		assertTrue (s17.compareTo(s19) > 0);
		assertTrue (s17.compareTo(s20) == 0);
	}

	/***************************************************************************************
     * Tests toString method
     ***************************************************************************************/
	@Test
	public void testToString () {
		StopWatch s1 = new StopWatch(5000000, 14, 56);
		assertEquals(s1.toString(), "5000000:14:056");

		s1 = new StopWatch(0, 0, 0);
		assertEquals(s1.toString(), "0:00:000");

		s1 = new StopWatch(763);
		assertEquals(s1.toString(), "0:00:763");

		s1 = new StopWatch(0, 20, 1);
		assertEquals(s1.toString(), "0:20:001");
	}

	/***************************************************************************************
     * Tests load and save methods
     ***************************************************************************************/
	@Test
	public void testLoadSave () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		s1.save("file1");
		s1 = new StopWatch();  // resets to zero

		s1.load("file1");
		assertTrue (s1.equals(s2));

		s1 = new StopWatch("56:17:987");
		s2 = new StopWatch("56:17:987");

		s1.save("file1");
		s1 = new StopWatch(); 
		s1.load("file1");
		assertTrue (s1.equals(s2));

		s1 = new StopWatch(22,350);
		s2 = new StopWatch(22,350);

		s1.save("file1");
		s1 = new StopWatch();  // resets to zero

		s1.load("file1");
		assertTrue (s1.equals(s2));
	}

	/***************************************************************************************
     * Tests setSuspend() and time mutation or lack thereof based on suspend value
     ***************************************************************************************/
	@Test
	public void testMutate () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		StopWatch.setSuspend(true);
		s1.add(1000);
		assertTrue (s1.equals(s2));
		StopWatch.setSuspend(false);
		s1.add(1000);
		assertFalse(s1.equals(s2));

		s1 = new StopWatch("22:15:600");
		s2 = new StopWatch("22:15:600");
		StopWatch s3 = new StopWatch("22:15:600");

		StopWatch.setSuspend(true);
		s1.add(777);
		s3.add(654);
		assertTrue (s1.equals(s2));
		assertTrue(s2.equals(s3));
		StopWatch.setSuspend(false);
		s1.add(777);
		s3.add(654);
		assertFalse(s1.equals(s2));
		assertFalse(s2.equals(s3));
		}


	/***************************************************************************************
     * Tests getter and setter methods for values within bounds
     ***************************************************************************************/
	@Test
	public void testGettersSetters() {
		StopWatch s1 = new StopWatch(22, 22, 222);
		s1.setMilliseconds(555);
		s1.setSeconds(33);
		s1.setMinutes(44);

		assertTrue(s1.getSeconds() == 33);
		assertTrue(s1.getMinutes() == 44);
		assertTrue(s1.getMilliseconds() == 555);

		s1 = new StopWatch("44:444");
		s1.setMilliseconds(111);
		s1.setSeconds(55);
		s1.setMinutes(88);

		assertTrue(s1.getSeconds() == 55);
		assertTrue(s1.getMinutes() == 88);
		assertTrue(s1.getMilliseconds() == 111);
	}

	/***************************************************************************************
     * Tests getter and setter methods for values outside of bounds
     ***************************************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSetterInputMinutes()
	{
		StopWatch s1 = new StopWatch(13,6,17);
		s1.setMinutes(-43);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSetterInputSeconds()
	{
		StopWatch s1 = new StopWatch(13,6, 17);
		s1.setSeconds(77);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSetterInputMilliseconds()
	{
		StopWatch s1 = new StopWatch(13,6,17);
		s1.setMilliseconds(-5);
	}
}