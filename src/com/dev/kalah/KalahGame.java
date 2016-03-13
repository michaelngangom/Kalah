package com.dev.kalah;


/*
 * 
 */

public class KalahGame {
//private int[] p1c1,p1c2,p1c3,p1c4,p1c5,p1c6,p2c2,p2c3,p2c4,p2c5,p2c6,p2c1,c1,c2;
	private int[][] c1,c2;
	private int[] r1,r2;
	
	public void init()
	{
		for (int i = 0; i < 6; i++) {
			int [][]c1={{i},{1,1,1,1,1,1}};
			int [][]c2={{i},{1,1,1,1,1,1}};
		}
		r1=new int[]{0};
		r2=new int[]{0};
	}
	
public void movePlayer()
{moveComputer();




	}
public void moveComputer()
{}


}
