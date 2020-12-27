package com.beginnerlevel.coding.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.beginnerlevel.coding.LiablityExtract;
import com.beginnerlevel.coding.SumPercentage;

public class SumPercentageTest {
	
	SumPercentage aSumPercentage = new SumPercentage();
	List<LiablityExtract> listLiablityExtract = new ArrayList<>();
	
	LiablityExtract aLiablityExtract1 = new LiablityExtract();
	LiablityExtract aLiablityExtract2 = new LiablityExtract();
	LiablityExtract aLiablityExtract3 = new LiablityExtract();
	
	@Before
	public void setUp() {
		aLiablityExtract1.setName("Anna");
		aLiablityExtract1.setPercentage(10.0f);
		aLiablityExtract2.setName("Anna");
		aLiablityExtract2.setPercentage(20.0f);
		aLiablityExtract3.setName("Betty");
		aLiablityExtract3.setPercentage(15.0f);
		
		listLiablityExtract.add(aLiablityExtract1);
		listLiablityExtract.add(aLiablityExtract2);
		listLiablityExtract.add(aLiablityExtract3);
	}
	
	@Test
	public void testCalculatePercentage() {
		assertEquals(new Float("35.0"), aSumPercentage.calculatePercentage(listLiablityExtract));
	}

}
