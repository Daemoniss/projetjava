package MotionLessElement;


public abstract class MotionLessElements {

	public static final MotionLessElement	LAND									= new Land();
	public static final MotionLessElement	OSV									= new OsV();
	public static final MotionLessElement	OSH									= new OsH();
	public static final MotionLessElement	BONE								= new Bone();
	
	

	private static MotionLessElement			motionLessElements[]	= {  LAND,BONE, OSV , OSH };

	public static MotionLessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionLessElement motionlessElement : motionLessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return LAND;
	}
}