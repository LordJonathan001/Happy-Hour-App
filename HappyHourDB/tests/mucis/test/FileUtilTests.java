package mucis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mucis.util.FileUtil;
import mucis.util.MyTimer;

public class FileUtilTests {
	// String filePath = "data/kjv10.txt";
	// String filePath = "data/log.sql";
	String filePath = "data/tarzn10.txt";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadF2L() {
		MyTimer.startTime();
		List<String> list = FileUtil.readF2L(filePath);
		System.out.println("**readF2L Time: " + MyTimer.stopTime());
		System.out.println("Lines: " + list.size());
		System.out.println("Length: "
				+ FileUtil.listToString(list, "\n").length());
	}

	@Test
	public void testReadAllF2L() {
		MyTimer.startTime();
		List<String> list = FileUtil.readAllF2L(filePath);
		System.out.println("**readAllF2L Time: " + MyTimer.stopTime());
		System.out.println("Lines: " + list.size());
		System.out.println("Length: "
				+ FileUtil.listToString(list, "\n").length());
	}

	@Test
	public void testReadF2S() {
		MyTimer.startTime();
		String s = FileUtil.readF2S(filePath, "\n");
		System.out.println("**readF2STime: " + MyTimer.stopTime());
		System.out.println("Length: " + s.length());
	}
}
