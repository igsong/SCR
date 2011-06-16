package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import java.awt.geom.AffineTransform;

import kr.ac.kaist.se.interactionmodel.idl.diagram.features.ColorConstants;

import org.eclipse.graphiti.util.IColorConstant;

public class GatewayConstants {
	public static final int WIDTH = 48;
	public static final int HEIGHT = 48;
	private static final int hl = WIDTH / 4;
	private static final int sl = HEIGHT / 12;
	private static final double r = 12;
	private static final double a = r / 2;
	private static final double b = r * Math.sqrt(3.) / 2;
	

	private static final double[] _templatePlus = new double[]{
		WIDTH/2 - sl, HEIGHT/2 - hl, //1
		WIDTH/2 + sl, HEIGHT/2 - hl, //2
		WIDTH/2 + sl, HEIGHT/2 - sl, //3
		WIDTH/2 + hl, HEIGHT/2 - sl, //4
		WIDTH/2 + hl, HEIGHT/2 + sl, //5
		WIDTH/2 + sl, HEIGHT/2 + sl, //6
		WIDTH/2 + sl, HEIGHT/2 + hl, //7
		WIDTH/2 - sl, HEIGHT/2 + hl, //8
		WIDTH/2 - sl, HEIGHT/2 + sl,  //9
		WIDTH/2 - hl, HEIGHT/2 + sl, //10
		WIDTH/2 - hl, HEIGHT/2 - sl, //11
		WIDTH/2 - sl, HEIGHT/2 - sl, //12
	};
	private static final double[] _templateX = new double[24];
	
	public static final int[] templatePlus = new int[24];
	public static final int[] templateX = new int[24];
	public static final int[] templateDiamond = new int[]{
		WIDTH/2, 0,
		WIDTH,HEIGHT/2, 
		WIDTH/2, HEIGHT, 
		0, HEIGHT/2
	};
	public static final int[] templateO = new int[]{
		(int)(WIDTH/2 + 0), (int)(HEIGHT/2 - r),//1
		(int)(WIDTH/2 + a), (int)(HEIGHT/2 - b),//2
		(int)(WIDTH/2 + b), (int)(HEIGHT/2 - a),//3
		(int)(WIDTH/2 + r), (int)(HEIGHT/2 + 0),//4
		(int)(WIDTH/2 + b), (int)(HEIGHT/2 + a),//5
		(int)(WIDTH/2 + a), (int)(HEIGHT/2 + b),//6
		(int)(WIDTH/2 + 0), (int)(HEIGHT/2 + r),//7
		(int)(WIDTH/2 - a), (int)(HEIGHT/2 + b),//8
		(int)(WIDTH/2 - b), (int)(HEIGHT/2 + a),//9
		(int)(WIDTH/2 - r), (int)(HEIGHT/2 + 0),//10
		(int)(WIDTH/2 - b), (int)(HEIGHT/2 - a),//11
		(int)(WIDTH/2 - a), (int)(HEIGHT/2 - b),//12
	};
	

	
	static 
	{
		for( int i = 0; i < 24; i++ )
		{
			templatePlus[i] = (int)_templatePlus[i];
		}
		
		AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 4, WIDTH/2, HEIGHT/2);
		at.transform(_templatePlus, 0, _templateX, 0, 12);
		for( int i = 0; i < 24; i++ )
		{
			templateX[i] = (int)_templateX[i];
		}
	}
	
	public static IColorConstant branch_df = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant branch_db = ColorConstants.INTERACTION_BACKGROUND;
	public static IColorConstant branch_pxf = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant branch_pxb = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant branch_of = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant branch_ob = ColorConstants.INTERACTION_BACKGROUND;
	
	public static IColorConstant join_df = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant join_db = ColorConstants.INTERACTION_FOREGROUND;
	public static IColorConstant join_pxf = ColorConstants.INTERACTION_BACKGROUND;
	public static IColorConstant join_pxb = ColorConstants.INTERACTION_BACKGROUND;
	public static IColorConstant join_of = ColorConstants.INTERACTION_BACKGROUND;
	public static IColorConstant join_ob = ColorConstants.INTERACTION_FOREGROUND;
}
